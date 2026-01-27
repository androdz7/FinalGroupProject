package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import com.automationexercise.factory.DriverFactory;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void testProductsDetails() {
        HomePage homePage= new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageVisible(),
                "\n HomePage Is Not Visible \n");

        ProductsPage productsPage = homePage.clickProductsMenuItem();

        String actualPageTitle = productsPage.getPageTitle();
        String expectedPageTitle = "Automation Exercise - All Products";
        Assert.assertEquals(actualPageTitle, expectedPageTitle,
                "\n Actual & Expected Products Page Titles Do Not Match \n");

        String product = "Men Tshirt";
        ProductDetailsPage productDetailsPage = productsPage.clickProductViewButton(product);
        Assert.assertTrue(productDetailsPage.isProductNameVisible(product),
                "Product's Name Is Not Visible");
        Assert.assertTrue(productDetailsPage.isProductCategoryVisible(product),
                "Product's Category Is Not Visible");
        Assert.assertTrue(productDetailsPage.isProductPriceVisible(product),
                "Product's Price Is Not Visible");
        Assert.assertTrue(productDetailsPage.isProductAvailabilityVisible(product),
                "Product's Availability Is Not Visible");
        Assert.assertTrue(productDetailsPage.isProductConditionVisible(product),
                "Product's Condition Is Not Visible");

    }
}
