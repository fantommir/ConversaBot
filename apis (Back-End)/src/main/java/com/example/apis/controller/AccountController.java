package com.example.apis.controller;

import java.util.ArrayList;

import com.example.apis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.apis.service.AccountService;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    // signUp
    @PostMapping("/signup")
    public String signUp(@RequestBody Account account) {
        accountService.signUp(account);
        return "Account created.";
    }

    // Login
    @GetMapping("/login")
    public int loginAuth(@RequestParam String mailId, String password) {
        return accountService.loginAuth(mailId, password);
//        return "Login Succefull";
    }


    // ************ Get *************

    @GetMapping("/accounts/{accountId}")
    public Account getAccountById(@PathVariable("accountId") int accountId) {
        return accountService.getAccountById(accountId);
    }

    @GetMapping("/accounts/{accountId}/username")
    public String getUsernameById(@PathVariable("accountId") int accountId) {
        return accountService.getUsernameById(accountId);
    }

    @GetMapping("/accounts/{accountId}/mailId")
    public String getMailIdById(@PathVariable("accountId") int accountId) {
        return accountService.getMailIdById(accountId);
    }

    @GetMapping("/accounts/{accountId}/phone")
    public long getPhoneById(@PathVariable("accountId") int accountId) {
        return accountService.getPhoneById(accountId);
    }

    @GetMapping("/accounts/{accountId}/password")
    public String getPasswordById(@PathVariable("accountId") int accountId) {
        return accountService.getPasswordById(accountId);
    }

    @GetMapping("/accounts/{accountId}/defaultpayment")
    public String getdefaultpaymentById(@PathVariable("accountId") int accountId) {
        return accountService.getdefaultpaymentById(accountId);
    }

    // ************ Update *************

    @PutMapping("/accounts/{accountId}")
    public Account updateAccount(@PathVariable("accountId") int accountId, @RequestBody Account account) {
        return accountService.updateAccount(accountId, account);
    }

    @PutMapping("/accounts/userName/{accountId}")
    public Account updateuserName(@PathVariable("accountId") int accountId, @RequestBody Account account) {
        return accountService.updateuserName(accountId, account);
    }

    @PutMapping("/accounts/mailID/{accountId}")
    public Account updatemailID(@PathVariable("accountId") int accountId, @RequestBody Account account) {
        return accountService.updatemailID(accountId, account);
    }

    @PutMapping("/accounts/phone/{accountId}")
    public Account updatphone(@PathVariable("accountId") int accountId, @RequestBody Account account) {
        return accountService.updatphone(accountId, account);
    }

    @PutMapping("/accounts/password/{accountId}")
    public Account updatpassword(@PathVariable("accountId") int accountId, @RequestBody Account account) {
        return accountService.updatpassword(accountId, account);
    }

    @PutMapping("/accounts/defaultpayment/{accountId}")
    public Account updatdefaultpayment(@PathVariable("accountId") int accountId, @RequestBody Account account) {
        return accountService.updatedefaultpayment(accountId, account);
    }


    // ************* get the all product details ***************

    @GetMapping("/accounts/{accountId}/products")
    public ArrayList<Product> getProductAccount(@PathVariable("accountId") int accountId) {
        return accountService.getProductAccount(accountId);
    }

    @GetMapping("/accounts/{accountId}/orders")
    public ArrayList<Order> getOrderAccount(@PathVariable("accountId") int accountId) {
        return accountService.getOrderAccount(accountId);
    }

    @GetMapping("/accounts/{accountId}/cashbacks")
    public ArrayList<Cashback> getCashbackAccount(@PathVariable("accountId") int accountId) {
        return accountService.getCashbackAccount(accountId);
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public ArrayList<Payment> getPaymentAccount(@PathVariable("accountId") int accountId) {
        return accountService.getPaymentAccount(accountId);
    }

    @GetMapping("/accounts/{accountId}/carddetails")
    public ArrayList<CardDetails> getCardDetailsAccount(@PathVariable("accountId") int accountId) {
        return accountService.getCardDetailsAccount(accountId);
    }

    @GetMapping("/accounts/{accountId}/upidetails")
    public ArrayList<UpiDetails> getUpiDetailsAccount(@PathVariable("accountId") int accountId) {
        return accountService.getUpiDetailsAccount(accountId);
    }

    // ************** Pin validation **************

    @GetMapping("/accounts/{accountId}/carddetails/cardpin")
    public boolean validateCardPin(@PathVariable("accountId") int accountId, @RequestParam int cardPin) {
        return accountService.validateCardPin(accountId, cardPin);
    }

    @GetMapping("/accounts/{accountId}/payments/pin")
    public boolean validatePin(@PathVariable("accountId") int accountId, @RequestParam int pin) {
        return (boolean) accountService.validatePin(accountId, pin);
    }

    @GetMapping("/accounts/{accountId}/upidetails/upipin")
    public boolean validateUpiPin(@PathVariable("accountId") int accountId, @RequestParam int upiPin) {
        return accountService.validateUpiPin(accountId, upiPin);
    }

}
