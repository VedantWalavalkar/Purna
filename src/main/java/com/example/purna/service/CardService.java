package com.example.purna.service;

import com.example.purna.dto.request.AddCardRequest;
import com.example.purna.dto.response.AddCardResponse;
import com.example.purna.exception.CustomerNotFoundException;
import com.example.purna.exception.InValidCardException;
import com.example.purna.model.Card;
import com.example.purna.model.Customer;
import com.example.purna.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.purna.transformer.CardTransformer.AddCardRequestToCard;
import static com.example.purna.transformer.CardTransformer.CardToAddCardResponse;

@Service
public class CardService {
    @Autowired
    CustomerRepository customerRepository;

    public AddCardResponse addCard(AddCardRequest addCardRequest) {
        Optional<Customer> optionalCustomer = customerRepository.findById(addCardRequest.getCustomerId());
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer does'nt exist");

        if(addCardRequest.getCardNo().length() != 16){
            throw new InValidCardException("Invalid Card Number");
        }

        if(addCardRequest.getCvv() > 999)
            throw new InValidCardException("Invalid card!");
        Date todayDate = new Date();
        if(todayDate.after(addCardRequest.getValidTill())){
            throw new InValidCardException("Provided Card is Expired, please enter valid card");
        }

        Customer customer = optionalCustomer.get();
        Card card = AddCardRequestToCard(addCardRequest);
        card.setCustomer(customer);

        customer.getCardList().add(card);

        Customer savedCustomer = customerRepository.save(customer);

        List<Card> cardList = savedCustomer.getCardList();
        Card latestCard = cardList.get(cardList.size()-1);

        String cardNo = "************" + card.getCardNo().substring(12);

        AddCardResponse response = CardToAddCardResponse(latestCard);
        response.setCardNo(cardNo);

        return response;
    }
}
