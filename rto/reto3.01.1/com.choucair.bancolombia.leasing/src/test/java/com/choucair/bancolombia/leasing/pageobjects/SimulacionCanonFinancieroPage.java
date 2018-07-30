package com.choucair.bancolombia.leasing.pageobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.grupobancolombia.com/wps/portal/personas/ ")
public class SimulacionCanonFinancieroPage extends PageObject {

	@FindBy(xpath = "//A[@href='#productosPersonas'][text()='Productos y Servicios']")
	private WebElementFacade lnkProductosServicios;

	@FindBy(xpath = "//A[@href='/wps/portal/personas/productos-servicios/leasing'][text()='Leasing']")
	private WebElementFacade lnkLeasing;

	@FindBy(xpath = "//A[@href='/wps/portal/personas/productos-servicios/leasing/habitacional/'][text()='Leasing Habitacional']")
	private WebElementFacade lnkLeasingHabitacional;

	@FindBy(xpath = "//A[@href='/wps/portal/personas/productos-servicios/leasing/habitacional/simulador-canon-financiero/'][text()='Simular Canon Constante']")
	private WebElementFacade btnSimularCanonConstante;

	@FindBy(name = "valorActivo")
	private WebElementFacade txtValorActivo;

	@FindBy(name = "plazo")
	private WebElementFacade txtPlazo;

	@FindBy(name = "opcionCompra")
	private WebElementFacade txtOpcionCompra;

	@FindBy(xpath = "//*[@id='sim-detail']/form/div[4]/select")
	private WebElementFacade cmbTipoTasa;

	@FindBy(xpath = "//*[@id=\"sim-detail\"]/form/div[5]/input")
	private WebElementFacade txtModalidad;

	@FindBy(name = "simular")
	private WebElementFacade btnSimular;

	@FindBy(xpath = "//*[@id=\"resultado\"]/div/table/tbody")
	private WebElementFacade tblResultado;

	private Map<String, String> arraySimulacion = new HashMap<String, String>();

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.valorActivo.$error.required'][text()='Este campo es obligatorio.']")
	public WebElementFacade txtInformativoValorActivoObligatorio;

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.valorActivo.$error.ngMin'][text()='El campo no cumple con el valor mínimo $ 10,000,000']")
	public WebElementFacade txtInformativoValorActivoMinimo;

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.valorActivo.$error.ngMax'][text()='El campo no cumple con el valor máximo $ 500,000,000,000']")
	public WebElementFacade txtInformativoValorActivoMaximo;

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.plazo.$error.required'][text()='Este campo es obligatorio.']")
	public WebElementFacade txtInformativoPlazoObligatorio;

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.plazo.$error.ngMin'][text()='El campo no cumple con el valor mínimo 12']")
	public WebElementFacade txtInformativoPlazoMinimo;

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.plazo.$error.ngMax'][text()='El campo no cumple con el valor máximo 120']")
	public WebElementFacade txtInformativoPlazoMaximo;

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.opcionCompra.$error.required'][text()='Este campo es obligatorio.']")
	public WebElementFacade txtInformativoOpcionCompraObligatorio;

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.opcionCompra.$error.ngMin'][text()='El campo no cumple con el valor mínimo 1%']")
	public WebElementFacade txtInformativoOpcionCompraMinimo;

	@FindBy(xpath = "//SPAN[@ng-show='CanonFinancieroForm.opcionCompra.$error.ngMax'][text()='El campo no cumple con el valor máximo 10%']")
	public WebElementFacade txtInformativoOpcionCompraMaximo;

	@FindBy(xpath = "(//SPAN[@class='ng-binding'][text()='Este campo es obligatorio.'][text()='Este campo es obligatorio.'])[1]")
	public WebElementFacade txtInformativoTipoTasaObligatorio;

	public String getTxtModalidad() {
		return txtModalidad.getTextValue();
	}

	public Boolean getTxtInformativoValorActivo() {
		return (txtInformativoValorActivoObligatorio.isCurrentlyVisible()
				|| txtInformativoValorActivoMinimo.isCurrentlyVisible()
				|| txtInformativoValorActivoMaximo.isCurrentlyVisible());
	}

	public Boolean getTxtInformativoPlazo() {
		return (txtInformativoPlazoObligatorio.isCurrentlyVisible() || txtInformativoPlazoMinimo.isCurrentlyVisible()
				|| txtInformativoPlazoMaximo.isCurrentlyVisible());
	}

	public Boolean getTxtInformativoOpcionCompra() {
		return (txtInformativoOpcionCompraObligatorio.isCurrentlyVisible()
				|| txtInformativoOpcionCompraMinimo.isCurrentlyVisible()
				|| txtInformativoOpcionCompraMaximo.isCurrentlyVisible());
	}

	public Boolean getTxtInformativoTipoTasa() {
		return (txtInformativoTipoTasaObligatorio.isCurrentlyVisible());
	}

	public void setTxtValorActivo(String txtValorActivo) {
		this.txtValorActivo.sendKeys(txtValorActivo);
	}

	public void setTxtPlazo(String txtPlazo) {
		this.txtPlazo.sendKeys(txtPlazo);
	}

	public void setTxtOpcionCompra(String txtOpcionCompra) {
		this.txtOpcionCompra.sendKeys(txtOpcionCompra);
	}

	public void setCmbTipoTasa(String strTipoTasa) {
		cmbTipoTasa.click();
		cmbTipoTasa.selectByVisibleText(strTipoTasa);
	}

	public void clicLnkProductosServicios() {
		lnkProductosServicios.click();
	}

	public void clicLnkLeasing() {
		lnkLeasing.click();
	}

	public void clicLnkLeasingHabitacional() {
		lnkLeasingHabitacional.click();
	}

	public void clicBtnSimular() {
		btnSimular.click();
	}

	public void clicBtnSimularCanonConstante() {
		btnSimularCanonConstante.click();
	}

	public boolean leerTablaResultado() {

		List<WebElement> rows_table = tblResultado.findElements(By.tagName("tr")); // To locate rows of table.
		String strKey = new String("");
		int rows_count = rows_table.size(); // To calculate no of rows In table.

		for (int row = 0; row < rows_count; row++) { // Loop will execute till the last row of table.

			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			int columns_count = Columns_row.size(); // To calculate no of columns (cells). In that specific row.

			for (int column = 0; column < columns_count; column++) {
				String celtext = Columns_row.get(column).getText(); // To retrieve text from that specific cell.

				if (!celtext.equals("")) {
					if (strKey.equals("")) {
						strKey = celtext;
						System.out.print("  -" + celtext + ": ");
					} else {
						arraySimulacion.put(strKey, celtext);
						System.out.println(celtext);
						strKey = "";
					}
				}
			}
		}
		return true;
	}

}
