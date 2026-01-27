package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import com.automationexercise.factory.DriverFactory;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesTest extends BaseTest {

    @Test
    public void testTestCasesPageLoads() throws InterruptedException {

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageVisible(),
                "\n HomePage Is Not Visible \n");

        TestCasesPage testCasesPage = homePage.clickTestCasesMenuItem();

        String expectedPageTitle = "Automation Practice Website for UI Testing - Test Cases";
        String actualPageTitle = testCasesPage.getPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle,
                "\n Actual & Expected Test Cases Page Title Do Not Match \n");
    }
}
