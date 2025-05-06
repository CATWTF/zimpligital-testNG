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
        wavepayCapabilities.put("appium:appPackage", "mm.com.wavemoney.wavepay");
        wavepayCapabilities.put("appium:appActivity", "mm.com.wavemoney.wavepay.ui.view.MainActivity");

        driver = commonKeywords.openApp(wavepayCapabilities);
        Assert.assertNotNull(driver, "Failed to open Wavepay application.");
    }

    @Test
    public void testLoginWithValidCredentials() {
        // ตอนนี้ 'driver' ถูก Initialize และแอปพลิเคชัน Wavepay เปิดอยู่แล้ว
        // คุณสามารถเริ่มเขียน Steps การทดสอบ Login ได้เลย
        // ตัวอย่าง:
        // driver.findElement(By.id("phone_number_field")).sendKeys("your_phone_number");
        // driver.findElement(By.id("password_field")).sendKeys("your_password");
        // driver.findElement(By.id("login_button")).click();
        System.out.println("Starting Login Test with valid credentials.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}