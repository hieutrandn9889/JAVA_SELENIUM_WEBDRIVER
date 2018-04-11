package hieutran;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoUploadMulti {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_005_test() throws IOException, InterruptedException {
		driver.get("http://optimizilla.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// 1
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 2
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 3
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 4
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 5
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 6
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 7
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 8
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 9
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 10
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 11
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 12
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 13
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 14
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 15
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 16
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 17
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 18
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		// 19
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		Thread.sleep(2000);

		// 20
		driver.findElement(By.xpath("//span[contains(.,'Upload Files')]")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Multi.exe" + " "
				+ "C:\\Users\\MyPC\\Desktop\\hinhanh\\2.JPG");
		Thread.sleep(2000);

		clickWhenReady(By.xpath(".//*[@id='download-all']"), 20);
	}

	// clickWhenReady
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}
}
