package com.zimpligital.keywords.common;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class common {

    public AndroidDriver driver;
    public AndroidDriver openApp(Map<String, Object> capabilitiesMap) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (Map.Entry<String, Object> entry : capabilitiesMap.entrySet()) {
            capabilities.setCapability(entry.getKey(), entry.getValue());
        }

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public void clickAllowNotifications() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement allowButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_button")));
            if (allowButton.isDisplayed()) {
                allowButton.click();
            }
        } catch (Exception e) {
            // Ignore error or log it elsewhere if needed
        }
    }

    public void clickSkipOnIntroPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement skipButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("th.co.crie.tron2.android:id/tvSkip")));
            if (skipButton.isDisplayed()) {
                skipButton.click();
            }
        } catch (Exception e) {
            // Ignore error or log it elsewhere if needed
        }
    }

    public void closeUpdateNotification() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement closeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("th.co.crie.tron2.android:id/ivClose")));
            if (closeButton.isDisplayed()) {
                closeButton.click();
            }
        } catch (Exception e) {
            // Ignore error or log it elsewhere if needed
        }
    }

    public void tapLoginButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("th.co.crie.tron2.android:id/btnLogin")));
            if (loginButton.isDisplayed()) {
                loginButton.click();
            }
        } catch (Exception e) {
            // Ignore error or log it elsewhere if needed
        }
    }

    public void inputPhoneNumber(String phoneNumber) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement phoneInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("th.co.crie.tron2.android:id/etMsisdn")));

            if (phoneInput.isDisplayed()) {
                phoneInput.clear();
                phoneInput.sendKeys(phoneNumber);

                WebElement rootElement = driver.findElement(By.xpath("//android.widget.FrameLayout"));
                rootElement.click();
            }
        } catch (Exception e) {
            // Ignore error or log it elsewhere if needed
        }
    }

}