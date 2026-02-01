package com.automationexercise.ui.base;

import com.automationexercise.ui.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.get("explicitWait"))));
        this.actions = new Actions(driver);
    }

    // ===== BASIC ACTIONS =====
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isEnabled(By locator) {
        return find(locator).isEnabled();
    }

    protected void hoverOver(By locator) {
        WebElement element = find(locator);
        actions.moveToElement(element)
                .pause(Duration.ofMillis(500))
                .perform();
    }

    // ===== JAVASCRIPT ACTIONS =====

    protected void scrollToElementJS(By locator) {
        WebElement element = find(locator);
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'})",
                element
        );
    }

    protected void clickJS(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected void hoverOverJS(By locator) {
        WebElement element = find(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true}));", element);
    }

    // ===== WAIT METHODS =====

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
