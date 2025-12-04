package facebookdemowdu;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import extra.WebDriverUtility;

public class facebooksse {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wdu = new WebDriverUtility(driver);
		driver.get("https://www.facebook.com/");
		WebElement lb= driver.findElement(By.name("login"));
		wdu.sse(lb,1);
	}
}
