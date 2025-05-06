package com.zimpligital.keywords.common;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
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
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("Wavepay Application opened successfully with provided capabilities.");
            return driver;
        } catch (MalformedURLException e) {
            System.err.println("Error creating Appium driver: " + e.getMessage());
            return null;
        }
    }

    // คุณสามารถเพิ่ม Keywords อื่นๆ ที่ใช้ร่วมกันได้ที่นี่
}