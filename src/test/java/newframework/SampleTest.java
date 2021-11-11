package newframework;

import org.testng.annotations.Test;

import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;

public class SampleTest extends BaseTest {
	
	@Test
	public void sampleEmailEntryTest()
	{
		HomePageEvents homePageEvents=new HomePageEvents();
		homePageEvents.signInButton();
		
		LoginPageEvents loginPageEvents=new LoginPageEvents();
		loginPageEvents.verifySigninPage();
		loginPageEvents.enterEmailId();
		//loginPageEvents.clickOnContinueButton();
	}

}
