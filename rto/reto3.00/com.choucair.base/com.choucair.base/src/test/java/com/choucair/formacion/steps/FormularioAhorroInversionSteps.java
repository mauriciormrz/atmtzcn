package com.choucair.formacion.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.List;

import com.choucair.formacion.pageobjects.FormularioDatosPage;

import net.thucydides.core.annotations.Step;

public class FormularioAhorroInversionSteps {

	FormularioDatosPage formularioDatosPage;


	@Step
	public void diligenciar_datos_tabla(List<List<String>> data, int id) {
		
		//a.Diligenciar Formulario.
		//b.Clic botón agregar al plan de ahorros y/o inversiones.
		//c.Verificar valores capturados.

		formularioDatosPage.select_ahorro(data.get(id).get(0).trim());
		formularioDatosPage.meses(data.get(id).get(1).trim());
		formularioDatosPage.select_producto(data.get(id).get(2).trim());
		formularioDatosPage.cantidadAhorro(data.get(id).get(3).trim());
		System.out.println("  a.Diligenciar Formulario.");
		
		formularioDatosPage.planAhorroInversiones();
	}

	@Step
	public void verificar_valores_capturados(List<List<String>> data, int id) {

		String para_que = formularioDatosPage.getTxtParaQue();
		
		String meses = formularioDatosPage.getTxtMeses();
		String monto = formularioDatosPage.getTxtMonto();
		String producto = formularioDatosPage.getTxtProducto();

		assertThat(para_que, containsString(data.get(id).get(0).trim()));
		assertThat(meses, containsString(data.get(id).get(1).trim()));
		assertThat(producto, containsString(data.get(id).get(2).trim()));
		assertThat(monto, containsString(data.get(id).get(3).trim()));
		System.out.println("  c.Verificar valores capturados.");
	}

	@Step
	public void diligenciar_disposiciones_legales() {
		formularioDatosPage.realizar_paso_dos();
	}

	@Step
	public void presentar_plan_ahorro_inversion() {
		
		System.out.println("  a.Presenta por consola ahorro mensual.");
		formularioDatosPage.realizar_paso_tres();
		
		System.out.println("");
		System.out.println("terminamos bien");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}

}
