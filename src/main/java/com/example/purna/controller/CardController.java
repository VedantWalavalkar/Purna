package com.example.purna.controller;

import com.example.purna.dto.request.AddCardRequest;
import com.example.purna.dto.response.AddCardResponse;
import com.example.purna.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/add_card")
    public ResponseEntity addCard(@RequestBody AddCardRequest addCardRequest){
        try {
            AddCardResponse response = cardService.addCard(addCardRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
