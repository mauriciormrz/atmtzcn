package com.choucair.bancolombia.creditos.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.List;

import com.choucair.bancolombia.creditos.pageobjects.CreditoConsumoFormularioPage;

import beans.Utilidades;
import dominio.PlanPagos;
import net.thucydides.core.annotations.Step;

public class CreditoConsumoFormularioSteps {

	CreditoConsumoFormularioPage creditoConsumoFormularioPage;

	private Integer intPlazoFeature;

	private Double dblValorPrestamoFeature;
	private Double dblCuotaMensualCalculada;
	private Double dblCuotaMensualMasSeguroCalculada;
	
	static final int MAX_CUOTAS =121;
	private PlanPagos [] arrayPlanPagos;

	@Step
	public void datos_tabla_formulario(List<List<String>> data, int id) {
		// a.Diligenciar Formulario.
		diligenciarFormulario(data, id);

		// b.Verificar valores capturados.
		obtenerValoresCapturados();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void diligenciarFormulario(List<List<String>> data, int id) {

		creditoConsumoFormularioPage.simulacion(data.get(id).get(0).trim());
		creditoConsumoFormularioPage.fechaNacimiento(data.get(id).get(1).trim());
		creditoConsumoFormularioPage.tasa(data.get(id).get(2).trim());
		creditoConsumoFormularioPage.producto(data.get(id).get(3).trim());
		// creditoConsumoFormularioPage.ingresos(data.get(id).get(4).trim());
		creditoConsumoFormularioPage.plazo(data.get(id).get(5).trim());
		creditoConsumoFormularioPage.prestamo(data.get(id).get(6).trim());
		creditoConsumoFormularioPage.btnSimulacion();

		intPlazoFeature = Integer.parseInt(data.get(id).get(5).trim());
		dblValorPrestamoFeature = Double.parseDouble(data.get(id).get(6).trim());
	}

	public void obtenerValoresCapturados() {
		creditoConsumoFormularioPage.leerTablaResultado();
	}

	@Step
	public void vefificar_valores() {

		Double dblTasaMesVencidaTabla = new Double(0.0);
		Double dblCuotaMensualMasSeguroTabla = new Double(0.0);
		Double dblSeguroVidaTabla = new Double(0.0);
		String strCuotaMensualMasSeguroCalculada = new String("");

		Utilidades.imprimirSeparador(0);

		// a. Verificar valor Plazo ingresado previamente.
		int intPlazoTabla = 0;
		String strPlazoTabla = creditoConsumoFormularioPage.encontrarValor("Plazo");
		if (strPlazoTabla.length() > 0) {

			String[] strPlazoMeses = strPlazoTabla.split(" ");
			intPlazoTabla = Integer.parseInt(strPlazoMeses[0]);
		}
		assertThat("El plazo del feature y la tabla son diferentes", intPlazoTabla, is(intPlazoFeature));

		// b. Verificar valores devueltos por el sistema (tasa efectiva, tasa mes
		// vencida, seguro de vida, seguro desempleo).
		String strTasaEfectivaAnual = creditoConsumoFormularioPage
				.encontrarValor("Tasa efectiva anual utilizada en la simulación");
		assertThat("No se encontro tasa efectiva anual", strTasaEfectivaAnual, is(not("")));

		String strTasaMesVencidaTabla = creditoConsumoFormularioPage
				.encontrarValor("Tasa mes vencida utilizada en la simulación");
		assertThat("No se encontro tasa mes vencida", strTasaMesVencidaTabla, is(not("")));
		dblTasaMesVencidaTabla = Utilidades.formatoPorcentaje_Double(strTasaMesVencidaTabla);

		String strCuotaMensualTabla = creditoConsumoFormularioPage.encontrarValor("Cuota mensual");
		assertThat("No se encontro cuota mensual", strCuotaMensualTabla, is(not("")));	

		String strSeguroVidaTabla = creditoConsumoFormularioPage
				.encontrarValor("Seguro de vida asociado a la deuda por cuota");
		assertThat("No se encontro seguro de vida", strSeguroVidaTabla, is(not("")));
		dblSeguroVidaTabla = Utilidades.formatoMonedaString_Double(strSeguroVidaTabla);

		String strCuotaMensualMasSeguroTabla = creditoConsumoFormularioPage.encontrarValor("Cuota mensual más seguro(s)");
		assertThat("No hay cuota mensual", strCuotaMensualMasSeguroTabla, is(not("")));

		Utilidades.imprimirSeparador(0);

		dblCuotaMensualCalculada = (dblValorPrestamoFeature / intPlazoFeature.doubleValue())
				+ (dblValorPrestamoFeature * dblTasaMesVencidaTabla.doubleValue());
		dblCuotaMensualMasSeguroCalculada = dblCuotaMensualCalculada + dblSeguroVidaTabla;

		strCuotaMensualMasSeguroCalculada = Utilidades.formatoDouble_Currency(dblCuotaMensualMasSeguroCalculada);
		dblCuotaMensualMasSeguroTabla = Utilidades.formatoMonedaString_Double(strCuotaMensualMasSeguroTabla);
		strCuotaMensualMasSeguroTabla = Utilidades.formatoDouble_Currency(dblCuotaMensualMasSeguroTabla);
		System.out.println("Cuota mensual mas seguro - tabla: " + strCuotaMensualMasSeguroTabla);
		System.out.println("Cuota mensual mas seguro - calculada: " + strCuotaMensualMasSeguroTabla);
		assertThat("La cuota mensual de la tabla no coincide con la cuota calculada", strCuotaMensualMasSeguroTabla, is(strCuotaMensualMasSeguroCalculada));

		Utilidades.imprimirSeparador(1);
	}

	public void presentar_plan_de_pagos() {

		int intNroPaginas = 0;

		arrayPlanPagos= new PlanPagos [MAX_CUOTAS];
		int offSet = 0;
		
		creditoConsumoFormularioPage.encontrarSiguiente();
		intNroPaginas = Integer.parseInt(creditoConsumoFormularioPage.getStrNroPaginas());
		
		//for (int i= 0; i < intNroPaginas; i++) {
			
			offSet= creditoConsumoFormularioPage.leerTablaPagos(arrayPlanPagos, offSet);
			System.out.println(offSet);
			creditoConsumoFormularioPage.clickSiguiente();
		//}
	}
}
