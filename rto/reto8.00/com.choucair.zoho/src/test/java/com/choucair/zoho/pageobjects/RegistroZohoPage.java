package com.choucair.zoho.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistroZohoPage extends PageObject {

	// Campo nombre completo
	@FindBy(id = "namefield")
	private WebElementFacade txtNombreCompleto;

	// Campo correo electronico
	@FindBy(id = "email")
	private WebElementFacade txtCorreoElectronico;

	// Campo contraseña
	@FindBy(name = "password")
	private WebElementFacade txtContrasegna;

	// Combo pais
	@FindBy(id = "country")
	private WebElementFacade cmbPais;

	// Check terminos de servicio
	@FindBy(id ="tos")
	private WebElementFacade chkTerminosDeServicio;

	// Boton comenzar
	@FindBy(id = "signupbtn")
	private WebElementFacade btnComenzar;
	

	// Campo nombre de la empresa
	@FindBy(id = "orgName")
	private WebElementFacade txtNombreEmpresa;
	
	// Campo telefono
	@FindBy(id = "orgPhone")
	private WebElementFacade txtTelefono;
	
	// Campo zona horaria
	//@FindBy(xpath = "(//DIV[@class='labelValCreate mL45'])[2]") //userTimeZone
	@FindBy(id="select2-userTimeZone-container")
	private WebElementFacade cmbZonaHoraria;
	
	// Campo idioma
	@FindBy(id = "select2-language-container")
	private WebElementFacade cmbIdioma;
	
	// Campo moneda local
	@FindBy(id = "select2-currencyLocale-container")
	private WebElementFacade cmbMonedaLocal;
	

	// Boton explorar con los datos de muestra
	@FindBy(id = "profileDetailBtn2")
	private WebElementFacade btnExplorarDatosDeMuestra;
	
	// Label de bienvenida
	@FindBy(id = "show-uName")
	private WebElementFacade lblBienvenida;


	public String getLblBienvenida() {
		return lblBienvenida.getTextValue();
	}

	public void setTxtNombreCompleto(String strNombreCompleto) {
		txtNombreCompleto.click();
		txtNombreCompleto.clear();
		txtNombreCompleto.sendKeys(strNombreCompleto);
	}

	public String setTxtCorreoElectronico(String strCorreoElectronico) {

		strCorreoElectronico = strCorreoElectronico.replace("...", crearUUID());
		txtCorreoElectronico.click();
		txtCorreoElectronico.clear();

		txtCorreoElectronico.sendKeys(strCorreoElectronico);
		return strCorreoElectronico;
	}

	public void setTxtContrasegna(String strContrasegna) {
		txtContrasegna.click();
		txtContrasegna.clear();
		txtContrasegna.sendKeys(strContrasegna);
	}

	public void setCmbPais(String strPais) {
		cmbPais.click();
		cmbPais.selectByVisibleText(strPais);
	}

	
	public void setChkTerminosDeServicio() {

		if ( !getDriver().findElement(By.id("tos")).isSelected() )  { 
             getDriver().findElement(By.id("tos")).click(); 
        }
	}
	

	public void clickBtnComenzar() {
		btnComenzar.click();
	}
	
	public void clickBtnExplorarDatosDeMuestra() {
		btnExplorarDatosDeMuestra.click();
	}
	
	
	public void setTxtNombreEmpresa(String strNombreEmpresa) {
		txtNombreEmpresa.click();
		txtNombreEmpresa.clear();
		txtNombreEmpresa.sendKeys(strNombreEmpresa);
		//getDriver().findElement(By.id("orgName")).sendKeys(strNombreEmpresa); 
	}
	
	public void setTxtTelefono(String strTelefono) {
		txtTelefono.click();
		txtTelefono.clear();
		txtTelefono.sendKeys(strTelefono);
	}

	
	public void setCmbZonaHoraria(String strZonaHoraria) {
		//getDriver().findElement(By.id("userTimeZone")).click();
		//getDriver().findElement(By.id("userTimeZone")).sendKeys(strZonaHoraria); 
		cmbZonaHoraria.click();
		cmbZonaHoraria.sendKeys(strZonaHoraria);
		cmbZonaHoraria.setWindowFocus();
	}

	public void setCmbIdioma(String strIdioma) {
		//cmbIdioma.click();
		//cmbIdioma.selectByVisibleText(strIdioma);
	}

	public void setCmbMonedaLocal(String strMonedaLocal) {
		//cmbMonedaLocal.click();
		//cmbMonedaLocal.selectByVisibleText(strMonedaLocal);
	}

	public String crearUUID() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
		Calendar calendar = Calendar.getInstance();

		return simpleDateFormat.format(calendar.getTime()).toString();

	}

	
	public void esperar(int segundos) {

		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
