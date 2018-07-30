package com.choucair.conSufi.pageobjects;

import org.hamcrest.MatcherAssert;

import com.choucair.conSufi.datos.SolicitantesJDBC;
import com.choucair.conSufi.utilities.Utilities;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ConSufiPage extends PageObject{
	
	static final String URL_APPLICATION_ID ="http://10.8.69.166/om_apm_consumer/EconomicActivity_Detail.jsf?ApplicationId=";
	
	@FindBy(id = "wtUserNameInput")
	private WebElementFacade txtNombreUsuario;

	@FindBy(id = "wtPasswordInput")
	private WebElementFacade txtContrasegna;
	
	@FindBy(xpath = "//SPAN[@class='Login_Button']")
	private WebElementFacade btnIngresar;
	
	@FindBy(xpath = "//*[contains (text(), 'Simulador')]")                    
	private WebElementFacade lnkSimulador;

	@FindBy(xpath = "//*[@class='dashboard-left pull-left OSInline']/span/div/a//*[contains(text(),'Simular')]")
	private WebElementFacade lnkSimular;
	
	@FindBy(xpath = "//*[contains (text(), 'Vendedor')]")                    
	private WebElementFacade lblVendedor;
	
	
	//  APM
	@FindBy(xpath = "//*[contains(@id, 'wtMainContent:wtBasePersonApplicant_IdentificationTypeId')]")
	private WebElementFacade cmbTipoDocumento;

	@FindBy(xpath = "//*[contains(@id, 'wtBasePersonApplicant_IdentificationValue')]")
	private WebElementFacade txtNumeroDocumento;

	@FindBy(xpath = "//*[contains(@id, 'wtBasePersonApplicant_FirstName')]")
	private WebElementFacade txtNombre1;

	@FindBy(xpath = "//*[contains(@id, 'wtBasePersonApplicant_SecondName')]")
	private WebElementFacade txtNombre2;

	@FindBy(xpath = "//*[contains(@id, 'wtBasePersonApplicant_FirstLastName')]")
	private WebElementFacade txtApellido1;

	@FindBy(xpath = "//*[contains(@id, 'wtBasePersonApplicant_SecondLastName')]")
	private WebElementFacade txtApellido2;

	@FindBy(xpath = "//*[contains(@id, 'wtApplicant_BaseContactPhone_PhoneNumber')][@type='text']")
	private WebElementFacade txtCelular;

	@FindBy(xpath = "//*[contains(@id, 'wtBasePersonApplicant_BaseContactEmail_EmailAddress')][@type='email']")
	private WebElementFacade txtCorreoElectronico;
	// Fin APM
	
	public void setTxtNombreUsuario(String strNombreUsuario) {
		txtNombreUsuario.click();
		txtNombreUsuario.clear();
		txtNombreUsuario.sendKeys(strNombreUsuario);
	}

	public void setTxtContrasegna(String strContrasegna) {
		txtContrasegna.click();
		txtContrasegna.clear();
		txtContrasegna.sendKeys(strContrasegna);
		Utilities.takeScreenShotTest("captura", getDriver());
	}
	
	public void clicBtnIngresar() {
		btnIngresar.click();	
	}
	
	public void clicLnkSimulador() {
		lnkSimulador.click();
	}
	

	public void IngresarURL(String strApplicationID) {
		getDriver().get(URL_APPLICATION_ID + strApplicationID + "#!");
		System.out.println("    " + getDriver().getCurrentUrl());
	}

	public void validarSesion() {
		MatcherAssert.assertThat("No se inicio sesion", lnkSimular.isDisplayed());
	}

	public boolean datosSolicitante() {
		return lblVendedor.isPresent();
	}

	public void evidenciaApplicationID(String strApplicationID) {
		Utilities.takeScreenShotTest("captura" + strApplicationID, getDriver());
	}
	
	public String getCmbTipoDocumento() {
		return cmbTipoDocumento.getSelectedVisibleTextValue();
	}
	
	public String getTxtNumeroDocumento() {
		return txtNumeroDocumento.getTextValue();
	}

	public String getTxtNombre1() {
		return txtNombre1.getTextValue();
	}
	
	public String getTxtNombre2() {
		return txtNombre2.getTextValue();
	}
	
	public String getTxtApellido1() {
		return txtApellido1.getTextValue();
	}
	
	public String getTxtApellido2() {
		return txtApellido2.getTextValue();
	}
	
	public String getTxtCelular() {
		return txtCelular.getTextValue();
	}
	
	public String getTxtCorreoElectronico() {
		return txtCorreoElectronico.getTextValue();
	}
	
	public void Almacenar_datos_Solicitante(Integer intApplicationID) {
		
        SolicitantesJDBC solicitantesJDBC = new SolicitantesJDBC();

        solicitantesJDBC.insert(intApplicationID,
        	   (getTxtNombre1()+ " " + getTxtNombre2()).trim(), 
        	   (getTxtApellido2()+ " " + getTxtApellido2()).trim(),
        		getCmbTipoDocumento(),
        		getTxtNumeroDocumento(),
        		getTxtCelular(),
        		getTxtCorreoElectronico());
        System.out.println("  [application_id=" + intApplicationID + ", nombre=" + (getTxtNombre1()+ " " + getTxtNombre2()).trim() + ", apellido=" + (getTxtApellido2()+ " " + getTxtApellido2()).trim() + ']');

	}

}
