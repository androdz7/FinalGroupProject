package com.automationexercise.api.services;

import com.automationexercise.api.endpoints.Routes;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class ApiService {

    public ApiService() {
        RestAssured.defaultParser = Parser.JSON;
    }

    @Step("Action: GET all products list")
    public Response getAllProducts() {
        return given().filter(new AllureRestAssured()).get(Routes.PRODUCTS_LIST);
    }

    @Step("Action: POST to all products list")
    public Response postAllProducts() {
        return given().filter(new AllureRestAssured()).post(Routes.PRODUCTS_LIST);
    }

    @Step("Action: GET all brands list")
    public Response getAllBrands() {
        return given().filter(new AllureRestAssured()).get(Routes.BRANDS_LIST);
    }

    @Step("Action: PUT to all brands list")
    public Response putAllBrands() {
        return given().filter(new AllureRestAssured()).put(Routes.BRANDS_LIST);
    }

    @Step("Action: POST search product with parameter: {productName}")
    public Response searchProduct(String productName) {
        return given()
                .filter(new AllureRestAssured())
                .formParam("search_product", productName)
                .post(Routes.SEARCH_PRODUCT);
    }

    @Step("Action: POST search product without parameter")
    public Response searchProductNoParam() {
        return given().filter(new AllureRestAssured()).post(Routes.SEARCH_PRODUCT);
    }

    @Step("Action: POST verify login with credentials")
    public Response verifyLogin(String email, String password) {
        return given()
                .filter(new AllureRestAssured())
                .formParam("email", email)
                .formParam("password", password)
                .post(Routes.VERIFY_LOGIN);
    }

    @Step("Action: POST verify login missing parameter")
    public Response verifyLoginMissingParam(Map<String, String> params) {
        return given()
                .filter(new AllureRestAssured())
                .formParams(params)
                .post(Routes.VERIFY_LOGIN);
    }

    @Step("Action: DELETE verify login")
    public Response deleteVerifyLogin() {
        return given().filter(new AllureRestAssured()).delete(Routes.VERIFY_LOGIN);
    }
}