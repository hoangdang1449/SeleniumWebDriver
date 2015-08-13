package junitpack;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class junittest3{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void beforetest(){
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	}
	
	@After
	public void aftertest(){
		driver.quit();
	}
	
	@Test
	public void test(){
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Bike']")).click();
		boolean str1 = driver.findElement(By.xpath("//input[@value='Bike']")).isSelected();
		if(str1 = true){
			System.out.println("Checkbox is Checked");
		}
		else{
			System.out.println("Checkbox is not Checked");
		}
	}
}
