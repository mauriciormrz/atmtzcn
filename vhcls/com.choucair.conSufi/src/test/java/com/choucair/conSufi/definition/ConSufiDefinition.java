package com.choucair.conSufi.definition;

import java.util.List;

import com.choucair.conSufi.steps.ConSufiSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class ConSufiDefinition {
	
	@Steps
	ConSufiSteps conSufiSteps;

	@Given("^que ingreso a la URL con el Application ID correspondiente$")
	public void que_ingreso_a_la_URL_con_el_Application_ID_correspondiente(DataTable dtDatosFeture) {

		List<List<String>> data = dtDatosFeture.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("\n1.Ingresar a la URL:");
			conSufiSteps.Ingresar_a_la_URL(data, i);
		}
	}

	@When("^se despliega la informacion del solicitante$")
	public void se_despliega_la_informacion_del_solicitante()  {
		System.out.println("\n2.Capturar la informacion del solicitante:");
		conSufiSteps.Capturar_la_informacion_del_solicitante();
	}

	@Then("^se almacena su informacion en base de datos$")
	public void se_almacena_su_informacion_en_base_de_datos()  {
		System.out.println("\n3.Almacenar  la informacion en base de datos:");
		conSufiSteps.Almacenar_la_informacion_en_base_de_datos();
	}

}
