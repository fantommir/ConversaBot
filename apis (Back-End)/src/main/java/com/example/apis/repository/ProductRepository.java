package com.example.apis.repository;

import com.example.apis.model.Account;
import com.example.apis.model.Product;

public interface ProductRepository {

    Product getProductById(int productId);

    String getProductNameById(int productId);

    double getProductPriceById(int productId);

    Account getProductAccount(int productId);

}
