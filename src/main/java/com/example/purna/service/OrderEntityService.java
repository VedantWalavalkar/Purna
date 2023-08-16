package com.example.purna.service;

import com.example.purna.Enum.Category;
import com.example.purna.Enum.Status;
import com.example.purna.dto.request.ItemRequest;
import com.example.purna.dto.request.OrderItemRequest;
import com.example.purna.dto.response.OrderItemResponse;
import com.example.purna.exception.CustomerNotFoundException;
import com.example.purna.exception.InValidCardException;
import com.example.purna.exception.InsufficientProductException;
import com.example.purna.exception.ProductNotFoundException;
import com.example.purna.model.*;
import com.example.purna.repository.*;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.purna.transformer.OrderEntityTransformer.OrderEntityToOrderItemResponse;

@Service
public class OrderEntityService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CardRepository cardRepository;

    public OrderItemResponse orderItem(OrderItemRequest orderItemRequest) {
        Customer customer = customerRepository.findByEmailId(orderItemRequest.getCustomerEmailId());
        if(customer == null)
            throw new CustomerNotFoundException("Customer doesn't exist");

        Optional<Product> optionalProduct = productRepository.findById(orderItemRequest.getProductId());
        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException("Product doesn't exist");

        Product product = optionalProduct.get();
        if(product.getAvailableQuantity() < orderItemRequest.getRequriedQuantity())
            throw new InsufficientProductException("Available quantity is insufficient");

        Card card = cardRepository.findByCardNo(orderItemRequest.getCardUsed());
        if(card.getCvv() != orderItemRequest.getCvv())
            throw new InValidCardException("Invalid Credentials");

        if(card.getValidTill().before(new Date()))
            throw new InValidCardException("Expired Card");

        String cardNo = "************" + card.getCardNo().substring(12);
        OrderEntity order = new OrderEntity();
        order.setCustomer(customer);
        order.setOrder_id(UUID.randomUUID().toString());
        order.setCardUsed(cardNo);
        order.setTotal(product.getPrice() * orderItemRequest.getRequriedQuantity());

        Item item = new Item();
        item.setProduct(product);
        item.setRequriedQuantity(orderItemRequest.getRequriedQuantity());
        item.setOrder(order);

        order.getItemList().add(item);
        product.setAvailableQuantity(product.getAvailableQuantity() - item.getRequriedQuantity());
        if(product.getAvailableQuantity() == 0)
            product.setStatus(Status.OUT_OF_STOCK);

        OrderEntity savedOrder = orderEntityRepository.save(order);

        product.getItemList().add(savedOrder.getItemList().get(0));
        customer.getOrderList().add(savedOrder);

        return OrderEntityToOrderItemResponse(savedOrder);
    }
//    public List<OrderEntity> get5OrdersWithHighestOrderTotal(){
//        List<OrderEntity> allOrders = orderEntityRepository.findAll();
//        Collections.sort(allOrders,(a,b)->{
//            return b.getTotal() - a.getTotal();
//        });
//
//        List<OrderEntity> topOrders = new ArrayList<>();
//        for(int i=0 ; i<5 ; i++)
//            topOrders.add(allOrders.get(i));
//
//        return topOrders;
//    }
//
//    public List<OrderEntity> get5cheapestProductInCategory(Category category)
//    {
//        List<OrderEntity> ordersWithCategory = orderEntityRepository.findByCategory(category);
//        Collections.sort(ordersWithCategory, (a,b)->{
//            return a.getTotal() - b.getTotal();
//        });
//        List<OrderEntity> cheapestOrders = new ArrayList<>();
//        int i = 0;
//        while(i<ordersWithCategory.size() && i<5){
//            cheapestOrders.add(ordersWithCategory.get(i));
//            i++;
//        }
//        return cheapestOrders;
//    }
//
//    public String cancelOrder(String orderId){
//        OrderEntity order = orderEntityRepository.findByOrderId(orderId);
//        if(order == null)
//            throw new OrderEntityNotFound("Order not found");
//
//        Customer customer = order.getCustomer();
//        customer.getOrderList().remove(customer.getOrderList().size() - 1);
//
//        List<Item> itemList = order.getItemList();
//        for(Item item : itemList){
//            Product product = item.getProduct();
//            if(product.getAvailableQuantity() == 0)
//                product.setStatus(Status.AVAILABLE);
//            product.setAvailableQuantity(product.getAvailableQuantity() + item.getRequriedQuantity());
//
//            item.setOrder(null);
//        }
//
//        return "Order Cancelled";
//    }
}
