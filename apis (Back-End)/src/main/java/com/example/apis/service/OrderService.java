package com.example.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.apis.model.Account;
import com.example.apis.model.Order;
import com.example.apis.repository.OrderJpaRepository;
import com.example.apis.repository.OrderRepository;

@Service
public class OrderService implements OrderRepository {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    public Order getOrderById(int orderId) {
        try {
            Order order = orderJpaRepository.findById(orderId).get();
            return order;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order details not found");
        }
    }

    public String getOrderDateById(int orderId) {
        Order order = getOrderById(orderId);
        return order.getOrderDate();
    }

    public String getOrderAddressById(int orderId) {
        Order order = getOrderById(orderId);
        return order.getOrderAddress();
    }

    public double getOrderPriceById(int orderId) {
        Order order = getOrderById(orderId);
        return order.getOrderPrice();
    }

    public int getOrderQuantityById(int orderId) {
        Order order = getOrderById(orderId);
        return order.getQuantity();
    }

    public double getOrderTotalPriceById(int orderId) {
        Order order = getOrderById(orderId);
        return order.getTotalPrice();
    }

    public String getOrderStatusById(int orderId) {
        Order order = getOrderById(orderId);
        return order.getStatus();
    }

    public String getOrderDeliveryDateById(int orderId) {
        Order order = getOrderById(orderId);
        if (order.getDeliveryDate() != null) {
            return order.getDeliveryDate();
        } else {
            return "Not yet delivered";
        }
    }

    public Account getOrderAccount(int orderId) {
        try {
            Order order = orderJpaRepository.findById(orderId).get();
            Account hotel = order.getAccount();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
