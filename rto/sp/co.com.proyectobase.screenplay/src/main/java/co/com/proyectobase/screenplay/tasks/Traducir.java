package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.GoogleHomePage;
import co.com.proyectobase.screenplay.ui.GoogleTraductorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Traducir implements Task{

	public Traducir(String palabra) {
		super();
		this.palabra = palabra;
	}

	private String palabra;
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(GoogleHomePage.BOTON_APLICACIONES));
		actor.attemptsTo(Click.on(GoogleHomePage.BOTON_GOOGLE_TRANSLATE));

		actor.attemptsTo(Click.on(GoogleTraductorPage.BOTON_LENGUAJE_ORIGEN));
		actor.attemptsTo(Click.on(GoogleTraductorPage.OPCION_INGLES));
		actor.attemptsTo(Click.on(GoogleTraductorPage.BOTON_LENGUAJE_DESTINO));
		actor.attemptsTo(Click.on(GoogleTraductorPage.OPCION_ESPAGNOL));
		actor.attemptsTo(Enter.theValue(palabra).into(GoogleTraductorPage.AREA_DE_TRADUCCION));
		
		actor.attemptsTo(Click.on(GoogleTraductorPage.BOTON_TRADUCIR));
	}
	
	public static Traducir DeInglesAEspagnolLa(String palabra) {

		return Tasks.instrumented(Traducir.class,palabra);
	}



}
