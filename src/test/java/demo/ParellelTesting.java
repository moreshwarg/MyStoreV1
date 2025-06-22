package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ParellelTesting {
WebDriver driver;
@Test
public void verifyTitle() {
	driver=new ChromeDriver();
	driver.get("https://login.wordpress.org/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Assert.assertEquals(driver.getTitle(), "WordPress.org Login | WordPress.org English");
driver.close();
driver.quit();
}
@Test
public void verifyLogo() {
	driver=new ChromeDriver();
	driver.get("https://login.wordpress.org/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Assert.assertEquals(driver.getTitle(), "WordPress.org Login | WordPress.org English");

WebElement logo=driver.findElement(By.xpath("//a[@href='https://wordpress.org/']"));
Assert.assertTrue(logo.isDisplayed());
driver.close();
driver.quit();
}
}
