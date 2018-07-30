package com.choucair.formacion.definition;

import java.util.List;

import com.choucair.formacion.steps.FormularioAhorroInversionSteps;
import com.choucair.formacion.steps.SimulacionAhorroInversionSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SimulacionAhorroInversionDefinition {

	@Steps
	SimulacionAhorroInversionSteps simulacionAhorroInversionSteps;

	@Steps
	FormularioAhorroInversionSteps formularioAhorroInversionSteps;

	@Given("^Navegacion Portal Personas$")
	public void navegacion_Portal_Personas() {
		
		System.out.println("");
		System.out.println("1.Navegar en el portal para presentar formulario:");
		simulacionAhorroInversionSteps.navegar_formulario_simulacion();
	}

	@When("^Se Construye tu Plan de Ahorro Inversion Paso Uno$")
	public void se_Construye_tu_Plan_de_Ahorro_Inversion_Paso_Uno(DataTable dtDatosForm) {
		
		System.out.println("");
		System.out.println("2.Construye tu plan de ahorro Paso - 1");
		List<List<String>> data = dtDatosForm.raw();
		for (int i = 1; i < data.size(); i++) {
			formularioAhorroInversionSteps.diligenciar_datos_tabla(data, i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}
		
		for (int i = 1; i < data.size(); i++) {
			formularioAhorroInversionSteps.verificar_valores_capturados(data, i);
		}
	}

	@When("^Se Aceptan las Disposiciones Legales Paso Dos$")
	public void se_Aceptan_las_Disposiciones_Legales_Paso_Dos() {
		
		System.out.println("");
		System.out.println("3.Disposiciones legales - Paso 2");
		formularioAhorroInversionSteps.diligenciar_disposiciones_legales();
	}


	@Then("^Se Presenta Ahorro Mensual por consola Paso Tres$")
	public void se_Presenta_Ahorro_Mensual_por_consola_Paso_Tres() {
		
		System.out.println("");
		System.out.println("4.Plan ahorro Inversion – Paso 3");
		formularioAhorroInversionSteps.presentar_plan_ahorro_inversion();
	}
}
