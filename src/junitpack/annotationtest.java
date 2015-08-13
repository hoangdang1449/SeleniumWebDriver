package junitpack;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public  class annotationtest {

private static WebDriver driver;

@BeforeClass
public static void beforetest(){
	driver = new FirefoxDriver();
	System.out.println("Browser Opened");
	driver.manage().window().maximize();
	driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
}

@AfterClass
public static void aftertest(){
	driver.quit();
	System.out.println("Close Driver");
}

@Test
public void test1(){
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@value='Bike']")).click();
	boolean str1 = driver.findElement(By.xpath("//input[@value='Bike']")).isSelected();
	if (str1 = true){
		System.out.println("Checkbox is checked");
	}
	
	else
	{
		System.out.println("Checbox is not checked");
	}	
}

@Ignore
@Test
public void test2()throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("annotationtest-test2");
	Thread.sleep(5000);
	System.out.println("annotationtest-test2 is executed");	
}
}
