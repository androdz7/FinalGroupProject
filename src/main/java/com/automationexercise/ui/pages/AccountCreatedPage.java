package com.automationexercise.ui.pages;

import com.automationexercise.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private By accountCreatedTitle = By.xpath("//section[@id='form']//b[text()='Account Created!']");
    private By continueButton = By.xpath("//section[@id='form']//a[text()='Continue']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedTitleVisible() {
        return isDisplayed(accountCreatedTitle);
    }

    public HomePage clickContinueButton() {
        clickJS(continueButton);
        return new HomePage(driver);
    }
}
