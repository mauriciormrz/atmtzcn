package com.choucair.conSufi.steps;

import java.util.List;

import com.choucair.conSufi.datos.SolicitantesJDBC;
import com.choucair.conSufi.domain.Solicitante;
import com.choucair.conSufi.pageobjects.ConSufiPage;
import com.choucair.conSufi.utilities.Utilities;

import net.thucydides.core.annotations.Step;

public class ConSufiSteps {

	ConSufiPage conSufiPage;
	private String strApplicationID;
	private Integer intIntervalo;
	
	long tInicio=System.currentTimeMillis();

	@Step
	public void Ingresar_a_la_URL(List<List<String>> data, int i) {
		// a. Abrir navegador e ir a la URL de la aplicacion APM_conSufi.
		conSufiPage.open();
		System.out.println("  a.Abrir navegador e ir a la URL de la aplicacion APM_conSufi.");

		// b. Iniciar de sesion.
		conSufiPage.setTxtNombreUsuario(data.get(i).get(0));
		conSufiPage.setTxtContrasegna(data.get(i).get(1));
		conSufiPage.clicBtnIngresar();
		System.out.println("  b.Iniciar de sesion.");
		System.out.println("    Nombre de Usuario: " + data.get(i).get(0));
		System.out.println("    Contrasegna:       " + data.get(i).get(1));

		// c.Validar inicio de sesión.
		conSufiPage.validarSesion();
		System.out.println("  c.Validar inicio de sesión.");

		//strApplicationID = Integer.toString(Integer.parseInt(data.get(i).get(2)) + 1);
		strApplicationID = data.get(i).get(2);
		intIntervalo = Integer.parseInt(data.get(i).get(3));
	}

	public void Capturar_la_informacion_del_solicitante() {

		// a. Obtener el Application ID.
		SolicitantesJDBC solicitantesJDBC = new SolicitantesJDBC();
		Solicitante ultimoSolicitante = solicitantesJDBC.ultimoSolicitante();
		if (ultimoSolicitante != null) {
			System.out.print("  " + ultimoSolicitante);
			System.out.println("");
			strApplicationID = ultimoSolicitante.getApplication_id();
		}
		System.out.println("  a.Obtenter el Application ID: " + strApplicationID);
	}

	public void Almacenar_la_informacion_en_base_de_datos() {

		Integer intApplicationID;
		
		intApplicationID = Integer.parseInt(strApplicationID);
		
		for (Integer i = 1; i <= intIntervalo; i++) {
			// a.Ingresar URL con el Application ID correspondiente.
			
			strApplicationID = Integer.toString(intApplicationID + i);
			System.out.println("  a.Ingresar URL con el Application ID correspondiente.");
			conSufiPage.IngresarURL(strApplicationID);
			
			//b.Clic opción Simulador
			conSufiPage.clicLnkSimulador();
			System.out.println("  b.Clic opción Simulador: " + i);

			// c.Verificar datos Solicitante.
			System.out.println("  c.Verificar datos Solicitante: " + i);
			if (conSufiPage.datosSolicitante()) {
				//d.Almacenar datos Solicitante.
				System.out.println("  d.Almacenar datos Solicitante.");
				conSufiPage.Almacenar_datos_Solicitante(Integer.parseInt(strApplicationID));
			}else {
				System.out.println("  No hay Datos");
			}
			
			conSufiPage.evidenciaApplicationID(strApplicationID);
			//strApplicationID = Integer.toString(intApplicationID + i);

			System.out.println(" ");
			
		}
        SolicitantesJDBC solicitantesJDBC = new SolicitantesJDBC();
        List<Solicitante> solicitantes = solicitantesJDBC.select();
        for (Solicitante solicitante : solicitantes) {
            System.out.print(solicitante);
            System.out.println("");
        } 
        System.out.println("\nTotal Registros: " + intIntervalo );
        System.out.print("Tiempo de ejecución total: " );
        Utilities.segundosHoras(System.currentTimeMillis() - tInicio);
        //System.out.println("Tiempo de ejecución total: " + (System.currentTimeMillis() - tInicio)/1000 +"seg");

		Utilities.esperar(5);
	}
}
