package pageEvents;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	public void verifySigninPage() 
	{
		ElementFetch elementFetch=new ElementFetch();
		Assert.assertTrue(elementFetch.getWebElement("XPATH", LoginPageElements.signInText).isDisplayed(),"Login Page is not opened");
		
	}
	
	public void enterEmailId()
	{
		ElementFetch elementFetch=new ElementFetch();
		elementFetch.getWebElement("XPATH", LoginPageElements.emailID).sendKeys("abhilashbr94@gmail.com");
	}
	
	public void clickOnContinueButton()
	{
		ElementFetch elementFetch=new ElementFetch();
		//Assert.assertTrue(elementFetch.getWebElement("ID", LoginPageElements.signinButton).isDisplayed());
		elementFetch.getWebElement("XPATH", LoginPageElements.signinButton).click();
	}
}
