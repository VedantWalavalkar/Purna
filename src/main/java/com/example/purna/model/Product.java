package com.example.purna.model;

import com.example.purna.Enum.Category;
import com.example.purna.Enum.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Enumerated(value = EnumType.STRING)
    Category category;

    int price;

    int availableQuantity;

    @Enumerated(value = EnumType.STRING)
    Status status;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();

    @ManyToOne
    Seller seller;
}
