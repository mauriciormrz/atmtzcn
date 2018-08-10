package co.com.proyectobase.screenplay.tasks;

import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class Realizar implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {

	}
	
	public static Realizar RegistroPaginaDe(List<List<String>> data, int i) {

		return Task.instrumented(Realizar.class);
	}

}
