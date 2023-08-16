package com.example.purna.repository;

import com.example.purna.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findByEmailId(String emailId);

//    @Query(value = "select * from customers where gender = FEMALE",nativeQuery = true)
//    public List<Customer> getFemaleCustomers();
}
