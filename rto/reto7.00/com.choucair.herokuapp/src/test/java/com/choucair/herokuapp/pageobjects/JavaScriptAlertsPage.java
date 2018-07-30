package com.choucair.herokuapp.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utilidades.Utilidades;

public class JavaScriptAlertsPage extends PageObject {

	// Link JavaScript Alerts
	@FindBy(xpath = "//A[@href='/javascript_alerts']")
	private WebElementFacade lnkJSAlerts;

	// Boton JavaScript Alert
	@FindBy(xpath = "//BUTTON[@onclick='jsAlert()']")
	private WebElementFacade btnJSAlert;

	// Boton JavaScript Confirm
	@FindBy(xpath = "//BUTTON[@onclick='jsConfirm()']")
	private WebElementFacade btnJSConfirm;

	// Boton JavaScript Prompt
	@FindBy(xpath = "//BUTTON[@onclick='jsPrompt()']")
	private WebElementFacade btnJSPrompt;

	// Label Result
	@FindBy(id = "result")
	private WebElementFacade lblResult;

	public String getLblResult() {
		return lblResult.getText();
	}

	public void clicLnkJSAlerts() {
		lnkJSAlerts.click();
	}

	public void clicBtnJSAlert(String strBoton) {

		btnJSAlert.click();
		JSAlerts(strBoton, null);
	}

	public void clicBtnJSConfirm(String strBoton) {
		btnJSConfirm.click();
		JSAlerts(strBoton, null);
	}

	public void clicBtnJSPrompt(String strBoton, String strMensaje) {
		btnJSPrompt.click();
		JSAlerts(strBoton, strMensaje);
	}

	public void JSAlerts(String strBoton, String strMensaje) {
		Utilidades.esperar(1);
		try {
			Alert alert = getDriver().switchTo().alert();
			String message = alert.getText();
			System.out.println("    Ouput Ventana: '" + message + "'");

			if (strMensaje != null) {
				alert.sendKeys(strMensaje);
				System.out.println("    Input Ventana:'" + strMensaje + "'");
			}

			if (strBoton.contains("Cancel")) {
				alert.dismiss();
			} else {
				alert.accept();
			}
			//strBoton.contains("Cancel")? alert.dismiss(): alert.accept();

		} catch (NoAlertPresentException e) {
			System.out.println("    La Ventana Alert no está presente");
		}
	}
	

	public void miJSAlert(String strMensaje) {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("alert('" + strMensaje + "')");
	}

}
