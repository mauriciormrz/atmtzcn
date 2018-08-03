package com.choucair.conSufi;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
//@CucumberOptions (features = "src/test/resources/features/", tags = "@SmokeTest")
@CucumberOptions (features = "src/test/resources/features/conSufi.feature", tags = "@CasoExitoso")
//@CucumberOptions (features = "src/test/resources/features/conSufi.feature", tags = "@CasoAlterno")
public class RunnerTags {

}
