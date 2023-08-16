package com.example.purna.model;

import com.example.purna.Enum.Gender;
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
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true)
    String pan;

    int age;

    @Column(unique = true)
    String emailId;

    String mobile;

    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    List<Product> productList = new ArrayList<>();
}
