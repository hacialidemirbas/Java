package main.JunitClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitSelNavigationGet {
    static WebDriver chromeDriver;
    static String baseUrl;
    static String currentUrl;
    static String pageTitle;
    @BeforeAll
    public static void setUP(){
        baseUrl="https://letskodeit.teachable.com";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test mthods in this class");
        pageTitle=chromeDriver.getTitle();
        System.out.println("Get page title : "+pageTitle);

            }
   /* @AfterAll
    public static void tearDown(){
        chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test mthods in this class");
    }*/
   @AfterEach
    public void done(){
        chromeDriver.navigate().refresh();
        System.out.println("@AfterEach-executed once before all test mthods in this class");
       currentUrl= chromeDriver.getCurrentUrl();
       System.out.println("@AfterEach - get current Url "+currentUrl);
    }
    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach-executed once before all test mthods in this class");
    }
    @Test
    public void browserNavigation() throws InterruptedException{

        chromeDriver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/ul/li[1]/a")).click();
        System.out.println("Click practice button");
        Thread.sleep(5000);
        chromeDriver.navigate().back();
        System.out.println("go to back page");
        Thread.sleep(5000);
        chromeDriver.navigate().forward();
        System.out.println("go to practice again");
        Thread.sleep(5000);
    }
    @Test
    public void browserNavigationGet() throws InterruptedException{
       chromeDriver.getCurrentUrl();
        chromeDriver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/ul/li[1]/a")).click();
        System.out.println("Click practice button");
        Thread.sleep(5000);
        chromeDriver.navigate().back();
        System.out.println("go to back page");
        Thread.sleep(5000);
        chromeDriver.navigate().forward();
        System.out.println("go forward to practice again");
        Thread.sleep(5000);
    }


}
