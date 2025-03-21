package org.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_button")
    private WebElement expenseButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/balance_amount")
    private WebElement balanceAmount;

    @AndroidFindBy(id = "com.monefy.app.lite:id/menu_settings")
    private WebElement settingsMenu;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_button")
    private WebElement incomeButton;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void addExpense(String amount, String category) {
        expenseButton.click();
        driver.findElement(By.id("com.monefy.app.lite:id/amount")).sendKeys(amount);
        driver.findElement(By.id("com.monefy.app.lite:id/category_" + category.toLowerCase())).click(); // Assumes category IDs like "category_house"
        driver.findElement(By.id("com.monefy.app.lite:id/keyboard_done")).click();
    }

    public String getBalance() {
        return balanceAmount.getText();
    }

    public void navigateToSettings() {
        settingsMenu.click();
    }

    public void setIncome(String amount, String period) {
        incomeButton.click();
        driver.findElement(By.id("com.monefy.app.lite:id/amount")).sendKeys(amount);
        driver.findElement(By.id("com.monefy.app.lite:id/period_" + period.toLowerCase())).click(); // Assumes period IDs like "period_month"
        driver.findElement(By.id("com.monefy.app.lite:id/keyboard_done")).click();
    }
}