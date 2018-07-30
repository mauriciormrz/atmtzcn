package com.choucair.bancolombia.creditos;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions (features = "src/test/resources/features/simulacion/CreditoConsumo.feature", tags = "@CasoExitoso")
public class RunnerTags {

}
