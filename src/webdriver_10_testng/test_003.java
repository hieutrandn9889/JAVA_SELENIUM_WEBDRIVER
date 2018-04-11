package webdriver_10_testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test_003 {
	WebDriver driver;
  @Test
  public void f() {
	  System.out.println("testing");
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
