package com.choucair.exito.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.List;

import org.junit.Assert;

import com.choucair.exito.pageobjects.CompraVirtualPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class CompraVirtualSteps {

	CompraVirtualPage compraVirtualPage;
	long tInicio = System.currentTimeMillis();

	@Step
	public void Ingresar_a_la_pagina_virtual() {

		// a.Abrir la url.
		compraVirtualPage.open();
		System.out.println("  a.Abrir la url.");
	}

	@Step
	public void Buscar_un_producto(List<List<String>> data, int i) {

		// Para cerrar la ventana emergente que aparece ocasionalmente
		compraVirtualPage.escape();

		// a.Ingresar el producto en 'Lo que deseas, está en exito.com'
		compraVirtualPage.setTxtBusqueda(data.get(i).get(0));
		System.out.println("  a.Ingresar el producto: '" + data.get(i).get(0) + "'");

		// b.Clic en el botón
		compraVirtualPage.clicBtnBusqueda();
		System.out.println("  b.Clic en el botón buscar ");
	}

	@Step
	public void Realizar_filtro(List<List<String>> data, int i) {

		WebElementFacade lstTamano = compraVirtualPage.getLstTamano();
		WebElementFacade lstMarca = compraVirtualPage.getLstMarca();
		WebElementFacade lstResolucion = compraVirtualPage.getLstResolucion();

		String strTamano = data.get(i).get(0).trim();
		String strMarca = data.get(i).get(1).trim();
		String strResolucion = data.get(i).get(2).trim();

		// a.Seleccionar tamaño.
		if (compraVirtualPage.buscarElementoLista(lstTamano, "mobil-link", strTamano)) {

			System.out.println("  a.Seleccionar tamaño: '" + strTamano + "'");

			// b.Seleccionar marca. "filter-checkbox"
			if (compraVirtualPage.buscarElementoLista(lstMarca, "filter-checkbox", strMarca)) {

				System.out.println("  b.Seleccionar marca: '" + strMarca + "'");

				// c.Seleccionar resolución de pantalla.
				if (compraVirtualPage.buscarElementoLista(lstResolucion, "mobil-link", strResolucion)) {

					System.out.println("  c.Seleccionar resolución de pantalla: '" + strResolucion + "'");
				} else {
					System.out.println("  c.Seleccionar resolución de pantalla: No se encontró la resolución '"
							+ strResolucion + "'");
					Assert.fail("No se encontró la resolución");
				}
			} else {
				System.out.println("  b.Seleccionar la marca: No se encontró la marca '" + strMarca + "'");
				Assert.fail("No se encontró la marca");
			}
		} else {
			System.out.println("  a.Seleccionar tamaño: No encontró el tamaño '" + strTamano + "'");
			Assert.fail("No se encontró el tamaño");
		}
	}

	@Step
	public void Presentar_el_resultado_del_filtro() {

		// a.Imprimir por consola la información de todos los televisores.
		System.out.println("  a.Imprimir por consola la información de todos los televisores.");
		compraVirtualPage.imprimirProductos();
	}

	@Step
	public void Agregar_el_producto_al_carrito_de_compras() {

		// a.Clic en el primer televisor.
		System.out.println("  a.Clic en el primer televisor.");
		compraVirtualPage.clicPrimerProducto(compraVirtualPage.getPrimerProducto());

		// b.Clic en el botón Añadir al carrito.
		compraVirtualPage.clicBtnAgnadirCarrito();
		System.out.println("  b.Clic en el botón Añadir al carrito.");

		// Para cerrar la ventana emergente que aparece ocasionalmente
		compraVirtualPage.escape();

	}

	@Step
	public void Verificar_el_carrito_de_compras() {
		// a.Clic en el botón
		System.out.println("  a.Clic en el botón carrito");
		compraVirtualPage.clicBtnCarrito();

		// b.Verificar información del producto.
		System.out.println("  b.Verificar información del producto.");
		assertThat("El producto no fue agregado al carrito", compraVirtualPage.getInfoProductoCarrito(),
				containsString(compraVirtualPage.getInfoPrimerProducto()));

		System.out.println("\n Tiempo de ejecución: " + (System.currentTimeMillis() - tInicio) / 1000 + "seg");
	}

}
