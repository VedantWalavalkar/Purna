package com.example.purna.service;

import com.example.purna.dto.request.AddSellerRequest;
import com.example.purna.dto.response.AddSellerResponse;
import com.example.purna.model.Product;
import com.example.purna.model.Seller;
import com.example.purna.repository.ProductRepository;
import com.example.purna.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.purna.transformer.SellerTransformer.AddSellerRequestToSeller;
import static com.example.purna.transformer.SellerTransformer.SellerToAddSellerResponse;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    public AddSellerResponse addSeller(AddSellerRequest addSellerRequest) {
        Seller seller = AddSellerRequestToSeller(addSellerRequest);
        Seller savedSeller = sellerRepository.save(seller);
        AddSellerResponse response = SellerToAddSellerResponse(savedSeller);
        return response;
    }

//    public List<Seller> getSellersSellingCheapestProduct(){
//        List<Product> listOfAllProducts = productRepository.findAll();
//        Collections.sort(listOfAllProducts,(a,b)->{return a.getPrice() - b.getPrice();});
//        List<Seller> possibleSellers = new ArrayList<>();
//        possibleSellers.add(listOfAllProducts.get(0).getSeller());
//        int i = 1;
//        while(listOfAllProducts.get(0).getPrice() == listOfAllProducts.get(i).getPrice()){
//            possibleSellers.add(listOfAllProducts.get(i).getSeller());
//        }
//
//        return possibleSellers;
//    }
}
