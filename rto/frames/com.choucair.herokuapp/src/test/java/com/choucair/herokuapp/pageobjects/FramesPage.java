package com.choucair.herokuapp.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class FramesPage extends PageObject{
	
	// Link Frames
	@FindBy(xpath = "//A[@href='/frames']")
	private WebElementFacade lnkFrames;
	
	// Link iFrame
	@FindBy(xpath = "//A[@href='/iframe']")
	private WebElementFacade lnkIframe;
	
	// Area de Texto
	@FindBy(id = "tinymce")
	private WebElementFacade txtArea;
	
	// Boton alinear derecha
	@FindBy(id = "mceu_7")
	private WebElementFacade btnAlinearDerecha;

	public void clicLnkFrames() {
		lnkFrames.click();
	}
	
	public void clicLnkIframe() {
		lnkIframe.click();
	}
	

	public void ingresarDatos(String strMensaje) {
		
		getDriver().switchTo().frame("mce_0_ifr");
		
		txtArea.clear();
		txtArea.sendKeys(strMensaje);
		System.out.println("  b.Ingresar mensaje: '" + strMensaje + "'");
		getDriver().switchTo().defaultContent();
		btnAlinearDerecha.click();
		System.out.println("  c.Alinear a la derecha.");
	}

}


//*[@id="content"]/div/ul/li[2]/a
