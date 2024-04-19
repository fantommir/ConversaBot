package com.example.apis.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Account;
import com.example.apis.model.Order;


@Repository
public interface OrderJpaRepository extends JpaRepository<Order, Integer> {
    ArrayList<Order> findByAccount(Account account);
}
