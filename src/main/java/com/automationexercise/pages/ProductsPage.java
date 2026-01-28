package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By continueShoppingButton = By.xpath("//div[@id='cartModal']//button[text()='Continue Shopping']");
    private By viewCartButton = By.xpath("//div[@id='cartModal']//u[text()='View Cart']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private By getProductContainerLocator(String product) {
        return  By.xpath("//p[text()='" + product + "']/ancestor::div[@class='single-products']//div[@class='product-overlay']");
    }

    private void hoverOverProduct(By locator) {
        hoverOver(locator);
    }

    private By getProductAddToCartButtonLocator(String product) {
        return By.xpath("//div[@class='product-image-wrapper'][.//p[text()='" + product + "']]//div[@class='product-overlay']//a[text()='Add to cart']");
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

    public void clickAddToCart(String product) {
        By productLocator = getProductAddToCartButtonLocator(product);
        By productContainerLocator = getProductContainerLocator(product);
        scrollToElementJS(productContainerLocator);
        hoverOverJS(productContainerLocator);
        clickJS(productLocator);
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
    }

    public CartPage clickViewCartButton() {
        click(viewCartButton);
        return new CartPage(driver);
    }
}