package junitpack;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleBrowserWindows
{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void BeforeTest()
	{
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@After
	public void AfterTest()
	{
		driver.quit();
	}
	
	@Test
	  public void test () throws InterruptedException 
	  {
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//b[contains(.,'Open New Page')]")).click();
	  
	  // Get and store both window handles in array
	  Set<String> AllWindowHandles = driver.getWindowHandles();
	  String window1 = (String) AllWindowHandles.toArray()[0];
	  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
	  String window2 = (String) AllWindowHandles.toArray()[1];
	  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
	  
	  //Switch to window2(child window) and performing actions on it.
	  driver.switchTo().window(window2);
	  driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
	  driver.findElement(By.xpath("//input[@value='Bike']")).click();
	  driver.findElement(By.xpath("//input[@value='Car']")).click();
	  driver.findElement(By.xpath("//input[@value='Boat']")).click();
	  driver.findElement(By.xpath("//input[@value='male']")).click();
	  Thread.sleep(5000);
	  
	  //Switch to window1(parent window) and performing actions on it.
	  driver.switchTo().window(window1);
	  driver.findElement(By.xpath("//option[@id='country6']")).click();
	  driver.findElement(By.xpath("//input[@value='female']")).click();
	  driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
	  driver.switchTo().alert().accept();
	  Thread.sleep(5000);
	  
	  //Once Again switch to window2(child window) and performing actions on it.
	  driver.switchTo().window(window2);
	  driver.findElement(By.xpath("//input[@name='fname']")).clear();
	  driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Name Changed");
	  Thread.sleep(5000);
	  driver.close();
	  
	  //Once Again switch to window1(parent window) and performing actions on it.
	  driver.switchTo().window(window1);
	  driver.findElement(By.xpath("//input[@value='male']")).click();
	  Thread.sleep(5000);
	  }
}