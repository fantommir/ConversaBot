package com.example.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apis.model.Account;
import com.example.apis.model.Payment;
import com.example.apis.repository.PaymentRepository;
import com.example.apis.service.PaymentService;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class PaymentController {

    @Autowired
    public PaymentService paymentService;

    @Autowired
    public PaymentRepository paymentRepository;


    @GetMapping("/accounts/transactions/{transactionId}")
    public Payment getTransactionById(@PathVariable("transactionId") int transactionId) {
        return paymentRepository.getTransactionById(transactionId);
    }

    @GetMapping("/accounts/transactions/{transactionId}/paymentid")
    public String getPaymentIdById(@PathVariable("transactionId") int transactionId) {
        return paymentRepository.getPaymentIdById(transactionId);
    }

    @GetMapping("/accounts/transactions/{transactionId}/accountnumber")
    public long getAccountNumberById(@PathVariable("transactionId") int transactionId) {
        return paymentRepository.getAccountNumberById(transactionId);
    }

    @GetMapping("/accounts/transactions/{transactionId}/date")
    public String getPaymentDateById(@PathVariable("transactionId") int transactionId) {
        return paymentRepository.getPaymentDateById(transactionId);
    }

    @GetMapping("/accounts/transactions/{transactionId}/method")
    public String getPaymentMethodById(@PathVariable("transactionId") int transactionId) {
        return paymentRepository.getPaymentMethodById(transactionId);
    }

    @GetMapping("/accounts/transactions/{transactionId}/status")
    public String getPaymentStatusById(@PathVariable("transactionId") int transactionId) {
        return paymentRepository.getPaymentStatusById(transactionId);
    }

    @GetMapping("/accounts/transactions/{transactionId}/amount")
    public double getPaymentAmountById(@PathVariable("transactionId") int transactionId) {
        return paymentRepository.getPaymentAmountById(transactionId);
    }


    @GetMapping("/transactions/{transactionId}/account")
    public Account getPaymentAccount(@PathVariable int transactionId) {
        return paymentRepository.getPaymentAccount(transactionId);
    }


}
