package com.example.purna.controller;

import com.example.purna.dto.request.AddCustomerRequest;
import com.example.purna.dto.response.AddCustomerResponse;
import com.example.purna.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add_customer")
    public ResponseEntity addCustomer(@RequestBody AddCustomerRequest addCustomerRequest){
        AddCustomerResponse response = customerService.addCustomer(addCustomerRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
