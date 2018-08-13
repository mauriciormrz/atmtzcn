package co.com.proyectobase.screenplay.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class OrangeDashboardPage {
	public static final Target MENU_PIM = Target.the("Menu Modulo de Informacion Personal - PIM")
			.located(By.xpath("//SPAN[@class='left-menu-title'][text()='PIM']"));
	public static final Target MENU_ADD_EMPLOYEE = Target.the("Menu Agregar Empleado")
			.located(By.xpath("//SPAN[@class='left-menu-title'][text()='Add Employee']"));
	public static final Target FIRST_NAME = Target.the("Nombre del Empleado").located(By.id("firstName"));
	public static final Target LAST_NAME = Target.the("Apellido del Empleado").located(By.id("lastName"));
	public static final Target EMPLOYEE_ID = Target.the("Identificador del Empleado").located(By.id("employeeId"));

}
