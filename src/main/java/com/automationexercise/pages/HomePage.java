package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By loginRegisterButton = By.xpath("//header[@id='header']//a[text()=' Signup / Login']");
    private By loggedInAsUserText = By.xpath("//header[@id='header']//a[text()=' Logged in as ']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUsername() {
        return getText(loggedInAsUserText);
    }

    public boolean isLoggedInAsUsernameVisible() {
        return isDisplayed(loggedInAsUserText);
    }

    public LoginSingUpPage clickLoginRegisterButton() {
        click(loginRegisterButton);
        return new LoginSingUpPage(driver);
    }
}
