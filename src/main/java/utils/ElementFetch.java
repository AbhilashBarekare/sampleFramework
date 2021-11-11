package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import newframework.BaseTest;

public class ElementFetch {
	
	
	public WebElement getWebElement(String identifierType,String identifierValue)
	{
		switch(identifierType)
		{
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));
		case "NAME":
			return BaseTest.driver.findElement(By.name(identifierValue));
		default:
			return null;
		}
		
	}
	
	public List<WebElement> getListWebElements(String identifierType,String identifierValue)
	{
		switch(identifierType)
		{
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifierValue));
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierValue));
		case "NAME":
			return BaseTest.driver.findElements(By.name(identifierValue));
		default:
			return null;
		}
		
	}
	
	
}
