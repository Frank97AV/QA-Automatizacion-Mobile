package com.ct.mobile.view;

import static com.ct.mobile.config.MobileDriverManager.getDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DetailProductView {
    private WebDriver driver;
    //private WebDriverWait wait;



    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement increment;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement addToCardButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement cardButton;
    public DetailProductView() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }
    public String increment (int cantidad){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(increment));

        for (int i = 1; i < cantidad ; i++) {
            increment.click();
        }
        return String.valueOf(cantidad);
    }

    public void tapAdd (){
        addToCardButton.click();
    }

    public void goToCard (){
        cardButton.click();
    }
}
