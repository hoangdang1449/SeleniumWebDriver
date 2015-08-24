package junitpack;

import java.io.IOException;
import java.net.BindException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VerifyElementEnableDisable
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
	public void Test() throws BindException, IOException, InterruptedException
	{
		Boolean fname = driver.findElement(By.xpath("//input[@name='fname']")).isEnabled();
		System.out.println(fname);
		
		WebElement firstname = driver.findElement(By.xpath("//input[@name='fname']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lname']"));
		
		//Verify First name text box is enabled or not then print related message
		if(firstname.isEnabled())
		{
			System.out.println("\nTextbox first name is enable. Take your action.");
		}
		
		else
		{
			System.out.println("\nTextbox first name is disable. Take your action");
		}
		
		//Verify Last name text box is not enable or not then print related message.
		if(lastname.isEnabled())
		{
			System.out.println("\nTextbox last name is enable. Take your action.");
		}
		
		else
		{
			System.out.println("\nTextbox last name is disable. Take your action.");
		}
	}
		
}
