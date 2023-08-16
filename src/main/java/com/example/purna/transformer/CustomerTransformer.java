package com.example.purna.transformer;

import com.example.purna.dto.request.AddCustomerRequest;
import com.example.purna.dto.response.AddCustomerResponse;
import com.example.purna.model.Customer;

public class CustomerTransformer {
    public static Customer AddCustomerRequestToCustomer(AddCustomerRequest addCustomerRequest){
        return Customer.builder()
                .address(addCustomerRequest.getAddress())
                .age(addCustomerRequest.getAge())
                .emailId(addCustomerRequest.getEmailId())
                .name(addCustomerRequest.getName())
                .gender(addCustomerRequest.getGender())
                .build();
    }
    public static AddCustomerResponse CustomerToAddCustomerResponse(Customer customer){
        return AddCustomerResponse.builder()
                .name(customer.getName())
                .address(customer.getAddress())
                .emailId(customer.getEmailId())
                .build();
    }
}
