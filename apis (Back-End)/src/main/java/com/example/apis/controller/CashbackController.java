package com.example.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apis.model.Account;
import com.example.apis.model.Cashback;
import com.example.apis.repository.CashbackRepository;
import com.example.apis.service.CashbackService;

@RestController
public class CashbackController {

    @Autowired
    public CashbackService cashbackService;

    @Autowired
    public CashbackRepository cashbackRepository;

    @GetMapping("/accounts/cashbacks/{cashbackId}")
    public Cashback getCashbackById(@PathVariable("cashbackId") int cashbackId) {
        return cashbackRepository.getCashbackById(cashbackId);
    }

    @GetMapping("/accounts/cashbacks/{cashbackId}/amount")
    public double getCashbackAmountById(@PathVariable("cashbackId") int cashbackId) {
        return cashbackRepository.getCashbackAmountById(cashbackId);
    }

    @GetMapping("/accounts/cashbacks/{cashbackId}/date")
    public String getCashbackDateById(@PathVariable("cashbackId") int cashbackId) {
        return cashbackRepository.getCashbackDateById(cashbackId);
    }

    @GetMapping("/accounts/cashbacks/{cashbackId}/status")
    public String getCashbackStatusById(@PathVariable("cashbackId") int cashbackId) {
        return cashbackRepository.getCashbackStatusById(cashbackId);
    }


    @GetMapping("/cashbacks/{cashbackId}/account")
    public Account getCashbackAccount(@PathVariable int cashbackId) {
        return cashbackRepository.getCashbackAccount(cashbackId);
    }

}
