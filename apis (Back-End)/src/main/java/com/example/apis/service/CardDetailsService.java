package com.example.apis.service;

import com.example.apis.repository.CardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.apis.model.Account;
import com.example.apis.model.CardDetails;
import com.example.apis.repository.CardDetailsJpaRepository;

@Service
public class CardDetailsService implements CardDetailsRepository {

    @Autowired
    private CardDetailsJpaRepository cardDetailsJpaRepository;

    // Method to get CardDetails by ID
    @Override
    public CardDetails getCardIdById(int cardId) {
        try {
            CardDetails payment = cardDetailsJpaRepository.findById(cardId).get();
            return payment;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card details not found");
        }

    }

    @Override
    public String getCardNameById(int cardId) {
        try {
            CardDetails payment = getCardIdById(cardId);
            return payment.getCardName();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "card name not found");
        }
    }

    @Override
    public String getCardNumberById(int cardId) {
        try {
            CardDetails payment = getCardIdById(cardId);
            return payment.getCardNumber();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "card number not found");
        }
    }

    @Override
    public String getExpiryDateById(int cardId) {
        try {
            CardDetails payment = getCardIdById(cardId);
            return payment.getExpiryDate();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "expiry date not found");
        }
    }

    @Override
    public int getCardPinById(int cardId) {
        try {
            CardDetails payment = getCardIdById(cardId);
            return payment.getCardPin();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "card pin not found");
        }
    }


    // Method to get account details who done the payment
    public Account getCardDetailsAccount(int cardId) {
        try {
            CardDetails payment = cardDetailsJpaRepository.findById(cardId).get();
            Account account = payment.getAccount();
            return account;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
