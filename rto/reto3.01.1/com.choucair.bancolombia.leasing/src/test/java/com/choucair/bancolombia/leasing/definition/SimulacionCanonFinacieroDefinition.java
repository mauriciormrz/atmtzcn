package com.choucair.bancolombia.leasing.definition;

import com.choucair.bancolombia.leasing.steps.SimulacionCanonFinancieroSteps;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SimulacionCanonFinacieroDefinition {

	@Steps
	SimulacionCanonFinancieroSteps simulacionCanonFinancieroSteps;

	@Given("^Que navego en el portal para presentar el formulario Simulador de canon financiero$")
	public void que_navego_en_el_portal_para_presentar_el_formulario_Simulador_de_canon_financiero() {
		
		System.out.println("");
		System.out.println("1.Navegar en el portal para presentar formulario:");
		simulacionCanonFinancieroSteps.navegar_portal_para_presentar_formulario();
	}

	@When("^Diligencio el formulario$")
	public void diligencio_el_formulario(DataTable dtDatosForm) {
		
		List<List<String>> data = dtDatosForm.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("");
			System.out.println("2.Diligenciar Formulario Simulador de canon financiero:");
			simulacionCanonFinancieroSteps.diligenciar_formulario_simulador(data, i);
		}
	}

	@Then("^Presento el resultado de la simulacion$")
	public void presento_el_resultado_de_la_simulacion() {
		
		System.out.println("");
		System.out.println("3.Presentar el resultado de la simulacion:");
		simulacionCanonFinancieroSteps.presentar_resultado_simulacion();
	}
	
	@Then("^Verifico mensaje de error$")
	public void verifico_mensaje_de_error() {
		System.out.println("");
		System.out.println("3.Verificar mensajes de error:");
		simulacionCanonFinancieroSteps.verificar_mensajes_de_error();
	}

}
