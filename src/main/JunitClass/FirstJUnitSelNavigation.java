package main.JunitClass;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitSelNavigation {
    boolean benzSelected;
    boolean bmwSelected;
    boolean hondaSelected;
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        baseUrl="https://letskodeit.teachable.com";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test mthods in this class");
            }
   /* @AfterAll
    public static void tearDown(){
        chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test mthods in this class");
    }*/
   /* @AfterEach
    public void done(){
        chromeDriver.navigate().refresh();
        System.out.println("@AfterEach-executed once before all test mthods in this class");
    }
    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach-executed once before all test mthods in this class");
    }*/
    @Test
    public void browserNavigation() throws InterruptedException{
       /* chromeDriver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        System.out.println("Clicked on sign in link");*/
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
   /* @Test
    public void checkBoxyTest() throws InterruptedException{
        WebElement bmwCheck= chromeDriver.findElement(By.id("bmwcheck"));
        WebElement benzCheck= chromeDriver.findElement(By.id("benzcheck"));
        WebElement hondaCheck= chromeDriver.findElement(By.id("hondacheck"));
        bmwCheck.click();
        Thread.sleep(5000);
        benzCheck.click();
        Thread.sleep(5000);
        hondaCheck.click();
        Thread.sleep(5000);
    }*/
   /* @Test
    public void test1() throws InterruptedException{
        Thread.sleep(5000);
        WebElement email =chromeDriver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }*/
    @Test
    public  void test2(){
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }

}
