package com.simplilearn.Phase_IV;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FlipkartProject {

    AndroidDriver<MobileElement> driver;
	// Launching the flipkart application
    
	@BeforeTest
	public void launchApp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.flipkart.android");
		cap.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}
	
	
	@Test
	public void placeTheOrder() throws InterruptedException {
		// Type 'Mobile'in the search box
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Search for products']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Search for Products, Brands and More']")).sendKeys("Mobile");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='mobiles']")).click();
		
		// Click on the first search result
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Infinix HOT 20 Play (Fantasy Purple, 64 GB)']")).click();
		
		// Click on 'Add to cart' button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']")).click();
		
		// Click on 'Go to cart' button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Go to cart']")).click();
		
		// Verify you see 'My cart' as heading of the activity
		
		Thread.sleep(5000);
        Boolean myCartAsHeading = driver.findElement(By.xpath("//android.widget.TextView[@text='My Cart']")).isDisplayed();
		
		Assert.assertTrue(myCartAsHeading);
	}	
		
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
				
	}

