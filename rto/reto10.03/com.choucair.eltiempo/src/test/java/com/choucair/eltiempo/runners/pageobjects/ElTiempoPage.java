package com.choucair.eltiempo.runners.pageobjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ElTiempoPage extends PageObject{

	// Campo nombre 
	@FindBy(id = "first_name")
	private WebElementFacade txtNombre;
	
	// Campo apellidos 
	@FindBy(id = "last_name")
	private WebElementFacade txtApellidos;
	
	// Campo correo electronico 
	@FindBy(id = "email")
	private WebElementFacade txtCorreoElectronico;
	
	// Campo contraseña
	@FindBy(id = "password")
	private WebElementFacade txtContrasegna;
	
	// Check terminos y condiciones
	@FindBy(xpath = "//*[@id=\"terms-div\"]/label")
	private WebElementFacade chkTerminosConciones;
	
	//Boton crear una cuenta
	@FindBy(id = "submitbutton")
	private WebElementFacade btnCrearCuenta;
	
	public void setTxtNombre(String strNombre) {
		
		//getDriver().switchTo().frame(getDriver().findElement(By.id("iframe_registro")));
		getDriver().switchTo().frame("iframe_registro");
		txtNombre.click();
		txtNombre.clear();
		txtNombre.sendKeys(strNombre);
	}
	
	public void setTxtApellidos(String strApellidos) {
		
		txtApellidos.click();
		txtApellidos.clear();
		txtApellidos.sendKeys(strApellidos);
	}
	
	public void setTxtCorreoElectronico(String strCorreoElectronico) {
		
		txtCorreoElectronico.click();
		txtCorreoElectronico.clear();
		txtCorreoElectronico.sendKeys(strCorreoElectronico);
	}
	
	public void setTxtContrasegna(String strContrasegna) {
		
		txtContrasegna.click();
		txtContrasegna.clear();
		txtContrasegna.sendKeys(strContrasegna);
	}
	
	public void setChkTerminosCondiciones() {
		if (!chkTerminosConciones.isSelected()) 
			chkTerminosConciones.click();
	}
	
	public void clickBtnCrearCuenta() {
		btnCrearCuenta.click();
	}
	
}

