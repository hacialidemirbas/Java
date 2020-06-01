package main.java;
//CLASS LOCATER
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocater_Class_Append {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        WebDriver chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.bankofamerica.com");
        //idvalue
        chromeDriver.findElement(By.cssSelector("span.spa-btn.spa-btn--primary.spa-btn--medium.masthead-cta-btn")).click();




    }
}
