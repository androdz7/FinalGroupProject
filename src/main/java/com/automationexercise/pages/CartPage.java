package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
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
        click(subscribeButton);
    }

}
