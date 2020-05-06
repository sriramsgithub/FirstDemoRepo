package Exceptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptionshandling {


    static WebDriver driver;
    public static void screenshot(String s)
    {
        //IO Exception
        try {
        TakesScreenshot screen =((TakesScreenshot)driver);
        File SrcFile=screen.getScreenshotAs(OutputType.FILE);
        File despath = new File("");
        FileUtils.copyFile(SrcFile, despath);
        } catch (IOException e) 
        {
            System.out.println("Path not found I/O exception");
        }    
    }
    public static void main(String[] args) throws Exception
    {
          
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("https://opensource-demo.orangehrmlive.com/");
         driver.findElement(By.id("txtUsername")).sendKeys("Admin");
         driver.findElement(By.id("txtPassword")).sendKeys("admin123");
         //No Such Element Exception
         try 
         {
            driver.findElement(By.id("12345678")).click();
        } 
         catch (Exception e) 
        {
            System.out.println("No Such Element Exception");
            
        }
         //No Alert Present Exception
         try 
         {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } 
         catch (Exception e) 
        {
            System.out.println("No Alert Present Exception");
            
        }
         //No Such Frame Exception
         try {
            driver.switchTo().frame("a077aa5e");
        } catch (Exception e) {
            
            System.out.println("No Such Frame Exception");
        }
         screenshot("welcome");
         driver.findElement(By.id("btnLogin")).click();
         
         driver.findElement(By.id("welcome")).click();
         
         driver.findElement(By.xpath("//a[text()='Logout']")).click();
         driver.close();
         
    }

 

}
