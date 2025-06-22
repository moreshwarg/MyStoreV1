package demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink1 {

	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.geeksforgeeks.org/java-program-to-print-even-length-words-in-a-string/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement>links= driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
		for(WebElement li:links) {
			String s=li.getAttribute("href");
			//System.out.println(s);
			URL url= new URL(s);
			HttpURLConnection conn=  (HttpURLConnection)url.openConnection();
			conn.connect();
			int stscode=conn.getResponseCode();
			if(stscode>=400) {
				System.out.println("Broken Links  "+s);
			}
			else {
				System.out.println("Working link  "+s);
			}
		}
	}

}
