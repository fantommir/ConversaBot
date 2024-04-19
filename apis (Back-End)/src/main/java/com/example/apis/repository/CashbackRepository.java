package com.example.apis.repository;

import com.example.apis.model.Account;
import com.example.apis.model.Cashback;

public interface CashbackRepository {

    Cashback getCashbackById(int cashbackId);

    double getCashbackAmountById(int cashbackId);

    String getCashbackDateById(int cashbackId);

    String getCashbackStatusById(int cashbackId);


    Account getCashbackAccount(int cashbackId);

}
