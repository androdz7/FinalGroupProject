package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import com.automationexercise.factory.DriverFactory;
import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginSingUpPage;
import com.automationexercise.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test
    public void testValidSignUp() {

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        LoginSingUpPage loginSignUpPage = homePage.clickLoginRegisterButton();

        Assert.assertTrue(loginSignUpPage.isSignUpTitleVisible(),
                "\n Sign Sign Up Title Is Not Visible \n");

        String timestamp = String.valueOf(System.currentTimeMillis());
        String userName = "Tester" + timestamp;
        String uniqueEmail = "tester" + timestamp + "@test.com";

        loginSignUpPage.enterSignUpName(userName);
        loginSignUpPage.enterSignUpEmail(uniqueEmail);
        RegistrationPage registrationPage = loginSignUpPage.clickSignUpButton();

        Assert.assertTrue(registrationPage.isRegistrationFormTitleVisible());
        registrationPage.selectMaleRadioButton();
        registrationPage.enterPassword("testing123%");
        registrationPage.setBirthDate("13", "January", "2005");
        registrationPage.selectNewsletterCheckbox();
        registrationPage.selectSpecialOfferCheckbox();
        registrationPage.enterFirstName("Tester");
        registrationPage.enterLastName("Testing");
        registrationPage.enterCompany("IBSU");
        registrationPage.enterAddress1("2, David Agmashenebeli Alley 13 km, 0131");
        registrationPage.enterAddress2("2 0131, 13km, David Agmashenebeli Alley, Tbilisi");
        registrationPage.selectCountry("United States");
        registrationPage.enterState("Georgia");
        registrationPage.enterCity("Tbilisi");
        registrationPage.enterZipcode("0144");
        registrationPage.enterNumber("123456789");

        AccountCreatedPage accountCreatedPage = registrationPage.clickCreateAccountButton();

        Assert.assertTrue(accountCreatedPage.isAccountCreatedTitleVisible(),
                "\n Account Created Title Is Not Visible \n");

        homePage = accountCreatedPage.clickContinueButton();
        Assert.assertTrue(homePage.isLoggedInAsUsernameVisible(),
                "\n Logged In As Username Is Not Visible \n");
        String ExpectedLoggedInAsUserText = "Logged in as " + userName;
        String ActualLoggedInAsUserText = homePage.getLoggedInUsername();
        Assert.assertEquals(ActualLoggedInAsUserText, ExpectedLoggedInAsUserText,
                "\n Actual & Expected Username Does Not Match");
    }
}
