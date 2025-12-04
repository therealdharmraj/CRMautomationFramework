package vTigerCRM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class login {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		TakesScreenshot tks = (TakesScreenshot)driver;
		File src =tks.getScreenshotAs(OutputType.FILE);
		File dest= new File("C:/Users/dharm/eclipse-workspace/A11Project/src/main/java/vTigerCRM/wb.png");
		
		FileHandler.copy(src, dest);
		
		Thread.sleep(5000);
		driver.close();
		
		
		
		
		
	}

}
