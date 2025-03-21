package org.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BudgetPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "com.monefy.app.lite:id/budget_amount")
    private WebElement budgetField;

    @AndroidFindBy(id = "com.monefy.app.lite:id/save_budget")
    private WebElement saveBudget;

    @AndroidFindBy(id = "com.monefy.app.lite:id/budget_remaining")
    private WebElement budgetRemaining; // Updated to reflect remaining balance

    public BudgetPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void setBudget(String amount) {
        budgetField.sendKeys(amount);
        saveBudget.click();
    }

    public String getBudgetBalance() {
        return budgetRemaining.getText(); // Returns remaining budget balance
    }
}