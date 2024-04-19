package com.example.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.apis.model.Account;
import com.example.apis.model.Product;
import com.example.apis.repository.ProductJpaRepository;
import com.example.apis.repository.ProductRepository;

@Service
public class ProductService implements ProductRepository {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    // Method to get product details by ID
    @Override
    public Product getProductById(int productId) {
        try {

            Product product = productJpaRepository.findById(productId).get();
            return product;

        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product details not found");
        }

    }

    // Method to get product name by ID
    @Override
    public String getProductNameById(int productId) {
        try {
            Product product = getProductById(productId);
            return product.getProductName();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product name not found");
        }
    }

    // Method to get product price by ID
    @Override
    public double getProductPriceById(int productId) {
        try {
            Product product = getProductById(productId);
            return product.getProductPrice();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product name not found");
        }
    }


    // Method to get account details who brought the product
    public Account getProductAccount(int productId) {
        try {
            Product product = productJpaRepository.findById(productId).get();
            Account account = product.getAccount();
            return account;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
