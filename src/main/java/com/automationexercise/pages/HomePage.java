package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import com.automationexercise.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By loginRegisterMenuItem = By.xpath("//header[@id='header']//a[text()=' Signup / Login']");
    private By deleteAccountMenuItem = By.xpath("//header[@id='header']//a[text()=' Delete Account']");
    private By productsMenuItem = By.xpath("//header[@id='header']//a[text()=' Products']");
    private By testCasesMenuItem = By.xpath("//header[@id='header']//a[text()=' Test Cases']");
    private By loggedInAsUserText = By.xpath("//header[@id='header']//a[text()=' Logged in as ']");
    private By logoutMenuItem = By.xpath("//header[@id='header']//a[text()=' Logout']");
    private By featuresItemsSection = By.cssSelector(".features_items");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AccountDeletedPage clickDeleteAccountMenuItem() {
        clickJS(deleteAccountMenuItem);
        return new AccountDeletedPage(driver);
    }

    public ProductsPage clickProductsMenuItem() {
        scrollToElementJS(productsMenuItem);
        clickJS(productsMenuItem);
        return new ProductsPage(driver);
    }

    public String getLoggedInUsername() {
        return getText(loggedInAsUserText);
    }

    public boolean isLoggedInAsUsernameVisible() {
        return isDisplayed(loggedInAsUserText);
    }

    public LoginSingUpPage clickLoginSignupMenuItem() {
        click(loginRegisterMenuItem);
        return new LoginSingUpPage(driver);
    }

    public boolean isHomePageVisible() {
        return isDisplayed(featuresItemsSection);
    }

    public HomePage clickLogoutMenuItem() {
        click(logoutMenuItem);
        return this;
    }

    public void registerUser(String username, String email, String password) {
        LoginSingUpPage loginSignUpPage = clickLoginSignupMenuItem();

        loginSignUpPage.enterSignUpName(username);
        loginSignUpPage.enterSignUpEmail(email);
        RegistrationPage registrationPage = loginSignUpPage.clickSignUpButton();

        registrationPage.selectMaleRadioButton();
        registrationPage.enterPassword(password);
        registrationPage.setBirthDate("13", "January", "2005");
        registrationPage.selectNewsletterCheckbox();
        registrationPage.selectSpecialOfferCheckbox();
        registrationPage.enterFirstName("Tester");
        registrationPage.enterLastName("Testing");
        registrationPage.enterCompany("Testing Company");
        registrationPage.enterAddress1("2, Tester Testing Alley 13 km, 0131");
        registrationPage.enterAddress2("27 1301, 13km, Testing Tester Alley");
        registrationPage.selectCountry("United States");
        registrationPage.enterState("Georgia");
        registrationPage.enterCity("Atlanta");
        registrationPage.enterZipcode("1234");
        registrationPage.enterNumber("123456789");

        AccountCreatedPage accountCreatedPage = registrationPage.clickCreateAccountButton();
        accountCreatedPage.clickContinueButton();

        clickLogoutMenuItem();
    }

    public TestCasesPage clickTestCasesMenuItem() {
        clickJS(testCasesMenuItem);
        return new TestCasesPage(driver);
    }
}
