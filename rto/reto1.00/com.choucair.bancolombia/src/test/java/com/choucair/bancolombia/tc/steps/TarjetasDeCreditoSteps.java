package com.choucair.bancolombia.tc.steps;

import java.util.List;

import com.choucair.bancolombia.tc.pageobjects.TarjetasDeCreditoPage;

import net.thucydides.core.annotations.Step;

public class TarjetasDeCreditoSteps {

	TarjetasDeCreditoPage tarjetasDeCreditoPage;

	
	@Step
	public void navegar_en_el_portal_para_ir_la_opcion_tarjetas_de_credito() {

		// a.Abrir navegador e ir a la url.
		tarjetasDeCreditoPage.open();
		System.out.println("  a.Abrir navegador e ir a  la url.");

		// b.Clic el submenú Productos y Servicios.
		tarjetasDeCreditoPage.clickOnProductos();
		System.out.println("  b.Clic el submenú Productos y Servicios.");

		// c.Clic en la opción Tarjetas Crédito.
		tarjetasDeCreditoPage.clickOnTarjetasCredito();
		System.out.println("  c.Clic en la opción Tarjetas Crédito.");
	}
	

	@Step
	public void consultar_la_informacion_de_las_tarjetas_de_credito() {

		// a.Desplegar por consola la información de American Express Green.
		System.out.println("\n  a.Desplegar por consola la información de American Express Green.");
		tarjetasDeCreditoPage.imprimirInfoTarjeta(tarjetasDeCreditoPage.getLstAmericanExpress());

		// b.Desplegar por consola la información de MasterCard Black.
		System.out.println("\n  b.Desplegar por consola la información de MasterCard Black.");
		tarjetasDeCreditoPage.imprimirInfoTarjeta(tarjetasDeCreditoPage.getLstMasterCard());
	}
	

	@Step
	public void solicitar_tarjeta_American_Express(List<List<String>> data, int i) {

		// a.Clic en el botón Solicítala aquí de la tarjeta American Express.
		tarjetasDeCreditoPage.clickOnSolicitaAmerican();
		System.out.println("  a.Clic en el botón Solicítala aquí  de la tarjeta American Express.");

		// b.Diligenciar los campos del formulario Solicitud Tarjeta de Crédito.
		System.out.println("  b.Diligenciar los campos del formulario Solicitud Tarjeta de Crédito.");
		tarjetasDeCreditoPage.diligenciar_formulario( data,  i);

		// c.Verificar botón Continuar.
		System.out.println("  c.Verificar botón Continuar.");

		// d.Clic botón Cancelar.
		System.out.println("  d.Clic botón Cancelar.");
	}

	@Step
	public void verificar_mensajes_error(List<List<String>> data, int i) {

		// a.Verificar Nombres.
		System.out.println("  a.Verificar Nombres.");

		// b.Verificar Apellidos.
		System.out.println("  b.Verificar Apellidos.");

		// c.Verificar Número de documento de identidad.
		System.out.println("  c.Verificar Número de documento de identidad.");

		// d.Verificar Fecha de nacimiento.
		System.out.println("  d.Verificar Fecha de nacimiento.");

		// e.Verificar Ingresos mensuales.
		System.out.println("  e.Verificar Ingresos mensuales.");

		// f.Verificar Ciudad y departamento de residencia.
		System.out.println("  f.Verificar Ciudad y departamento de residencia.");
	}

}
