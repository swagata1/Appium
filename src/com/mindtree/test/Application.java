package com.mindtree.test;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.mindtree.repository.RepoUtil;

public class Application {
	@Test(priority=0)
	public static void newRegisteration() throws Exception {
		RepoUtil repo = new RepoUtil();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", repo.getData("PlatformVersion"));
		capabilities.setCapability("deviceName", repo.getData("DeviceName"));
		capabilities.setCapability("appPackage", "com.mindtree.fsmmindtree");
		capabilities.setCapability("appActivity", "com.mindtree.fsmmindtree.view.LoginActivity");
		AndroidDriver driver = new AndroidDriver(new URL(repo.getData("URL")), capabilities);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.id(repo.getObject("RegisterBtn"))).click();
		
		int randomFirstNameNum = ThreadLocalRandom.current().nextInt(0,9999);
		String firstName="Test"+randomFirstNameNum;
		driver.findElement(By.id(repo.getObject("Firstname"))).sendKeys(firstName);
		driver.hideKeyboard();
		
		driver.findElement(By.id(repo.getObject("Lastname"))).sendKeys("mindtree");
		driver.hideKeyboard();
		
		int randomEmailNum = ThreadLocalRandom.current().nextInt(0,9999);
		String email="Test"+randomEmailNum+"@gmail.com";
		driver.findElement(By.id(repo.getObject("Email"))).sendKeys(email);
		driver.hideKeyboard();
		
		long randomMobileNum = ThreadLocalRandom.current().nextLong(100000000, 999999999);
		driver.findElement(By.id(repo.getObject("Mobilenum"))).sendKeys(""+randomMobileNum);
		driver.hideKeyboard();
		
		int randomNameNum = ThreadLocalRandom.current().nextInt(0,9999);
		String Username="Test"+randomNameNum;
		driver.findElement(By.id(repo.getObject("Username"))).sendKeys(Username);
		driver.hideKeyboard();
		
		int randomPasswordNum = ThreadLocalRandom.current().nextInt(0,9999);
		String password = "Test@"+randomPasswordNum;
		driver.findElement(By.id(repo.getObject("Password"))).sendKeys(password);
		driver.hideKeyboard();
		
		driver.findElement(By.id(repo.getObject("Technician"))).click();
		driver.findElement(By.id(repo.getObject("RegisterBtn2"))).click();
		Assert.assertTrue("Registeration Successful",true);
		driver.quit();

	}
	
	@Test(priority=1)
	public void Login() throws Exception {
		RepoUtil repo = new RepoUtil();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", repo.getData("PlatformVersion"));
		capabilities.setCapability("deviceName", repo.getData("DeviceName"));
		capabilities.setCapability("appPackage", "com.mindtree.fsmmindtree");
		capabilities.setCapability("appActivity", "com.mindtree.fsmmindtree.view.LoginActivity");
		AndroidDriver driver = new AndroidDriver(new URL(repo.getData("URL")), capabilities);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.findElement(By.id(repo.getObject("Username"))).clear();
		driver.findElement(By.id(repo.getObject("Username"))).sendKeys(repo.getData("Username"));
		driver.hideKeyboard();
		
		driver.findElement(By.id(repo.getObject("Password"))).clear();
		driver.findElement(By.id(repo.getObject("Password"))).sendKeys(repo.getData("5678"));
		driver.hideKeyboard();
		
		driver.findElement(By.id(repo.getObject("Login"))).click();
		
		if(driver.findElements(By.id("android:id/content")).size()!=0){
			Assert.assertFalse("Login Failed",true);
			
		}
		
		
		driver.quit();
	}
}
