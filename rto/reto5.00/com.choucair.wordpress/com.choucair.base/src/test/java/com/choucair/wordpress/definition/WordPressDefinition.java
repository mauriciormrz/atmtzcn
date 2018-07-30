package com.choucair.wordpress.definition;

import java.util.List;

import com.choucair.wordpress.steps.WordPressSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class WordPressDefinition {

	@Steps
	WordPressSteps wordPressSteps;

	@Given("^Que navego en el portal para presentar los formularios$")
	public void que_navego_en_el_portal_para_presentar_los_formularios() {
		System.out.println("");
		System.out.println("1.Navegar en el portal para presentar los formularios:");
		wordPressSteps.navegar_en_el_portal_para_presentar_los_formularios();
	}

	@When("^Diligencio el formulario paso uno$")
	public void diligencio_el_formulario_paso_uno(DataTable dtDatosForm) {

		List<List<String>> data = dtDatosForm.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("");
			System.out.println("2.Diligenciar formulario paso 1");
			wordPressSteps.diligenciar_formulario_paso_uno(data, i);
		}
	}

	@When("^Diligencio el formulario paso dos$")
	public void diligencio_el_formulario_paso_dos(DataTable dtDatosForm) {

		List<List<String>> data = dtDatosForm.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println("");
			System.out.println("3.Diligenciar formulario paso 2");
			wordPressSteps.diligenciar_formulario_paso_dos(data, i);
		}
	}

	@When("^Diligencio el formulario paso tres$")
	public void diligencio_el_formulario_paso_tres() {

		System.out.println("");
		System.out.println("4.Diligenciar formulario paso 3");
		wordPressSteps.diligenciar_formulario_paso_tres();
	}

	@When("^Diligencio el formulario paso cuatro$")
	public void diligencio_el_formulario_paso_cuatro(DataTable dtDatosForm) {

		List<List<String>> data = dtDatosForm.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("");
			System.out.println("5.Diligenciar formulario paso 4");
			wordPressSteps.diligenciar_formulario_paso_cuatro(data, i);
		}
	}

	@Then("^Verifico la creación del sitio exitoso$")
	public void verifico_la_creación_del_sitio_exitoso(DataTable dtDatosForm) {
		List<List<String>> data = dtDatosForm.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("");
			System.out.println("6.Verificar creación del sitio exitoso");
			wordPressSteps.verificar_creacion_del_sitio_exitoso(data, i);
		}
	}
}
