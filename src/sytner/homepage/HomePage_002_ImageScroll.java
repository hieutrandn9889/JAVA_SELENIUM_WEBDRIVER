package sytner.homepage;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage_002_ImageScroll {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void ImageScroll_001_ImageScrollDisplay() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Check textbox email and input to textbox
		String checkRadio_01 = "//div[@class='cycle-pager-container']//li[1]";
		WebElement elementRadio_01 = driver.findElement(By.xpath(checkRadio_01));
		Assert.assertTrue(elementRadio_01.isDisplayed());
		if (isElementDisplayed(driver, checkRadio_01)) {
			System.out.println("Element is displayed");
		}
		
		// Check textbox email and input to textbox
		String checkRadio_02 = "//div[@class='cycle-pager-container']//li[2]";
		WebElement elementRadio_02 = driver.findElement(By.xpath(checkRadio_02));
		Assert.assertTrue(elementRadio_02.isDisplayed());
		if (isElementDisplayed(driver, checkRadio_02)) {
			System.out.println("Element is displayed");
		}
		// Check textbox email and input to textbox
		String checkRadio_03 = "//div[@class='cycle-pager-container']//li[3]";
		WebElement elementRadio_03 = driver.findElement(By.xpath(checkRadio_03));
		Assert.assertTrue(elementRadio_03.isDisplayed());
		if (isElementDisplayed(driver, checkRadio_03)) {
			System.out.println("Element is displayed");
		}
		// Check textbox email and input to textbox
		String checkRadio_04 = "//div[@class='cycle-pager-container']//li[4]";
		WebElement elementRadio_04 = driver.findElement(By.xpath(checkRadio_04));
		Assert.assertTrue(elementRadio_04.isDisplayed());
		if (isElementDisplayed(driver, checkRadio_04)) {
			System.out.println("Element is displayed");
		}
	}
	//figure[@class='inset']/span[@class='image']/img[@class='css-bg-image image83552']
	
	@Test
	public void ImageScroll_002_Pagination() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Check textbox email and input to textbox
		String checkRadio_01 = "//div[@class='cycle-pager-container']//li[1]";
		WebElement elementRadio_01 = driver.findElement(By.xpath(checkRadio_01));
		elementRadio_01.click();
		WebElement image_01 = driver.findElement(By.xpath("//span[not(@style='visibility: hidden;')]//img[starts-with(@class,'css-bg-image')]")); 
		Assert.assertTrue(image_01.isDisplayed());
		
		// Check textbox email and input to textbox
		String checkRadio_02 = "//div[@class='cycle-pager-container']//li[2]";
		WebElement elementRadio_02 = driver.findElement(By.xpath(checkRadio_02));
		elementRadio_02.click();
		WebElement image_02 = driver.findElement(By.xpath("//span[not(@style='visibility: hidden;')]//img[starts-with(@class,'css-bg-image')]"));
		Assert.assertTrue(image_02.isDisplayed());
		// Check textbox email and input to textbox
		String checkRadio_03 = "//div[@class='cycle-pager-container']//li[3]";
		WebElement elementRadio_03 = driver.findElement(By.xpath(checkRadio_03));
		elementRadio_03.click();
		WebElement image_03 = driver.findElement(By.xpath("//span[not(@style='visibility: hidden;')]//img[starts-with(@class,'css-bg-image')]"));
		Assert.assertTrue(image_03.isDisplayed());
		// Check textbox email and input to textbox
		String checkRadio_04 = "//div[@class='cycle-pager-container']//li[4]";
		WebElement elementRadio_04 = driver.findElement(By.xpath(checkRadio_04));
		elementRadio_04.click();
		WebElement image_04 = driver.findElement(By.xpath("//span[not(@style='visibility: hidden;')]//img[starts-with(@class,'css-bg-image')]"));
		Assert.assertTrue(image_04.isDisplayed());
		
	}
	
	public boolean isElementDisplayed(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterTest
	public void afterTest() {
		try {
//			driver.quit();
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
