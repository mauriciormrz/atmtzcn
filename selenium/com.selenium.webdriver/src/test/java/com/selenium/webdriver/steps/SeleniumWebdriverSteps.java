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
	public void interactuar_con_los_componentes() {
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
		
		seleniumWebdriverPage.findElementsByTagName();
	}

}
