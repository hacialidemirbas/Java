package main.java;
//CLASS LOCATER
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocater {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        WebDriver chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://discover.com");
        chromeDriver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div[4]/div[2]/div/a/span")).click();


    }
}
