package com.selenium.webdriver.steps;

import com.selenium.webdriver.pageobjects.SeleniumWebdriverPage;

import net.thucydides.core.annotations.Step;

public class SeleniumWebdriverSteps {
	
	SeleniumWebdriverPage seleniumWebdriverPage;

	@Step
	public void navegar_a_la_pagina() {
		seleniumWebdriverPage.open();
	}
	
	@Step
	public void encontrar_los_componentes() {
		if (seleniumWebdriverPage.findElementById())
			System.out.println(" a.El elemento fue encontrado usando el atributo id.");
	
		if ( seleniumWebdriverPage.findElementByName())
		   System.out.println(" b.El elemento fue encontrado usando el atributo name.");
	
		if ( seleniumWebdriverPage.findElmentByXpath())
			   System.out.println(" c.El elemento fue encontrado usando xpath.");

		if ( seleniumWebdriverPage.findElmentByClassName())
			   System.out.println(" d.El elemento fue encontrado usando el atributo class.");
		
		if ( seleniumWebdriverPage.findElmentByLinkText())
			   System.out.println(" e.El elemento fue encontrado por linkText.");
		
		if ( seleniumWebdriverPage.findElmentByPartialLinkText())
			   System.out.println(" f.El elemento fue encontrado por partialLinkText.");
		
		if ( seleniumWebdriverPage.findElmentByTagName())
			   System.out.println(" g.El elemento fue encontrado por tagName.");
		
		if ( seleniumWebdriverPage.findElmentByCssSelector())
			   System.out.println(" h.El elemento fue encontrado por cssSelector.");
		
		   System.out.println(" i.Encontrar mas de un elemento.");
		   seleniumWebdriverPage.findElementsByTagName();

	}
	
	@Step
	public void accionar_los_componentes() {
		System.out.println(" a.Clic en un elemento y escribir un texto.");
		seleniumWebdriverPage.clickAndSendKeys();
		
		System.out.println(" b.Clic en botones y casillas de selección.");
		seleniumWebdriverPage.clicRadioButtonAndCheckBoxes();
		
		System.out.println(" c.Selección de una opción drop down y una lista de selección multiple.");
		seleniumWebdriverPage.clicSelect();
		
		System.out.println(" d.Obteniendo un atributo o texto: " + seleniumWebdriverPage.getTextOrAttr());
		
		System.out.println(" e.Cambiando el foco a una ventana.");
		seleniumWebdriverPage.cambiarFocoVentana();
		
		System.out.println(" f.Cambiando el foco a una alerta.");
		seleniumWebdriverPage.cambiarFocoAlerta();
		
		
		System.out.println(" g.Cambiando el foco a un frame.");
		seleniumWebdriverPage.cambiarFocoFrame();
		
		System.out.println(" h.Acciones en cadena.");
		seleniumWebdriverPage.accionesEnCandena();
	}

	@Step
	public void cerrar_el_navegador() {
		seleniumWebdriverPage.salir();
	}

	@Step
	public void espera_explicita() {
		System.out.println(" a.Esperas explícitas.");
		seleniumWebdriverPage.esperasExplicitas();
	}

}
