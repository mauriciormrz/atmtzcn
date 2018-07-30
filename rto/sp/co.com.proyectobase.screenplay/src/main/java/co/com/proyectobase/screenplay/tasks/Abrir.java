package co.com.proyectobase.screenplay.tasks;


import co.com.proyectobase.screenplay.ui.GoogleHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class Abrir implements Task{

	private GoogleHomePage googleHomePage;
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn(googleHomePage));	
	}

	public static Abrir LaPaginaDeGoogle() {
		return Tasks.instrumented(Abrir.class);
	}

}
