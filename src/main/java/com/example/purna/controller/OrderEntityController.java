package com.example.purna.controller;

import com.example.purna.dto.request.ItemRequest;
import com.example.purna.dto.request.OrderItemRequest;
import com.example.purna.dto.response.ItemResponse;
import com.example.purna.dto.response.OrderItemResponse;
import com.example.purna.model.Item;
import com.example.purna.model.OrderEntity;
import com.example.purna.service.ItemService;
import com.example.purna.service.OrderEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderEntityController {
    @Autowired
    OrderEntityService orderEntityService;

    @Autowired
    ItemService itemService;

    @PostMapping("/order_item")
    public ResponseEntity orderItem(@RequestBody OrderItemRequest orderItemRequest){
        try{
            OrderItemResponse response = orderEntityService.orderItem(orderItemRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/getTopOrders")
//    public List<OrderEntity> getTopOrders(){
//        return orderEntityService.get5OrdersWithHighestOrderTotal();
//    }
}
