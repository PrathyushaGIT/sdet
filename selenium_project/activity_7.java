package suiteCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity_7 {

	WebDriver driver;
	
	@Test
	  public void Reading_additional_information() throws InterruptedException {
		
		  WebElement user = driver.findElement(By.id("user_name"));	  
		  WebElement pass = driver.findElement(By.id("username_password"));
		  user.sendKeys("admin");
		  pass.sendKeys("pa$$w0rd");
		  driver.findElement(By.id("bigbutton")).click();
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		  Actions action = new Actions(driver);
		  action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
		  driver.findElement(By.id("moduleTab_9_Leads")).click();	
		  Thread.sleep(1000);	
		  //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	
		  WebElement element = driver.findElement(By.xpath("//*[@title='Filter']"));
		  WebDriverWait wait = new WebDriverWait(driver, 30); 
		  wait.until(ExpectedConditions.visibilityOf(element)); 
		  element.click();
		  WebElement name = driver.findElement(By.xpath("//*[@id='first_name_advanced']"));
		  Thread.sleep(1000);	
		  name.clear();
		  name.sendKeys("uday");
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  driver.findElement(By.xpath("//*[@title='Search']")).click();
		  Thread.sleep(3000);
		  WebElement element1 = driver.findElement(By.xpath("//*[@id='adspan_e261655f-8e87-e131-d72b-600673d3a0e8']/span"));
		  WebDriverWait wait1 = new WebDriverWait(driver, 30); 
		  wait1.until(ExpectedConditions.visibilityOf(element1)); 
		  element1.click(); 
		  Thread.sleep(3000);
		  String phone = driver.findElement(By.className("phone")).getText();
		  System.out.println("Phone Number is : " +phone);
		  
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
