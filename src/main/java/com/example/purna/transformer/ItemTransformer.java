package com.example.purna.transformer;

import com.example.purna.dto.response.ItemResponse;
import com.example.purna.model.Item;

public class ItemTransformer {
    public static ItemResponse itemToItemResponse(Item item){
        return ItemResponse.builder()
                .productName(item.getProduct().getName())
                .requiredQuantity(item.getRequriedQuantity())
                .build();
    }
}
