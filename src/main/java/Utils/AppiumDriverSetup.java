package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumDriverSetup {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() throws Exception {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");
                caps.setCapability("appPackage", "com.monefy.app.lite");
                caps.setCapability("appActivity", "com.monefy.app.lite.MainActivity");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("noReset", true); // Avoid resetting app state
                driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize Appium driver: " + e.getMessage());
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error quitting driver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }
}