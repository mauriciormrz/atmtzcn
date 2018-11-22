package com.selenium.webdriver.definition;

import com.selenium.webdriver.steps.SeleniumWebdriverSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SeleniumWebdriverDefinition {

	@Steps
	SeleniumWebdriverSteps seleniumWebdriverSteps;
	
	@Given("^Navego a la pagina de internet para pruebas$")
	public void navego_a_la_pagina_de_internet_para_pruebas()  {
		System.out.println("");
		System.out.println("1.Navegar a la pagina:");
		seleniumWebdriverSteps.navegar_a_la_pagina();
	}

	@When("^Encuentro los componentes$")
	public void encuentro_los_componentes()  {
		System.out.println("");
		System.out.println("2.Encontrar los componentes:");
		seleniumWebdriverSteps.encontrar_los_componentes();
	}
	
	@When("^Acciono los elementos$")
	public void acciono_los_elementos()  {
		System.out.println("");
		System.out.println("3.Accionar los componentes:");
		seleniumWebdriverSteps.accionar_los_componentes();
	}

	@Then("^Verifico su funcionamiento$")
	public void verifico_su_funcionamiento() {
		System.out.println("");
		System.out.println("4.Verificar su funcionamiento:");
	}
	
	@Then("^Cierro el navegador$")
	public void cierro_el_navegador()  {
		System.out.println("");
		System.out.println("5.Cerrar el navegador:");
		seleniumWebdriverSteps.cerrar_el_navegador();
	}
}
