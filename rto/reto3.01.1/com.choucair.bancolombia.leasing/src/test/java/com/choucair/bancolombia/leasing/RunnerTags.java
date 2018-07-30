package com.choucair.bancolombia.leasing;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
//@CucumberOptions (features = "src/test/resources/features/SimulacionCanonFinanciero.feature", tags = "@Regresion")
@CucumberOptions (features = "src/test/resources/features/SimulacionCanonFinanciero.feature", tags = "@CasoExitoso")
//@CucumberOptions (features = "src/test/resources/features/SimulacionCanonFinanciero.feature", tags = "@CasoAlterno")
public class RunnerTags {

}
