package com.automationexercise.tests;

import com.automationexercise.base.BasePage;
import com.automationexercise.base.BaseTest;
import com.automationexercise.factory.DriverFactory;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionTest extends BaseTest {

    @Test
    public void testSubscriptionMessage() {

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
        Assert.assertTrue(homePage.isSubscriptionSuccessText(),
                "\n Subscription Text Is Not Visible \n");
    }
}
