package com.example.purna.transformer;

import com.example.purna.dto.response.AddToCartResponse;
import com.example.purna.dto.response.ItemResponse;
import com.example.purna.model.Cart;
import com.example.purna.model.Item;

import java.util.ArrayList;
import java.util.List;

import static com.example.purna.transformer.ItemTransformer.itemToItemResponse;

public class CartTransformer {
    public static AddToCartResponse cartToAddToCartResponse(Cart cart){
        AddToCartResponse response = new AddToCartResponse();
        response.setCartTotal(cart.getCartTotal());
        List<ItemResponse> itemResponses = new ArrayList<>();
        for(Item item : cart.getItemList()){
            itemResponses.add(itemToItemResponse(item));
        }
        response.setItemList(itemResponses);
        return response;
    }
}
