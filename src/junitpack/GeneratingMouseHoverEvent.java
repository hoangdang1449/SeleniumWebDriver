package junitpack;

import java.io.IOException;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneratingMouseHoverEvent
{
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void BeforeTest()
	{
		driver.manage().window().maximize();
		driver.navigate().to("http:\\only-testing-blog.blogspot.in/p/mouse-hover.html");
	}
	
	@After
	public void AfterTest()
	{
		driver.quit();
	}
	
	@Test
	public void Test() throws InterruptedException, IOException
	{
		//Generate mouse hover event on main menu to click on the sub menu
		Actions varActions = new Actions(driver);
		WebElement varMoveOnMenu = driver.findElement(By.xpath("//div[@id='menu1']/div"));
		varActions.moveToElement(varMoveOnMenu).moveToElement(driver.findElement(By.xpath("//div[@id='menu1choices']/a"))).click().perform();
		
		WebDriverWait varWait = new WebDriverWait(driver,15);
		varWait.until(ExpectedConditions.titleContains("Google"));
	}
}