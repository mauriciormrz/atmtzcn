package com.selenium.webdriver;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions (features = "src/test/resources/features/panOpen.feature", tags = "@FacultySide")
public class RunnerTags {

}
