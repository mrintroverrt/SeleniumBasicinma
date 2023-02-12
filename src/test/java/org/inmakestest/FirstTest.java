package org.inmakestest;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class FirstTest {
	public static AndroidDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	private void lauchBrowser() throws IOException, InterruptedException {
		htmlreporter = new ExtentHtmlReporter("calculator_report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);

		test = extent.createTest("Android", "Calculator Application");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("noReset", true);
		cap.setCapability("deviceName", "OPPO A31");
		cap.setCapability("udid", "EQEMCQ4PHISGJFOB");
		cap.setCapability("appPackage", "com.coloros.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("unicodeKeyboard", false);
		cap.setCapability("resetKeyboard", false);

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);

	}

	@Test
	private void tc1() {
		test.log(Status.INFO, "Appium Click The One Button");
		driver.findElement(By.id("com.coloros.calculator:id/digit_1")).click();
	}

	@Test
	private void tc2() {
		test.log(Status.INFO, "Appium Click The Two Button");
		driver.findElement(By.id("com.coloros.calculator:id/digit_2")).click();
	}

	@Test
	private void tc3() {
		test.log(Status.INFO, "Appium Click The Multiply Button");
		driver.findElement(By.id("com.coloros.calculator:id/op_mul")).click();
	}

	@Test
	private void tc4() {
		test.log(Status.INFO, "Appium Click The Again one Button");
		driver.findElement(By.id("com.coloros.calculator:id/digit_1")).click();
	}

	@Test
	private void tc5() {
		test.log(Status.INFO, "Appium Click The Five Button");
		driver.findElement(By.id("com.coloros.calculator:id/digit_5")).click();
	}

	@Test
	private void tc6() {
		test.log(Status.INFO, "Appium Click The Equal Button");
		driver.findElement(By.id("com.coloros.calculator:id/eq")).click();
	}

	@Test
	@BeforeMethod
	private void startdate() {
		Date d = new Date();
		System.out.println(d);
	}

	@Test
	@AfterMethod
	private void endmethod() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterClass
	private void closeapplication() {
		extent.flush();
		driver.quit();
	}
}