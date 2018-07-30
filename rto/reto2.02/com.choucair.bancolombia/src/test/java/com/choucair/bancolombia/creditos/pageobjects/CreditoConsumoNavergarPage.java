package com.choucair.bancolombia.creditos.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@DefaultUrl("https://www.grupobancolombia.com/wps/portal/personas/productos-servicios/creditos/consumo/libre-inversion/simulador-credito-consumo")
public class CreditoConsumoNavergarPage extends PageObject {

	// Label del formulario
	@FindBy(xpath="//*[@id=\"for-detail\"]/div[1]/h1")
	private WebElementFacade lblSimulaTuCredito;
	
	public String getLblSimulaTuCredito() {
		return lblSimulaTuCredito.getText();
	}

	public void verificarFormulario() {
		String lblEsperado = "Simula tu Crédito";
		assertThat("No se encuentra en la pagina del formulario",lblSimulaTuCredito.getText(),containsString(lblEsperado));
		
	}
}
