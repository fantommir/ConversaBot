package com.example.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.apis.model.Account;
import com.example.apis.model.Cashback;
import com.example.apis.repository.CashbackJpaRepository;
import com.example.apis.repository.CashbackRepository;

@Service
public class CashbackService implements CashbackRepository {

    @Autowired
    private CashbackJpaRepository cashbackJpaRepository;

    // Method to get cashback details by ID
    @Override
    public Cashback getCashbackById(int cashbackId) {
        try {
            Cashback cashback = cashbackJpaRepository.findById(cashbackId).get();
            return cashback;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cashback details not found");
        }

    }

    // Method to get cashback amount by ID
    @Override
    public double getCashbackAmountById(int cashbackId) {
        try {
            Cashback cashback = getCashbackById(cashbackId);
            return cashback.getCashbackAmount();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cashback amount not found");
        }
    }

    // Method to get cashback date by ID
    @Override
    public String getCashbackDateById(int cashbackId) {
        try {
            Cashback cashback = getCashbackById(cashbackId);
            return cashback.getCashbackDate();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cashback date not found");
        }
    }

    // Method to get cashback status by ID
    @Override
    public String getCashbackStatusById(int cashbackId) {
        try {
            Cashback cashback = getCashbackById(cashbackId);
            return cashback.getCashbackStatus();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cashback status not found");
        }
    }


    // Method to get account details who brought the cashback
    public Account getCashbackAccount(int cashbackId) {
        try {
            Cashback cashback = cashbackJpaRepository.findById(cashbackId).get();
            Account account = cashback.getAccount();
            return account;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
