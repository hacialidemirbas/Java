package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

public class FirstChrome {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        WebDriver chromeDriver= new ChromeDriver();
        WebDriver fireFox= new FirefoxDriver();
        //chromeDriver.get("https://amazon.com");
        chromeDriver.get("https://westernunion.com");
        fireFox.get("https://samanyoluhaber.com");
        System.out.println("driver location is of firefox : "+System.getProperty("webdriver.gecko.driver"));
        System.out.println("driver location is of chrome : "+System.getProperty("webdriver.chrome.driver"));
    }
}
