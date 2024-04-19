package com.example.apis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountid")
    private int accountId;

    @Column(name = "username")
    private String userName;

    @Column(name = "mailid", unique = true, nullable = false)
    private String mailId;

    @Column(name = "phone", unique = true, nullable = false)
    private long phone;

    @Column(name = "password")
    private String password;

    @Column(name = "defaultpayment")
    private String defaultPayment;

    public Account() {

    }

    public Account(int accountId, String userName, String mailId, long phone, String password, String defaultPayment) {
        this.accountId = accountId;
        this.userName = userName;
        this.mailId = mailId;
        this.phone = phone;
        this.password = password;
        this.defaultPayment = defaultPayment;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDefaultPayment() {
        return defaultPayment;
    }

    public void setDefaultPayment(String defaultPayment) {
        this.defaultPayment = defaultPayment;
    }
}
