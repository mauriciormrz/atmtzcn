package beans;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Utilidades {

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
