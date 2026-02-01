package com.automationexercise.ui.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {

    public static void selectByVisibleText(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Option '" + text + "' not found in dropdown");
        } catch (Exception e) {
            throw new RuntimeException("Error selecting dropdown option: " + e.getMessage());
        }
    }

    public static void selectByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Value '" + value + "' not found in dropdown");
        } catch (Exception e) {
            throw new RuntimeException("Error selecting dropdown value: " + e.getMessage());
        }
    }

    public static void selectByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Index '" + index + "' not found in dropdown");
        } catch (Exception e) {
            throw new RuntimeException("Error selecting dropdown index: " + e.getMessage());
        }
    }
}