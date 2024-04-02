package com.pCloudy.testNG;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Runner {

	AppiumDriverLocalService service;
	AppiumDriver<WebElement> driver;
	String folder_name;
	DateFormat df;
	String USERNAME = AppConfig.userName;
	String APIKEY = AppConfig.password;
	
//	System.out.println("UserName from paramter - "+ USERNAME);
//	System.out.println("API key from paramter - "+ APIKEY);
	
	@Parameters({"deviceName"})
	@BeforeMethod
	public void prepareTest(String deviceName, Method m) throws IOException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		////////////////// original code //////////////
		capabilities.setCapability("pCloudy_Username", USERNAME);
		capabilities.setCapability("pCloudy_ApiKey", APIKEY);
		capabilities.setCapability("pCloudy_ApplicationName", "pCloudy_Appium_Demo-1666933373.apk");
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("pCloudy_DeviceManafacturer", deviceName);
		//capabilities.setCapability("pCloudy_DeviceVersion", "8.0.0");
		//capabilities.setCapability("pCloudy_DeviceFullName", "Samsung_GalaxyTabA_Android_7.1.1");
		
		//***** Performance data	*****//
		capabilities.setCapability("pCloudy_EnableVideo", "true");
		capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
		capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
		
		//****  Capabilities for Progressive report  ****//
		capabilities.setCapability("project", "Prtesting_webapp");
		capabilities.setCapability("build", "Build_701");
		capabilities.setCapability("name",m.getName());
		capabilities.setCapability("tag", "Android");
		
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("appPackage", "com.pcloudy.appiumdemo");
		capabilities.setCapability("appActivity", "com.ba.mobile.LaunchActivity");
		driver = new AndroidDriver(new URL("https://ind-west.pcloudy.com/progressive/wd/hub"), capabilities);
//		driver = new AndroidDriver(new URL("https://lab.pcloudy.com/progressive/wd/hub"), capabilities);
		
		
	}

	@Test (invocationCount = 1)
	public void SearchFlight() throws IOException, InterruptedException {

		//Click on Accept button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/accept']")).click(); 
        captureScreenShots();
        
        //Click on Flight button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/flightButton']")).click();
        captureScreenShots();
        
        //Select from location
        driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerfrom']")).click();
        captureScreenShots();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Bangalore, India (BLR)']")).click();
		captureScreenShots();
		
		//Select to location
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerto']")).click();
		captureScreenShots();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Pune, India (PNQ)']")).click();
        captureScreenShots();
        
        //Select one way trip
        driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.pcloudy.appiumdemo:id/singleTrip']")).click();
        captureScreenShots();
        
        //Select departure time
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.pcloudy.appiumdemo:id/txtdepart']")).click();
        captureScreenShots();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")).click();
        captureScreenShots();
        
        //Click on search flights button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/searchFlights']")).click();
        captureScreenShots();
	}
	@Test
	public void FailTheTest() throws IOException, InterruptedException {

		//Click on Accept button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/accept']")).click(); 
        captureScreenShots();
        
        //Click on Flight button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/flightButton1']")).click();
        captureScreenShots();
        
        //Select from location
        driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerfrom']")).click();
        captureScreenShots();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Bangalore, India (BLR)']")).click();
		captureScreenShots();
		
		//Select to location
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerto']")).click();
		captureScreenShots();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Pune, India (PNQ)']")).click();
        captureScreenShots();
        
        //Select one way trip
        driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.pcloudy.appiumdemo:id/singleTrip']")).click();
        captureScreenShots();
        
        //Select departure time
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.pcloudy.appiumdemo:id/txtdepart']")).click();
        captureScreenShots();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")).click();
        captureScreenShots();
        
        //Click on search flights button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/searchFlights']")).click();
        captureScreenShots();
	}

	// After method to discard driver
	@AfterMethod
	public void endTest(ITestResult result) throws  IOException {
		String status = result.isSuccess()? "Passed" : "Failed";
		driver.executeScript("pCloudy_setResult", status);
		System.out.println("status of the test case - "+ status);

		driver.quit();
	}

	//Capture screenshot
	public void captureScreenShots() throws IOException {
        folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Date format for screenshot file name
        df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //create dir with given folder name
        new File(folder_name).mkdir();
        //Setting file name
        String file_name=df.format(new Date())+".png";
        //copy screenshot file into screenshot folder.
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }
}
