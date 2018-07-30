package com.choucair.bancolombia.leasing.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import java.util.List;

import com.choucair.bancolombia.leasing.pageobjects.SimulacionCanonFinancieroPage;

import net.thucydides.core.annotations.Step;

public class SimulacionCanonFinancieroSteps {

	SimulacionCanonFinancieroPage simulacionCanonFinancieroPage;

	@Step
	public void navegar_portal_para_presentar_formulario() {
		// a.Abrir la url.
		simulacionCanonFinancieroPage.open();
		System.out.println(" a.Abrir la url.");

		// b.Clic Productos y Servicios.
		simulacionCanonFinancieroPage.clicLnkProductosServicios();
		System.out.println(" b.Clic Productos y Servicios.");

		// c.Clic opción Leasing.
		simulacionCanonFinancieroPage.clicLnkLeasing();
		System.out.println(" c.Clic opción Leasing.");

		// d.Clic Leasing Habitacional.
		simulacionCanonFinancieroPage.clicLnkLeasingHabitacional();
		System.out.println(" d.Clic Leasing Habitacional.");

		// e.Clic Simular Canon Constante.
		simulacionCanonFinancieroPage.clicBtnSimularCanonConstante();
		System.out.println(" e.Clic Simular Canon Constante.");
	}

	@Step
	public void diligenciar_formulario_simulador(List<List<String>> data, int ind) {

		// a.Ingresa el valor del activo (incluyendo IVA) ($).
		simulacionCanonFinancieroPage.setTxtValorActivo(data.get(ind).get(0).trim());
		System.out
				.println(" a.Ingresa el valor del activo (incluyendo IVA) ($): '" + data.get(ind).get(0).trim() + "'");

		// b.Ingresa Ingresa el plazo del contrato (meses).
		simulacionCanonFinancieroPage.setTxtPlazo(data.get(ind).get(1).trim());
		System.out.println(" b.Ingresa Ingresa el plazo del contrato (meses): '" + data.get(ind).get(1).trim() + "'");

		// c.Ingresa el porcentaje de la opción de compra(%).
		simulacionCanonFinancieroPage.setTxtOpcionCompra(data.get(ind).get(2).trim());
		System.out.println(" c.Ingresa el porcentaje de la opción de compra(%): '" + data.get(ind).get(2).trim() + "'");

		// d.Selecciona el tipo de tasa.
		simulacionCanonFinancieroPage.setCmbTipoTasa(data.get(ind).get(3).trim());
		System.out.println(" d.Selecciona el tipo de tasa: '" + data.get(ind).get(3).trim() + "'");

		// e. Verificar Modalidad Vencida.
		assertThat("La Modalidad no es Vencida", simulacionCanonFinancieroPage.getTxtModalidad(),
				containsString(data.get(ind).get(4).trim()));
		System.out.println(" e. Verificar Modalidad Vencida. ");
	}

	@Step
	public void presentar_resultado_simulacion() {

		// a.Clic Simular.
		simulacionCanonFinancieroPage.clicBtnSimular();
		System.out.println(" a.Clic Simular.");

		// a. Presentar por consola los valores Valor canon mensual, Tasa efectiva
		// anual, Tasa nominal anual mes vencida, Valor de la opción de compra y
		// Porcentaje de la opción de compra.
		System.out.println(" b. Presentar por consola los valores Valor canon mensual, Tasa efectiva ...");
		simulacionCanonFinancieroPage.leerTablaResultado();
		System.out.println(" ");
	}

	@Step
	public void verificar_mensajes_de_error() {

		// a.Verificar valor del activo.
		assertThat("No se valida Valor Activo ", simulacionCanonFinancieroPage.getTxtInformativoValorActivo(),
				is(true));
		System.out.println(" a.Verificar valor del activo.");

		// b.Verificar plazo del contrato.
		assertThat("No se valida Plazo del Contrato",
				simulacionCanonFinancieroPage.getTxtInformativoValorActivo(), is(true));
		System.out.println(" b.Verificar plazo del contrato.");

		// c.Verificar porcentaje de la opción de compra.
		assertThat("No se valida Porcentaje Opción de Compra",
				simulacionCanonFinancieroPage.getTxtInformativoValorActivo(), is(true));
		System.out.println(" c.Verificar porcentaje de la opción de compra.");

		// d.Verificar tipo de tasa.
		assertThat("No se valida Tipo de Tasa", simulacionCanonFinancieroPage.getTxtInformativoTipoTasa(),
				is(true));
		System.out.println(" d.Verificar tipo de tasa.");

		System.out.println(" ");
	}

}
