package com.example.apis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private int orderId;

    @Column(name = "orderdate")
    private String orderDate;

    @Column(name = "orderaddress")
    private String orderAddress;

    @Column(name = "orderprice")
    private double orderPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "totalprice")
    private double totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "deliverydate")
    private String deliveryDate;

    @Column(name = "productname")
    private String productname;

    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;

    public Order() {

    }

    public Order(int orderId, String orderDate, String orderAddress, double orderPrice, int quantity, double totalPrice, String status, String deliveryDate, String productname) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderPrice = orderPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.productname = productname;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.deliveryDate = productname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
