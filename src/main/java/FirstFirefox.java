package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstFirefox {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        WebDriver fireFox= new FirefoxDriver();
        //chromeDriver.get("https://amazon.com");
        fireFox.get("https://samanyoluhaber.com");
        System.out.println("driver location is of firefox : "+System.getProperty("webdriver.gecko.driver"));
    }
}
