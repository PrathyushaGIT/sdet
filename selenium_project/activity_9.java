package suiteCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity_9 {
WebDriver driver;
	
	 @Test
	 public void Traversing_tables_2() throws InterruptedException {
		  
		WebElement user = driver.findElement(By.id("user_name"));	  
		WebElement pass = driver.findElement(By.id("username_password"));
		user.sendKeys("admin");
		pass.sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
		driver.findElement(By.id("moduleTab_9_Leads")).click();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		try {
			WebElement clearFilterBtn = driver.findElements(By.xpath("//table[@class='paginationTable']/tbody/tr/td/ul[5]")).get(0);
			clearFilterBtn.click();
		} catch (ElementNotInteractableException e) {
			System.out.println("No Filter is applied yet. You can proceed.");
		} catch(IndexOutOfBoundsException e) {
			try {
				System.out.println("You are on No results found.");
				WebElement clearFilterBtn = driver.findElements(By.xpath("//li[@class='sugar_action_button desktopOnly']")).get(0);
				clearFilterBtn.click();
			} catch (Exception e2) {
				e2.printStackTrace();
			}				
		}
		
		System.out.println("Data in Table: "); 
		int i=1;
		 while(i<=10) {
		    String name= driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[3]")).getText();
		    String user1= driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[8]")).getText();
			System.out.println("Name"+(i)+":-" +name+"|User"+(i)+ ":-" +user1);
			System.out.println("\n");
			i++;
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
