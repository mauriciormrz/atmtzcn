package com.choucair.eltiempo.runners.definition;

import java.util.List;

import com.choucair.eltiempo.runners.steps.ElTiempoSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ElTiempoDefinition {
	
	
	@Steps
	ElTiempoSteps elTiempoSteps;
	
	@Given("^que ingreso a la pagina$")
	public void que_ingreso_a_la_pagina()  {
		System.out.println("\n1.Ingresar  a la página:");
		elTiempoSteps.ingresar_a_la_pagina();
	}

	@When("^realizo el registro$")
	public void realizo_el_registro(DataTable dtDatosForm)  {
			List<List<String>> data = dtDatosForm.raw();
			for (int i = 0; i < data.size(); i++) {
				System.out.println("\n2.Realizar el registro:");
				elTiempoSteps.realizar_el_registro(data, i);
			}
	}

	@Then("^verifico el acceso a la aplicación$")
	public void verifico_el_acceso_a_la_aplicación()  {
		System.out.println("\n3.Verificar el acceso:");
		elTiempoSteps.verificar_el_acceso();
		System.out.println("");
	}
}
