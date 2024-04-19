package com.example.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apis.model.Account;
import com.example.apis.model.UpiDetails;
import com.example.apis.repository.UpiDetailsRepository;

@RestController
public class UpiDetailsController {

    @Autowired
    public UpiDetailsRepository upiDetailsRepository;

    @GetMapping("/accounts/upis/{upiId}")
    public UpiDetails getUpiIdById(@PathVariable("upiId") int upiId) {
        return upiDetailsRepository.getUpiIdById(upiId);
    }

    @GetMapping("/accounts/upis/{upiId}/upiname")
    public String getUpiNameById(@PathVariable("upiId") int upiId) {
        return upiDetailsRepository.getUpiNameById(upiId);
    }

    @GetMapping("/accounts/upis/{upiId}/upiidentifier")
    public String getUpiIdentifierById(@PathVariable("upiId") int upiId) {
        return upiDetailsRepository.getUpiIdentifierById(upiId);
    }

    @GetMapping("/accounts/upis/{upiId}/registeredmobile")
    public String getRegisteredMobileById(@PathVariable("upiId") int upiId) {
        return upiDetailsRepository.getRegisteredMobileById(upiId);
    }

    @GetMapping("/accounts/upis/{upiId}/upipin")
    public int getUpiPinById(@PathVariable("upiId") int upiId) {
        return upiDetailsRepository.getUpiPinById(upiId);
    }

    @GetMapping("/upis/{upiId}/account")
    public Account getUpiDetailsAccount(@PathVariable int upiId) {
        return upiDetailsRepository.getUpiDetailsAccount(upiId);
    }

}
