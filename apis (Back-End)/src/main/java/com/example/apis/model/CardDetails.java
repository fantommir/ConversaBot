package com.example.apis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carddetails")
public class CardDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardid")
    private int cardId;

    @Column(name = "cardname")
    private String cardName;

    @Column(name = "cardnumber")
    private String cardNumber;

    @Column(name = "expirydate")
    private String expiryDate;

    @Column(name = "cardpin")
    private int cardPin;


    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;

    public CardDetails() {

    }

    public CardDetails(int cardId, String cardName, String cardNumber, String expiryDate, int cardPin) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cardPin = cardPin;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCardPin() {
        return cardPin;
    }

    public void setCardPin(int cardPin) {
        this.cardPin = cardPin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
