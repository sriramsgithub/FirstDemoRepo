package StepDef;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition
{
    static WebDriver driver;
    public void screenshot(String s1)
    {
    	TakesScreenshot screen = ((TakesScreenshot)driver);
    	File file = screen.getScreenshotAs(OutputType.FILE);
    	File path = new File("C:\\Users\\sriramsn\\Desktop\\Screen\\"+s1+".jpg");
    	try {
			FileUtils.copyFile(file,path);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	@Given("^I have url$")
	public void url()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		screenshot("Launch");
}

@When("^I entered the username and password$")
public void i_entered_the_username_and_password() 
{
   driver.findElement(By.id("txtUsername")).sendKeys("Admin");
   driver.findElement(By.id("txtPassword")).sendKeys("admin123");
   screenshot("Loginpage");
   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
   driver.findElement(By.id("btnLogin")).click();
   
}

@Then("^I successfully logged in to the application$")
public void i_successfully_logged_in_to_the_application() throws Throwable
{
	String s1=driver.findElement(By.id("welcome")).getText();
	System.out.println(s1);
	String s2 = "Welcome Admin";
	Assert.assertEquals(s2,s1);
	screenshot("Home Page");
	driver.findElement(By.id("welcome")).click();
	 Thread.sleep(3000); 
		driver.findElement(By.linkText("Logout")).click(); 
	driver.close();
	
}
	
	
}
