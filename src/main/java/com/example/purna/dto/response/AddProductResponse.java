package com.example.purna.dto.response;

import com.example.purna.Enum.Category;
import com.example.purna.Enum.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AddProductResponse {
    String name;

    Category category;

    int price;

    int availableQuantity;

    Status status;
}
