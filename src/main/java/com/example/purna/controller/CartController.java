package com.example.purna.controller;

import com.example.purna.dto.request.ItemRequest;
import com.example.purna.dto.response.AddToCartResponse;
import com.example.purna.model.Item;
import com.example.purna.service.CartService;
import com.example.purna.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    ItemService itemService;

    @PostMapping("/add_to_cart")
    public ResponseEntity addToCart(@RequestBody ItemRequest addToCartRequest){
        try{
            Item item = itemService.createItem(addToCartRequest);
            AddToCartResponse response = cartService.addToCart(addToCartRequest, item);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
