package com.example.purna.service;

import com.example.purna.dto.request.ItemRequest;
import com.example.purna.exception.CustomerNotFoundException;
import com.example.purna.exception.InsufficientProductException;
import com.example.purna.exception.ProductNotFoundException;
import com.example.purna.model.Customer;
import com.example.purna.model.Item;
import com.example.purna.model.OrderEntity;
import com.example.purna.model.Product;
import com.example.purna.repository.CustomerRepository;
import com.example.purna.repository.OrderEntityRepository;
import com.example.purna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderEntityRepository orderEntityRepository;
    public Item createItem(ItemRequest itemRequest){
        Customer customer = customerRepository.findByEmailId(itemRequest.getCustomerEmailId());
        if(customer == null)
            throw new CustomerNotFoundException("Customer doesn't exist");

        Optional<Product> optionalProduct = productRepository.findById(itemRequest.getProductId());
        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException("Sorry! Product not found, Please try again.");
        Product product = optionalProduct.get();

        if(product.getAvailableQuantity() < itemRequest.getQuantity())
            throw new InsufficientProductException("Insufficient product availability");

        Item item = new Item();
        item.setRequriedQuantity(itemRequest.getQuantity());
        item.setProduct(product);
        return item;
    }


}
