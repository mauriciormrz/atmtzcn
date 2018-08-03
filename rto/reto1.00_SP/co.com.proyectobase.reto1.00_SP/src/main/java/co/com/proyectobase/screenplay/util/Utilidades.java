package co.com.proyectobase.screenplay.util;

public class Utilidades {

	public static void esperar(int segundos) {

		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
