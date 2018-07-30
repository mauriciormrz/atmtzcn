package com.choucair.herokuapp.definition;

import java.util.List;

import com.choucair.herokuapp.steps.JavaScriptAlertsSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class JavaScriptAlertsDefinition {

	@Steps
	JavaScriptAlertsSteps javaScriptAlertsSteps;

	
	@Given("^Que el usuario ingresa a la pagina de herokuapp$")

	public void que_el_usuario_ingresa_a_la_pagina_de_herokuapp() {

		System.out.println("\n1.Ingresar a la pagina herokuapp:");
		javaScriptAlertsSteps.Ingresar_a_la_pagina_de_herokuapp();
	}
	

	@When("^Selecciona el link JavaScript Alerts$")

	public void selecciona_el_link_JavaScript_Alerts() {

		System.out.println("\n2.Seleccionar el link JavaScript Alerts:");
		javaScriptAlertsSteps.Seleccionar_el_link_JavaScript_Alerts();
	}
	

	@Then("^Interactua con los controles que hay en esta pantalla$")
	
	public void interactua_con_los_controles_que_hay_en_esta_pantalla(DataTable dtDatosFeture) {

		List<List<String>> data = dtDatosFeture.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("\n3.Interactuar con los controles de la pagina:");
			javaScriptAlertsSteps.interactuar_con_los_controles(data, i);
		}
	}


}
