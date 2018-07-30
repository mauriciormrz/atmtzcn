package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class GoogleTraductorPage extends PageObject {

	public static final Target BOTON_LENGUAJE_ORIGEN = Target.the("Boton del idioma origen")
			.located(By.id("gt-sl-gms"));
	public static final Target BOTON_LENGUAJE_DESTINO = Target.the("Boton del idioma destino")
			.located(By.id("gt-tl-gms"));
	public static final Target OPCION_INGLES = Target.the("La opcion ingles")
			.located(By.xpath("//div[@id='gt-sl-gms-menu']/table/tbody//tr/td//div[contains(text(),'ingl')]"));
	public static final Target OPCION_ESPAGNOL = Target.the("La el segundo idioma")
			.located(By.xpath("//div[@id='gt-tl-gms-menu']/table/tbody//tr/td//div[contains(text(),'esp')]"));
	public static final Target AREA_DE_TRADUCCION = Target.the("El lugar donde se escriben las palabras a traducir")
			.located(By.id("source"));
	public static final Target BOTON_TRADUCIR = Target.the("El boton traducir").located(By.id("gt-lang-submit"));
	public static final Target AREA_TRADUCIDA = Target.the("El area donde ya se presenta la palabra traducida")
			.located(By.id("gt-res-dir-ctr"));
}
