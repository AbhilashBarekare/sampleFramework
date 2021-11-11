package newframework;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
static WebDriver driver;
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
	}

}
