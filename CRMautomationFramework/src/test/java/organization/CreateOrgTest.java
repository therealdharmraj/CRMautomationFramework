package organization;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import extra.WebDriverUtility;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		//LoginTo
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		
		username.sendKeys("admin");
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		
		//Create organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		Thread.sleep(1000);
		
		//organization name
		String orgName = "qspiders_" + (int)(Math.random()*9999);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);
		
		Thread.sleep(1000);
		
		//Type Drop Down List
		WebElement typeDD = driver.findElement(By.name("accounttype"));
		Select sel = new Select(typeDD);
		
		sel.selectByVisibleText("Investor");
		
		Thread.sleep(1000);
		
		//Phone Text Field
		WebElement phone = driver.findElement(By.id("phone"));
		WebDriverUtility wdu = new WebDriverUtility(driver);
		wdu.sse(phone,2);
		phone.sendKeys("1234567890");
		
		//save
		driver.findElement(By.name("button")).click();
		
		Thread.sleep(1000);
		
		//Logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		 
		 
		Thread.sleep(3000);
		driver.quit();
	}

}