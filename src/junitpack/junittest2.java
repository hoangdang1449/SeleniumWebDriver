package junitpack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class junittest2{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setup(){
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	}
	
	@After
	public void aftertest(){
		driver.quit();
	}
	
	@Test
	public void test1() throws InterruptedException{
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test1");
		System.out.println("\njunittest2 class-test1 method is executed");
		Thread.sleep(5000);
	}
	
	@Test
	public void test2() throws InterruptedException{
		driver.findElement(By.xpath("//input{@name='fname']")).sendKeys("junittest2 class-test2");
		Thread.sleep(5000);
		System.out.println("\njunittest2 class-test2 method is executed");
		
	}
}


