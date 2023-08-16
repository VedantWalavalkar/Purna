package com.example.purna.service;

import com.example.purna.dto.request.AddCustomerRequest;
import com.example.purna.dto.response.AddCustomerResponse;
import com.example.purna.model.Cart;
import com.example.purna.model.Customer;
import com.example.purna.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.purna.transformer.CustomerTransformer.AddCustomerRequestToCustomer;
import static com.example.purna.transformer.CustomerTransformer.CustomerToAddCustomerResponse;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest) {
        Customer customer = AddCustomerRequestToCustomer(addCustomerRequest);
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);

        AddCustomerResponse response = CustomerToAddCustomerResponse(savedCustomer);
        return response;
    }

//    public List<Customer> getFemalesBetween20to30WithAtleastKOrders(int k){
//        List<Customer> allFemaleCustomers = customerRepository.getFemaleCustomers();
//        List<Customer> result = new ArrayList<>();
//        for(Customer customer : allFemaleCustomers){
//            if(customer.getAge() >= 20 && customer.getAge() <= 30 && customer.getOrderList().size() >= k)
//                result.add(customer);
//        }
//
//        return result;
//    }
}
