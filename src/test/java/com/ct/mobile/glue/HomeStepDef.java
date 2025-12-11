package com.ct.mobile.glue;

import com.ct.mobile.config.MobileDriverManager;
import com.ct.mobile.step.HomeStep;
import com.ct.mobile.view.CartView;
import com.ct.mobile.view.DetailProductView;
import com.ct.mobile.view.DetailsAPKView;
import com.ct.mobile.view.ProductsView;

import io.appium.java_client.ScreenshotState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeStepDef {

    String cantidadEsperada;
    String productoEsperado;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeauceLabs(){
        // Implementación del paso
        assertThat(MobileDriverManager.getDriver()).isNotNull();
        Screensho;
    }
    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        new ProductsView().visibleProducts();

    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoCantidadDelSiguienteProduct( int cantidad, String productName){
        productoEsperado = new ProductsView().tapProduct(productName);

        cantidadEsperada = new DetailProductView().increment(cantidad);
        new DetailProductView().tapAdd();
    }
    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente(){
        new DetailProductView().goToCard();
        new CartView().validarCantidad(cantidadEsperada);
    }
}
