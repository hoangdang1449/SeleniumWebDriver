package junitpack;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasicAction
{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void BeforeTest()//Open Firefox, Maximize and Open URL in browser
	{
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	}
	
	@After
	public void AfterTest()//Close Web Driver
	{
		driver.quit();
	}
	
	@Test
	public void Test1()//Store Text of Element
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//Locating element by tagName and store its text in to variable dropdown.
		String dropdown = driver.findElement(By.tagName("select")).getText();
		System.out.print("Dropdown list values are as below :\n" +dropdown);
	}
	
	@Test
	public void Test2()//Clicking on Button
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		for (int i=20;i<=20;i++)
		{
			WebElement btn = driver.findElement(By.id("submitButton"));//Locating Element by ID
			if(btn.isEnabled())
			{
				//if webelement's attribute found enable then this code will be executed.
				System.out.print("\nButton is enable and webdriver is clicking on is now");
				//Location button ID then clicking on it.
				driver.findElement(By.id("submitButton")).click();
				i=20;
			}
				else
				{
					//if webelement's attribute found disable then this code will be executed.
					System.out.println("\nSorry this button is disable right now");
				}
				try
				{
					Thread.sleep(5000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}				
		}
	}
	
	@Test
	public void Test3()//Typing text into a textbox
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//Locating element by Name and type give texts into the input box.
		driver.findElement(By.name("fname")).sendKeys("My First Name");
	}
}