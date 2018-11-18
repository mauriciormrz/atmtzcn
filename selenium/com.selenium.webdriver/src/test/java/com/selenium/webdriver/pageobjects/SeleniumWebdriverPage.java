//http://toolsqa.com/selenium-webdriver/findelement-and-findelements-command/
//https://www.swtestacademy.com/xpath-selenium/
//http://toolsqa.com/

package com.selenium.webdriver.pageobjects;

import org.openqa.selenium.WebElement;

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
		 String sClass = getDriver().findElements(By.tagName("tr")).toString();
		 System.out.println(sClass.length());
	}
}

