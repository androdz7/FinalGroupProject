package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import com.automationexercise.factory.DriverFactory;
import com.automationexercise.pages.AccountDeletedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginSingUpPage;
import com.automationexercise.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageVisible(),
                "\n HomePage Is Not Visible \n");

        String timestamp = String.valueOf(System.currentTimeMillis());
        String uniqueUsername = "Tester" + timestamp;
        String uniqueEmail = "tester" + timestamp + "@test.com";
        String uniquePassword = "testing" + timestamp;
        homePage.registerUser(uniqueUsername, uniqueEmail, uniquePassword);

        LoginSingUpPage loginSignUpPage = homePage.clickLoginSignupMenuItem();

        Assert.assertTrue(loginSignUpPage.isLoginTitleVisible(),
                "\n Login Title Is Not Visible \n");
        loginSignUpPage.enterLoginEmail(uniqueEmail);
        loginSignUpPage.enterLoginPassword(uniquePassword);

        homePage = loginSignUpPage.clickLoginButton();
        String ActualLoggedInAsUserText = homePage.getLoggedInUsername();
        String ExpectedLoggedInAsUserText = "Logged in as " + uniqueUsername;
        Assert.assertEquals(ActualLoggedInAsUserText,ExpectedLoggedInAsUserText,
                "\n Actual & Expected Username Do Not Match  \n");

        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccountMenuItem();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextVisible(),
                "\n Account Deleted! Is Not Visible \n");
    }

    @Test
    public void testInvalidLogin() {

        HomePage homePage= new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageVisible(),
                "\n HomePage Is Not Visible \n");

        LoginSingUpPage loginSingUpPage = homePage.clickLoginSignupMenuItem();
        Assert.assertTrue(loginSingUpPage.isLoginTitleVisible(),
                "\n Login Title Is Not Visible \n");

        loginSingUpPage.enterLoginEmail("invalidEmail@test.com");
        loginSingUpPage.enterLoginPassword("InvalidPassword123!");
        loginSingUpPage.clickLoginButton();

        Assert.assertTrue(loginSingUpPage.isLoginErrorMessageVisible(),
                "\n Login Error Message Is Not Visible \n");
    }
}
