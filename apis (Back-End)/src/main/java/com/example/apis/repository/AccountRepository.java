package com.example.apis.repository;

import com.example.apis.model.*;

import java.util.ArrayList;

public interface AccountRepository {

    public void signUp(Account account);

    public int loginAuth(String mailId, String Password);

    boolean isEmailPresent(String email);


    // Get

    Account getAccountById(int accountId);

    String getUsernameById(int accountId);

    String getMailIdById(int accountId);

    long getPhoneById(int accountId);

    String getPasswordById(int accountId);

    String getdefaultpaymentById(int accountId);

    // Update

    Account updateAccount(int accountId, Account account);

    Account updateuserName(int accountId, Account account);

    Account updatemailID(int accountId, Account account);

    Account updatphone(int accountId, Account account);

    Account updatpassword(int accountId, Account account);

    Account updatedefaultpayment(int accountId, Account account);

    // *************  get the all product details  ***************


    ArrayList<Product> getProductAccount(int accountId);

    ArrayList<Order> getOrderAccount(int accountId);

    ArrayList<Cashback> getCashbackAccount(int accountId);

    ArrayList<Payment> getPaymentAccount(int accountId);

    ArrayList<CardDetails> getCardDetailsAccount(int accountId);

    ArrayList<UpiDetails> getUpiDetailsAccount(int accountId);
}
