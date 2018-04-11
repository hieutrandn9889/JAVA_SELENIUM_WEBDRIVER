package hieutran;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execure04 {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		userID = "mngr68604";
		passWord = "agUtEvU";
		CustomerName = "AUTOMATION TESTING";
		DateOfBirth = "01/01/1989";
		Address = "PO Box 911 8331 Duis Avenue";
		EditAdress = "Test address";
		City = "Tampa";
		State = "FL";
		Pin = "466250";
		Mobile = "4555442476";
		firstName = "Automation";
		lastName = "testing";
		email = "auto_testing" + radomEmail() + "@gmail.com";
	}
	@Test
	public void TC_001_CreateAccount(){
		driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		UserID = driver.findElement(By.xpath("//td[contains(text(),'User ID :')]//following-sibling::td")).getText();
		System.out.println(UserID);
		Password = driver.findElement(By.xpath("//td[contains(text(),'Password :')]//following-sibling::td")).getText();
		System.out.println(Password);
		driver.navigate().to("http://demo.guru99.com/v4");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}
	@Test
	public void TC_002_XuliTextboxAndTextArea (){
		

				// Click New Customer
				driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();

				// Fill in Customer Name, Gender, Date of Birth, Address, City, State,
				// PIN, Mobile Number, E-mail, Password fields
				driver.findElement(By.xpath("//input[@name='name']")).sendKeys(CustomerName);
				driver.findElement(By.id("dob")).sendKeys(DateOfBirth);
				driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(Address);
				driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
				driver.findElement(By.xpath("//input[@name='state']")).sendKeys(State);
				driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(Pin);
				driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(Mobile);
				driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);

				// Click submit button
				driver.findElement(By.xpath("//input[@name='sub']")).click();
				// Get Customer ID
				CustomerID = driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]//following-sibling::td"))
						.getText();
				System.out.println(CustomerID);
				// Click Edit Customer
				driver.findElement(By.xpath("//a[contains(text(),'Edit Customer' )]")).click();
				// Input to customerID
				driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
				// Submit button
				driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
				
				// verify Customer Name và Address
				editCustomer = driver.findElement(By.xpath("//td[contains(text(),'Customer Name')]//following-sibling::td//input")).getAttribute("value");
				Assert.assertEquals(editCustomer, "AUTOMATION TESTING");
				
				editAddress = driver.findElement(By.xpath("//td[contains(text(),'Address')]//following-sibling::td//textarea")).getText();
				Assert.assertEquals(editAddress, "PO Box 911 8331 Duis Avenue");
				
				// Edit customer Name and address
				
				WebElement name = driver.findElement(By. xpath( "//input[@name='name']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript( "arguments[0].removeAttribute('disabled')" ,name );
				name.clear();
				name.sendKeys("TestName");
				// Clear content and input to address of the textbox
				driver.findElement(By.xpath("//textarea[@name='addr']")).clear();
				driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(EditAdress);
				
				// Submit the button
				driver.findElement(By.xpath("//input[@name='sub']")).click();
				
				editAddress = driver.findElement(By.xpath("//td[contains(text(),'Address')]//following-sibling::td")).getText();
				System.out.println(editAddress);
				Assert.assertEquals(editAddress, EditAdress);
				editCustomer = driver.findElement(By.xpath("//td[contains(text(),'Customer Name')]//following-sibling::td")).getText();
				Assert.assertEquals(editCustomer, "TestName");
				
				
	}
	
	@Ignore
	public void TC_003_XulyDropDown (){
		driver.navigate().to("http://daominhdam.890m.com/");
		String selectXpath = "//*[@id='job1']";
		Select select = new Select(driver.findElement(By.xpath(selectXpath)));
		isMultiple(driver, selectXpath);
		
		//selectByVisibleText
		select.selectByVisibleText("Automation Tester");
		Assert.assertEquals("Automation Tester", select.getFirstSelectedOption().getText());
		
		//selectByValue
		select.selectByValue("manual");
		// tra ve value ="manual" : Manual Tester
		Assert.assertEquals("Manual Tester", select.getFirstSelectedOption().getText());
		select.selectByIndex(3);
		Assert.assertEquals("Mobile Tester", select.getFirstSelectedOption().getText());
		Assert.assertEquals(5, select.getOptions().size());
	}
	
	public int radomEmail(){
		Random rand = new Random();
		int number = rand.nextInt(9999) + 1;
		return number;
	}
	
	public void isMultiple(WebDriver driver, String yourLocator) {
		Select select = new Select(driver.findElement(By.xpath(yourLocator)));
		Assert.assertFalse(select.isMultiple());
		if (select.isMultiple()) {
			System.out.println("Select is multiple");
			
		}else {
			System.out.println("Select is not multiple");
			
		}
	}
	
	@AfterTest
	public void afterTest(){
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
	public String firstName, lastName, email, UserID, Password, userID, passWord, CustomerName, DateOfBirth, Address, City, State, Pin, Mobile,CustomerID, editCustomer, editAddress, EditAdress ;
}
