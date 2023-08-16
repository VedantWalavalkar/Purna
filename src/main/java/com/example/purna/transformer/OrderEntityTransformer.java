package com.example.purna.transformer;

import com.example.purna.dto.response.ItemResponse;
import com.example.purna.dto.response.OrderItemResponse;
import com.example.purna.model.Item;
import com.example.purna.model.OrderEntity;

import java.util.ArrayList;
import java.util.List;

import static com.example.purna.transformer.ItemTransformer.itemToItemResponse;

public class OrderEntityTransformer {
    public static OrderItemResponse OrderEntityToOrderItemResponse(OrderEntity order){
        List<ItemResponse> itemResponses = new ArrayList<>();
        for(Item item : order.getItemList())
            itemResponses.add(itemToItemResponse(item));

        OrderItemResponse orderItemResponse = OrderItemResponse.builder()
                .total(order.getTotal())
                .orderId(order.getOrder_id())
                .cardUsed(order.getCardUsed())
                .date(order.getDate())
                .items(itemResponses)
                .build();

        return orderItemResponse;
    }
}
