package com.example.purna.transformer;

import com.example.purna.dto.request.AddCardRequest;
import com.example.purna.dto.response.AddCardResponse;
import com.example.purna.model.Card;

public class CardTransformer {
    public static Card AddCardRequestToCard(AddCardRequest cardRequest){
        return Card.builder()
                .cardNo(cardRequest.getCardNo())
                .cardType(cardRequest.getCardType())
                .cvv(cardRequest.getCvv())
                .validTill(cardRequest.getValidTill())
                .build();
    }

    public static AddCardResponse CardToAddCardResponse(Card card){
        return AddCardResponse.builder()
                .cardType(card.getCardType())
                .validTill(card.getValidTill())
                .build();
    }
}
