package Listener_implementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClasses.conficAnn;

public class List_Imp implements ISuiteListener, ITestListener {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver=null;

	@Override
	public void onStart(ISuite suite) {
		System.err.println("Test Suite is Started");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyy_HHmmss");
		String time = now.format(dtf);

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

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test has been started");
		report.createTest(result.getName());
		test.log(Status.INFO, "Info..");
	
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed");
		test.log(Status.PASS, "Passed");
		}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is failed");
		test.log(Status.FAIL, "Failed");
		TakesScreenshot tks = (TakesScreenshot)driver;
			String	ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, "Ye Raha ScreenShot");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println("Test is Skipped");
	test.log(Status.SKIP, "Skipped");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Suite is finished");
		report.flush();
	}
}
