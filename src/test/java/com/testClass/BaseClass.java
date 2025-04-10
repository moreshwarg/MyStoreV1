package com.testClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utilities.ReadConfig;

public class BaseClass {
	private static  Logger logger = LogManager.getLogger(BaseClass.class);
	WebDriver driver;
	 
	
		
		 ReadConfig readConfig= new ReadConfig();
		String brow=readConfig.getBrowser();
		  String ur=readConfig.getUrl();
	
	@BeforeMethod
	public void launchingBrowser() {
	if(brow.equals("chrome")) {
	driver	= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(ur);
	logger.info("browser opened succssfully");
	}
	else if(brow.equals("edge")) {
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(ur);
		logger.info("browser opened succssfully");
	}
	else {
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(ur);
	}
	logger= LogManager.getLogger("MS1");
	}
	
@AfterMethod
public void tearDown() {
	driver.close();
	driver.quit();
}
public void captureScreenShot(WebDriver driver,String testName) throws IOException {
	TakesScreenshot screenshot=((TakesScreenshot)driver);
File src=	screenshot.getScreenshotAs(OutputType.FILE);
File dest=new File(System.getProperty("user.dir")+"//screenshot//"+testName+".png");
FileUtils.copyFile(src, dest);  

}
}
