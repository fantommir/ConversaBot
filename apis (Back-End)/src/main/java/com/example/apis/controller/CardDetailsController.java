package com.example.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apis.model.Account;
import com.example.apis.model.CardDetails;
import com.example.apis.repository.CardDetailsRepository;

@RestController
public class CardDetailsController {
    @Autowired
    public CardDetailsRepository cardDetailsRepository;

    @GetMapping("/accounts/cards/{cardId}")
    public CardDetails getCardIdById(@PathVariable("cardId") int cardId) {
        return cardDetailsRepository.getCardIdById(cardId);
    }

    @GetMapping("/accounts/cards/{cardId}/cardname")
    public String getCardNameById(@PathVariable("cardId") int cardId) {
        return cardDetailsRepository.getCardNameById(cardId);
    }

    @GetMapping("/accounts/cards/{cardId}/cardnumber")
    public String getCardNumberById(@PathVariable("cardId") int cardId) {
        return cardDetailsRepository.getCardNumberById(cardId);
    }

    @GetMapping("/accounts/cards/{cardId}/expirydate")
    public String getExpiryDateById(@PathVariable("cardId") int cardId) {
        return cardDetailsRepository.getExpiryDateById(cardId);
    }

    @GetMapping("/accounts/cards/{cardId}/cardpin")
    public int getCardPinById(@PathVariable("cardId") int cardId) {
        return cardDetailsRepository.getCardPinById(cardId);
    }


    @GetMapping("/cards/{cardId}/account")
    public Account getCardDetailsAccount(@PathVariable int cardId) {
        return cardDetailsRepository.getCardDetailsAccount(cardId);
    }

}
