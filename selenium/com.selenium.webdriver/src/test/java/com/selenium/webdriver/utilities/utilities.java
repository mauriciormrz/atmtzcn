package com.selenium.webdriver.utilities;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class utilities {

	static String separador = System.getProperty("file.separator");
	static final String RUTA_EVIDENCIA = "D:\\Fotos prueba";

	public static void esperar(int segundos) {

		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenShotTest(String imageName, WebDriver driver) {
		// Directorio donde quedaran las imagenes guardadas
		File directory = new File(RUTA_EVIDENCIA);

		try {
			if (directory.isDirectory()) {
				// Toma la captura de imagen
				File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Mueve el archivo a la carga especificada con el respectivo nombre
				FileUtils.copyFile(imagen,
						new File(directory.getAbsolutePath() + separador + separador + imageName + ".png"));
			} else {
				// Se lanza la excepcion cuando no encuentre el directorio
				throw new IOException("ERROR : La ruta especificada no es un directorio!");
			}
		} catch (IOException e) {
			// Impresion de Excepciones
			e.printStackTrace();
		}
	}

	public static void segundosHoras(long num) {
		int  hor, min, seg;

		num = num/1000;
		hor = (int)(num / 3600);
		min = (int)((num - (3600 * hor)) / 60);
		seg = (int)(num - ((hor * 3600) + (min * 60)));
		System.out.println(hor + "h " + min + "m " + seg + "s");
	}
	
	private static DateFormat fechaFormato;
	static final Locale COLOMBIA = new Locale("es", "CO");

	public static String formatoDouble_Currency(Double doble) {

		NumberFormat cf = NumberFormat.getCurrencyInstance(COLOMBIA);
		String cadena = cf.format(doble);

		return cadena;
	}

	public static String formatoFecha(Date fecha) {

		fechaFormato = DateFormat.getDateInstance(DateFormat.LONG, COLOMBIA);
		System.out.println(fechaFormato.format(fecha));

		return fechaFormato.format(fecha);
	}

	public static void imprimirSeparador() {
		System.out.println("-------------------------------------------------------------------------------- ");
	}

	public static void imprimirSeparador(int intBlancos) {
		System.out.println("-------------------------------------------------------------------------------- ");
		for (int i = 1; i <= intBlancos; i++) {
			System.out.println("");
		}
	}

	public static Double formatoMonedaString_Double(String cadena) {
		int lastPosComas = -1;
		int lastPosPuntos = -1;

		cadena = cadena.replaceAll("\\$", "").trim();

		lastPosComas = cadena.lastIndexOf(",");
		lastPosPuntos = cadena.lastIndexOf(".");

		if (lastPosComas > lastPosPuntos) {
			cadena = cadena.replace(".", "");
			cadena = cadena.replace(",", ".");

		} else {
			cadena = cadena.replace(",", "");
		}

		return Double.parseDouble(cadena);
	}

	public static Double formatoPorcentaje_Double(String cadena) {
		Double doble;

		cadena = cadena.replaceAll("%", "").trim();
		doble = Double.parseDouble(cadena);

		return doble / 100;
	}
}

