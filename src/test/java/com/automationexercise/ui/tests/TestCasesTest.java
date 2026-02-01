package com.automationexercise.ui.tests;

import com.automationexercise.ui.base.BaseTest;
import com.automationexercise.ui.factory.DriverFactory;
import com.automationexercise.ui.pages.HomePage;
import com.automationexercise.ui.pages.TestCasesPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Content Management")
@Feature("Test Cases Page")
public class TestCasesTest extends BaseTest {

    @Test
    @Story("Verify test case page loads")
    @Severity(SeverityLevel.CRITICAL)
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
