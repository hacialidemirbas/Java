package main.java;
//CLASS LOCATER
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WildCard {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        WebDriver chromeDriver= new ChromeDriver();
        WebDriver fireFoxDriver= new FirefoxDriver();
        chromeDriver.manage().window().maximize();
        fireFoxDriver.manage().window().maximize();
        chromeDriver.get("https://www.bankofamerica.com");
        //idvalue
        chromeDriver.findElement(By.cssSelector("a[aria-controls$='ckingContent']")).click();
        fireFoxDriver.get("https://www.bankofamerica.com");
        fireFoxDriver.findElement(By.cssSelector("a[aria-controls*='Checking']")).click();




    }
}
