package com.choucair.zoho.definition;

import java.util.List;

import com.choucair.zoho.steps.RegistroZohoSteps;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EscenariosZohoDefinition {
	
	@Steps
	RegistroZohoSteps registroZohoSteps;


	@Given("^que yo quiero utilizar el CRM Zoho$")
	public void que_yo_quiero_utilizar_el_CRM_Zoho() {
		System.out.println("\n1.Ingresar  a la página:");
		registroZohoSteps.ingresar_a_la_pagina();
	}

	@When("^realizo el registro exitoso$")
	public void realizo_el_registro_exitoso(DataTable dtDatosForm) {
		List<List<String>> data = dtDatosForm.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("\n2.Realizar el registro exitoso:");
			registroZohoSteps.realizar_el_registro_exitoso(data, i);
		}
	}

	@Then("^verifico el acceso a la aplicación$")
	public void verifico_el_acceso_a_la_aplicación() {
		System.out.println("\n3.Verificar el acceso:");
		registroZohoSteps.verificar_el_acceso();
		System.out.println("");
	}
	
	@Given("^que ingreso al CRM Zoho con un usuario registrado$")
	public void que_ingreso_al_CRM_Zoho_con_un_usuario_registrado()  {
		System.out.println("\n1.Ingresar  a la página:");
		registroZohoSteps.ingresar_a_la_pagina();
	}

	@When("^realizo la creacion de una tarea$")
	public void realizo_la_creacion_de_una_tarea(DataTable dtDatosForm)  {
		List<List<String>> data = dtDatosForm.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("\n2.Crear una tarea:");
			registroZohoSteps.crear_una_tarea(data, i);
		}
	}

	@Then("^verifico la tarea creada exitosamente$")
	public void verifico_la_tarea_creada_exitosamente()  {
		System.out.println("\n3.Verificar la tarea:");
		registroZohoSteps.verificar_la_tarea();
		System.out.println("");
	}
	

}
