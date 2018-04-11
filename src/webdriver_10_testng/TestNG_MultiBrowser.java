package webdriver_10_testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class TestNG_MultiBrowser {
	WebDriver driver;

	@Parameters({"UserName","Password"})
	@Test
	public void TC_001(String UserName, String Password) {
		driver.navigate().to("http://demo.guru99.com/V4");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.name("btnLogin")).click();
	}

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// run chrome
			System.setProperty("webdriver.chrome.driver", "..//JAVA_SELENIUM_WEBDRIVER/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("ie")) {
			// run IE
			System.setProperty("webdriver.ie.driver", "..//JAVA_SELENIUM_WEBDRIVER/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
