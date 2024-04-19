package com.example.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.apis.model.Account;
import com.example.apis.model.Product;
import com.example.apis.repository.ProductRepository;
import com.example.apis.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/accounts/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        return productRepository.getProductById(productId);
    }

    @GetMapping("/accounts/products/{productId}/name")
    public String getProductNameById(@PathVariable("productId") int productId) {
        return productRepository.getProductNameById(productId);
    }

    @GetMapping("/accounts/products/{productId}/price")
    public double getProductPriceById(@PathVariable("productId") int productId) {
        return productRepository.getProductPriceById(productId);
    }


    @GetMapping("/products/{productId}/account")
    public Account getProductAccount(@PathVariable int productId) {
        return productRepository.getProductAccount(productId);
    }

}
