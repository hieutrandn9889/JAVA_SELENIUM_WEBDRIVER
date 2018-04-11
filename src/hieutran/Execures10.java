package hieutran;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.base.Function;

public class Execures10 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Ignore
	public void TC_001_Implicit_Wait() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement xpathText = driver.findElement(By.xpath("//h4[contains(text(),'Hello World')]"));
		String verifyText = xpathText.getText();
		Assert.assertEquals(verifyText, "Hello World!");
	}

	@Ignore
	public void TC_002_Explicit_Wait() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(
				"http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

		// present C1
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='contentWrapper']")));

		// present C2
		presentWhenReady(By.xpath("//div[@class='contentWrapper']"), 5);
		WebElement xpathText = driver.findElement(By.xpath("//span[contains(.,'No Selected Dates to display.')]"));
		String InText = xpathText.getText();
		System.out.println(InText);

		// click C1
		// WebDriverWait wait2 = new WebDriverWait(driver, 5);
		// wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='9']"))).click();

		// click C2
		clickWhenReady(By.xpath("//a[text()='9']"), 5);

		// invisible C1
		WebDriverWait wait3 = new WebDriverWait(driver, 30);
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));

		// invisible C2
		getWhenVisible(By.xpath("//div[@class='raDiv']"), 30);

		// visible
		WebDriverWait wait4 = new WebDriverWait(driver, 30);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='rcSelected']/a[text()='9']")));

		// visible C2
		getWhenInVisible(By.xpath("//span[contains(.,'Sunday, April 09, 2017')]"), 30);

		WebElement xpathText1 = driver.findElement(By.xpath("//span[contains(.,'Sunday, April 09, 2017')]"));
		String InText1 = xpathText1.getText();
		System.out.println(InText1);
		Assert.assertEquals(InText1, "Sunday, April 09, 2017");

	}

	@Ignore
	public void TC_003_Fluent_Wait_01() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://stuntcoders.com/snippets/javascript-countdown/");

		// visible

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='javascript_countdown_time']")));

		WebElement countdown = driver.findElement(By.id("javascript_countdown_time"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(countdown));

		new FluentWait<WebElement>(countdown).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.until(new Function<WebElement, Boolean>() {

					public Boolean apply(WebElement element) {
						return element.getText().endsWith("02");
					}
				});
	}

	
	@Test
	public void TC_004_Fluent_Wait_02() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		// visible
		WebElement countdown = driver.findElement(By.id("clock"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(countdown));
		
		// check changeColor
		new FluentWait<WebElement>(countdown).withTimeout(40, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
		.until(new Function<WebElement, Boolean>() {
					
					public Boolean apply(WebElement changColor) {
						changColor = driver.findElement(By.xpath("//*[@style='color: red;']"));
						return changColor.isDisplayed();
					}
				});
	}

	@Ignore
	public void TC_005_Fluent_Wait_03() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		// visible
		WebElement countdown = driver.findElement(By.id("clock"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(countdown));
		
		
		// check textBuzz
		new FluentWait<WebElement>(countdown).withTimeout(40, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS)
		.until(new Function<WebElement, Boolean>() {	
			public Boolean apply(WebElement textBuzz) {
				textBuzz = driver.findElement(By.xpath("//span[contains(text(),'Buzz  Buzz')]"));
				return textBuzz.isDisplayed();
			}			
		});
	}
	// Common
	// visible
	public WebElement getWhenVisible(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	// invisible
	public boolean getWhenInVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		boolean pass = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		return pass;
	}

	// presenceOfElementLocated
	public void presentWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.click();
	}

	// clickWhenReady
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	@AfterTest()
	public void afterTest() {
		try {
			// driver.quit();
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
