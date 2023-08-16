package com.example.purna.service;

import com.example.purna.dto.request.ItemRequest;
import com.example.purna.dto.response.AddToCartResponse;
import com.example.purna.exception.CustomerNotFoundException;
import com.example.purna.exception.InsufficientProductException;
import com.example.purna.exception.ProductNotFoundException;
import com.example.purna.model.Cart;
import com.example.purna.model.Customer;
import com.example.purna.model.Item;
import com.example.purna.model.Product;
import com.example.purna.repository.CartRepository;
import com.example.purna.repository.CustomerRepository;
import com.example.purna.repository.ItemRepository;
import com.example.purna.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.purna.transformer.CartTransformer.cartToAddToCartResponse;

@Service
public class CartService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartRepository cartRepository;

    public AddToCartResponse addToCart(ItemRequest itemRequest, Item item) {

        Customer customer = customerRepository.findByEmailId(itemRequest.getCustomerEmailId());

        Product product = item.getProduct();

        Cart cart = customer.getCart();

        item.setCart(cart);
        Item savedItem = itemRepository.save(item);

        int totalPrice = product.getPrice() * savedItem.getRequriedQuantity();
        cart.setCartTotal(cart.getCartTotal()+totalPrice);
        cart.getItemList().add(item);
        Cart savedCart = cartRepository.save(cart);


        product.getItemList().add(item);
        productRepository.save(product);


        AddToCartResponse response = cartToAddToCartResponse(savedCart);

        return response;
    }
}
