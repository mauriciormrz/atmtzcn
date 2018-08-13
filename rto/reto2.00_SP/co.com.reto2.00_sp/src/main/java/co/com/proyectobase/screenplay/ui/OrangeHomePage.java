package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://orangehrm-demo-6x.orangehrmlive.com/")
public class OrangeHomePage extends PageObject{
	
	public static final Target BOTON_LOGIN = Target.the("El boton para iniciar session").located(By.id("btnLogin"));

}
