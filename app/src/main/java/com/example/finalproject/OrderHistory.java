package com.example.finalproject;

import java.util.ArrayList;
import java.util.Date;

public class OrderHistory {
    private int orderCode;
    private double totalAmount;
    private ArrayList<Food> foodList;
    private Date orderDate;
    private String userFullName;
    private String phoneNumber;
    private String address;
    private String status;

    public OrderHistory(int orderCode, double totalAmount, ArrayList<Food> foodList,
                        Date orderDate, String userFullName, String phoneNumber, String address, String status) {
        this.orderCode = orderCode;
        this.totalAmount = totalAmount;
        this.foodList = foodList;
        this.orderDate = orderDate;
        this.userFullName = userFullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.address = status;
    }
}
