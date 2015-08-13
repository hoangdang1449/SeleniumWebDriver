package junitpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Navigation

{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void BeforeTest() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		driver.wait(5000);
	}
	
}