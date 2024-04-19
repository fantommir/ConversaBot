package com.example.apis.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Account;
import com.example.apis.model.Product;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
    ArrayList<Product> findByAccount(Account account);
}