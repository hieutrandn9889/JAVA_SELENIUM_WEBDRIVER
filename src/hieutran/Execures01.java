package hieutran;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execures01 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_VerifyURLAndTitle() {

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Home page", title);
		driver.findElement(By.xpath("//div[@class='footer-container']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		// Back
		driver.navigate().back();
		String urlManageAccountPage = driver.getCurrentUrl();
		Assert.assertEquals(urlManageAccountPage, "http://live.guru99.com/index.php/customer/account/login/");
		// Refresh
		driver.navigate().refresh();
		// Forward
		driver.navigate().forward();
		String urlCreateAccountPage = driver.getCurrentUrl();
		Assert.assertEquals(urlCreateAccountPage, "http://live.guru99.com/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_LoginEmpty() {
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='footer-container']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.id("send2")).click();
		String errorMessageEmail = driver.findElement(By.id("advice-required-entry-email")).getText();
		Assert.assertEquals(errorMessageEmail, "This is a required field.");
		String errorMessagePassword = driver.findElement(By.id("advice-required-entry-pass")).getText();
		Assert.assertEquals(errorMessagePassword, "This is a required field.");
	}

	@Test
	public void TC_03LoginWithEmailInvalid() {
		driver.findElement(By.xpath("//div[@class='footer-container']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.id("email")).sendKeys("123434234@12312.123123");
		driver.findElement(By.id("send2")).click();
		String errorMessageEmail = driver.findElement(By.id("advice-validate-email-email")).getText();
		Assert.assertEquals(errorMessageEmail, "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_04_LoginWithPasswordIncorrect() {
		driver.findElement(By.xpath("//div[@class='footer-container']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.id("send2")).click();
		String errorMessage = driver.findElement(By.id("advice-validate-password-pass")).getText();
		Assert.assertEquals(errorMessage,
				"Please enter 6 or more characters. Leading or trailing spaces will be ignored.");
	}

	@Test
	public void TC_05_CreateAnAccount() {

		// Click My account and Create account
		driver.findElement(By.xpath("//div[@class='footer-container']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		// Input to firstname
		driver.findElement(By.id("firstname")).sendKeys("hieu");

		// Input to lastname
		driver.findElement(By.id("lastname")).sendKeys("tran");

		// Random email
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		driver.findElement(By.id("email_address")).sendKeys("hieutran" + randomInt + "@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.findElement(By.id("confirmation")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		String successMessage = driver
				.findElement(By
						.xpath("//div[@class='col-main']//span[contains(text(),'Thank you for registering with Main Website Store.')]"))
				.getText();
		Assert.assertEquals(successMessage, "Thank you for registering with Main Website Store.");
		driver.findElement(By.xpath("//div[@class='page-header-container']//span[contains(text(), 'Account')]"))
				.click();
		driver.findElement(By.xpath("//div[@class='page-header-container']//a[@title='Log Out']")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
