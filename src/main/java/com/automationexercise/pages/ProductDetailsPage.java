package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private By getProductNameLocator(String product) {
        return By.xpath("//section//h2[text()='"+ product +"']");
    }

    private By getProductCategoryLocator(String product) {
        return By.xpath("//section//h2[text()='"+ product +"']//following-sibling::p[contains(text(), 'Category')]");
    }

    private By getProductPriceLocator(String product) {
        return By.xpath("//section//h2[text()='"+ product +"']//following::span[contains(text(), 'Rs')]");
    }

    private By getProductAvailabilityLocator(String product) {
        return By.xpath("//section//h2[text()='" + product + "']//following::p/b[contains(text(), 'Availability:')]//parent::p");
    }

    private By getProductConditionLocator(String product) {
        return By.xpath("//section//h2[text()='" + product + "']//following::p/b[contains(text(), 'Condition:')]//parent::p");
    }

    private By getProductBrandLocator(String product) {
        return By.xpath("//section//h2[text()='" + product + "']//following::p/b[contains(text(), 'Brand:')]//parent::p");
    }

    public boolean isProductNameVisible(String product) {
        return isDisplayed(getProductNameLocator(product));
    }

    public boolean isProductCategoryVisible(String product) {
        return isDisplayed(getProductCategoryLocator(product));
    }

    public boolean isProductPriceVisible(String product) {
        return isDisplayed(getProductPriceLocator(product));
    }

    public boolean isProductAvailabilityVisible(String product) {
        return isDisplayed(getProductAvailabilityLocator(product));
    }

    public boolean isProductConditionVisible(String product) {
        return isDisplayed(getProductConditionLocator(product));
    }

    public boolean isProductBrandVisible(String product) {
        return isDisplayed(getProductBrandLocator(product));
    }
}
