package com.example.purna.transformer;

import com.example.purna.dto.request.AddProductRequest;
import com.example.purna.dto.response.AddProductResponse;
import com.example.purna.model.Product;

public class ProductTransformer {
    public static Product AddProductRequestToProduct(AddProductRequest addProductRequest){
        return Product.builder()
                .name(addProductRequest.getName())
                .category(addProductRequest.getCategory())
                .price(addProductRequest.getPrice())
                .availableQuantity(addProductRequest.getAvailableQuantity())
                .status(addProductRequest.getStatus())
                .build();

    }
    public static AddProductResponse ProductToAddProductResponse(Product product){
        return AddProductResponse.builder()
                .name(product.getName())
                .availableQuantity(product.getAvailableQuantity())
                .category(product.getCategory())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }
}
