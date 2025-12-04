package Working_With_Listeners;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClasses.conficAnn;


@Listeners(Listener_implementation.List_Imp.class)

public class justToProve extends conficAnn {
	public WebDriver driver=null;;
	
	@Test
	public void case1() {
		 driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Fakebook");
		
		
		

}}
