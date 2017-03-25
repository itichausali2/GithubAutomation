import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GitTest {
	WebDriver driver;
	@BeforeTest
	public void launchBtrowser() {
		System.setProperty("webdriver.gecko.driver", "D://GithubAutomation//Drivers//chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://github.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void signin() {
		WebElement signup = driver.findElement(By.linkText("Sign in"));
		signup.click();
		Boolean text = driver.findElement(By.xpath(".//input [@value= 'Sign in']")).isDisplayed();
		
	Assert.assertTrue(text);
	}
	@Test(priority=2)
	public void login() {
		
		WebElement username  =  driver.findElement(By.id("login_field"));
		username.sendKeys("itichausali2");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("papa@123456");
		driver.findElement(By.xpath(".//input [@value= 'Sign in']")).click();
		boolean button = driver.findElement(By.linkText("Read the guide")).isDisplayed();
		Assert.assertTrue(button);
	}
	@Test(priority=3) 
		
	public void repositoryselection() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("Window.scrollBy, (0,500)","");
	
		WebElement repositoty = driver.findElement(By.xpath(".//a//span[text()='GithubAutomation']"));
		repositoty.click();
		WebElement element = driver.findElement(By.xpath(".//button[contains(@title, 'Clone or download this repository')]"));
		element.click();
		driver.findElement(By.linkText("Open in Desktop")).click();
		//Assert.assertTrue(show);
	}
	@Test(priority=4)
	public void clonedownload() {
	
	WebElement button= driver.findElement(By.xpath(".//button[contains(@title, 'Clone or download this repository')])"));
	button.click();
	
}
}
