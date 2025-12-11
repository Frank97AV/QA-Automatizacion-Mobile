package com.ct.mobile.view;

import static com.ct.mobile.config.MobileDriverManager.getDriver;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartView extends DetailProductView{
    private WebDriver driver;
    private WebDriverWait wait;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    private WebElement getAmount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]")
    private WebElement getProduct;


    public CartView() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public void validarCantidad (String cantidadEsperada ){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(getAmount));
        Assertions.assertEquals(cantidadEsperada, getAmount.getText());
    }

    public void validadPorducto (String productoEsperado){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(getProduct));
        Assertions.assertEquals(productoEsperado, getProduct.getText());
    }

}
