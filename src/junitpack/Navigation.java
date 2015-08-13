package junitpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Navigation

{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void BeforeTest()
	{
		driver.manage().window().maximize();
		driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}	
	
	@Test
	public void Test() throws InterruptedException
	{
		//To navigate back (Sane as ckicking on browser back button)
		driver.navigate().back();
		
		//To navigate forward (Same as clicking on browser forward button)
		driver.navigate().forward();
	}	
	
	@After
	
	public void AfterTest()
	{
		driver.quit();
	}
}