package hieutran;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execure05 {
    WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Ignore
	public void TC_001_Test_Script_01() {
		driver.get("http://daominhdam.890m.com/");
		// selenium code
		driver.findElement(By.xpath("//button[contains(@id,'button-enabled')]")).click();
		String getUrl = driver.getCurrentUrl();
		Assert.assertEquals(getUrl, "http://daominhdam.890m.com/#");
		driver.navigate().back();

		// javascript code
		WebElement enable = driver.findElement(By.id("button-enabled"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", enable);
		String getUrl1 = driver.getCurrentUrl();
		Assert.assertEquals(getUrl1, "http://daominhdam.890m.com/#");
	}

	@Test
	public void TC_002_Test_Script_02() {
		driver.navigate().to("http://demos.telerik.com/kendo-ui/styling/checkboxes");
		WebElement enable = driver.findElement(By.xpath("//li/label[contains(text(),'Dual-zone air conditioning')]/../input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", enable);
		
		
		// c1
//		String the_checkbox = "//li[label[contains(text(),'Dual-zone air conditioning')]]/input";
		// c2
//		 driver.findElement(By.xpath("//li/label[contains(text(),'Dual-zone air conditioning')]/../input")).click();
		// kiem tra check box
//		driver.findElement(By.xpath(the_checkbox)).click();
//		Assert.assertTrue(isElementSeleted(driver,the_checkbox ));
//		//deselect va kiem tra
//		driver.findElement(By.xpath(the_checkbox)).click();
//		Assert.assertFalse(isElementSeleted(driver,the_checkbox ));
	}

	@Ignore
	public void TC_003_Test_Script_03() {
		driver.navigate().to("http://demos.telerik.com/kendo-ui/styling/radios");
		//c1
//		driver.findElement(By.xpath("//li/label[contains(text(),'2.0 Petrol, 147kW')]/../input"));
		//c2
		String radio = "//li[label[contains(text(),'2.0 Petrol, 147kW')]]/input";
		WebElement testRadio = driver.findElement(By.xpath(radio));
		testRadio.click();
		Assert.assertTrue(isElementSeleted(driver, radio));
		if (!testRadio.isSelected()) {
			testRadio.click();
		}
	}
	
	@Ignore
	public void TC_004_Test_Script_04() {
		driver.navigate().to("http://daominhdam.890m.com/");
		driver.findElement(By.xpath("//li/button[contains(text(),'Click for JS Alert')]")).click();
		
		//Alert
		Alert alert = driver.switchTo().alert();
		String textOnAlert = alert.getText();
		Assert.assertEquals(textOnAlert, "I am a JS Alert");
		alert.accept();
		System.out.println("You clicked an alert successfully");
		
	}
	
	@Ignore
	public void TC_005_Test_Script_05() {
		driver.navigate().to("http://daominhdam.890m.com/");
		driver.findElement(By.xpath("//li/button[contains(text(),'Click for JS Confirm')]")).click();
		
		//Alert
		Alert alert = driver.switchTo().alert();
		String textAlert1 = alert.getText();
		Assert.assertEquals(textAlert1, "I am a JS Confirm");
		alert.dismiss();
		System.out.println("You clicked: Cancel");
	}
	
	@Ignore
	public void TC_006_Test_Script_06() {
		driver.navigate().to("http://daominhdam.890m.com/");
		driver.findElement(By.xpath("//li/button[contains(text(),'Click for JS Prompt')]")).click();
		
		//Alert
		Alert alert = driver.switchTo().alert();
		String textAlert1 = alert.getText();
		Assert.assertEquals(textAlert1, "I am a JS prompt");
		alert.sendKeys("Hieutran");
		alert.accept();
		WebElement textResult =  driver.findElement(By.xpath("//p[contains(@id,'result')]"));
		String hello = textResult.getText();
		Assert.assertEquals(hello, "You entered: Hieutran");
	}
	
	
	
	public boolean isElementSeleted(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isSelected();
		} catch (NoSuchElementException e) {
			return false;
		}

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
			if (driver.toString().toLowerCase().contains("firefox")) {
				String cmd = "taskkill /IM firefoxdriver.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
