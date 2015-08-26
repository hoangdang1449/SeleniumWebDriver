package junitpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingAlert
{
	WebDriver driver;

@BeforeTest
public void setup() throws Exception
{
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
}

@AfterTest
public void clearup() throws Exception
{
	driver.quit();
}

@Test
public void test() throws InterruptedException
{
	//Alert popup Handling.
	driver.findElement(By.xpath("input[@value='Show Me Alert']")).click();
	//To locate alert
	Alert A1 = driver.switchTo().alert();
	//To read the text from alert popup.
	String Alert1 = A1.getText();
	System.out.println(Alert1);
	Thread.sleep(2000);
	//To accept/Click OK on the alert popup
	A1.accept();
	
	//Confirmation Pop up handling.
	driver.findElement(By.xpath("//button[@onlick='myFunction()']")).click();
	Alert A2 = driver.switchTo().alert();
	String Alert2 = A2.getText();
	System.out.println(Alert2);
	Thread.sleep(2000);
	//To Click on cancel button of confirmation box.
	A2.dismiss();
	
	//Prompt pop up handling.
	driver.findElement(By.xpath("//button[contains(.,'Show Me Prompt')]")).click();
	Alert A3 = driver.switchTo().alert();
	String Alert3 = A3.getText();
	System.out.println(Alert3);
	//To type text Im text box of prompt pop up.
	A3.sendKeys("This is John");
	Thread.sleep(2000);
	A3.accept();
}

}

