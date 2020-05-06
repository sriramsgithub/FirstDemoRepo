package Implicitexplicit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implicitexplicit
{

	 public static void main(String[] args)throws Exception
	 {
	 
	  WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("https://opensource-demo.orangehrmlive.com/");
     driver.findElement(By.id("txtUsername")).sendKeys("Admin");
     driver.findElement(By.id("txtpassword")).sendKeys("admin123");
     driver.findElement(By.id("btnlogin")).click();
     driver.findElement(By.id("Welcome")).click();
     Thread.sleep(3000);
     
     driver.findElement(By.xpath("//a[text()='Logout')")).click();
     driver.close();
	 }
     
    }
