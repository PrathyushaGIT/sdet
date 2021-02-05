package suiteCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity_8 {
WebDriver driver;
	
	@Test
	  public void Traversing_tables() throws InterruptedException {
		  
		  WebElement user = driver.findElement(By.id("user_name"));	  
		  WebElement pass = driver.findElement(By.id("username_password"));
		  user.sendKeys("admin");
		  pass.sendKeys("pa$$w0rd");
		  driver.findElement(By.id("bigbutton")).click();
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		  Actions action = new Actions(driver);
		  action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
		  driver.findElement(By.id("moduleTab_9_Accounts")).click();	
		  Thread.sleep(5000);		  
		  System.out.println("Names of the first 5 odd-numbered rows are : "); 
		  Thread.sleep(100);	
		  for(int i=1; i<=10; i++){
			    if(i%2!=0) {
				System.out.print(driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[3]")).getText());
				System.out.println("\n");
			    }			    
				}
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
		  driver.close();
	  }
}
