//http://toolsqa.com/selenium-webdriver/findelement-and-findelements-command/
//https://www.swtestacademy.com/xpath-selenium/
//http://toolsqa.com/

package com.selenium.webdriver.pageobjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.selenium.webdriver.utilities.utilities;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;


@SuppressWarnings("deprecation")
@DefaultUrl("http://goodstartbooks.com/pruebas/")
public class SeleniumWebdriverPage extends PageObject{
	
	// findElementById
	@FindBy(id="noImportante")
	private WebElementFacade findElementById_1;
	
	// findElementByName
	@FindBy(name="ultimo")
	private WebElementFacade findElementByName_1;
	
	// findElmentByXpath
	//@FindBy(xpath="//tr[@id='noImportante']") para optimizar más la búsqueda
	@FindBy(xpath="//*[@id='noImportante']")
	private WebElementFacade findElmentByXpath_1;
	
	// findElmentByClassName
	@FindBy(className="rojo")
	private WebElementFacade findElmentByClassName_1;
	
	// findElmentByLinkText
	@FindBy(linkText="Pagina 2")
	private WebElementFacade findElmentByLinkText_1;
	
	// findElmentByPartialLinkText
	@FindBy(partialLinkText="Pagina")
	private WebElementFacade findElmentByPartialLinkText_1;
	
	// findElmentByTagName
	@FindBy(tagName="h3")
	private WebElementFacade findElmentByTagName_1;
	
	// findElmentByCssSelector
	@FindBy(css="#primera")
	private WebElementFacade findElmentByCssSelector_1;
	
	// Campo dop drown
	@FindBy(name="ingrediente")
	private WebElementFacade cmbIngrediente;
	
	// Campo multi-select
	@FindBy(name="Select1")
	private WebElementFacade slcFruta;
	
	
	public boolean findElementById() {
		//WebElement findElementById_2 = getDriver().findElement(By.id("noImportante"));
		//return findElementById_2.isDisplayed();
		return findElementById_1.isPresent();
	}
	
	public boolean findElementByName() {
		//WebElement findElementByName_2 = getDriver().findElement(By.name("ultimo"));
		//return findElementByName_2.isDisplayed();
		return findElementByName_1.isPresent();
	}
	
	public boolean findElmentByXpath() {
		WebElement findElmentByXpath_2 = getDriver().findElement(By.xpath("//*[@id='noImportante']"));
		return findElmentByXpath_2.isDisplayed();
		//return findElmentByXpath_1.isPresent();
	}
	
	public boolean findElmentByClassName() {
		WebElement findElmentByClassName_2 = getDriver().findElement(By.className("rojo"));
		return findElmentByClassName_2.isDisplayed();
		//return findElmentByClassName_1.isPresent();
		
		//WebElement parentElement = driver.findElement(By.className("button"));
		//WebElement childElement = parentElement.findElement(By.id("submit"));
		//childElement.submit();
	}
	
	public boolean findElmentByLinkText() {
		WebElement findElmentByLinkText_2 = getDriver().findElement(By.linkText("Pagina 2"));
		return findElmentByLinkText_2.isDisplayed();
		//return findElmentByLinkText_1.isPresent();
	}
	
	public boolean findElmentByPartialLinkText() {
		WebElement findElmentByPartialLinkText_2 = getDriver().findElement(By.partialLinkText("Pagina"));
		return findElmentByPartialLinkText_2.isDisplayed();
		//return findElmentByPartialLinkText_1.isPresent();
	}
	
	public boolean findElmentByTagName() {
		//WebElement findElmentByTagName_2 = getDriver().findElement(By.tagName("h3"));
		//return findElmentByTagName_2.isDisplayed();
		return findElmentByTagName_1.isPresent();
	}
	
	public boolean findElmentByCssSelector() {
		WebElement findElmentByCssSelector_2 = getDriver().findElement(By.cssSelector("#primera"));
		return findElmentByCssSelector_2.isDisplayed();
		//return findElmentByCssSelector_1.isPresent();
	}
	
	public  void findElementsByTagName() {
		 List <WebElement> list = getDriver().findElements(By.tagName("tr"));
		 System.out.println("   Number of links: "+list.size());
		 for(int i = 0; i < list.size(); i++){
			 System.out.println("   " +i +" " +list.get(i).getText());
		 }
	}
	

	public void salir() {
		getDriver().quit();	
	}

	public void clickAndSendKeys() {
		//findElmentByLinkText_1.click();
		WebElement lnk = getDriver().findElement(By.linkText("Pagina 2"));
		lnk.click();

		WebElement nombre = getDriver().findElement(By.id("Segundo"));
		nombre.sendKeys("Mauricio");
		utilities.esperar(1);
		
		lnk = getDriver().findElement(By.linkText("Home"));
		lnk.click();
		
	}

	public void clicRadioButtonAndCheckBoxes() {
		WebElement btn1 = getDriver().findElement(By.id("RadioGroup1_0"));
		btn1.click();
		utilities.esperar(1);
		
		WebElement btn2 = getDriver().findElement(By.id("RadioGroup1_1"));
		btn2.click();
		utilities.esperar(1);
		
		WebElement chck1 = getDriver().findElement(By.id("CheckboxGroup1_0"));
		chck1.click();
		utilities.esperar(1);
		
		WebElement chck2 = getDriver().findElement(By.id("CheckboxGroup1_1"));
		chck2.click();
		utilities.esperar(1);
	}

	public void clicSelect() {
		cmbIngrediente.click();
		cmbIngrediente.selectByVisibleText("Cebolla");
		
		slcFruta.click();
		slcFruta.selectByIndex(1);
		slcFruta.selectByIndex(2);
		
		utilities.esperar(1);
		
	}

	public String getTextOrAttr() {
		WebElement txtOpcion = getDriver().findElement(By.xpath("//*[@id='noImportante']/td[2]"));
		
		WebElement atttOpcion = getDriver().findElement(By.id("importante"));
		return "Texto: " +txtOpcion.getText() + " - Atributo: " + atttOpcion.getAttribute("class");
	}

	public void cambiarFocoVentana() {
		// Encuentra la ventana actual
		String parentWindow = getDriver().getWindowHandle();//  get the current window handle

		// Encuentra el boton submit y se da clic
		WebElement btnSubmit =getDriver().findElement(By.id("Buton1"));
		btnSubmit.click();

		 Set<String> handles =  getDriver().getWindowHandles();//Return a set of window handle
		 
		 for (String windowHandle  : handles) {
			 if (!windowHandle.equals(parentWindow)){
			    getDriver().switchTo().window(windowHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		          
			    //Perform your operation here for new window
				 WebElement nombre = getDriver().findElement(By.id("Segundo"));
				 nombre.sendKeys("Mauricio");
				 utilities.esperar(2);
			   
		         getDriver().close(); //closing child window
		         getDriver().switchTo().window(parentWindow); //cntrl to parent window
		      }
		   }
	}
		 
	public void cambiarFocoAlerta() {

		// Ejemplo de localizar un componente sin id, name, class
		WebElement btnAlert =getDriver().findElement(By.xpath("//*[@id='center']/button"));
		btnAlert.click();
		
		utilities.esperar(2);
		getDriver().switchTo().alert().accept();

	}

	public void cambiarFocoFrame() {
		WebElement iFrame =getDriver().findElement(By.id("pruebas-iframe"));
		getDriver().switchTo().frame(iFrame); //switching the frame by ID
		
		WebElement nombre = getDriver().findElement(By.id("Segundo"));
		nombre.sendKeys("Mauricio");
		utilities.esperar(1);
		//getDriver().switchTo().parentFrame();
		getDriver().switchTo().defaultContent();
	}

	public void accionesEnCandena() {
		WebElement btnMenu = getDriver().findElement(By.className("dropbtn"));
		Actions action = new Actions(getDriver());
		action.moveToElement(btnMenu).perform();
		
		WebElement lnk = getDriver().findElement(By.linkText("Link 1"));
		action.moveToElement(lnk);
		action.click();
		action.perform();
		utilities.esperar(3);
	}
	
}

