package extraTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demo3 {
	public void case1() {
		System.out.println("hey !!");
		
		
	}
	@Test
	public void case2()  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();
		
	}
	@Test
	public void case3()  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.quit();
}
	@Test
	public void case4()  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
		driver.quit();}
}
