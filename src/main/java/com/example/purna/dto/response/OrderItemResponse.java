package com.example.purna.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderItemResponse {
    String orderId;

    int total;

    Date date;

    String cardUsed;

    List<ItemResponse> items;


}
