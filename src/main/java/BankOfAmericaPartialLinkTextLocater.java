package main.java;
//CLASS LOCATER
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankOfAmericaPartialLinkTextLocater {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        WebDriver chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.bankofamerica.com");
        chromeDriver.findElement(By.partialLinkText("Management")).click();


    }
}
