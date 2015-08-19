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

public class VerifyElementPresent
{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void preCondition()
	{
		driver.manage().window().maximize();
		driver.navigate().to("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@After
	public void postCondition()
	{
		driver.quit();
	}
	
	@Test
	public void Test() throws InterruptedException
	{
		for (int i = 1; i<6; i++)
		{
			//To verify element is presented on page or not.
			String XPath = "//input[@id='text"+i+"']";
			boolean iselementpresent = driver.findElements(By.xpath(XPath)).size()!=0;
			if (iselementpresent == true)
			{
				System.out.println("\nTargeted Textbox "+i+" is present on the page");
			}
			else
			{
				System.out.println("\nTargeted Textbox "+i+" is not present on the page");
			}
			
		}
	}
}