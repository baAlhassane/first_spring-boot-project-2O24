package com.alhas2024.spring2024;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    @JsonProperty
    private String customername;
    private String productname;
    private int quantity;


    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Order(String customername, String productname, int quantity) {
        this.customername = customername;
        this.productname = productname;
        this.quantity = quantity;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "customername='" + customername + '\'' +
                ", productname='" + productname + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
