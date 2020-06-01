package main.JunitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitSel {
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
    @AfterAll
    public static void tearDown(){
        chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test mthods in this class");
    }
    @AfterEach
    public void done(){
        chromeDriver.navigate().refresh();
        System.out.println("@AfterEach-executed once before all test mthods in this class");
    }
    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach-executed once before all test mthods in this class");
    }
    @Test
    public void test(){
        chromeDriver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }
    @Test
    public void test1(){
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }
    @Test
    public  void test2(){
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }

}
