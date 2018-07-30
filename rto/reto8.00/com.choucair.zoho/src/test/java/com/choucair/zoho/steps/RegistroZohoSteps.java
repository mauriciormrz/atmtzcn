package com.choucair.zoho.steps;


import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.choucair.zoho.pageobjects.RegistroZohoPage;

import net.thucydides.core.annotations.Step;

public class RegistroZohoSteps {

	RegistroZohoPage registroZohoPage;
	String strNombreCompleto;

	@Step
	public void ingresar_a_la_pagina() {
		// a.Abrir navegador e ir a la url.
		registroZohoPage.open();
		System.out.println("  a.Abrir navegador e ir a  la url.");
	}

	@Step
	public void realizar_el_registro_exitoso(List<List<String>> data, int i) {
		
		strNombreCompleto = data.get(i).get(0).trim();
		String strCorreoElectronico = data.get(i).get(1).trim();
		String strContrasegna = data.get(i).get(2).trim();
		String strPais = data.get(i).get(3).trim();
		
		String strNombreEmpresa = data.get(i).get(4).trim();
		String strTelefono = data.get(i).get(5).trim();
		String strZonaHoraria = data.get(i).get(6).trim();
		String strIdioma = data.get(i).get(7).trim();
		String strMonedaLocal = data.get(i).get(8).trim();
		
		//a.Ingresar  Nombre completo.
		registroZohoPage.setTxtNombreCompleto(strNombreCompleto);
		System.out.println("  a.Ingresar Nombre completo: '" + strNombreCompleto + "'");
		
		//b.Ingresar  Correo electrónico. 
		strCorreoElectronico = registroZohoPage.setTxtCorreoElectronico(strCorreoElectronico);
		System.out.println("  b.Ingresar Correo electrónico: '" + strCorreoElectronico + "'");
		
		//c.Ingresar  Contraseña.
		registroZohoPage.setTxtContrasegna(strContrasegna);
		System.out.println("  c.Ingresar Contraseña: '" + strContrasegna + "'");
		
		//d.Seleccionar País.
		System.out.println("  d.Seleccionar País: " + strPais + "'");
		registroZohoPage.setCmbPais(strPais);
		
		//e.Check Estoy de acuerdo con los Términos de servicio…
		registroZohoPage.setChkTerminosDeServicio();
		System.out.println("  e.Check Estoy de acuerdo con los Términos de servicio…");
		
		//e.Clic en el botón Comenzar.
		registroZohoPage.clickBtnComenzar();
		System.out.println("  e.Clic en el botón Comenzar.");

		//f.Ingresar nombre de la empresa.
		registroZohoPage.setTxtNombreEmpresa(strNombreEmpresa);
		System.out.println("  f.Ingresar nombre de la empresa.");
		
		//g.Ingresar Teléfono.
		registroZohoPage.setTxtTelefono(strTelefono);
		System.out.println("  g.Ingresar Teléfono.");
		
		//h.Seleccionar Zona Horaria. 
		registroZohoPage.setCmbZonaHoraria(strZonaHoraria);
		System.out.println("  h.Seleccionar Zona Horaria.");
		
		//i.Seleccionar Idioma. 
		registroZohoPage.setCmbIdioma(strIdioma);
		System.out.println("  i.Seleccionar Idioma.");
		
		//j.Seleccionar Moneda local.
		registroZohoPage.setCmbMonedaLocal(strMonedaLocal);
		System.out.println("  j.Seleccionar Moneda local.");
		
		//k.Clic botón Explorar con los  datos de muestra.
		registroZohoPage.clickBtnExplorarDatosDeMuestra();
		System.out.println("  k.Clic botón Explorar con los  datos de muestra.");
		registroZohoPage.esperar(5);
	}
	

	@Step
	public void verificar_el_acceso() {
		//a.Verificar mensaje de Bienvenida.
		assertThat(registroZohoPage.getLblBienvenida(),containsString(strNombreCompleto));
		System.out.println("  a.Verificar mensaje de Bienvenida: '" + registroZohoPage.getLblBienvenida() + "'");
	}

	@Step
	public void crear_una_tarea(List<List<String>> data, int i) {

	}

	@Step
	public void verificar_la_tarea() {

	}

}