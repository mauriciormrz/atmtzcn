package com.choucair.bancolombia.creditos.definition;

import java.util.List;

import com.choucair.bancolombia.creditos.steps.CreditoConsumoFormularioSteps;
import com.choucair.bancolombia.creditos.steps.CreditoConsumoNavegarSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CreditoConsumoDefinition {

	@Steps
	CreditoConsumoNavegarSteps creditoConsumoNavegarSteps;

	@Steps
	CreditoConsumoFormularioSteps creditoConsumoFormularioSteps;

	@Given("^Navegar en el portal para presentar formulario$")
	public void navegar_en_el_portal_para_presentar_formulario() {
		creditoConsumoNavegarSteps.ir_formulario_simulacion();
	}

	@When("^Calcular el valor de la cuota$")
	public void calcular_el_valor_de_la_cuota(DataTable dtDatosForm) {
		List<List<String>> data = dtDatosForm.raw();

		for (int i = 1; i < data.size(); i++) {
			creditoConsumoFormularioSteps.datos_tabla_formulario(data, i);
			try {
				Thread.sleep(5000);
			} catch(InterruptedException e) {}
		}
	}

	@Then("^Verificar el resultado de la simulacion$")
	public void verificar_el_resultado_de_la_simulacion() {
		creditoConsumoFormularioSteps.vefificar_valores();
	}
	
	@Then("^Presentar por consola plan de pagos mensual$")
	public void presentar_por_consola_plan_de_pagos_mensual()  {
		creditoConsumoFormularioSteps.presentar_plan_de_pagos();
	}

}
