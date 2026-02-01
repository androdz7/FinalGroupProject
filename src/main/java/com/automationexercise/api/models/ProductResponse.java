package com.automationexercise.api.models;

import java.util.List;

public class ProductResponse {
    private int responseCode;
    private List<Product> products;

    public int getResponseCode() { return responseCode; }
    public List<Product> getProducts() { return products; }
}