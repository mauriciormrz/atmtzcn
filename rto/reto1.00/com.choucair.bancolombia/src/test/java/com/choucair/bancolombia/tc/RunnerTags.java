package com.choucair.bancolombia.tc;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/TarjetasDeCredito.feature", tags = "@CasoExitoso")
// @CucumberOptions (features =
// "src/test/resources/features/TarjetasDeCredito.feature", tags =
// "@CasoAlterno")
public class RunnerTags {

}
