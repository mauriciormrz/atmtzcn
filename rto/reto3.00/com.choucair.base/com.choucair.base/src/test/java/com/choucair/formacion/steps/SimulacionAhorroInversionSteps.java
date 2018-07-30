package com.choucair.formacion.steps;

import com.choucair.formacion.pageobjects.NavegacionAhorroInversionPage;

import net.thucydides.core.annotations.Step;

public class SimulacionAhorroInversionSteps {
	
	 NavegacionAhorroInversionPage navegacionAhorroInversionPage;
	
	@Step
	public void navegar_formulario_simulacion() {
		
		//a.	Abrir la url.
		navegacionAhorroInversionPage.open();
		System.out.println("  a.Abrir la url.");
		
		//b.	Clic menú “necesidades”.
		//c.	Clic submenú “estudio”.
		//d.	Clic link “simula tus ahorros”.
		navegacionAhorroInversionPage.NavegarFormulario();
		System.out.println("  b.Clic menú 'necesidades'.");
		System.out.println("  c.Clic submenú 'estudio'.");
		System.out.println("  d.Clic link 'simula tus ahorros'.");
		
		//e.	Verificar presentación formulario.
		navegacionAhorroInversionPage.VerificarPresentacionFormulario();
		System.out.println("  e.Verificar presentación formulario.");
	}
}
