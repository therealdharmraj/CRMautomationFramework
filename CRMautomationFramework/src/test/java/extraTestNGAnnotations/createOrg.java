package extraTestNGAnnotations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClasses.conficAnn;
import extra.WebDriverUtility;
import extra.randomN;

public class createOrg extends conficAnn {
	@Test
	public void organisation() throws InterruptedException, IOException {
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
				
				
				wdu.sse(phone,randomN.rn());
				phone.sendKeys("1234567890");
				
				//save
				driver.findElement(By.name("button")).click();
				
				Thread.sleep(1000);
				
	}

}
