package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSingUpPage extends BasePage {

    private By singupNameField = By.xpath("//section[@id='form']//input[@name='name']");
    private By signupEmailField = By.xpath("//section[@id='form']//input[@name='name']/following::input[@name='email']");
    private By signupButton = By.xpath("//section[@id='form']//button[text()='Signup']");
    private By signupTitle = By.xpath("//section[@id='form']//h2[text()='New User Signup!']");

    public boolean isSignUpTitleVisible() {
        return isDisplayed(signupTitle);
    }

    public LoginSingUpPage(WebDriver driver) {
        super(driver);
    }

    public void enterSignUpName(String name) {
        type(singupNameField, name);
    }

    public void enterSignUpEmail(String email) {
        type(signupEmailField, email);
    }

    public RegistrationPage clickSignUpButton() {
        click(signupButton);
        return new RegistrationPage(driver);
    }
}
