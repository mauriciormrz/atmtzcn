package co.com.proyectobase.screenplay.tasks;

import java.util.List;

import co.com.proyectobase.screenplay.ui.OrangeDashboardPage;
import co.com.proyectobase.screenplay.util.utilities;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Diligenciar implements Task{
	
	static List<List<String>> data;
	static int ind;

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(OrangeDashboardPage.MENU_PIM));
		System.out.println("  a.Clic menú PIM.");
		
		actor.attemptsTo(Click.on(OrangeDashboardPage.MENU_ADD_EMPLOYEE));
		System.out.println("  b.Clic menú Add Employee.");
		
		utilities.esperar(10);
		actor.attemptsTo(Enter.theValue("hola").into(OrangeDashboardPage.FIRST_NAME));
		System.out.println("  c.Ingresar First Name*: " + data.get(ind).get(0));
		
	}
	
	public static Diligenciar FormularioEmpleado(List<List<String>> data, int ind) {
		System.out.println( data.get(ind).get(0));
		this.data = data;
		this.ind = ind;
		return Tasks.instrumented(Diligenciar.class, data, ind);
	}


}
