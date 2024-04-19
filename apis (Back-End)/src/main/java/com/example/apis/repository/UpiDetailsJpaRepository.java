package com.example.apis.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Account;
import com.example.apis.model.UpiDetails;


@Repository
public interface UpiDetailsJpaRepository extends JpaRepository<UpiDetails, Integer> {
    ArrayList<UpiDetails> findByAccount(Account account);

    List<UpiDetails> findByAccount_AccountId(int accountId);

}
