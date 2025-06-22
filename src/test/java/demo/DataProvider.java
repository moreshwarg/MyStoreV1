package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProvider {
	WebDriver driver;
	@BeforeClass
		public void setUp()throws InterruptedException {
		 driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.wordpress.org/");
		
		Thread.sleep(2000);
	}
	@Test(dataProvider = "TestData")
	public void loginToapp(String user,String pas) throws InterruptedException {
		WebElement un= driver.findElement(By.xpath("//*[@id='user_login']"));
		un.clear();
		un.sendKeys(user);
		Thread.sleep(2000);

		WebElement pass= driver.findElement(By.xpath("//*[@id='user_pass']"));
		pass.clear();
		pass.sendKeys(pas);
		Thread.sleep(2000);

		WebElement button= driver.findElement(By.xpath("//*[@id='wp-submit']"));
		button.click();
		Thread.sleep(2000);
		
	}
	@org.testng.annotations.DataProvider(name="TestData")
public String[][]gatData(){
	String [][] data={{"coding","12345"},
		            {"jdker","54323"},
		            {"hfhgkd","23456"}
		                   };
		return data;
}
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	}