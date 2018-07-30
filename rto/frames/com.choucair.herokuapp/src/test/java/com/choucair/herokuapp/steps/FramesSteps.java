package com.choucair.herokuapp.steps;

import java.util.List;

import com.choucair.herokuapp.pageobjects.FramesPage;

import net.thucydides.core.annotations.Step;
import utilidades.Utilidades;

public class FramesSteps {

	FramesPage framesPage;

	@Step
	public void Ingresar_a_la_pagina_herokuapp() {
		
		// a.Abrir la url.
		framesPage.open();
		System.out.println("  a.Abrir la url.");

	}

	public void Seleccionar_el_link_Frames() {
		// a.Clic en el link Frames.
		framesPage.clicLnkFrames();
		System.out.println("  a.Clic en el link Frames.");

	}



	public void interactuar_con_los_Nested_Frames() {

		
	}

	public void interactuar_con_los_iFrame(List<List<String>> data, int i) {

		String strMensaje = data.get(i).get(0);
		
		// a.Clic en el link Frames.
		framesPage.clicLnkIframe();
		System.out.println("  a.Clic en el link iFrame.");
		
		// b.Ingresar mensaje.
		framesPage.ingresarDatos(strMensaje);
		
		Utilidades.esperar(2);
	}

}
