package com.choucair.bancolombia.creditos.pageobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import dominio.PlanPagos;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreditoConsumoFormularioPage extends PageObject {

	// Campo seleccion que desea simular
	@FindBy(xpath = "//SELECT[@name='comboTipoSimulacion']")
	private WebElementFacade cmbSimulacion;

	// Campo fecha de nacimiento
	@FindBy(name = "dateFechaNacimiento")
	private WebElementFacade dteFechaNacimiento;

	// Campo tipo de tasa
	@FindBy(xpath = "//SELECT[@name='comboTipoTasa']")
	private WebElementFacade cmbTasa;

	// Campo producto de credito
	@FindBy(xpath = "//SELECT[@name='comboTipoProducto']")
	private WebElementFacade cmbProducto;

	// Campo ingresos mensuales
	@FindBy(xpath = "//*[@id=\"sim-detail\"]/form/div[5]/div[2]/input")
	private WebElementFacade txtIngresos;

	// Campo plazo para el prestamo
	@FindBy(xpath = "//*[@id=\"sim-detail\"]/form/div[7]/div[1]/input")
	private WebElementFacade txtPlazo;

	// Campo valor del prestamo
	@FindBy(xpath = "//*[@id=\"sim-detail\"]/form/div[7]/div[2]/input")
	private WebElementFacade txtPrestamo;

	// Boton Simular
	@FindBy(xpath = "//*[@id=\"sim-detail\"]/form/div[8]/button")
	private WebElementFacade btnSimular;

	//private
	@FindBy(xpath = "//*[@id=\"sim-results\"]/div[1]/table/tbody")
	private WebElementFacade tblResultado;

	@FindBy(xpath = "//*[@id=\"sim-results\"]/div[4]/table[1]/tbody")
	private WebElementFacade tblPlanPagos;
	
	@FindBy(xpath = "//*[@id=\"sim-results\"]/div[4]/table[2]/tbody/tr[2]/td/ul")
	private WebElementFacade lstPlanPagos;
	
	
	private String strNroPaginas;
	
	public String getStrNroPaginas() {
		return strNroPaginas;
	}

	private WebElement lnkSiguiente;


	private Map<String, String> arraySimulacion = new HashMap<String, String>();
	
	
	public void encontrarSiguiente() {
		
		List<WebElement> webList;
		//lstPlanPagos = lstPlanPagos.findElement(By.xpath("//*[@id=\\\"sim-results\\\"]/div[4]/table[2]/tbody/tr[2]/td/ul"));
		
		webList = lstPlanPagos.findElements(By.tagName("li"));
		System.out.println(lstPlanPagos);

	    for(int i=0; i<webList.size(); i++){
	        //to print directly
	        System.out.println(webList.get(i).getText());

	        if(webList.get(i).getText().trim().equals("Siguiente")){  
	        	strNroPaginas = webList.get(i-1).getText();
	        	lnkSiguiente=getDriver().findElement(By.xpath("//*[@id='sim-results']/div[4]/table[2]/tbody/tr[2]/td/ul/li["+(i+1)+"]/a"));
	        }
		}
	}
	

	public void clickSiguiente(){
		lnkSiguiente.click();
	}
	

	public boolean leerTablaResultado() {

		List<WebElement> rows_table = tblResultado.findElements(By.tagName("tr")); // To locate rows of table.
		String strKey = new String("");
		int rows_count = rows_table.size(); // To calculate no of rows In table.

		for (int row = 0; row < rows_count; row++) { // Loop will execute till the last row of table.

			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td")); // To locate
																								// columns(cells) of
																								// that specific row.
			int columns_count = Columns_row.size(); // To calculate no of columns (cells). In that specific row.
			// System.out.println("Number of cells In Row " + row + " are " +
			// columns_count);

			for (int column = 0; column < columns_count; column++) { // Loop will execute till the last cell of that
																		// specific row.
				String celtext = Columns_row.get(column).getText(); // To retrieve text from that specific cell.

				if (!celtext.equals("")) {
					if (strKey.equals("")) {
						strKey = celtext;
					} else {
						arraySimulacion.put(strKey, celtext);
						strKey = "";
					}
				}
				// System.out.println("Cell Value of row number " + row + " and column number "
				// + column + " Is " + celtext);
			}
			// System.out.println("-------------------------------------------------- ");
		}
		return true;
	}


	public String encontrarValor(String key) {

		for (Map.Entry<String, String> entry : arraySimulacion.entrySet()) {
			if (entry.getKey().equals(key)) {
				System.out.println(entry.getKey() + ", " + entry.getValue());
				return entry.getValue();
			}
		}
		return "";
	}

	public void imprimirTablaResultado() {

		for (Map.Entry<String, String> entry : arraySimulacion.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}

	public void simulacion(String datoPrueba) {
		cmbSimulacion.click();
		cmbSimulacion.selectByVisibleText(datoPrueba);
	}

	public void fechaNacimiento(String datoPrueba) {
		dteFechaNacimiento.click();
		dteFechaNacimiento.clear();
		dteFechaNacimiento.sendKeys(datoPrueba);
	}

	public void tasa(String datoPrueba) {
		cmbTasa.click();
		cmbTasa.selectByVisibleText(datoPrueba);
	}

	public void producto(String datoPrueba) {
		cmbProducto.click();
		cmbProducto.selectByVisibleText(datoPrueba);
	}

	public void ingresos(String datoPrueba) {
		txtIngresos.click();
		txtIngresos.clear();
		txtIngresos.sendKeys(datoPrueba);
	}

	public void plazo(String datoPrueba) {
		txtPlazo.click();
		txtPlazo.clear();
		txtPlazo.sendKeys(datoPrueba);
	}

	public void prestamo(String datoPrueba) {
		txtPrestamo.click();
		txtPrestamo.clear();
		txtPrestamo.sendKeys(datoPrueba);
	}

	public void btnSimulacion() {
		btnSimular.click();
	}

	public int leerTablaPagos(PlanPagos [] arrayPlanPagos, int offSet) {
		
		PlanPagos planPagos = null;
		
		List<WebElement> rows_table = tblPlanPagos.findElements(By.tagName("tr")); // To locate rows of table.

		int rows_count = rows_table.size(); // To calculate no of rows In table.

		for (int row = 0; row < rows_count; row++) { // Loop will execute till the last row of table.

			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td")); // To locate columns(cells) of that specific row.
			int columns_count = Columns_row.size(); // To calculate no of columns (cells). In that specific row.
			System.out.println("Number of cells In Row " + row + " are " + columns_count);
			
			planPagos = new PlanPagos();
		
			for (int column = 0; column < columns_count; column++) { // Loop will execute till the last cell of that specific row.
		
				String celtext = Columns_row.get(column).getText(); // To retrieve text from that specific cell.
				ingresarPlanPagos(planPagos,column,celtext);
				//System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
			}
			if (planPagos.getCuota() != null)
				arrayPlanPagos [Integer.parseInt(planPagos.getCuota())+offSet] = planPagos;
			//System.out.println("-------------------------------------------------- ");
		}
		return Integer.parseInt(planPagos.getCuota())+offSet;
	}
	
	public void ingresarPlanPagos(PlanPagos planPagos,int i, String valor) {

        switch (i) {
	        case 0:  planPagos.setCuota(valor);
	        		 break;
            case 1:  planPagos.setAbonoIntereses(valor);
                     break;
            case 2:  planPagos.setAbonoCapital(valor);
                     break;
            case 3:  planPagos.setCuotaMensualSinSeguros(valor);
                     break;
            case 4:  planPagos.setValorSeguroVida(valor);
                     break;
            case 6:  planPagos.setCuotaMensualConSeguros(valor);
                     break;
            case 7:  planPagos.setSaldo(valor);
            default: break;
        }
	}
	
}

//*[@id="plp"]/div[2]/div[2]/div/div[3]
//*[@id="prd0002523836676001"]
//*[@class="row product-list"]
//div[@class="row product-list"]
//(//div[@class="product search col-xs-12 col-sm-4 col-md-4 col-lg-3"])[1]
