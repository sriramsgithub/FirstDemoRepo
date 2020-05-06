package Seleniumtest2;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlink 
{
    public static void verifyLink(String urlLink) 
    {
       
        try {
 
            URL link = new URL(urlLink);
            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();
            System.out.println("Message" +httpConn.getResponseCode());
            int message = httpConn.getResponseCode();
            String str = Integer.toString(message);
            if(str.contains("2")) 
            { 
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            if(str.contains("3")) 
            {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            if(str.contains("4")) 
            {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            if(str.contains("5")) 
            {
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

 

    } 
    public static void main(String[] args) throws InterruptedException 
    {
        
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("https://demosite.com/");
         Thread.sleep(3000);
         
         List<WebElement> links = driver.findElements(By.tagName("a")); 
         System.out.println("Total links are "+links.size()); 
         for(int i=0; i<links.size(); i++) 
         {
         WebElement element = links.get(i);
         String url=element.getAttribute("href");
         verifyLink(url); 
         }
         driver.quit();
    }
}