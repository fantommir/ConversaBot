package com.example.apis.repository;

import com.example.apis.model.Account;
import com.example.apis.model.Order;

public interface OrderRepository {

    Order getOrderById(int orderId);

    String getOrderDateById(int orderId);

    String getOrderAddressById(int orderId);

    double getOrderPriceById(int orderId);

    int getOrderQuantityById(int orderId);

    double getOrderTotalPriceById(int orderId);

    String getOrderStatusById(int orderId);

    String getOrderDeliveryDateById(int orderId);


    Account getOrderAccount(int orderId);


}
