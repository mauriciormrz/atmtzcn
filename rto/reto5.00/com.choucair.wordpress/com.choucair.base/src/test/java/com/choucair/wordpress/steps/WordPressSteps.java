package com.choucair.wordpress.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import java.util.List;

import com.choucair.wordpress.pageobjects.WordPressPage;

import net.thucydides.core.annotations.Step;

public class WordPressSteps {

	WordPressPage wordPressPage;

	@Step
	public void navegar_en_el_portal_para_presentar_los_formularios() {

		// a.Abrir navegador e ir a la url.
		wordPressPage.open();
		System.out.println(" a.Abrir navegador e ir a  la url.");

		// b.Clic en Empezar(Get Started).
		wordPressPage.clicBtnEmpezar();
		System.out.println(" b.Clic en Empezar.");

		// c.Cambiar idioma a Español.
		System.out.println(" c.Cambiar idioma a Español(Sin implementar).");
	}

	@Step
	public void diligenciar_formulario_paso_uno(List<List<String>> data, int ind) {

		// a. Cómo quieres que se llame tu sitio?
		wordPressPage.setTxtNombresitio(data.get(ind).get(0));
		System.out.println(" a.Como quieres que se llame tu sitio: '" + data.get(ind).get(0) + "'");

		// b. De qué trata tu sitio?
		wordPressPage.setTxtTemasitio(data.get(ind).get(1));
		System.out.println(" b.De que trata tu sitio: '" + data.get(ind).get(1) + "'");

		// c. Cuál es el objetivo principal de tu sitio?
		wordPressPage.setChkComparteTuEmpresa();
		wordPressPage.setChkPromocionaTuEmpresa();
		System.out.println(" c.Cuál es el objetivo principal de tu sitio? ");

		// d. Clic en el botón Continuar
		wordPressPage.clicBtnContinuar();
		System.out.println(" d.Clic en el botón Continuar ");

	}

	@Step
	public void diligenciar_formulario_paso_dos(List<List<String>> data, int ind) {

		// a. Introducir nombre o palabra clave.
		wordPressPage.setTxtDireccionSitio(data.get(ind).get(0));
		System.out.println(" a.Introducir nombre o palabra clave: '" + data.get(ind).get(0) + "'");

		// b. Clic en botón Elegir de la opción gratis.
		if (wordPressPage.clicLnkGratis()) {
			System.out.println(" b.Clic en botón Elegir de la opción gratis. ");
		} else {
			System.out.println("b.FluentWait Failed");
		}

	}

	@Step
	public void diligenciar_formulario_paso_tres() {

		wordPressPage.esperar(1);
		// a.Clic en el botón Empieza con el Plan Gratuito…
		if (wordPressPage.clicBtnEmpezarPlanGratuito()) {
			System.out.println(" a.Clic en el botón Empieza con el Plan Gratuito…");
		} else {
			System.out.println("a.Botón no clickable");
		}
	}

	@Step
	public void diligenciar_formulario_paso_cuatro(List<List<String>> data, int ind) {

		String strCorreo = new String("");
		// a.Tu dirección de correo electrónico.
		strCorreo = wordPressPage.setTxtMail(data.get(ind).get(0));
		System.out.println(" a.Tu dirección de correo electrónico: '" + strCorreo + "'");

		// b.Seleccionar una contraseña.
		wordPressPage.setTxtPass(data.get(ind).get(1));
		System.out.println(" b.Seleccionar una contraseña: '" + data.get(ind).get(1) + "'");

		// c.Clic en el botón Continuar.
		wordPressPage.esperar(1);
		if (wordPressPage.clicBtnContinuarPaso4()) {
			System.out.println(" c.Clic en el botón Continuar.");
		} else {
			System.out.println("a.Botón no clickable");
		}

	}

	@Step
	public void verificar_creacion_del_sitio_exitoso(List<List<String>> data, int ind) {

		// a.Verificar texto ¡Felicidades! Tu sitio está en vivo.
		wordPressPage.esperar(1);
		String strSitioEnVivo = wordPressPage.verificarSitioEnVivo();
		assertThat("No coincide el mensaje de tu sitio en vivo",strSitioEnVivo, containsString("¡Felicidades! Tu sitio está en vivo."));
		System.out.println(" a.Verificar texto ¡Felicidades! Tu sitio está en vivo.");
		
		// b.Clic botón Ver mi sitio.
		if (wordPressPage.clicBtnVerMiSitio()) {
			System.out.println(" b.Clic botón Ver mi sitio.");
		} else {
			System.out.println("b.Botón no clickable");
		}
		
		// c.Verificar texto con el nombre de mi sitio.
		String lblBienvenido = wordPressPage.getLblBienvenido();
		assertThat("No coincide el nombre de mi sitio",lblBienvenido, containsString("¡Bienvenido a WordPress.com!"));
		System.out.println(" c.Verificar texto ¡Bienvenido a WordPress.com!");
	}

}
