package com.automationexercise.api;

import com.automationexercise.api.services.ApiService;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    protected ApiService apiService;

    @BeforeClass
    public void apiSetup() {
        apiService = new ApiService();
    }
}