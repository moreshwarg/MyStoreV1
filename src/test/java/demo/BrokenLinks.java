package demo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
public static void main(String[] args) throws IOException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://hr.wistaff.in/Default.aspx");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	List<WebElement>links= new ArrayList<WebElement>(driver.findElements(By.tagName("a")));
	for(WebElement link:links) {
		String li = link.getAttribute("href");
		System.out.println(li);
		URL url= new URL(li);
		HttpURLConnection conn= (HttpURLConnection)url.openConnection();
		conn.connect();
		int statuscode=conn.getResponseCode();
		if(statuscode>=400) {
			System.out.println("URL BROKEN  "+li);
		}
		else {
			System.out.println("URL Working  "+li);
		}
	}
	
	driver.close();
}
}
