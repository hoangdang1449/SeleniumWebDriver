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

public class SelectDropdownValue

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
	public void Test1() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='fname']"));
		
		//selecting value from drop down using visible text
		Select mydrpdwn = new Select(driver.findElement(By.id("Carlist")));
		mydrpdwn.selectByVisibleText("Audi");
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));
	}
}

