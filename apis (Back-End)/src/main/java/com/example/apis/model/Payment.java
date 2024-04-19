package com.example.apis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    private int transactionId;

    @Column(name = "paymentid")
    private String paymentId;

    @Column(name = "accountnumber")
    private long accountNumber;

    @Column(name = "paymentdate")
    private String paymentDate;

    @Column(name = "paymentmethod")
    private String paymentMethod;

    @Column(name = "paymentstatus")
    private String paymentStatus;

    @Column(name = "paymentamount")
    private double paymentAmount;

    @Column(name = "pin")
    private int pin;


    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;

    public Payment() {

    }

    public Payment(int transactionId, String paymentId, long accountNumber, String paymentDate, String paymentMethod, String paymentStatus, double paymentAmount, int pin) {
        this.transactionId = transactionId;
        this.paymentId = paymentId;
        this.accountNumber = accountNumber;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.paymentAmount = paymentAmount;
        this.pin = pin;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
