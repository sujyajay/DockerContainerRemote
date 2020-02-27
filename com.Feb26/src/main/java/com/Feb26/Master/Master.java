package com.Feb26.Master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Master {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Properties globalFileProp; 

	
	public Master() {
		
		globalFileProp = new Properties();
		String globalFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\gloablFile.properties";
		try {
			globalFileProp.load(new FileInputStream(globalFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void initiateReporting() {
		
		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\ExtentHTMLReport.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
		logger = extent.createTest("Suite Execution Starts");
		
	}
	
	public static void flushReport() {
		
		extent.flush();
		
	}
	
	
	public static void launchBrowser() {
		String browser  = globalFileProp.getProperty("browser").toLowerCase();
		String url  = globalFileProp.getProperty("url");
		
		switch(browser) { 
		
			case "chrome":
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Batman\\Desktop\\POC-DockerContainer\\com.Feb26\\src\\test\\resources\\chromedriver.exe");	
			driver = new ChromeDriver();
			
			case "firefox":;
			default:;
		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}
	
	
	public static void closeBrowser() {
			
		driver.quit();		
		
	}	
}