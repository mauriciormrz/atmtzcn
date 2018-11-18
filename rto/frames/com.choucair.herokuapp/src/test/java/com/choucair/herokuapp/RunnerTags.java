package com.choucair.herokuapp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
//@CucumberOptions (features = "src/test/resources/features/JavaScriptAlerts/JavaScriptAlerts.feature", tags = "@CasoExitoso")
@CucumberOptions (features = "src/test/resources/features/Frames/Frames.feature", tags = "@CasoExitosoFrames")
public class RunnerTags {

}
