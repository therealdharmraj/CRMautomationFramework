package extra;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	WebDriver driver;
	Actions act;
	TakesScreenshot tks;
	public WebDriverUtility(WebDriver driver){
		this.driver=driver;
		this.act=new Actions(driver);
		this.tks = (TakesScreenshot) driver;
	}


public void hover(WebElement element) {
	Actions act = new Actions(driver);
	act.moveToElement(element).build().perform();
	
}

public void ss(String fileName) throws IOException {
	TakesScreenshot tks = (TakesScreenshot) driver;
	File src=tks.getScreenshotAs(OutputType.FILE);
	File dest= new File("C:/Users/dharm/eclipse-workspace/A11Project/src/test/resources/ScreenShots/"+fileName+"ss.png");
	org.openqa.selenium.io.FileHandler.copy(src,dest);
System.out.println("Screenshot Taken!");
}

public void sse(WebElement element,int fileName) throws IOException {

	File src=element.getScreenshotAs(OutputType.FILE);
	File dest= new File("C:/Users/dharm/eclipse-workspace/A11Project/src/test/resources/ScreenShots/"+"Screenshot"+fileName+".png");
	org.openqa.selenium.io.FileHandler.copy(src,dest);
	System.out.println("Screenshot Taken!");
}
	
	
	
		
	


}