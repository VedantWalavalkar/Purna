package com.example.purna.controller;

import com.example.purna.dto.request.AddProductRequest;
import com.example.purna.dto.response.AddProductResponse;
import com.example.purna.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add_product")
    public ResponseEntity addProduct(@RequestBody AddProductRequest addProductRequest) {
        try{
            AddProductResponse response = productService.addProduct(addProductRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}