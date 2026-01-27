package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    private By getProductViewButtonLocator(String product) {
        return By.xpath("//p[text()='" + product + "']/ancestor::div[@class='col-sm-4']//a[text()='View Product']");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public ProductDetailsPage clickProductViewButton(String product) {
        By locator = getProductViewButtonLocator(product);
        scrollToElementJS(locator);
        clickJS(locator);
        return new ProductDetailsPage(driver);
    }
}
