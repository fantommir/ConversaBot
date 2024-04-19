package com.example.apis.repository;

import com.example.apis.model.Account;
import com.example.apis.model.CardDetails;

public interface CardDetailsRepository { // Interface for flexibility and future database integration

    CardDetails getCardIdById(int cardId);

    String getCardNameById(int cardId);

    String getCardNumberById(int cardId);

    String getExpiryDateById(int cardId);

    int getCardPinById(int cardId);

    Account getCardDetailsAccount(int cardId);
}

