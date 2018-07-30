package com.choucair.herokuapp.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.List;

import com.choucair.herokuapp.pageobjects.JavaScriptAlertsPage;

import net.thucydides.core.annotations.Step;
import utilidades.Utilidades;

public class JavaScriptAlertsSteps {

	JavaScriptAlertsPage javaScriptAlertsPage;
	long tInicio=System.currentTimeMillis();

	@Step
	public void Ingresar_a_la_pagina_de_herokuapp() {
		// a.Abrir la url.
		javaScriptAlertsPage.open();
		System.out.println("  a.Abrir la url.");
	}

	public void Seleccionar_el_link_JavaScript_Alerts() {
		// a.Clic en el link JavaScript Alerts.
		javaScriptAlertsPage.clicLnkJSAlerts();
		System.out.println("  a.Clic en el link JavaScript Alerts.");

	}

	public void interactuar_con_los_controles(List<List<String>> data, int i) {
		
		String strBotonAlert = data.get(i).get(0);
		String strResultAlert = data.get(i).get(1);
		String strBotonConfirm  = data.get(i).get(2);
		String strBotonPrompt  = data.get(i).get(3);
		String strMensajePrompt  = data.get(i).get(4);

		// a.Clic botón JSAlert.
		System.out.println("  a.Clic botón JSAlert: '" + strBotonAlert +"'");
		javaScriptAlertsPage.clicBtnJSAlert(strBotonAlert);
		
		//b.Verificar etiqueta Result - JSAlert.
		assertThat("La ventana JS Alert no se cerró correctamente", javaScriptAlertsPage.getLblResult(),containsString(strResultAlert));
		System.out.println("  b.Verificar etiqueta Result: '" + javaScriptAlertsPage.getLblResult() + "'");
		System.out.println("");	
		
		// c.Clic botón JSConfirm.
		System.out.println("  c.Clic botón JSConfirm: '" + strBotonConfirm + "'");
		javaScriptAlertsPage.clicBtnJSConfirm(strBotonConfirm);
		
		//d.Verificar etiqueta Result - JSConfirm.
		String strResultConfirm = "Cancel";
		if (!(strBotonConfirm.contains("Cancel"))) {
			strResultConfirm = "Ok";
		} 
		
		assertThat("La ventana JS JSConfirm no se cerró correctamente", javaScriptAlertsPage.getLblResult(),containsString(strResultConfirm));
		System.out.println("  d.Verificar etiqueta Result: '" + javaScriptAlertsPage.getLblResult() + "'");
		System.out.println("");

		// e.Clic botón JSPrompt.
		System.out.println("  e.Clic botón JSPrompt: '" + strBotonPrompt  + "'");
		javaScriptAlertsPage.clicBtnJSPrompt(strBotonPrompt,strMensajePrompt);
		
		//f.Verificar etiqueta Result - JSPrompt.
		assertThat("La ventana JS JSPrompt no se cerró correctamente", javaScriptAlertsPage.getLblResult(),containsString(strMensajePrompt));
		System.out.println("  f.Verificar etiqueta Result: '" + javaScriptAlertsPage.getLblResult() + "'");
		
		javaScriptAlertsPage.miJSAlert("Mi propia ventana - Mauricio Ramírez");
		System.out.println("\n  Tiempo de ejecución: " + (System.currentTimeMillis() - tInicio)/1000 +"seg");
		Utilidades.esperar(3);
	}

}
