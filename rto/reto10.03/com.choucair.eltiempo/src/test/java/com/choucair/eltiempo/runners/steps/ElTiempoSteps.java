package com.choucair.eltiempo.runners.steps;

import java.util.List;

import com.choucair.eltiempo.runners.pageobjects.ElTiempoPage;
import com.choucair.eltiempo.utilities.Utilities;

import net.thucydides.core.annotations.Step;


public class ElTiempoSteps {

	ElTiempoPage elTiempoPage;
	
	@Step
	public void ingresar_a_la_pagina() {
		// a.Abrir navegador e ir a la url.
		elTiempoPage.open();
		System.out.println("  a.Abrir navegador e ir a  la url.");
	}

	@Step
	public void realizar_el_registro(List<List<String>> data, int i) {
		
		String strNombre = data.get(i).get(0).trim();
		String strApellidos = data.get(i).get(1).trim();
		String strCorreoElectronico = data.get(i).get(2).trim();
		String strContrasegna = data.get(i).get(3).trim();
		
		//a.Ingresar  Nombre.
		//elTiempoPage.setTxtNombreCompleto(strNombreCompleto);
		elTiempoPage.setTxtNombre(strNombre);
		System.out.println("  a.Ingresar Nombre: '" + strNombre + "'");
		
		//b.Ingresar Apellidos. 
		elTiempoPage.setTxtApellidos(strApellidos);
		System.out.println("  b.Ingresar Apellidos: '" + strApellidos + "'");
		
		//c.Ingresar Correo electrónico.
		elTiempoPage.setTxtCorreoElectronico(strCorreoElectronico);
		System.out.println("  c.Ingresar Correo electrónico: '" + strCorreoElectronico + "'");
		
		//d.Ingresar  Contraseña. 
		elTiempoPage.setTxtContrasegna(strContrasegna);
		System.out.println("  d.Ingresar Contraseña: '" + strContrasegna + "'");
		
		//e.Check Acepto los términos y condiciones …
		elTiempoPage.setChkTerminosCondiciones();
		System.out.println("  e.Check Acepto los términos y condiciones …");
		
		//f.Clic en el botón Crear una cuenta.
		elTiempoPage.clickBtnCrearCuenta();
		
		//g.Clic en el botón  SI, ENVIAR.

	}

	@Step
	public void verificar_el_acceso() {

		
		Utilities.esperar(5);
	}

}

//iframe_registro
