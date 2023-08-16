package com.example.purna.repository;

import com.example.purna.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    public Card findByCardNo(String cardUsed);
}
