package org.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "com.monefy.app.lite:id/subscribe_7day")
    private WebElement sevenDayPlan;

    @AndroidFindBy(id = "com.monefy.app.lite:id/autopay_toggle")
    private WebElement autopayToggle;

    public SubscriptionPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectSevenDayPlan() {
        sevenDayPlan.click();
    }

    public void enableAutopay() {
        autopayToggle.click();
    }
}