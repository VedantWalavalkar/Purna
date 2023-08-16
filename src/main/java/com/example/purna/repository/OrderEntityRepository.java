package com.example.purna.repository;

import com.example.purna.Enum.Category;
import com.example.purna.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity,Integer> {
//    public List<OrderEntity> findByCategory(Category category);
//    public OrderEntity findByOrderId(String orderId);
}
