package com.example.apis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cashback")
public class Cashback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cashbackid")
    private int cashbackId;

    @Column(name = "cashbackamount")
    private double cashbackAmount;

    @Column(name = "cashbackdate")
    private String cashbackDate;

    @Column(name = "cashbackstatus")
    private String cashbackStatus;

    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;


    public Cashback() {
    }

    public Cashback(int cashbackId, double cashbackAmount, String cashbackDate, String cashbackStatus) {
        this.cashbackId = cashbackId;
        this.cashbackAmount = cashbackAmount;
        this.cashbackDate = cashbackDate;
        this.cashbackStatus = cashbackStatus;
    }

    public int getCashbackId() {
        return cashbackId;
    }

    public void setCashbackId(int cashbackId) {
        this.cashbackId = cashbackId;
    }

    public double getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(double cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public String getCashbackDate() {
        return cashbackDate;
    }

    public void setCashbackDate(String cashbackDate) {
        this.cashbackDate = cashbackDate;
    }

    public String getCashbackStatus() {
        return cashbackStatus;
    }

    public void setCashbackStatus(String cashbackStatus) {
        this.cashbackStatus = cashbackStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
