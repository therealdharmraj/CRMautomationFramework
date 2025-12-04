package BaseClasses;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class conficAnn {
	public WebDriver driver =null;
	public static WebDriver sdriver;
	ExtentReports report=null;
	@BeforeSuite
	public void dbConnection() 
	{
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyy_HHmmss");
		String time=now.format(dtf);

		System.out.println("Database connectivity + Report Configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\dharm\\eclipse-workspace\\A11Project\\src\\test\\resources\\advanceReports\\" + time
						+ ".html");
		spark.config().setDocumentTitle("FaceBook_Report");
		spark.config().setReportName("Begining");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Version", "11");
	}

	@BeforeTest
	public void preConditon() {
		System.out.println("Pre-Conditions");
	}
	
	@BeforeClass
	public void openBrowser() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	@BeforeMethod
	public void login() {
		//LoginTo
		driver.get("http://localhost:8888/");
				WebElement username = driver.findElement(By.name("user_name"));
				WebElement password = driver.findElement(By.name("user_password"));
				
				username.sendKeys("admin");
				password.sendKeys("manager");
				
				driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void logOut() {
//		System.out.println();
		//Logout
				WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
				
				Actions act = new Actions(driver);
				act.moveToElement(profile).build().perform();
				
				driver.findElement(By.linkText("Sign Out")).click();

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterTest
	public void postCondition() {
		System.out.println("Browser Opens");
		
	}
	
	@AfterSuite
	public void DBConnecttionOff() {
		System.out.println("Database connectivity + Report Configuration");
	report.flush();
	}
	
	
}
