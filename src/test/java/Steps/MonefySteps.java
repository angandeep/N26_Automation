package Steps;

import org.Pages.BudgetPage;
import org.Pages.HomePage;
import org.Pages.SubscriptionPage;
import Utils.AppiumDriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MonefySteps {
    private HomePage homePage;
    private SubscriptionPage subscriptionPage;
    private BudgetPage budgetPage;

    @Given("the Monefy app is launched")
    public void launchApp() throws Exception {
        homePage = new HomePage(AppiumDriverSetup.getDriver());
    }

    @When("the user navigates to the subscription page")
    public void navigateToSubscription() throws Exception {
        homePage.navigateToSettings();
        AppiumDriverSetup.getDriver().findElement(By.id("com.monefy.app.lite:id/subscription_menu")).click();
        subscriptionPage = new SubscriptionPage(AppiumDriverSetup.getDriver());
    }

    @When("selects a 7-day subscription plan")
    public void selectSevenDayPlan() {
        subscriptionPage.selectSevenDayPlan();
    }

    @When("enables autopay")
    public void enableAutopay() {
        subscriptionPage.enableAutopay();
    }

    @Then("the subscription is activated")
    public void verifySubscription() throws Exception {
        Assert.assertTrue(AppiumDriverSetup.getDriver().findElement(By.id("com.monefy.app.lite:id/subscription_active")).isDisplayed());
    }

    // Updated to handle "total balance" as "0" dollars
    @Then("the {string} reflects {string} dollars")
    public void verifyBalanceOrBudget(String type, String expectedValue) {
        if ("total balance".equals(type)) {
            Assert.assertEquals(homePage.getBalance(), expectedValue);
        } else if ("budget".equals(type)) {
            Assert.assertEquals(budgetPage.getBudgetBalance(), expectedValue); // Updated method call
        }
    }

    // Combined step for adding expense with category
    @When("user adds an expense of {string} dollars for {string}")
    public void addExpense(String amount, String category) {
        homePage.addExpense(amount, category); // Updated to pass category
    }

    @When("the user sets a budget of {string} dollars")
    public void setBudget(String amount) throws Exception {
        homePage.navigateToSettings();
        AppiumDriverSetup.getDriver().findElement(By.id("com.monefy.app.lite:id/budget_menu")).click();
        budgetPage = new BudgetPage(AppiumDriverSetup.getDriver());
        budgetPage.setBudget(amount);
    }

    @When("the user sets the {string} as {string} dollars for {string}")
    public void setIncome(String type, String amount, String period) throws Exception {
        homePage.setIncome(amount, period); // New method for income
    }

    @After
    public void tearDown() {
        AppiumDriverSetup.quitDriver();
    }
}