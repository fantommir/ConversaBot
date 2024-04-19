package com.example.apis.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Account;
import com.example.apis.model.Cashback;


@Repository
public interface CashbackJpaRepository extends JpaRepository<Cashback, Integer> {
    ArrayList<Cashback> findByAccount(Account account);
}

