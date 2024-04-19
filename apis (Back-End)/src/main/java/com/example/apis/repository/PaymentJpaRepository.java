package com.example.apis.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Account;
import com.example.apis.model.Payment;


@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment, Integer> {
    ArrayList<Payment> findByAccount(Account account);

    List<Payment> findByAccount_AccountId(int accountId);
}
