package com.automationexercise.ui.pages;

import com.automationexercise.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage {

    private By accountDeletedText = By.xpath("//section[@id='form']//b[text()='Account Deleted!']");

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDeletedTextVisible() {
        return isDisplayed(accountDeletedText);
    }

}
