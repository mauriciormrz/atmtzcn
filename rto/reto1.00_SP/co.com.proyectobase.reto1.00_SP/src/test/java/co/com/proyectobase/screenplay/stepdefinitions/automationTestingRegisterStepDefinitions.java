package co.com.proyectobase.screenplay.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import co.com.proyectobase.screenplay.tasks.Abrir;
import co.com.proyectobase.screenplay.tasks.Realizar;
import co.com.proyectobase.screenplay.util.Utilidades;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class automationTestingRegisterStepDefinitions {

	@Managed(driver="chrome")
	private WebDriver hisBrowser;
	private Actor carlos = Actor.named("Carlos");
	
	@Before
	public void configuracionInicial() {
		carlos.can(BrowseTheWeb.with(hisBrowser));
	}
	
	@Given("^que Carlos quiere acceder a la Web Automation Demo Site$")
	public void queCarlosQuiereAccederALaWebAutomationDemoSite() throws Exception {
		System.out.println("\n1. Ir a la URL:");
		carlos.wasAbleTo(Abrir.LaPaginaDeAutomationDemo());
		Utilidades.esperar(5);
	}

	@When("^el realiza el registro en la pagina$")
	public void elRealizaElRegistroEnLaPagina(DataTable dtDatosFeture) throws Exception {
		List<List<String>> data = dtDatosFeture.raw();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("\n2. Realiza el registro en la pagina:");
			carlos.attemptsTo(Realizar.RegistroPaginaDe(data,i));
		}
	}

	@Then("^el verifica que se carga la pantalla con texto Double Click on Edit Icon to EDIT the Table Row$")
	public void elVerificaQueSeCargaLaPantallaConTextoDoubleClickOnEditIconToEDITTheTableRow() throws Exception {

	}
}
