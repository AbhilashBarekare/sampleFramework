package pageEvents;

import newframework.BaseTest;
import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {
	
	public void signInButton()
	{
		ElementFetch elementFetch=new ElementFetch();
		BaseTest.logger.info("Clicking on Signin button on HomePage");
		elementFetch.getWebElement("XPATH", HomePageElements.signingButton).click();
	}
	
}
