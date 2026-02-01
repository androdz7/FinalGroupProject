package com.automationexercise.ui.tests;

import com.automationexercise.ui.base.BaseTest;
import com.automationexercise.ui.factory.DriverFactory;
import com.automationexercise.ui.pages.CartPage;
import com.automationexercise.ui.pages.HomePage;
import com.automationexercise.ui.utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Marketing")
@Feature("Newsletter Subscription")
public class SubscriptionTest extends BaseTest {

    @Test
    @Story("Verify home page subscription")
    @Severity(SeverityLevel.MINOR)
    public void testHomePageSubscriptionMessage() {

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageVisible(),
                "\n HomePage Is Not Visible \n");

        homePage.scrollDownToFooter();
        String actualSubscriptionText = homePage.getSubscriptionText();
        String expectedSubscriptionText = "SUBSCRIPTION";
        Assert.assertEquals(actualSubscriptionText, expectedSubscriptionText,
                "\n Actual & Expected Subscription Text Do Not Match \n");
        homePage.enterSubscriptionEmail(ConfigReader.get("test.email"));
        homePage.clickSubscribeButton();
        Assert.assertTrue(homePage.isSubscriptionSuccessTextVisible(),
                "\n Subscription Text Is Not Visible \n");
    }

    @Test
    @Story("Verify cart page subscription")
    @Severity(SeverityLevel.MINOR)
    public void testCartPageSubscriptionMessage() {

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageVisible(),
                "\n HomePage Is Not Visible \n");

        CartPage cartPage = homePage.clickCartMenuItem();

        cartPage.scrollDownToFooter();
        String actualSubscriptionText = cartPage.getSubscriptionText();
        String expectedSubscriptionText = "SUBSCRIPTION";
        Assert.assertEquals(actualSubscriptionText, expectedSubscriptionText,
                "\n Actual & Expected Subscription Text Do Not Match \n");
        cartPage.enterSubscriptionEmail(ConfigReader.get("test.email"));
        cartPage.clickSubscribeButton();
        Assert.assertTrue(cartPage.isSubscriptionSuccessTextVisible(),
                "\n Subscription Text Is Not Visible \n");
    }
}
