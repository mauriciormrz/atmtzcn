package com.choucair.formacion.pageobjects;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;



public class FormularioDatosPage extends PageObject {

	// Select Ahorro
	@FindBy(name = "nmSelectAhorro")
	private WebElementFacade cmbAhorro;

	// Campo Meses Ahorro
	@FindBy(xpath = "//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[3]/input")
	public WebElementFacade txtMeses;

	// Campo Select Producto
	@FindBy(xpath = "//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[4]/select")
	public WebElementFacade cmbProducto;

	// Campo Cantidad Ahorro
	@FindBy(xpath = "//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[5]/input")
	public WebElementFacade txtCantidadAhorro;

	// Boton Agregar Plan
	@FindBy(xpath = "//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[8]/button")
	public WebElementFacade btnAgregarPlan;

	// Boton Paso 2
	@FindBy(xpath = "(//DIV[@class='contenido'])[4]")
	public WebElementFacade btnPasoDos;

	// Check Disposiciones Legales
	@FindBy(xpath = "//INPUT[@type='checkbox']")
	public WebElementFacade chkDisposicionesLeg;

	// Boton Calcular Ahorro
	@FindBy(xpath = "//BUTTON[@ng-click='ctrl.tablaResultados()'][text()='Calcular ahorro']")
	public WebElementFacade btnCalcularAhorro;

	// Boton Paso 3
	@FindBy(xpath = "(//DIV[@class='contenido'])[5]")
	public WebElementFacade btnPasoTres;

	// Campo Sueño
	@FindBy(xpath = "(//tr[3]//TD[@class='ng-binding'][1])[1]")
	private WebElementFacade txtParaQue;

	// Campo Meses Tabla
	@FindBy(xpath = "(//tr[3]//TD[@class='ng-binding'][2])[1]")
	public WebElementFacade txtMesesTabla;

	// Campo Producto Tabla
	@FindBy(xpath = "(//tr[3]//TD[@class='ng-binding'][3])[1]")
	public WebElementFacade txtProducto;

	// Campo Producto Tabla
	@FindBy(xpath = "(//TD[@class='monto ng-binding'][1][1])[1]")
	public WebElementFacade txtMonto;

	public void select_ahorro(String datoPrueba) {
		cmbAhorro.click();
		cmbAhorro.selectByVisibleText(datoPrueba);
	}

	public void meses(String datoPrueba) {
		txtMeses.click();
		txtMeses.clear();
		txtMeses.sendKeys(datoPrueba);
	}

	public void select_producto(String datoPrueba) {
		cmbProducto.click();
		cmbProducto.selectByVisibleText(datoPrueba);
	}

	public void cantidadAhorro(String datoPrueba) {
		txtCantidadAhorro.click();
		txtCantidadAhorro.clear();
		txtCantidadAhorro.sendKeys(datoPrueba);
	}

	public void realizar_paso_dos() {
		btnPasoDos.click();
		System.out.println("  a.Clic botón disposiciones legales.");

		if (!chkDisposicionesLeg.isSelected()) {
			chkDisposicionesLeg.click();
		}
		System.out.println("  b.Activar check disposiciones legales.");
		btnCalcularAhorro.click();
		System.out.println("  c.Clic botón “calcular ahorro”.");
	}

	public void planAhorroInversiones() {
		btnAgregarPlan.click();
		System.out.println("  b.Clic botón agregar al plan de ahorros y/o inversiones.");
	}

	public void realizar_paso_tres() {
		String sCellValue;

		btnPasoTres.click();

		// No.of Columns
		java.util.List<WebElement> cols = getDriver()
				.findElements(By.xpath("//*[@id=\"tablaResultadosTotal\"]/table[1]/tbody/tr/th"));

		// No.of rows
		java.util.List<WebElement> rows = getDriver()
				.findElements(By.xpath("//*[@id=\"tablaResultadosTotal\"]/table[1]/tbody/tr"));

		for (Integer i = new Integer(2); i <= rows.size(); i++) {

			for (Integer j = new Integer(1); j <= cols.size() - 2; j++) {
				sCellValue = getDriver().findElement(By.xpath(
						"(//TD[@class='ng-binding'][" + Integer.toString(j) + "][1])[" + Integer.toString(i) + "]"))
						.getText();

				System.out.print(sCellValue + "   ");
			}
			sCellValue = getDriver()
					.findElement(By.xpath(" (//TD[@class='tasa ng-binding'][1])[" + Integer.toString(i) + "]"))
					.getText();

			System.out.print(sCellValue + "   ");
			sCellValue = getDriver()
					.findElement(By.xpath(" (//TD[@class='monto ng-binding'][1])[" + Integer.toString(i) + "]"))
					.getText();

			System.out.println(sCellValue);

		}

	}

	public String getTxtParaQue() {
		return txtParaQue.getText();
	}

	public String getTxtMeses() {
		return txtMesesTabla.getText();
	}

	public String getTxtMonto() {
		//return txtMonto.getText().replaceAll("[\\$,]", "").replaceAll("\\,", "").replaceAll("\\.00", "");
		return txtMonto.getText().replaceAll("[\\$,]", "").replaceAll("\\.00", "");
	}

	public String getTxtProducto() {
		return txtProducto.getText();

	}
}
