package suiteCRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity_5 {

	WebDriver driver;

	@Test
	public void Getting_colors() {

		WebElement user = driver.findElement(By.id("user_name"));
		WebElement pass = driver.findElement(By.id("username_password"));
		user.sendKeys("admin");
		pass.sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String navicolor = driver.findElement(By.id("toolbar")).getCssValue("color");
		System.out.println("Color of the Navigation Menu: " +navicolor);
		String hex = Color.fromString(navicolor).asHex();
		System.out.println(hex);	
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