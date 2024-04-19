package com.example.apis.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Account;
import com.example.apis.model.CardDetails;

public interface CardDetailsJpaRepository extends JpaRepository<CardDetails, Integer> {
    ArrayList<CardDetails> findByAccount(Account account);

    List<CardDetails> findByAccount_AccountId(int accountId);
}
