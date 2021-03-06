package newframework;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Constants;

public class BaseTest {
	
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeTest
	public void beforeTestMethod()
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"AutomationReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Äutomation Tester", "Abhilash");
	}
	
	
	@BeforeMethod
	@Parameters(value={"browserName"})
	public void beforeMethodMethod(String browserName,Method testMethod)
	{	
		logger=extent.createTest(testMethod.getName());
		setupBrowser(browserName);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void afterMethodMethod(ITestResult result)
	{	
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case: "+methodName+"Passed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
		}else if(result.getStatus()==ITestResult.FAILURE)
		{
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case: "+methodName+"Failed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL, m);
		}
		driver.quit();
	}
	
	
	@AfterTest
	public void afterTestMethod()
	{
		extent.flush();
	}
	
	public void setupBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
			driver=new ChromeDriver();

		}else
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
			driver=new ChromeDriver();

		}
	}
}
