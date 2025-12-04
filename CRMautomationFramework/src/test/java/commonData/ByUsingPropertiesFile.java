package commonData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class ByUsingPropertiesFile {
	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver = null;
		FileInputStream fis = new FileInputStream("C:\\Users\\dharm\\eclipse-workspace\\A11Project\\src\\test\\java\\commonData\\org.properties");
		
		Properties pObj = new Properties();
		pObj.load(fis);
		String browser = pObj.getProperty("bro");
		System.out.println(browser);
		if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("safari")) {
			driver= new SafariDriver();
		}
		else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
	}

}
