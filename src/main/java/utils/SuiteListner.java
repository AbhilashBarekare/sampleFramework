package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import newframework.BaseTest;


public class SuiteListner implements ITestListener,IAnnotationTransformer {
	@Override
	 public void onTestStart(ITestResult result) {
		    // not implemented
		  }

	@Override	 
	 public void onTestSuccess(ITestResult result) {
		    // not implemented
		  }

	@Override  
	 public void onTestFailure(ITestResult ITestResult) {
		    String fileName=System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+ITestResult.getMethod().getMethodName();
		    File f=((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		    try
		    {
				FileUtils.copyFile(f, new File(fileName+".png"));
			} catch (IOException e)
		    {
				e.printStackTrace();
			}
		  }

	@Override	 
	 public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

	@Override	 
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

	@Override  
	 public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

	@Override	
	 public void onStart(ITestContext context) {
		    // not implemented
		  }

	@Override  
	 public void onFinish(ITestContext context) {
		    // not implemented
		  }
	@Override
	 public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
		{	
			annotation.setRetryAnalyzer(RetryAnalyser.class);
		 }
	
	
}
