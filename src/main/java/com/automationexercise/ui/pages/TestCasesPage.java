package com.automationexercise.ui.pages;

import com.automationexercise.ui.base.BasePage;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
