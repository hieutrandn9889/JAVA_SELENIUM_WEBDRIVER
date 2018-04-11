package webdriver_10_testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Demo {
	
  // groups	
  @Test(groups="buying")
  public void Test_Demo_01() {
  }
  @Test(groups="testing")
  public void Test_Demo_02() {
  }
  @Test(groups="contribue")
  public void Test_Demo_03() {
  }
  @Test(groups="contribue")
  public void Test_Demo_04() {
  }
  @Test(groups="testing")
  public void Test_Demo_05() {
  }
  
//Priority	
 @Test(groups="buying", priority = 1, enabled = true)
 public void Test_Demo_06() {
 }
 @Test(groups="testing",  priority = 2, enabled = true)
 public void Test_Demo_07() {
 }
 @Test(groups="contribue", priority = 3, enabled = true)
 public void Test_Demo_08() {
 }
 @Test(groups="contribue",  priority = 4, enabled = true)
 public void Test_Demo_09() {
 }
 @Test(groups="testing",  priority = 5, enabled = true)
 public void Test_Demo_10() {
 }
 
 // Parameters
 
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
