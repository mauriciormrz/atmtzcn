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

	@When("^Interactuo con los componentes$")
	public void interactuo_con_los_componentes()  {
		System.out.println("");
		System.out.println("1.Interactuar con los componentes:");
		seleniumWebdriverSteps.interactuar_con_los_componentes();
	}

	@Then("^Verifico su funcionamiento$")
	public void verifico_su_funcionamiento() {

	}
}
