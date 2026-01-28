package com.automationexercise.tests;

import com.automationexercise.base.BaseTest;
import com.automationexercise.factory.DriverFactory;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import org.openqa.selenium.interactions.Actions;
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

        String product = "Blue Top";
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

    @Test
    public void testAddProductsInCart() {
        HomePage homePage= new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageVisible(),
                "\n HomePage Is Not Visible \n");

        ProductsPage productsPage = homePage.clickProductsMenuItem();

        String[] productBlueTop = {"Blue Top", "500", "1", "500"};
        String[] productMenTshirt = {"Men Tshirt", "400", "1", "400"};
        productsPage.clickAddToCart(productBlueTop[0]);
        productsPage.clickContinueShoppingButton();
        productsPage.clickAddToCart(productMenTshirt[0]);

        CartPage cartPage = productsPage.clickViewCartButton();
        Assert.assertTrue(cartPage.isProductVisible(productBlueTop[0]),
                "\n" + productBlueTop[0] + " Is Not Visible \n");
        Assert.assertTrue(cartPage.isProductVisible(productMenTshirt[0]),
                "\n" + productMenTshirt[0] + " Is Not Visible \n");

        Assert.assertTrue(cartPage.getProductPrice(productBlueTop[0]).contains(productBlueTop[1]),
                "\n Actual & Expected Product's " + productBlueTop[0] + " Price Do Not Match \n");
        Assert.assertEquals(cartPage.getProductQuantity(productBlueTop[0]), productBlueTop[2],
                "\n Actual & Expected Product's " + productBlueTop[0] + " Quantity Do Not Match \n");
        Assert.assertTrue(cartPage.getProductTotalPrice(productBlueTop[0]).contains(productBlueTop[3]),
                "\n Actual & Expected Product's " + productBlueTop[0] + " Total Price Do Not Match \n");

        Assert.assertTrue(cartPage.getProductPrice(productMenTshirt[0]).contains(productMenTshirt[1]),
                "\n Actual & Expected Product's " + productMenTshirt[0] + " Price Do Not Match \n");
        Assert.assertEquals(cartPage.getProductQuantity(productMenTshirt[0]), productMenTshirt[2],
                "\n Actual & Expected Product's " + productMenTshirt[0] + " Quantity Do Not Match \n");
        Assert.assertTrue(cartPage.getProductTotalPrice(productMenTshirt[0]).contains(productMenTshirt[3]),
                "\n Actual & Expected Product's " + productMenTshirt[0] + " Total Price Do Not Match \n");
    }
}
