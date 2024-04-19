package com.example.apis.repository;

import com.example.apis.model.Account;
import com.example.apis.model.Payment;

public interface PaymentRepository {

    Payment getTransactionById(int transactionId);

    String getPaymentIdById(int transactionId);

    long getAccountNumberById(int transactionId);

    String getPaymentDateById(int transactionId);

    String getPaymentMethodById(int transactionId);

    String getPaymentStatusById(int transactionId);

    double getPaymentAmountById(int transactionId);

    int getPinById(int transactionId);

    Account getPaymentAccount(int transactionId);

}
