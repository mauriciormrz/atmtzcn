package com.choucair.exito.definition;

import java.util.List;

import com.choucair.exito.steps.CompraVirtualSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CompraVirtualDefinition {

	@Steps
	CompraVirtualSteps compraVirtualSteps;

	
	@Given("^Que ingreso a la pagina virtual$")
	public void que_ingreso_a_la_pagina_virtual() {

		System.out.println("");
		System.out.println("1.Ingresar a la página virtual:");
		compraVirtualSteps.Ingresar_a_la_pagina_virtual();
	}
	

	@Given("^Hago una busqueda del producto$")
	public void hago_una_busqueda_del_producto(DataTable dtDatosFeture) {

		List<List<String>> data = dtDatosFeture.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("");
			System.out.println("2.Buscar un producto:");
			compraVirtualSteps.Buscar_un_producto(data, i);
		}
	}
	

	@When("^Realizo los filtros del producto$")
	public void realizo_los_filtros_del_producto(DataTable dtDatosFeture) {

		List<List<String>> data = dtDatosFeture.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("");
			System.out.println("3.Realizar filtro:");
			compraVirtualSteps.Realizar_filtro(data, i);
		}
	}
	

	@When("^Presento el resultado del filtro$")
	public void presento_el_resultado_del_filtro() {

		System.out.println("");
		System.out.println("4.Presentar el resultado del filtro:");
		compraVirtualSteps.Presentar_el_resultado_del_filtro();
	}
	

	@Then("^Agrego el producto al carrito de compras$")
	public void agrego_el_producto_al_carrito_de_compras() {
		System.out.println("");
		System.out.println("5.Agregar el producto al carrito de compras:");
		compraVirtualSteps.Agregar_el_producto_al_carrito_de_compras();
	}
	

	@Then("^Verifico el carrito$")
	public void verifico_el_carrito() {
		System.out.println("");
		System.out.println("6.Verificar el carrito de compras:");
		compraVirtualSteps.Verificar_el_carrito_de_compras();
	}

}
