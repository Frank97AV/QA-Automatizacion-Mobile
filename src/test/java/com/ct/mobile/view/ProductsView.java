package com.ct.mobile.view;

import static com.ct.mobile.config.MobileDriverManager.driver;
import static com.ct.mobile.config.MobileDriverManager.getDriver;


import static org.apache.commons.io.FileUtils.waitFor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsView {
    private WebDriver driver;
    private WebDriverWait wait;

    private String amount;
    private String product;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup\n")
    private WebElement productsLoad;



    public ProductsView() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }


    public void visibleProducts (){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productsLoad));
    }

    public String tapProduct ( String productName ){
        getDriver().findElement(By.xpath("//android.widget.ImageView[@content-desc='" + productName + "']")).click();
        return String.valueOf(productName);
    }

}
