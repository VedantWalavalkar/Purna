package com.example.purna.controller;

import com.example.purna.dto.request.AddSellerRequest;
import com.example.purna.dto.response.AddSellerResponse;
import com.example.purna.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerContorller {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add_seller")
    public ResponseEntity addSeller(@RequestBody AddSellerRequest addSellerRequest){
        AddSellerResponse response = sellerService.addSeller(addSellerRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
