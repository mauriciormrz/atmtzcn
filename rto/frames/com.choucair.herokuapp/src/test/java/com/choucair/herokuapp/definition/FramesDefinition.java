package com.choucair.herokuapp.definition;

import com.choucair.herokuapp.steps.FramesSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.util.List;

public class FramesDefinition {

	@Steps
	FramesSteps framesSteps;

	@Given("^Que el usuario ingresa a la pagina de herokuapp$")
	public void que_el_usuario_ingresa_a_la_pagina_de_herokuapp() {

		System.out.println("\n1.Ingresar a la pagina herokuapp:");
		framesSteps.Ingresar_a_la_pagina_herokuapp();
	}

	@When("^Selecciona el link Frames$")
	public void selecciona_el_link_Frames() {

		System.out.println("\n2.Seleccionar el link Frames:");
		framesSteps.Seleccionar_el_link_Frames();
	}

	@Then("^Interactua con los Nested Frames$")
	public void interactua_con_los_Nested_Frames() {
		System.out.println("\n3.Interactuar con los Nested Frames:");
		framesSteps.interactuar_con_los_Nested_Frames();

	}

	@And("^Interactua con los iFrames$")
	public void interactua_con_los_iFrames(DataTable dtDatosFeture) {

		List<List<String>> data = dtDatosFeture.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("\n4.Interactuar con los iFrame:");
			framesSteps.interactuar_con_los_iFrame(data, i);
		}
	}

}
