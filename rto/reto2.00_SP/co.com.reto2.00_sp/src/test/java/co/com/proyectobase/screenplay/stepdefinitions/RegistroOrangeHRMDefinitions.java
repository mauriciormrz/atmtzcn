package co.com.proyectobase.screenplay.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import co.com.proyectobase.screenplay.tasks.Abrir;
import co.com.proyectobase.screenplay.tasks.Diligenciar;
import co.com.proyectobase.screenplay.util.utilities;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class RegistroOrangeHRMDefinitions {

	@Managed(driver = "chrome")
	private WebDriver hisBrowser;
	private Actor juan = Actor.named("Juan");

	@Before
	public void configuracionInicial() {
		juan.can(BrowseTheWeb.with(hisBrowser));
	}

	@Given("^que Juan necesita un empleado en el OrangeHRM$")
	public void queJuanNecesitaUnEmpleadoEnElOrangeHRM() throws Exception {
		System.out.println("\n1.Ingresar a la pagina de Orange HRM:");
		juan.wasAbleTo(Abrir.LaPaginaDeOrangeHRM());
	}

	@When("^el realiza el ingreso del registro en la aplicacion$")
	public void elRealizaElIngresoDelRegistroEnLaAplicacion(DataTable dtDatosForm) throws Exception {
		List<List<String>> data = dtDatosForm.raw();

		for (int i = 0; i < data.size(); i++) {
			System.out.println("");
			System.out.println("\n2.Agregar empleado:");
			juan.attemptsTo(Diligenciar.FormularioEmpleado(data, i));

			// wordPressSteps.diligenciar_formulario_paso_uno(data, i);
		}
	}

	@Then("^el visualiza el nuevo empleado en el aplicativo$")
	public void elVisualizaElNuevoEmpleadoEnElAplicativo() throws Exception {
		utilities.esperar(5);
	}
}
