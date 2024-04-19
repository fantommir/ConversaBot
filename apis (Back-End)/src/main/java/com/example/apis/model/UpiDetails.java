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
@Table(name = "upidetails")
public class UpiDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upiid")
    private int upiId;

    @Column(name = "upiname")
    private String upiName;

    @Column(name = "upiidentifier")
    private String upiIdentifier;

    @Column(name = "registeredmobile")
    private String registeredMobile;

    @Column(name = "upipin")
    private int upiPin;

    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;

    public UpiDetails() {

    }

    public UpiDetails(int upiId, String upiName, String upiIdentifier, String registeredMobile, int upiPin) {
        this.upiId = upiId;
        this.upiName = upiName;
        this.upiIdentifier = upiIdentifier;
        this.registeredMobile = registeredMobile;
        this.upiPin = upiPin;
    }

    public int getUpiId() {
        return upiId;
    }

    public void setUpiId(int upiId) {
        this.upiId = upiId;
    }

    public String getUpiName() {
        return upiName;
    }

    public void setUpiName(String upiName) {
        this.upiName = upiName;
    }

    public String getUpiIdentifier() {
        return upiIdentifier;
    }

    public void setUpiIdentifier(String upiIdentifier) {
        this.upiIdentifier = upiIdentifier;
    }

    public String getRegisteredMobile() {
        return registeredMobile;
    }

    public void setRegisteredMobile(String registeredMobile) {
        this.registeredMobile = registeredMobile;
    }

    public int getUpiPin() {
        return upiPin;
    }

    public void setUpiPin(int upiPin) {
        this.upiPin = upiPin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
