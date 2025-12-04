package contact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import extra.WebDriverUtility;

public class createContactTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		//LoginToCRM
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		
		username.sendKeys("admin");
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Contacts")).click(); 
		Thread.sleep(3000);
		
		WebElement create = driver.findElement(By.xpath("//img[@alt=\'Create Contact...\']"));
		create.click();
		
		WebElement prefixDD = driver.findElement(By.name("salutationtype"));
		//prefixDD.click();
		Select selPreFix = new Select(prefixDD);
		selPreFix.selectByContainsVisibleText("Mr.");
		  driver.findElement(By.name("firstname")).sendKeys("Dharamraj");
		  
		  driver.findElement(By.name("lastname")).sendKeys("Singh");
		  
		  driver.findElement(By.cssSelector("input[name=\'account_name\']")).sendKeys("Wipro");
		  
		  driver.findElement(By.name("email")).sendKeys("dharrmaj23@gmail.com");
		  
		  driver.findElement(By.name("mobile")).sendKeys("7055025364");
		  
		  driver.findElement(By.cssSelector("input[name=\'button\']")).click();
		
		  WebElement icon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		   
		  //LogOut
		  WebDriverUtility wbu = new WebDriverUtility(driver);
		 // Actions act = new Actions(driver);
		  wbu.hover(icon);
		  driver.findElement(By.xpath("//a[@href=\'index.php?module=Users&action=Logout\']")).click();
	
		  Thread.sleep(1500);
		  driver.quit();
	}
	
	

}
