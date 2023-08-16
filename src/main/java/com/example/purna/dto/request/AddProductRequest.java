package com.example.purna.dto.request;

import com.example.purna.Enum.Category;
import com.example.purna.Enum.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddProductRequest {
    String name;

    Category category;

    int price;

    int availableQuantity;

    Status status;

    String sellerEmailId;
}
