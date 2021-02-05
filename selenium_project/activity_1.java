package suiteCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity_1 {
	
  WebDriver driver;
  
  @Test
  public void Verify_website_title() {
	  String title = driver.getTitle();
	  System.out.println("Title of Page is: " + title);
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  Assert.assertEquals(driver.getTitle(), "SuiteCRM");  	  
	  System.out.println("'SuiteCRM' matches with tile of page: " + driver.getTitle());
  } 
  
  @BeforeMethod
  public void beforemethod() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\UdayVerma\\Desktop\\SDET\\geckodriver-v0.29.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
  }
  
  @AfterMethod
  public void browserclose() {	  
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  driver.close();
  }
  
}
