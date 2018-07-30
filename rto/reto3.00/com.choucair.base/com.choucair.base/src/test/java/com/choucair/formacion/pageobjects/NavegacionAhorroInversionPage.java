package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@DefaultUrl("https://www.grupobancolombia.com/wps/portal/personas/ ")


public class NavegacionAhorroInversionPage extends PageObject {

	// Boton necesidades
	@FindBy(xpath="//*[@id=\"main-menu\"]/div[2]/ul[1]/li[2]/a")
	public WebElementFacade btnNecesidades;
	
	@FindBy(xpath="//*[@id=\"necesidadesPersonas\"]/div/div[1]/div[1]/div/div[3]/div/a")
	public WebElementFacade btnEstudio;
	
	@FindBy(xpath="(//A[@href='/wps/portal/personas/necesidades/estudiar/simulador-ahorro-inversion/'][text()='Simula tus ahorros'][text()='Simula tus ahorros'])[2]")
	public WebElementFacade btnSimulaTusAhorros;
	
	@FindBy(xpath="//*[@id=\"sim-description\"]/div[1]/h1")
	public WebElementFacade lblBienvenido;
	
	
	public void NavegarFormulario() {
		btnNecesidades.click();
		btnEstudio.click();
		btnSimulaTusAhorros.click();
	}
	
	public void VerificarPresentacionFormulario() {

		String labels ="Bienvenidos al Simulador de Ahorro e Inversión";
		String strMensaje = lblBienvenido.getText();
		assertThat(strMensaje,containsString(labels));
	}
	

}
