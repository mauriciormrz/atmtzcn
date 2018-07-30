package com.choucair.bancolombia.creditos.steps;

import com.choucair.bancolombia.creditos.pageobjects.CreditoConsumoNavergarPage;

import net.thucydides.core.annotations.Step;

public class CreditoConsumoNavegarSteps {
	
	CreditoConsumoNavergarPage creditoConsumoNavergarPage;

	@Step
	public void ir_formulario_simulacion() {
		//a.	Abrir la url.
		creditoConsumoNavergarPage.open();
		
		//b.	Verificar presentación formulario.
		creditoConsumoNavergarPage.verificarFormulario();
	}
}
