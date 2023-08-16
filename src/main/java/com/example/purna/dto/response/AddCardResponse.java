package com.example.purna.dto.response;

import com.example.purna.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddCardResponse {
    String cardNo;

    Date validTill;

    CardType cardType;
}
