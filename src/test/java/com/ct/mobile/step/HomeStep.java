package com.ct.mobile.step;

import com.ct.mobile.config.MobileDriverManager;
import com.ct.mobile.view.HomeView;
import com.ct.mobile.view.ProductsView;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomeStep {
    private final AppiumDriver driver;

    public HomeStep() {
        this.driver = MobileDriverManager.getDriver();
        if(this.driver == null) {
            throw new IllegalStateException("El driver no ha sido inicializado. Por favor, inicia el driver antes de crear una instancia de HomeStep.");
        }
    }

    public void selectApp(String apk_name){
        By element = HomeView.selectApp(apk_name);
        driver.findElement(element).click();
    }
}
