package hieutran;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execures06 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();

	}

	@Ignore
	public void TC_001_Move_mouse_to_element() {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement hover = driver.findElement(By.xpath("//a[contains(text(),'Hover over me')]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(hover).perform();

		// verify
		WebElement verify = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
		String hooryText = verify.getText();
		Assert.assertEquals(hooryText, "Hooray!");
	}

	@Ignore
	public void TC_001_Move_mouse_to_element_02() {
		driver.get("http://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement hoverLogin = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(hoverLogin).perform();

		// verify Login
		WebElement verifyLogin = driver.findElement(By.xpath("//a[contains(text(),'login')]"));
		String hooryTextLogin = verifyLogin.getText();
		Assert.assertEquals(hooryTextLogin, "LOGIN");

		// verify Sign Up
		WebElement verifySignUp = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
		String hooryTextSignUP = verifySignUp.getText();
		Assert.assertEquals(hooryTextSignUP, "SIGN UP");
	}

	@Ignore
	public void TC_002_Click_and_hold_element_select_multiple_item() {
		driver.get("http://jqueryui.com/selectable/#display-grid");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);

		// chieu ngang
		List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(listItems.get(0)).clickAndHold(listItems.get(3)).click().perform();

		// chieu doc: xem nguon va dich
		// List<WebElement> listItems =
		// driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		// Actions builder = new Actions(driver);
		// builder.clickAndHold(listItems.get(1)).clickAndHold(listItems.get(9)).click().perform();

		// chieu cheo: xem nguon va dich
		// List<WebElement> listItems =
		// driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		// Actions builder = new Actions(driver);
		// builder.clickAndHold(listItems.get(0)).clickAndHold(listItems.get(11)).click().perform();

		// WebElement verify4Element =
		// driver.findElement(By.xpath("//li[@class='ui-state-default
		// ui-selectee ui-selected']"))
		List<WebElement> listItems_TC_002 = driver
				.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));
		System.out.println(listItems_TC_002.size());
		Assert.assertEquals(listItems_TC_002.size(), 4);
	}

	@Ignore
	public void TC_003_Double_click() {
		driver.get("http://www.seleniumlearn.com/double-click");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement xpathDouble = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me!')]"));
		Actions builder = new Actions(driver);
		builder.doubleClick((xpathDouble)).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage, "The Button was double-clicked.");
		// Accepting alert
		alert.accept();
	}

	@Test
	public void TC_004_Right_click_to_element() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement xpathRightClick = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		Actions builder = new Actions(driver);
		builder.contextClick(xpathRightClick).perform();
		WebElement xpathQuit = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"));
		builder.moveToElement(xpathQuit).perform();
		
		WebElement hoverXpathQuit = driver.findElement(By.xpath("//li[contains(@class,'context-menu-visible') and contains(.,'Quit')]"));
		Assert.assertTrue(hoverXpathQuit.isDisplayed());
		// click
		builder.click(xpathQuit).perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Ignore
	public void TC_005_Drag_and_drop_element() {
		driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement xpathDrapFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));
		Actions builder = new Actions(driver);
		Action drapAndDrop = builder.clickAndHold(xpathDrapFrom).moveToElement(target).release(target).build();
		drapAndDrop.perform();
		WebElement verify = driver.findElement(By.xpath("//div[contains(text(),'You did great!')]"));
		String verifyText = verify.getText();
		Assert.assertEquals(verifyText, "You did great!");

	}

	@Ignore
	public void TC_005_Drag_and_drop_element_002() {
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Switch to frame
		WebElement iframe_00 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe_00);
		WebElement xpathDrapFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions builder = new Actions(driver);
		Action drapAndDrop = builder.clickAndHold(xpathDrapFrom).moveToElement(target).release(target).build();
		drapAndDrop.perform();
		WebElement verify = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
		String verifyText = verify.getText();
		Assert.assertEquals(verifyText, "Dropped!");
		driver.switchTo().defaultContent();

	}

	@Ignore
	public void TC_006_Sendkey_sequence() {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Hello");
		WebElement elem = driver.findElement(By.xpath("//textarea[@id='edu']"));
		Actions builder = new Actions(driver);
		builder.click(elem).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		builder.sendKeys(Keys.BACK_SPACE).perform();
		WebElement verify = driver.findElement(By.xpath("//textarea[@id='edu']"));
		String verifyText = verify.getText();
		Assert.assertEquals(verifyText, "");
	}

	@AfterTest
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
