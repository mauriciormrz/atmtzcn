package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.AutomationDemoSite;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class Abrir implements Task {
	
	private AutomationDemoSite automationDemoSite;

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn(automationDemoSite));
	}

	public static Abrir LaPaginaDeAutomationDemo() {
		return Tasks.instrumented(Abrir.class);
	}

}
