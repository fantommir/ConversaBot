package com.example.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.apis.model.Account;
import com.example.apis.model.Order;
import com.example.apis.service.OrderService;


@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{orderId}")
    public Order getOrderById(@PathVariable("orderId") int orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/orders/{orderId}/orderdate")
    public String getOrderDateById(@PathVariable("orderId") int orderId) {
        return orderService.getOrderDateById(orderId);
    }

    @GetMapping("/orders/{orderId}/orderaddress")
    public String getOrderAddressById(@PathVariable("orderId") int orderId) {
        return orderService.getOrderAddressById(orderId);
    }

    @GetMapping("/orders/{orderId}/price")
    public double getOrderPriceById(@PathVariable("orderId") int orderId) {
        return orderService.getOrderPriceById(orderId);
    }

    @GetMapping("/orders/{orderId}/quantity")
    public int getOrderQuantityById(@PathVariable("orderId") int orderId) {
        return orderService.getOrderQuantityById(orderId);
    }

    @GetMapping("/orders/{orderId}/totalprice")
    public double getOrderTotalPriceById(@PathVariable("orderId") int orderId) {
        return orderService.getOrderTotalPriceById(orderId);
    }

    @GetMapping("/orders/{orderId}/status")
    public String getOrderStatusById(@PathVariable("orderId") int orderId) {
        return orderService.getOrderStatusById(orderId);
    }

    @GetMapping("/orders/{orderId}/deliverydate")
    public String getOrderDeliveryDateById(@PathVariable("orderId") int orderId) {
        return orderService.getOrderDeliveryDateById(orderId);
    }


    @GetMapping("/orders/{orderId}/account")
    public Account getOrderAccount(@PathVariable("orderId") int orderId) {
        return orderService.getOrderAccount(orderId);
    }


}
