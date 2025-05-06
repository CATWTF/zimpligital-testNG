package com.zimpligital.testcases;

import com.zimpligital.keywords.common.common;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class tc_001_login {

    private common commonKeywords;
    private AndroidDriver driver;
    private Map<String, Object> wavepayCapabilities;

    @BeforeMethod
    public void setUp() {
        commonKeywords = new common();
        wavepayCapabilities = new HashMap<>();
        wavepayCapabilities.put("platformName", "Android");
        wavepayCapabilities.put("appium:platformVersion", "13");
        wavepayCapabilities.put("appium:deviceName", "emulator-5554");
        wavepayCapabilities.put("appium:automationName", "UiAutomator2");
        wavepayCapabilities.put("appium:appPackage", "th.co.crie.tron2.android");
        wavepayCapabilities.put("appium:appActivity", "com.portonics.dtac.ui.home.HomeActivity");

        driver = commonKeywords.openApp(wavepayCapabilities);
        Assert.assertNotNull(driver, "Failed to open dtac application.");
    }

    @Test
    public void loginTest() {
        commonKeywords.clickAllowNotifications();
        commonKeywords.clickSkipOnIntroPage();
        commonKeywords.closeUpdateNotification();
        commonKeywords.tapLoginButton();
        commonKeywords.inputPhoneNumber("0983979923");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
