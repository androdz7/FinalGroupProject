package com.automationexercise.ui.pages;

import com.automationexercise.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By footer = By.id("footer");
    private By subscriptionText = By.xpath("//footer//h2[text()='Subscription']");
    private By subscriptionEmailInput = By.id("susbscribe_email");
    private By subscriptionSuccessText = By.id("success-subscribe");
    private By subscribeButton = By.id("subscribe");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By getProductNameLocator(String product) {
        return By.xpath("//table[@id='cart_info_table']/tbody/tr/td[@class='cart_description']//a[text()='" + product + "']");
    }

    private By getProductPriceLocator(String product) {
        return By.xpath("//table[@id='cart_info_table']/tbody/tr[.//td[@class='cart_description']//a[text()='" + product + "']]/td[@class='cart_price']/p");
    }

    private By getProductQuantityLocator(String product) {
        return By.xpath("//table[@id='cart_info_table']/tbody/tr[.//td[@class='cart_description']//a[text()='" + product + "']]/td[@class='cart_quantity']/button");
    }

    private By getProductTotalPriceLocator(String product) {
        return By.xpath("//table[@id='cart_info_table']/tbody/tr[.//td[@class='cart_description']//a[text()='" + product + "']]/td[@class='cart_total']/p");
    }

    public String getProductPrice(String product) {
        By locator = getProductPriceLocator(product);
        return getText(locator);
    }

    public String getProductQuantity(String product) {
        By locator = getProductQuantityLocator(product);
        return getText(locator);
    }

    public String getProductTotalPrice(String product) {
        By locator = getProductTotalPriceLocator(product);
        return getText(locator);
    }

    public void scrollDownToFooter() {
        scrollToElementJS(footer);
    }

    public String getSubscriptionText() {
        return getText(subscriptionText);
    }

    public void enterSubscriptionEmail(String email) {
        type(subscriptionEmailInput, email);
    }

    public boolean isSubscriptionSuccessTextVisible() {
        return isDisplayed(subscriptionSuccessText);
    }

    public void clickSubscribeButton() {
        clickJS(subscribeButton);
    }

    public String getProductName(String product) {
        By locator = getProductNameLocator(product);
        return getText(locator);
    }

    public boolean isProductVisible(String product) {
        By locator = getProductNameLocator(product);
        return isDisplayed(locator);
    }
}
