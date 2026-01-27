package com.automationexercise.pages;

import com.automationexercise.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automationexercise.utils.DropDownUtility.selectByVisibleText;

public class RegistrationPage extends BasePage {

    private By registrationFormTitle = By.xpath("//section[@id='form']//b[text()='Enter Account Information']");
    private By maleRadioButton = By.id("id_gender1");
    private By usernameInput = By.id("name");
    private By passwordInput = By.id("password");
    private By dayDropDown = By.id("days");
    private By monthDropDown = By.id("months");
    private By yearDropDown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By specialOfferCheckbox = By.id("optin");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By address1Input = By.id("address1");
    private By address2Input = By.id("address2");
    private By countryDropDown = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By numberInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//section[@id='form']//button[text()='Create Account']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public AccountCreatedPage clickCreateAccountButton() {
        click(createAccountButton);
        return new AccountCreatedPage(driver);
    }

    public void enterState(String state) {
        type(stateInput, state);
    }

    public void enterCity(String city) {
        type(cityInput, city);
    }

    public void enterZipcode(String code) {
        type(zipcodeInput, code);
    }

    public void enterNumber(String number) {
        type(numberInput, number);
    }

    public void selectCountry(String country) {
        WebElement element = find(countryDropDown);
        selectByVisibleText(element, country);
    }

    public void enterAddress1(String address) {
        type(address1Input, address);
    }

    public void enterAddress2(String address) {
        type(address2Input, address);
    }

    public void enterCompany(String company) {
        type(companyInput, company);
    }

    public void enterFirstName(String firstname) {
        type(firstNameInput, firstname);
    }

    public void enterLastName(String lastname) {
        type(lastNameInput, lastname);
    }

    public boolean isRegistrationFormTitleVisible() {
        return isDisplayed(registrationFormTitle);
    }

    public void selectMaleRadioButton() {
        click(maleRadioButton);
    }

    public void enterUsername(String name) {
        type(usernameInput, name);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void selectDay(String day) {
        WebElement element = find(dayDropDown);
        selectByVisibleText(element, day);
    }

    public void selectMonth(String month) {
        WebElement element = find(monthDropDown);
        selectByVisibleText(element, month);
    }

    public void selectYear(String year) {
        WebElement element = find(yearDropDown);
        selectByVisibleText(element, year);
    }

    public void setBirthDate(String day, String month, String year) {
        selectDay(day);
        selectMonth(month);
        selectYear(year);
    }

    public void selectNewsletterCheckbox() {
        clickJS(newsletterCheckbox);
    }

    public void selectSpecialOfferCheckbox() {
        click(specialOfferCheckbox);
    }

}
