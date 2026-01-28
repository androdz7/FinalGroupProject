package com.automationexercise.tests;

import com.automationexercise.base.BasePage;
import com.automationexercise.base.BaseTest;
import com.automationexercise.factory.DriverFactory;
import com.automationexercise.pages.AccountDeletedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginSingUpPage;
import com.automationexercise.utils.ConfigReader;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Login")
public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    @Story("Valid user login")
    @Description("Verify login User with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
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
        String actualLoggedInAsUserText = homePage.getLoggedInUsername();
        String expectedLoggedInAsUserText = "Logged in as " + uniqueUsername;
        Assert.assertEquals(actualLoggedInAsUserText, expectedLoggedInAsUserText,
                "\n Actual & Expected Username Do Not Match  \n");

        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccountMenuItem();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextVisible(),
                "\n Account Deleted! Is Not Visible \n");
    }

    @Test
    @Story("Invalid user login")
    @Description("Verify Login User with incorrect email and password")
    @Severity(SeverityLevel.CRITICAL)
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

    @Test
    @Story("Verify user logout")
    @Description("Verify User can logout")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogout() {

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageVisible(),
                "\n HomePage Is Not Visible \n");

        LoginSingUpPage loginSignUpPage = homePage.clickLoginSignupMenuItem();
        Assert.assertTrue(loginSignUpPage.isLoginTitleVisible(),
                "\n Login Title Is Not Visible \n");

        loginSignUpPage.enterLoginEmail(ConfigReader.get("test.email"));
        loginSignUpPage.enterLoginPassword(ConfigReader.get("test.password"));
        homePage = loginSignUpPage.clickLoginButton();
        Assert.assertTrue(homePage.isLoggedInAsUsernameVisible(),
                "\n Logged In As Username Is Not Visible \n");
        homePage.clickLogoutMenuItem();

        String actualPageTitle = loginSignUpPage.getPageTitle();
        String expectedPageTitle = "Automation Exercise - Signup / Login";
        Assert.assertEquals(actualPageTitle, expectedPageTitle,
                "\n Actual & Expected Page Titles Do Not Match \n");
    }
}
