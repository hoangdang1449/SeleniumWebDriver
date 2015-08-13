package junitpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeselectAllListbox
{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void beforetest()
	{
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	}
	
	@After
	public void aftertest()
	{
		driver.quit();
	}
	
	@Test
	public void Test1()
	{
		Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
		boolean value = listbox.isMultiple();
		System.out.println(value);		
	}
	
	@Test
	public void Test2() throws InterruptedException
	{
		Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
		 
		//To verify that specific select is listbox supports multiple select or not.
		if(listbox.isMultiple())
		{
			System.out.println("This listbox support multiple select");
			listbox.selectByVisibleText("USA");
			listbox.selectByValue("Russia");
			listbox.selectByIndex(5);
			Thread.sleep(5000);
			
			//To deselect all selected options.
			listbox.deselectAll();
			Thread.sleep(5000);
		}
		
		else
		{
			System.out.println("Not support multiple selection");
		}
	}
	
}