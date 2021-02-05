package suiteCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity_3 {
	
  WebDriver driver;
  
  @Test
  public void Get_copyright_text() {
	  
	  WebElement copyrighttext = driver.findElement(By.id("admin_options"));	  
	  System.out.println("Printing the first copyright text to the console: " +copyrighttext.getText());
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
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
