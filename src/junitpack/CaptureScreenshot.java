package junitpack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureScreenshot

{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void BeforeTest()
	
	{
		driver.manage().window().maximize();
		driver.get("http:\\google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@After
	public void AfterTest()
	
	{
		driver.quit();
	}

	@Test
	public void Test() throws InterruptedException,IOException
	
	{
		//Capture entire page screenshot and then store it in a destination drive
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\seleniumScreenshot.jpg"));
		System.out.print("Screenshot is captured and stored in your D: Drive");
	}
	
}



