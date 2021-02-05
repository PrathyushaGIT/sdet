package suiteCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity_4 {
	
  WebDriver driver;
  
  @Test
  public void Logging_into_site() {
	  
	  WebElement user = driver.findElement(By.id("user_name"));	  
	  WebElement pass = driver.findElement(By.id("username_password"));
	  user.sendKeys("admin");
	  pass.sendKeys("pa$$w0rd");
	  driver.findElement(By.id("bigbutton")).click();
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	  Actions action = new Actions(driver);
	  action.moveToElement(driver.findElement(By.xpath("//*[@id='with-label']"))).perform();
	  
  }
  
  @BeforeMethod
  public void beforemethod() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\SwarnaPrathyusha\\Desktop\\SDET\\geckodriver-v0.29.0-win64\\geckodriver.exe");
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
