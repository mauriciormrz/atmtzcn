package com.choucair.wordpress;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions (features = "src/test/resources/features/WordPress.feature", tags = "@CasoExitoso")
public class RunnerTags {
//Crear un sitio web propio y ponerlo gratis en
//	  línea usando el sistema de gestión de contenidos (CMS)  WordPress.
}
