package com.choucair.bancolombia.tc.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.grupobancolombia.com/wps/portal/personas")

public class TarjetasDeCreditoPage extends PageObject {

	// Link Productos y Servicios
	@FindBy(xpath = "//A[@href='#productosPersonas'][text()='Productos y Servicios']")
	private WebElementFacade lnkProductos;

	// Link Tarjetas de Credito
	@FindBy(xpath = "//A[@href='/wps/portal/personas/productos-servicios/tarjetas-credito'][text()='Tarjetas Crédito']")
	private WebElementFacade lnkTarjetasCredito;
	
	// Link American Express Green
	@FindBy(xpath = "(//UL[@class='list-basic'])[1]")
	private WebElementFacade lstAmericanExpress;
	
	// Link MasterCard Black
	@FindBy(xpath = "(//UL[@class='list-basic'])[2]")
	private WebElementFacade lstMasterCard;

	// Boton Solicitala aqui
	@FindBy(xpath = "(//A[@title='Solicítala aquí'])[1]")
	private WebElementFacade btnSolicitaAmerican;
	
	// Input Nombres
	@FindBy(id ="nombresReq")
	private WebElementFacade txtNombres;

	public WebElementFacade getLstMasterCard() {
		return lstMasterCard;
	}

	public WebElementFacade getLstAmericanExpress() {
		return lstAmericanExpress;
	}

	public void imprimirInfoTarjeta(WebElementFacade lstTarjetaCredito) {

		List<WebElement> webList;

		webList = lstTarjetaCredito.findElements(By.tagName("li"));

		for (int i = 0; i < webList.size(); i++) {
			System.out.println("   -" +webList.get(i).getText());
		}
	}

	public void clickOnProductos() {
		lnkProductos.click();
	}

	public void clickOnTarjetasCredito() {
		lnkTarjetasCredito.click();
	}
	
	public void clickOnSolicitaAmerican() {
		btnSolicitaAmerican.click();
	}

	public void diligenciar_formulario(List<List<String>> data, int i) {
		// TODO Auto-generated method stub
		
	}

}
