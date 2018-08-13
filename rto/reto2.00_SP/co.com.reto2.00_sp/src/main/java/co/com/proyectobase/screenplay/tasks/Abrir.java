package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.OrangeHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class Abrir implements Task {

private OrangeHomePage orangeHomePage;

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn(orangeHomePage));
		System.out.println("  a.Abrir la URL.");
		
		actor.attemptsTo(Click.on(OrangeHomePage.BOTON_LOGIN));
		System.out.println("  b.Clic boton LOGIN.");
	}

	public static Abrir LaPaginaDeOrangeHRM() {
		return Tasks.instrumented(Abrir.class);
	}
}
