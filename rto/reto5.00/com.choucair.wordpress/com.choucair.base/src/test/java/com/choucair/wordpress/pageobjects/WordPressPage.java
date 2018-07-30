package com.choucair.wordpress.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;
//import net.serenitybdd.core.annotations.findby.By;
//import java.util.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
//import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.wordpress.com")

public class WordPressPage extends PageObject {

	@FindBy(id = "navbar-getstarted-link")
	private WebElementFacade btnEmpezar;

	@FindBy(id = "siteTitle")
	private WebElementFacade txtNombresitio;

	@FindBy(id = "siteTopic")
	private WebElementFacade txtTemasitio;

	@FindBy(id = "share")
	private WebElementFacade chkComparteTuEmpresa;

	@FindBy(id = "promote")
	private WebElementFacade chkPromocionaTuEmpresa;

	@FindBy(xpath = "//*[@class='button is-primary'][1]")
	private WebElementFacade btnContinuar;

	@FindBy(id = "search-component-1")
	private WebElementFacade txtDireccionSitio;

	private FluentWait<WebDriver> wait;

	@FindBy(xpath = "(//BUTTON[@type='button'])[4]")
	private WebElementFacade btnEmpezarPlanGratuito;

	@FindBy(id = "email")
	public WebElementFacade txtMail;

	@FindBy(id = "password")
	public WebElementFacade txtPass;

	@FindBy(xpath = "//BUTTON[@type='submit'][1]")
	public WebElementFacade btnContinuarPaso4;

	@FindBy(xpath = "//P[@class='signup-process-screen__title signup-process-screen__title-test'][1]")
	public WebElementFacade lblSitioEnVivo;

	@FindBy(xpath = "//BUTTON[@class='button email-confirmation__button'][1]")
	public WebElementFacade btnVerMiSitio;

	@FindBy (id="trampoline-header")
	public WebElementFacade lblBienvenido;

	public void clicBtnEmpezar() {

		btnEmpezar.click();
	}

	public void setTxtNombresitio(String txtNombresitio) {

		this.txtNombresitio.sendKeys(txtNombresitio);
	}

	public void setTxtTemasitio(String txtTemasitio) {

		this.txtTemasitio.sendKeys(txtTemasitio);
	}

	public WebElementFacade getTxtNombresitio() {

		return txtNombresitio;
	}

	public void setChkComparteTuEmpresa() {

		if (!chkComparteTuEmpresa.isSelected()) {
			chkComparteTuEmpresa.click();
		}
	}

	public void setChkPromocionaTuEmpresa() {

		if (!chkPromocionaTuEmpresa.isSelected()) {
			chkPromocionaTuEmpresa.click();
		}
	}

	public void clicBtnContinuar() {

		btnContinuar.click();
	}

	public void setTxtDireccionSitio(String txtDireccionSitio) {

		this.txtDireccionSitio.sendKeys(txtDireccionSitio);
	}

	public WebElement buscarElemento(final String strElemento) {

		wait = new FluentWait<WebDriver>(getDriver()).withTimeout(45, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(strElemento));
				return element;
			}
		});
		return element;
	}

	public boolean clicLnkGratis() {

		WebElement webElement = null;

		String strElemento = new String("//*[@class='domain-product-price__price'][1]");
		webElement = buscarElemento(strElemento);

		if (webElement == null) {
			return false;
		} else {
			webElement.click();
			return true;
		}
	}

	public boolean clicBtnEmpezarPlanGratuito() {

		if (isClickable(btnEmpezarPlanGratuito, getDriver())) {
			btnEmpezarPlanGratuito.click();
			return true;
		}
		return false;
	}

	public boolean isClickable(WebElement el, WebDriver driver) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(el));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String setTxtMail(String txtMail) {

		txtMail = txtMail.replace("...", crearUUID());
		this.txtMail.sendKeys(txtMail);
		return txtMail;
	}

	public void setTxtPass(String txtPass) {

		this.txtPass.sendKeys(txtPass);
	}

	public boolean clicBtnContinuarPaso4() {

		if (isClickable(btnContinuarPaso4, getDriver())) {
			btnContinuarPaso4.click();
			return true;
		}
		return false;
	}

	public void esperar(int segundos) {

		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String crearUUID() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
		Calendar calendar = Calendar.getInstance();

		return simpleDateFormat.format(calendar.getTime()).toString();

	}

	public boolean clicBtnVerMiSitio() {
		if (isClickable(btnVerMiSitio, getDriver())) {
			btnVerMiSitio.click();
			return true;
		}
		return false;
	}

	public String verificarSitioEnVivo() {
		if (isClickable(btnVerMiSitio, getDriver())) {
			return lblSitioEnVivo.getText();
		}
		return "";
	}
	
	 public String getLblBienvenido() {
		return lblBienvenido.getText();
	}

}
