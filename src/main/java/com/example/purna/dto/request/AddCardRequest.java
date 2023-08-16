package com.example.purna.dto.request;

import com.example.purna.Enum.CardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddCardRequest {
    String cardNo;

    int cvv;

    Date validTill;

    CardType cardType;

    int customerId;

}
