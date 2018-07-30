package com.choucair.exito.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.exito.com")
public class CompraVirtualPage extends PageObject {

	// Campo de busqueda
	@FindBy(id = "tbxSearch")
	private WebElementFacade txtBusqueda;

	// botón de busqueda
	@FindBy(id = "btnSearch")
	private WebElementFacade btnBusqueda;

	@FindBy(xpath = "//*[@id='filterBy']/div[2]/div[2]/ul")
	private WebElementFacade lstTamagno;

	@FindBy(xpath = "//*[@id='filterBy']/div[2]/div[2]/ul")
	private WebElementFacade lstMarca;

	@FindBy(xpath = "//*[@id='filterBy']/div[3]/div[2]/ul")
	private WebElementFacade lstResolucion;

	@FindBy(xpath = "//*[@class='row product-list']")
	private WebElementFacade lstProductos;

	@FindBy(xpath = "//*[@class='btn btn-warning btn-lg btn-block btn-add-cart']")
	private WebElementFacade btnAgnadirCarrito;

	@FindBy(xpath = "//*[@class='icon icoe-carro-compras-lleno']")
	private WebElementFacade btnCarrito;

	@FindBy(xpath = "//*[@class='col-xs-8 col-name']")
	private WebElementFacade infoProductoCarrito;

	@FindBy(xpath = "//*[@class='name']")
	private WebElementFacade infoPrimerProducto;

	private WebElement primerProducto;

	public void setTxtBusqueda(String strBusqueda) {
		txtBusqueda.click();
		txtBusqueda.sendKeys(strBusqueda);
	}
	

	public void escape() {
		esperar(1);
		Actions action = new Actions(getDriver());
		action.sendKeys(Keys.ESCAPE).build().perform();
		esperar(1);
	}
	

	public void clicBtnCarrito() {
		btnCarrito.click();
	}
	

	public WebElement getPrimerProducto() {
		return primerProducto;
	}
	

	public void clicBtnBusqueda() {
		btnBusqueda.click();
	}
	

	public WebElementFacade getLstTamano() {
		return lstTamagno;
	}
	

	public WebElementFacade getLstMarca() {
		return lstMarca;
	}
	

	public WebElementFacade getLstResolucion() {
		return lstResolucion;
	}
	

	public boolean buscarElementoLista(WebElementFacade lstElemento, String strClassName, String marca) {

		List<WebElement> webList;
		webList = lstElemento.findElements(By.tagName("li"));

		for (int i = 0; i < webList.size(); i++) {
			if (webList.get(i).getText().contains(marca)) {
				webList.get(i).findElement(By.className(strClassName)).click();
				return true;
			}
		}
		return false;
	}
	

	public void imprimirProductos() {

		List<WebElement> webList;
		webList = lstProductos
				.findElements(By.xpath("//*[@class='product search col-xs-12 col-sm-4 col-md-4 col-lg-3']"));

		for (int i = 0; i < webList.size(); i++) {
			System.out.print("    ------------------------------------------------------------------" + "\n    ");

			System.out.println(webList.get(i).getText().replaceAll("\n%", "%").replaceAll("\n", "\n    "));

		}
		System.out.println("    ------------------------------------------------------------------");

		primerProducto = null;
		if (webList.size() > 0) {
			primerProducto = webList.get(0);
		}
	}
	

	public void clicPrimerProducto(WebElement primerProducto) {
		primerProducto.click();
	}
	

	public void clicBtnAgnadirCarrito() {
		btnAgnadirCarrito.click();
	}

	
	public void esperar(int segundos) {

		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public String getInfoProductoCarrito() {
		return infoProductoCarrito.getTextValue();
	}
	

	public String getInfoPrimerProducto() {
		return infoPrimerProducto.getTextValue();
	}
}
