package webdriver_10_testng;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestNG_Parameters {
  WebDriver driver;
  
  //C01
//  @DataProvider(name="User/Pass")
//  public static Object[][] userAndPassword(){
//	  return new Object[][]{
//		  
//		  {"mngr74550","EgejEdU"},
//		  {"mngr74553","getApYh"},
//		  {"mngr74554","EhUnYgY"}
//		  
//	  };
//  }
//  
//  @Test(dataProvider = "User/Pass")
//  public void TC_001(String UserName, String Password) {
//	  driver.navigate().to("http://demo.guru99.com/V4");
//	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserName);;
//	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);;
//	  driver.findElement(By.name("btnLogin")).click();;
//  }
  
  // C02
  @DataProvider(name="User/Pass")
  public static Object[][] userAndPassword2(Method method){
	  Object[][] result = null;
	  if(method.getName().equals("TC_002")){
		  result = new Object[][]{
		  {"mngr74550","EgejEdU"},
		  {"mngr74553","getApYh"},
		  };
	  }else if (method.getName().equals("TC_003")) {
		  result = new Object[][]{
		  {"mngr74550","EgejEdU"},
		  {"mngr74553","getApYh"},
		  };
	}
	 return result; 
  }
  
  @Test(dataProvider = "User/Pass")
  public void TC_002(String UserName, String Password) {
	  driver.navigate().to("http://demo.guru99.com/V4");
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserName);;
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);;
	  driver.findElement(By.name("btnLogin")).click();;
  }
  
  @Test(dataProvider = "User/Pass")
  public void TC_003(String UserName, String Password) {
	  driver.navigate().to("http://demo.guru99.com/V4");
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserName);;
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);;
	  driver.findElement(By.name("btnLogin")).click();;
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
