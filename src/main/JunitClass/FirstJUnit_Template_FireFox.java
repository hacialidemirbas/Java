package main.JunitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstJUnit_Template_FireFox {
    static WebDriver fireFoxDriver;
    static String baseUrl;
    static JavascriptExecutor jse;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        fireFoxDriver= new FirefoxDriver();
        fireFoxDriver.manage().window().maximize();
        baseUrl="https:\\www.bankofamerica.com";
        jse=(JavascriptExecutor) fireFoxDriver;
        jse.executeScript("window.location=arguments[0]",baseUrl);

        System.out.println("@BeforeAll-executed once before all test methods in this class");
            }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        fireFoxDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }


    @Test
    public void windowSize()throws InterruptedException{
        Thread.sleep(20000);
        long height = (Long) jse.executeScript("return window.innerHeight");
        long width = (Long) jse.executeScript("return window.innerWidth");
        System.out.println("Window dimensions are: "+ height+" x "+width);
        jse.executeScript("window.scrollBy(0,arguments[0])",height-150);
    }
}

