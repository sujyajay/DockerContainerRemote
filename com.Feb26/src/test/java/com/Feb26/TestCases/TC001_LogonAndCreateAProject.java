package com.Feb26.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Feb26.Master.Master;
import com.Feb26.Pages.HomePage;
import com.Feb26.Pages.LogOn;

public class TC001_LogonAndCreateAProject extends Master{

	public LogOn logon;
	public HomePage homepage;
	
	@BeforeSuite
	public void beforeSuiteSetup() {
		
		initiateReporting();
		
	}
	
	//test
	
	
	@AfterSuite
	public void afterSuiteActions() {
		
		flushReport();
		
	}
	
	@BeforeMethod
	public void beforeMethodSetUp() {
		
		launchBrowser();
		
		logon = new LogOn();
		
	}
	
	//@AfterMethod
	public void afterMethodActions() {
		
		closeBrowser(); 
		
	}

	@Test
	public void logonToTodoIst() {
		
		logon.launchLogonPage();
		homepage = logon.login("sujyajay@gmail.com", "sujyajay");
		homepage.createNewProject();		
	}

}