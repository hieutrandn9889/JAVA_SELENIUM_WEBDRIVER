package hieutran;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankTestCase {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		userID = "mngr75460";
		passWord = "tYnytym";
		CustomerName = "AUTOMATION TESTING";
		DateOfBirth = "01/01/1989";
		Address = "PO Box 911 8331 Duis Avenue";
		EditAdress = "1883 Cursus Avenue";
		City = "Tampa";
		EditCity = "Houston";
		State = "FL";
		EditState = "Texas";
		Pin = "466250";
		EditPin = "166455";
		Mobile = "4555442476";
		EditMobile = "4779728081";
		firstName = "automation";
		EditfirstName = "testing";
		lastName = "@gmail.com";
		Email = firstName + ranDomEmail() + lastName;
		EditEmail = EditfirstName + ranDomEmail() + lastName;
		Password = "automation";
	}

	@Test(enabled= true)
	public void TC_001_CreateNewAccount() {
		// Input to userID
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);

		// Input to passWord
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);

		// Click login button
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

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
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);

		// Click submit button
		driver.findElement(By.xpath("//input[@name='sub']")).click();

		// Verify message
		String verifySuccess = driver
				.findElement(By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]")).getText();
		System.out.println(verifySuccess);
		Assert.assertEquals(verifySuccess, "Customer Registered Successfully!!!");

		// Get Customer ID
		CustomerID = driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]//following-sibling::td"))
				.getText();
		System.out.println(CustomerID);

	}

	@Test(enabled= true)
	public void TC_002_EditAccount() {

		// Click Edit Customer
		driver.findElement(By.xpath("//a[contains(text(),'Edit Customer' )]")).click();
		// Input to customerID
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);

		// Submit button
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();

		// Clear content and input to address of the textbox
		driver.findElement(By.xpath("//textarea[@name='addr']")).clear();
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(EditAdress);

		// Clear content and input to city of the textbox
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(EditCity);

		// Clear content and input to State of the textbox
		driver.findElement(By.xpath("//input[@name='state']")).clear();
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(EditState);

		// Clear content and input to pinno of the textbox
		driver.findElement(By.xpath("//input[@name='pinno']")).clear();
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(EditPin);

		// Clear content and input to telephoneno of the textbox
		driver.findElement(By.xpath("//input[@name='telephoneno']")).clear();
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(EditMobile);

		// Clear content and input to emailid of the textbox
		driver.findElement(By.xpath("//input[@name='emailid']")).clear();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(EditEmail);

		// Submit the button
		driver.findElement(By.xpath("//input[@name='sub']")).click();

		// Verify the content
		String editContent = driver
				.findElement(By.xpath("//p[contains(text(),'Customer details updated Successfully!!!')]")).getText();
		System.out.println(editContent);
		Assert.assertEquals(editContent, "Customer details updated Successfully!!!");
	}

	@Test(enabled= false)
	public void TC_003_AddNewAccount() {
		
		// AccountID
		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
		// Choosing the select
		Select oSelect = new Select(driver.findElement(By.name("selaccount")));
		// Choosing the Current
		oSelect.selectByVisibleText("Current");
		// Input the money
		driver.findElement(By.xpath("//input[@name='inideposit']")).sendKeys("500000");
		// click the button
		driver.findElement(By.xpath("//input[@name='button2']")).click();
		// Verify the content
		String verifyGenerate = driver
				.findElement(By.xpath("//p[contains(text(),'Account Generated Successfully!!!')]")).getText();
		Assert.assertEquals(verifyGenerate, "Account Generated Successfully!!!");
		// Get Account ID
		AccountID = driver.findElement(By.xpath("//td[contains(text(),'Account ID')]//following-sibling::td"))
				.getText();
		System.out.println(AccountID);

		// AccountID2
		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
		// Choosing the select
		Select oSelect2 = new Select(driver.findElement(By.name("selaccount")));
		// Choosing the Current
		oSelect2.selectByVisibleText("Current");
		// Input the money
		driver.findElement(By.xpath("//input[@name='inideposit']")).sendKeys("500000");
		// click the button
		driver.findElement(By.xpath("//input[@name='button2']")).click();
		// Verify the content
		String verifyGenerate2 = driver
				.findElement(By.xpath("//p[contains(text(),'Account Generated Successfully!!!')]")).getText();
		Assert.assertEquals(verifyGenerate2, "Account Generated Successfully!!!");
		// Get Account ID
		AccountID2 = driver.findElement(By.xpath("//td[contains(text(),'Account ID')]//following-sibling::td"))
				.getText();
		System.out.println(AccountID2);

	}

	@Test (enabled= false)
	public void TC_004_TranferMoney() {
		driver.findElement(By.xpath("//a[contains(text(),'Deposit')]")).click();
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(AccountID);
		driver.findElement(By.xpath("//input[@name='ammount']")).sendKeys("5000");
		driver.findElement(By.xpath("//input[@name='desc']")).sendKeys("Depsoit");
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		String verifytranferMoney = driver
				.findElement(By.xpath("//p[contains(text(),'Transaction details of Deposit for Account')]")).getText();
		Assert.assertEquals(verifytranferMoney, "Transaction details of Deposit for Account " + AccountID);

		// Get Account number
		AccountNo = driver.findElement(By.xpath("//td[contains(text(),'Account No')]//following-sibling::td"))
				.getText();

		// AccountNo2
		driver.findElement(By.xpath("//a[contains(text(),'Deposit')]")).click();
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(AccountID2);
		driver.findElement(By.xpath("//input[@name='ammount']")).sendKeys("5000");
		driver.findElement(By.xpath("//input[@name='desc']")).sendKeys("Depsoit");
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		String verifytranferMoney2 = driver
				.findElement(By.xpath("//p[contains(text(),'Transaction details of Deposit for Account')]")).getText();
		Assert.assertEquals(verifytranferMoney2, "Transaction details of Deposit for Account " + AccountID2);

		// Get Account number
		AccountNo2 = driver.findElement(By.xpath("//td[contains(text(),'Account No')]//following-sibling::td"))
				.getText();
	}

	@Test (enabled= false)
	public void TC_005_WithDrawa() {
		driver.findElement(By.xpath("//a[contains(text(),'Withdrawal')]")).click();
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(AccountNo);
		driver.findElement(By.xpath("//input[@name='ammount']")).sendKeys("1500");
		driver.findElement(By.xpath("//input[@name='desc']")).sendKeys("WithDraw");
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		String verifyWithDraw = driver
				.findElement(By.xpath("//p[contains(text(),'Transaction details of Withdrawal for Account')]"))
				.getText();
		Assert.assertEquals(verifyWithDraw, "Transaction details of Withdrawal for Account " + AccountNo);
	}

	@Test (enabled= false)
	public void TC_006_FundTransfer() {
		driver.findElement(By.xpath("//a[contains(text(),'Fund Transfer')]")).click();
		driver.findElement(By.xpath("//input[@name='payersaccount']")).sendKeys(AccountNo);
		driver.findElement(By.xpath("//input[@name='payeeaccount']")).sendKeys(AccountNo2);
		driver.findElement(By.xpath("//input[@name='ammount']")).sendKeys("10000");
		driver.findElement(By.xpath("//input[@name='desc']")).sendKeys("Transfer");
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		String verifyFundTransfer = driver
				.findElement(By.xpath("//p[contains(text(),'Fund Transfer Details')]"))
				.getText();
		Assert.assertEquals(verifyFundTransfer, "Fund Transfer Details");
	}

	@Test (enabled= false)
	public void TC_007_Balance() {
		driver.findElement(By.xpath("//a[contains(text(),'Balance Enquiry')]")).click();
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(AccountNo);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		String verifyBalance = driver.findElement(By.xpath("//p[contains(text(),'Balance Details for Account')]"))
				.getText();
		Assert.assertEquals(verifyBalance, "Balance Details for Account " + AccountNo);
	}

	@Test (enabled= false)
	public void TC_008_DeleteAccount() {
		driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(AccountNo);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		// Wait Alert
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
		// Accepting alert
		alert.accept();
		// get content of alert
		String VerifyDeleteAccount = alert.getText();
		System.out.println(VerifyDeleteAccount);
		Assert.assertEquals(VerifyDeleteAccount, "Account Deleted Sucessfully");
		driver.switchTo().alert().accept();
		
		
		// Delete Accountno2
		driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(AccountNo2);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		// Wait Alert
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.alertIsPresent());
		// Switching to Alert
		Alert alert2 = driver.switchTo().alert();
		// Capturing alert message.
		String alertMessage2 = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage2);
		// Accepting alert
		alert2.accept();
		// get content of alert
		String VerifyDeleteAccount2 = alert2.getText();
		System.out.println(VerifyDeleteAccount2);
		Assert.assertEquals(VerifyDeleteAccount2, "Account Deleted Sucessfully");
		driver.switchTo().alert().accept();

	}

	@Test (enabled= false)
	public void TC_009_DeleteAccountCustomer() {
		driver.findElement(By.xpath("//a[contains(text(),'Delete Customer')]")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(CustomerID);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();

		// Displaying alert message
		System.out.println(alertMessage);

		// Accepting alert
		alert.accept();

		// get content of alert
		String VerifyDeleteAccountCustomer = alert.getText();
		System.out.println(VerifyDeleteAccountCustomer);
		Assert.assertEquals(VerifyDeleteAccountCustomer, "Customer deleted Successfully");
		driver.switchTo().alert().accept();
	}

	public int ranDomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(99999) + 1;
		return number;
	}

	@AfterTest
	public void afterTest() {
		 driver.quit();
	}

	private String firstName, lastName, userID, passWord, CustomerName, DateOfBirth, Address, City, State, Pin, Mobile,
			Email, Password, EditAdress, EditCity, EditPin, EditMobile, EditfirstName, EditEmail, EditState, CustomerID,
			AccountID, AccountID2, AccountNo, AccountNo2;

}
