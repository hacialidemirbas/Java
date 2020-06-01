package main.JunitClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstJUnitJSE {
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

@org.junit.jupiter.api.Test
    public void clicking() throws InterruptedException {
        Thread.sleep(5000);
        WebElement checking= fireFoxDriver.findElement(By.xpath("//a[@aria-controls='navCheckingContent']"));
        jse.executeScript("arguments[0].click();",checking);
        System.out.println("@Aftereach-executed once before all test methods in this class");
    }
   @org.junit.jupiter.api.Test
    public void sendingKey() throws InterruptedException {
       WebElement onlineID=fireFoxDriver.findElement(By.xpath("//input[@aria-labelledby='labelForonlineId1']"));
       jse.executeScript("arguments[0].value='tester1'",onlineID);
       Thread.sleep(10000);
       jse.executeScript("arguments[0].value=arguments[1]",onlineID," tester2");
    System.out.println("@Test1-executed test");
    }
   @org.junit.jupiter.api.Test
    public  void scrollBy() throws InterruptedException {
        Thread.sleep(10000);
        jse.executeScript("window.scrollBy(0,1800");//scroll down
        Thread.sleep(5000);
        jse.executeScript("window.scrollBy(0,-1000");//scroll up
        Thread.sleep(5000);
        System.out.println("@scrollBy-scroll down and up executed");
    }

    @Test
    public void scrollView()throws InterruptedException{
      Thread.sleep(20000);
      WebElement agree=(WebElement) jse.executeScript("return document.getElementById(arguments[0])","footer_bofa_online_banking_service_agreement");
      jse.executeScript("arguments[0].scrollIntoView(true)",agree);
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

