package com.example.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.apis.model.Account;
import com.example.apis.model.UpiDetails;
import com.example.apis.repository.UpiDetailsJpaRepository;
import com.example.apis.repository.UpiDetailsRepository;

@Service
public class UpiDetailsService implements UpiDetailsRepository {

    @Autowired
    private UpiDetailsJpaRepository upiDetailsJpaRepository;

    // Method to get upi details by ID
    @Override
    public UpiDetails getUpiIdById(int upiId) {
        try {
            UpiDetails upi = upiDetailsJpaRepository.findById(upiId).get();
            return upi;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Upi details not found");
        }

    }

    @Override
    public String getUpiNameById(int upiId) {
        try {
            UpiDetails upi = getUpiIdById(upiId);
            return upi.getUpiName();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "upi name not found");
        }
    }

    @Override
    public String getUpiIdentifierById(int upiId) {
        try {
            UpiDetails upi = getUpiIdById(upiId);
            return upi.getUpiIdentifier();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "upi identifier not found");
        }
    }

    @Override
    public String getRegisteredMobileById(int upiId) {
        try {
            UpiDetails upi = getUpiIdById(upiId);
            return upi.getRegisteredMobile();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "registered mobile not found");
        }
    }

    @Override
    public int getUpiPinById(int upiId) {
        try {
            UpiDetails upi = getUpiIdById(upiId);
            return upi.getUpiPin();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "upi pin not found");
        }
    }


    // Method to get account details who done the upi
    public Account getUpiDetailsAccount(int upiId) {
        try {
            UpiDetails upi = upiDetailsJpaRepository.findById(upiId).get();
            Account account = upi.getAccount();
            return account;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
