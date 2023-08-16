package com.example.purna.transformer;

import com.example.purna.dto.request.AddSellerRequest;
import com.example.purna.dto.response.AddSellerResponse;
import com.example.purna.model.Seller;

public class SellerTransformer {
    public static Seller AddSellerRequestToSeller(AddSellerRequest addSellerRequest){
        return Seller.builder()
                .name(addSellerRequest.getName())
                .age(addSellerRequest.getAge())
                .emailId(addSellerRequest.getEmailId())
                .gender(addSellerRequest.getGender())
                .pan(addSellerRequest.getPan())
                .mobile(addSellerRequest.getMobile())
                .build();
    }
    public static AddSellerResponse SellerToAddSellerResponse(Seller seller){
        return AddSellerResponse.builder()
                .name(seller.getName())
                .emailId(seller.getEmailId())
                .mobile(seller.getMobile())
                .build();
    }
}
