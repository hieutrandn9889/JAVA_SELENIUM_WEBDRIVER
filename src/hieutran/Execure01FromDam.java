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

public class Execure01FromDam {
	WebDriver driver;

	@BeforeTest
	public void beforTest() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		firstName = "Automation";
		lastName = "testing";
		email = "auto_testing" + radomEmail() + "@gmail.com";
		passWord = "123456789";
	}

	@Test
	public void TC_01_CreateNewAccount() {

		// Click My Account page
		driver.findElement(By.xpath("//div[@class='footer-container']//a[contains(text(),'My Account')]")).click();

		// Click Create Account page
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		// Input to firstName
		driver.findElement(By.name("firstname")).sendKeys(firstName);

		// Input to lastName
		driver.findElement(By.xpath("//*[@title='Last Name']")).sendKeys(lastName);

		// Input to email
		driver.findElement(By.id("email_address")).sendKeys(email);

		// Input to passWord
		driver.findElement(By.id("password")).sendKeys(passWord);
		
		//Confirm to passWord
		driver.findElement(By.id("confirmation")).sendKeys(passWord);

		// Click Register button
		driver.findElement(By.xpath("//button[@title='Register']")).click();

		// Get the text
		String text = driver.findElement(By.xpath("//p[@class='hello']/strong")).getText();

		// Verify the text
		System.out.println(text);
		Assert.assertEquals(text, "Hello, " + firstName + " " + lastName + "!");
	}

	public int radomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(99999) + 1;
		return number;

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	private String firstName, lastName, email, passWord;

}
