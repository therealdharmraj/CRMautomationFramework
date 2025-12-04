package Working_With_Listeners;



import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class amazon {
	@Test(retryAnalyzer = Listener_implementation.List_Imp_Retry.class)
	public void am() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://amazon.in/");
		WebElement verify = driver.findElement(By.id("nav-logo-sprites"));
		assertTrue(verify.isDisplayed());
		driver.quit();
	}

}
