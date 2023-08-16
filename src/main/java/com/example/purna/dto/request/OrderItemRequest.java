package com.example.purna.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemRequest {
    String customerEmailId;

    String cardUsed;

    int cvv;

    int productId;

    int requriedQuantity;


}
