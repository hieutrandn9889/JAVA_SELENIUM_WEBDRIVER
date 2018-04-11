package sytner.homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage_004_CarSearch_01 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void CarSearch_001_CarSearchSetion() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		// 2. Click on About us menu item""
		driver.findElement(By.xpath("//a[@title='About Us']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void CarSearch_002_ViewAllStock() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on News menu item"
		driver.findElement(By.xpath("//a[@title='News']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	@Test
	public void CarSearch_003_TotalVehicles() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on News menu item"
		String getValue = driver.findElement(By.xpath("//span[@class='value']")).getText();
		Integer compare = 7000;
		Assert.assertNotEquals(getValue, compare);

	}

	@AfterTest
	public void afterTest() {
		try {
			driver.quit();
			System.gc();
			if (driver.toString().toLowerCase().contains("chrome")) {
				String cmd = "taskkill /IM chromedriver.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				String cmd = "taskkill /IM IEDriverServer.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
