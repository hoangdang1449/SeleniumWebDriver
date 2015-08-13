package junitpack;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void Test4()//wait for page title and store page in a variable
	{
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		//Wait for page title
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(":My Test"));
		
		//Get and store page title in to variable
		String title = driver.getTitle();
		System.out.print(title);
	}
	
	@Test
	public void Test5()//Executing javascript in selenium webdriver to get page title with example
	{
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		//Get current title page
		String pagetitle = (String)javascript.executeScript("return document.title");
		System.out.println("My page is: "+pagetitle);
		
		//Get current page URL
		String currentURL = driver.getCurrentUrl();
		System.out.println("My current page is: "+currentURL);
	}
	
	@Test
	public void Test6()//Get Domain Name Using JavascriptExecutor
	{
		String currentURL = driver.getCurrentUrl();
		System.out.println("My current page is:"+currentURL);
		
		//Get and store domain name in variable
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		String DomainUsingJS = (String)javascript.executeScript("return document.domain");
		System.out.println("My current domain using JS is:"+DomainUsingJS);
	}
	
	@Test
	public void Test7()//Generating Alert In Selenium Webdriver using JavascriptExecutor
	throws InterruptedException
	{
		//Generating Alert Using Javascript Executor
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("Alert('Test case starts now...');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void Test8()//Select Option By Value or By Index In Selenium WebDriver
	throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My First Name");
		
		//Selecting value from dropdown by value
		Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
		listbox.selectByValue("Italy");
		listbox.selectByValue("Mexico");
		listbox.selectByValue("Spain");
		
		driver.findElement(By.xpath("//input[@value='->']")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='lname']")));
		
		//Selecting value from dropdown by index
		listbox.selectByIndex(0);
		listbox.selectByIndex(3);
		driver.findElement(By.xpath("//input[@value='->']")).click();
		Thread.sleep(5000);
	}

}