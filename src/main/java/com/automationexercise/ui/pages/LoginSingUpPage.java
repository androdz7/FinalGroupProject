package com.automationexercise.ui.pages;

import com.automationexercise.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSingUpPage extends BasePage {

    private By singupNameInput = By.xpath("//section[@id='form']//input[@name='name']");
    private By signupEmailInput = By.xpath("//section[@id='form']//input[@name='name']/following::input[@name='email']");
    private By signupButton = By.xpath("//section[@id='form']//button[text()='Signup']");
    private By signupTitle = By.xpath("//section[@id='form']//h2[text()='New User Signup!']");
    private By loginEmailInput = By.xpath("//section[@id='form']//input[@name='password']//preceding::input[@name='email']");
    private By loginPsswordInput = By.xpath("//section[@id='form']//input[@name='password']");
    private By loginButton = By.xpath("//section[@id='form']//button[text()='Login']");
    private By loginTitle = By.xpath("//section[@id='form']//h2[text()='Login to your account']");
    private By loginErrorMessage = By.xpath("//section[@id='form']//p[text()='Your email or password is incorrect!']");
    private By signupErrorMessage = By.xpath("//section[@id='form']//p[text()='Email Address already exist!']");

    public LoginSingUpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginTitleVisible() {
        return isDisplayed(loginTitle);
    }

    public HomePage clickLoginButton() {
        clickJS(loginButton);
        return new HomePage(driver);
    }

    public void enterLoginPassword(String password) {
        type(loginPsswordInput, password);
    }

    public void enterLoginEmail(String email) {
        type(loginEmailInput, email);
    }

    public boolean isSignUpTitleVisible() {
        return isDisplayed(signupTitle);
    }

    public void enterSignUpName(String name) {
        type(singupNameInput, name);
    }

    public void enterSignUpEmail(String email) {
        type(signupEmailInput, email);
    }

    public RegistrationPage clickSignUpButton() {
        scrollToElementJS(signupButton);
        clickJS(signupButton);
        return new RegistrationPage(driver);
    }

    public boolean isLoginErrorMessageVisible() {
        return isDisplayed(loginErrorMessage);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isSignUpErrorMessageVisible() {
        return isDisplayed(signupErrorMessage);
    }

}
