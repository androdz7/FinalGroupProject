package com.automationexercise.api;

import com.automationexercise.api.services.ApiService;
import com.automationexercise.api.models.ProductResponse;
import com.automationexercise.api.utils.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AutomationExerciseApiTests extends BaseApiTest {

    @Test(priority = 1, description = "API 1: Get All Products List")
    public void testGetAllProducts() {
        ProductResponse productData = apiService.getAllProducts()
                .then().extract().as(ProductResponse.class);

        Assert.assertEquals(productData.getResponseCode(), 200);
        Assert.assertFalse(productData.getProducts().isEmpty(), "Product list should not be empty");
    }

    @Test(priority = 2, description = "API 2: POST To All Products List")
    public void testPostAllProducts() {
        Response response = apiService.postAllProducts();
        Assert.assertEquals(response.jsonPath().get("message"), "This request method is not supported.");
    }

    @Test(priority = 3, description = "API 3: Get All Brands List")
    public void testGetAllBrands() {
        Response response = apiService.getAllBrands();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("brands"));
    }

    @Test(priority = 4, description = "API 4: PUT To All Brands List")
    public void testPutAllBrands() {
        Response response = apiService.putAllBrands();
        Assert.assertEquals(response.jsonPath().get("message"), "This request method is not supported.");
    }

    @Test(priority = 5, description = "API 5: POST To Search Product")
    public void testSearchProduct() {
        ProductResponse searchData = apiService.searchProduct("tshirt")
                .then().extract().as(ProductResponse.class);

        Assert.assertEquals(searchData.getResponseCode(), 200);
        Assert.assertTrue(searchData.getProducts().size() > 0);
    }

    @Test(priority = 6, description = "API 6: POST To Search Product without parameter")
    public void testSearchProductNoParam() {
        Response response = apiService.searchProductNoParam();
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 400);
        Assert.assertEquals(response.jsonPath().get("message"), "Bad request, search_product parameter is missing in POST request.");
    }

}
