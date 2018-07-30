package com.choucair.bancolombia.tc.definition;

import java.util.List;

import com.choucair.bancolombia.tc.steps.TarjetasDeCreditoSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TarjetasDeCreditoDefinition {

	@Steps
	TarjetasDeCreditoSteps tarjetasDeCreditoSteps;

	@Given("^Que navego en el portal para ir la opcion tarjetas de credito$")

	public void que_navego_en_el_portal_para_ir_la_opcion_tarjetas_de_credito() {

		System.out.println("");
		System.out.println("1.Navegar en el portal para ir la opción Tarjetas de Crédito:");
		tarjetasDeCreditoSteps.navegar_en_el_portal_para_ir_la_opcion_tarjetas_de_credito();
	}

	@When("^Consulto la informacion de las tarjetas de credito$")

	public void consulto_la_información_de_las_tarjetas_de_crédito() {

		System.out.println("");
		System.out.println("2.Consultar la información de las tarjetas de crédito:");
		tarjetasDeCreditoSteps.consultar_la_informacion_de_las_tarjetas_de_credito();
	}

	@Then("^Solicito la tarjeta American Express$")

	public void solicito_la_tarjeta_American_Express(DataTable dtDatosForm) {

		System.out.println("");
		System.out.println("3.Solicitar Tarjeta American Express :");
		List<List<String>> data = dtDatosForm.raw();
		for (int i = 0; i < data.size(); i++) {
			tarjetasDeCreditoSteps.solicitar_tarjeta_American_Express(data, i);
		}
	}

	@Then("^Verifico los mensajes de error$")

	public void verifico_los_mensajes_de_error(DataTable dtDatosForm) {

		System.out.println("");
		System.out.println("3.Solicitar Tarjeta American Express :");
		List<List<String>> data = dtDatosForm.raw();
		for (int i = 0; i < data.size(); i++) {
			tarjetasDeCreditoSteps.verificar_mensajes_error(data, i);
		}
	}
}
