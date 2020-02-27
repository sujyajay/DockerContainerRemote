package com.Feb26.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Feb26.Master.Master;

public class LogOn extends Master {

	@FindBy(xpath="//a[text() ='Login']") WebElement loginLaunchButton;
	@FindBy(tagName = "iframe") WebElement iFrame;
	@FindBy(id="email") WebElement emailIDField;
	@FindBy(id="password") WebElement passwordField;
	@FindBy(xpath="//button[text() ='Log in']") WebElement loginSubmitButton;
	
	
	public LogOn() {
		
		PageFactory.initElements(driver, this);
		
	}
	 
	public void launchLogonPage() {
		
		loginLaunchButton.click();		

	}
	
	public HomePage login(String username, String password) {
		
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1][@class='_3ga5X']")));
		//driver.switchTo().frame(iFrame);
		//driver.switchTo().frame(driver.findElement(By.tagName("form")));

		driver.switchTo().frame(0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emailIDField.sendKeys(username);
		passwordField.sendKeys(password);
		loginSubmitButton.click();
		
		//to return home page here.
		return new HomePage();
	}
}