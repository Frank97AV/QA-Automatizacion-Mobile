package com.ct.mobile.hooks;

import com.ct.mobile.config.MobileDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hook {
    @BeforeAll()
    public static void beforeAll() {
        // Código para inicializar o AppiumDriver antes de cada teste
        String platform = System.getProperty("platform", "android");
        String serverUrl = System.getProperty("appiumServerUrl", "http://127.0.0.1:4723/");
        if (MobileDriverManager.getDriver() == null) {
            MobileDriverManager.startDriver(platform, serverUrl);
        }
    }

    @AfterAll()
    public static void afterAll() {
        // Código para finalizar o AppiumDriver após cada teste
        MobileDriverManager.stopDriver();
    }
}
