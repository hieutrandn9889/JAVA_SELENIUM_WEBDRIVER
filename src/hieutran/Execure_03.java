package hieutran;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execure_03 {
	WebDriver driver;
	public String age, InterestsDevelopment;

	@BeforeTest
	public void beforeTest() {
		// driver = new FirefoxDriver();

		// run chrome
		// System.setProperty("webdriver.chrome.driver",
		// "..//JAVA_SELENIUM_WEBDRIVER/driver/chromedriver.exe");
		// driver = new ChromeDriver();

		// run IE
		System.setProperty("webdriver.ie.driver", "..//JAVA_SELENIUM_WEBDRIVER/driver/IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_001_CheckElementOnPage() {
		// Check textbox email and input to textbox
		String checkEmailTextBox = "//input[@id='mail']";
		WebElement elementEmail = driver.findElement(By.xpath(checkEmailTextBox));
		if (isElementDisplayed(driver, checkEmailTextBox)) {
			elementEmail.sendKeys("Automation Testing");
		}

		// Check radio Age amd click to choose
		String age = "//*[@id='under_18']";
		WebElement elementAge = driver.findElement(By.xpath(age));
		if (isElementDisplayed(driver, age)) {
			elementAge.click();
		}

		// Check textbox email and input to textbox
		String education = ".//*[@id='edu']";
		WebElement elementEducation = driver.findElement(By.xpath(education));
		if (isElementDisplayed(driver, education)) {
			elementEducation.sendKeys("Automation Testing");
		}

	}

	@Test
	public void TC_002_CheckEnableDisableOnPage() {

		// check Email/ Age (Under 18)/ Education/ Job Role 01/ Interests
		// (Development)/ Slider 01/ Button is enabled
		String checkEmailTextBox = "//input[@id='mail']";
		if (isElementEnabled(driver, checkEmailTextBox)) {
			System.out.println("Element is enabled");
		}
		String age = "//input[@id='under_18']";
		if (isElementEnabled(driver, age)) {
			System.out.println("Element is enabled");
		}
		String education = "//input[@id='edu']";
		if (isElementEnabled(driver, education)) {
			System.out.println("Element is enabled");
		}
		String JobRole01 = "//input[@id='job1']";
		if (isElementEnabled(driver, JobRole01)) {
			System.out.println("Element is enabled");
		}
		String InterestsDevelopment = "//input[@id='development']";
		if (isElementEnabled(driver, InterestsDevelopment)) {
			System.out.println("Element is enabled");
		}
		String Slider01 = "//input[@id='slider-1']";
		if (isElementEnabled(driver, Slider01)) {
			System.out.println("Element is enabled");
		}
		String ButtonIsEnabled = "//input[@id='button-enabled']";
		if (isElementEnabled(driver, ButtonIsEnabled)) {
			System.out.println("Element is enabled");
		}
		System.out.println("=====================================");
		// Password / Age (Radiobutton is disabled)/ Biography/ Job Role 02/
		// Interests (Checkbox is disabled)/ Slider 02/ Button is disabled
		String password = "//input[@id='password']";
		if (!isElementEnabled(driver, password)) {
			System.out.println("Element is disabled");
		}
		String ageRadiobutton = "//input[@id='radio-disabled']";
		if (!isElementEnabled(driver, ageRadiobutton)) {
			System.out.println("Element is disabled");
		}
		String biography = "//input[@id='bio']";
		if (!isElementEnabled(driver, biography)) {
			System.out.println("Element is disabled");
		}
		String JobRole02 = "//input[@id='job2']";
		if (!isElementEnabled(driver, JobRole02)) {
			System.out.println("Element is disabled");
		}
		String InterestsCheckbox = "//input[@id='check-disabled']";
		if (!isElementEnabled(driver, InterestsCheckbox)) {
			System.out.println("Element is disabled");
		}
		String Slider02 = "//input[@id='slider-2']";
		if (!isElementEnabled(driver, Slider02)) {
			System.out.println("Element is disabled");
		}
		String ButtonIsDisenabled = "//input[@id='button-disabled']";
		if (!isElementEnabled(driver, ButtonIsDisenabled)) {
			System.out.println("Element is disabled");
		}
	}

	@Test
	public void TC_003_CheckSelectElementOnPage() {

		age = "//*[@id='under_18']";
		WebElement elementAge = driver.findElement(By.xpath(age));
		elementAge.click();

		// InterestsDevelopment
		InterestsDevelopment = "//input[@id='development']";
		WebElement elementInterestsDevelopment = driver.findElement(By.xpath(InterestsDevelopment));
		elementInterestsDevelopment.click();
		if (isElementSeleted(driver, age) && isElementSeleted(driver, InterestsDevelopment)) {
			System.out.println("Age and InterestsDevelopment are enabled");
		} else {
			elementAge.click();
			elementInterestsDevelopment.click();
		}

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

	public boolean isElementSeleted(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isSelected();
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public boolean isElementEnabled(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isEnabled();
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
