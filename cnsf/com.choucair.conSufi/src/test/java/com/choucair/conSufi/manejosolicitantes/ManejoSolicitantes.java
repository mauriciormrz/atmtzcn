package com.choucair.conSufi.manejosolicitantes;


import java.util.List;

import com.choucair.conSufi.datos.SolicitantesJDBC;
import com.choucair.conSufi.domain.Solicitante;


public class ManejoSolicitantes {

    public static void main(String[] args) {
        SolicitantesJDBC solicitantesJDBC = new SolicitantesJDBC();
	//Prueba del metodo insert
        solicitantesJDBC.insert(25003,"Mauricio", "Ramirez","CC","98548330","3003206240","ramirezmauricio@hotmail.com");
        
        //Prueba del metodo update
        //solicitantesJDBC.update(2, "Nombre3", "Apellido3");
		
        //Prueba del metodo delete
        //solicitantesJDBC.delete(2);
      
        //Prueba del metodo select
        //Uso de un objeto persona para encapsular la informacion
        //de un registro de base de datos
        List<Solicitante> solicitantes = solicitantesJDBC.select();
        for (Solicitante solicitante : solicitantes) {
            System.out.print(solicitante);
            System.out.println("");
        } 
    }

}

