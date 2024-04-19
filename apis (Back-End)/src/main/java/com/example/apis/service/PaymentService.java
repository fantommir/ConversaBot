package com.example.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.apis.model.Account;
import com.example.apis.model.Payment;
import com.example.apis.repository.PaymentJpaRepository;
import com.example.apis.repository.PaymentRepository;

@Service
public class PaymentService implements PaymentRepository {

    @Autowired
    private PaymentJpaRepository paymentJpaRepository;

    // Method to get Payment details by ID
    @Override
    public Payment getTransactionById(int transactionId) {
        try {

            Payment payment = paymentJpaRepository.findById(transactionId).get();
            return payment;

        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment details not found");
        }

    }

    // Method to get Payment id by ID
    @Override
    public String getPaymentIdById(int transactionId) {
        try {
            Payment payment = getTransactionById(transactionId);
            return payment.getPaymentId();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment id not found");
        }
    }

    // Method to get Account number by ID
    @Override
    public long getAccountNumberById(int transactionId) {
        try {
            Payment payment = getTransactionById(transactionId);
            return payment.getAccountNumber();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number not found");
        }
    }

    // Method to get Payment date by ID
    @Override
    public String getPaymentDateById(int transactionId) {
        try {
            Payment payment = getTransactionById(transactionId);
            return payment.getPaymentDate();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment date not found");
        }
    }

    // Method to get Payment method by ID
    @Override
    public String getPaymentMethodById(int transactionId) {
        try {
            Payment payment = getTransactionById(transactionId);
            return payment.getPaymentMethod();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment method not found");
        }
    }

    // Method to get Payment status by ID
    @Override
    public String getPaymentStatusById(int transactionId) {
        try {
            Payment payment = getTransactionById(transactionId);
            return payment.getPaymentStatus();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment status not found");
        }
    }

    // Method to get Payment amount by ID
    @Override
    public double getPaymentAmountById(int transactionId) {
        try {
            Payment payment = getTransactionById(transactionId);
            return payment.getPaymentAmount();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment amount not found");
        }
    }

    @Override
    public int getPinById(int transactionId) {
        try {
            Payment payment = getTransactionById(transactionId);
            return payment.getPin();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pin not found");
        }
    }


    // Method to get account details who done the payment
    public Account getPaymentAccount(int transactionId) {
        try {
            Payment payment = paymentJpaRepository.findById(transactionId).get();
            Account account = payment.getAccount();
            return account;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
