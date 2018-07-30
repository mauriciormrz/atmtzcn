package co.com.proyectobase.screenplay.stepdefinitions;

import static org.hamcrest.Matchers.equalTo;
import org.openqa.selenium.WebDriver;

import co.com.proyectobase.screenplay.questions.LaRespuesta;
import co.com.proyectobase.screenplay.tasks.Abrir;
import co.com.proyectobase.screenplay.tasks.Traducir;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;


public class TraductorGoogleStepDefinitions {

	@Managed(driver = "chrome")
	private WebDriver hisBrowser;
	private Actor rafa = Actor.named("Rafa");
	
	@Before
	public void configuracionInicial() {
		rafa.can(BrowseTheWeb.with(hisBrowser));
	}

	@Given("^que Rafa quiere usar el Traductor de Google$")
	public void queRafaQuiereUsarElTraductorDeGoogle() throws Exception {
		rafa.wasAbleTo(Abrir.LaPaginaDeGoogle());
	}

	@When("^el traduce la palabra (.*) de Ingles a Espagnol$")
	public void elTraduceLaPalabraTableDeInglesAEspagnol(String palabra) throws Exception {
		rafa.attemptsTo(Traducir.DeInglesAEspagnolLa(palabra));

	}

	@Then("^el deberia ver la palabra (.*) en la pantalla$")
	public void elDeberiaVerLaPalabraMesaEnLaPantalla(String palabraEsperada) throws Exception {
		rafa.should(seeThat(LaRespuesta.es(), equalTo(palabraEsperada)));
	}
}
