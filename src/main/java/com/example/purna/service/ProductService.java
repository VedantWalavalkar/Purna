package com.example.purna.service;

import com.example.purna.dto.request.AddProductRequest;
import com.example.purna.dto.response.AddProductResponse;
import com.example.purna.exception.SellerNotFoundException;
import com.example.purna.model.Product;
import com.example.purna.model.Seller;
import com.example.purna.repository.ProductRepository;
import com.example.purna.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.purna.transformer.ProductTransformer.AddProductRequestToProduct;
import static com.example.purna.transformer.ProductTransformer.ProductToAddProductResponse;

@Service
public class ProductService {
    @Autowired
    SellerRepository sellerRepository;


    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Seller seller = sellerRepository.findByEmailId(addProductRequest.getSellerEmailId());
        if(seller == null)
            throw new SellerNotFoundException("Seller doesn't exist");

        Product product = AddProductRequestToProduct(addProductRequest);
        product.setSeller(seller);
        seller.getProductList().add(product);

        Seller savedSeller = sellerRepository.save(seller);

        List<Product> productList = savedSeller.getProductList();

        AddProductResponse response = ProductToAddProductResponse(productList.get(productList.size() - 1));
        return response;
    }
}
