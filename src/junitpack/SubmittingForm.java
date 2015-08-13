package junitpack;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class SubmittingForm{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void BeforeTest() throws Exception
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
	}
	
	@After
	public void AfterTest() throws Exception
	{
		driver.quit();
	}
	
	@Test
	public void TestLogin()
	{
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("MyFName");
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("MyLName");
		driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys("MyEmailID");
		driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys("My Mob No.");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("My Comp Name");
		//To submit form.
		//You can use any other Input field's(First Name, Last Name etc.) xpath too In bellow given syntax.
		driver.findElement(By.xpath("//input[@name='Company']")).submit();
		String alrt = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alrt);
	}
}
