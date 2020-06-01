package main.java;
//CLASS LOCATER
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Or_Keyword {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        WebDriver chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.bankofamerica.com");
        //idvalue
        chromeDriver.findElement(By.xpath("//span[text()='Get started'"+
                "or text()='Open account'"+
                "or text()='Click to get started' "+
                "or text()='Click to see options'"+
                "or text()='Learn more'"+
                "or text()='Learn more'"+
                "or text()='See options']")).click();




    }
}
