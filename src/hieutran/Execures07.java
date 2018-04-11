package hieutran;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execures07 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_001() {
		driver.get("http://hdfcbank.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// iframe for pop-up
		WebElement iframe_00 = driver.findElement(By.xpath("//iframe[@id='http-push']"));
		driver.switchTo().frame(iframe_00);
		if (driver.findElement(By.xpath("//*[@id='closeImage']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='closeImage']")).click();
		}
		driver.switchTo().defaultContent();

		// Verify What are you looking for?
		WebElement iframe_01 = driver
				.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe[contains(@id,'viz_iframe')]"));
		driver.switchTo().frame(iframe_01);
		WebElement xpathText = driver.findElement(By.xpath("//span[@id='messageText']"));
		String verifyText = xpathText.getText();
		Assert.assertEquals(verifyText, "What are you looking for?");
		driver.switchTo().defaultContent();

		// Verify banner image
		WebElement iframe_02 = driver
				.findElement(By.xpath("//div[@class='slidingbanners']//iframe[contains(@id,'viz_iframe')]"));
		driver.switchTo().frame(iframe_02);
		WebElement xpathText02 = driver.findElement(By.xpath("//div[@id='productcontainer']"));
		Assert.assertTrue(xpathText02.isDisplayed());
		driver.switchTo().defaultContent();
		WebElement xpathText03 = driver.findElement(By.xpath("//div[@class='flipBanner']"));
		Assert.assertTrue(xpathText03.isDisplayed());
	}

	@Test
	public void TC_002() {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		String parentWindow = driver.getWindowHandle();
		switchToChildWindow(parentWindow);
		System.out.println(driver.getTitle());
		closeAllWithoutParentWindows(parentWindow);
		// Back home
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		System.out.println(driver.getTitle());
		
	}

	@Test
	public void TC_003() {
		driver.get("http://hdfcbank.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// iframe for pop-up
		WebElement iframe_00 = driver.findElement(By.xpath("//iframe[@id='http-push']"));
		driver.switchTo().frame(iframe_00);
		if (driver.findElement(By.xpath("//*[@id='closeImage']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='closeImage']")).click();
		}
		driver.switchTo().defaultContent();
		// switch Agri
		driver.findElement(By.xpath("//a[contains(text(),'Agri')]")).click();
		String parentWindow = driver.getWindowHandle();
		switchToChildWindow(parentWindow);
		driver.findElement(By.xpath("//p[contains(text(),'Account Details')]")).click();

		// switch Account Details
		switchToWindowByTitle("Welcome to HDFC Bank NetBanking");
		System.out.println(driver.getTitle());

		// click Privacy Policy
		WebElement iframe_01 = driver.findElement(By.xpath("//frame[@name='footer']"));
		driver.switchTo().frame(iframe_01);
		driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
		driver.switchTo().defaultContent();

		// switch CSR
		switchToWindowByTitle(
				"HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@title='Corporate Social Responsibility']")).click();
		System.out.println(driver.getTitle());

		// Back home
		switchToWindowByTitle("HDFC Bank: Personal Banking Services");
		System.out.println(driver.getTitle());
		// close
		String parentWindow1 = driver.getWindowHandle();
		closeAllWithoutParentWindows(parentWindow1);
		
	}

	public void switchToChildWindow(String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
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
