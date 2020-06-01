package main.JunitClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnit_Template_Chrome {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://learn.letskodeit.com/p/practice");
        System.out.println("@BeforeAll-executed once before all test methods in this class");
            }
    @AfterAll
    public static void tearDown(){
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }
    @AfterEach
    public void done(){
        System.out.println("@AfterEach-executed once before all test methods in this class");
    }
    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach-executed once before all test methods in this class");
    }
    @Test
    public void test(){

        System.out.println("@Aftereach-executed once before all test methods in this class");
    }
    @Test
    public void test1(){
        System.out.println("@Aftereach-executed once before all test methods in this class");
    }
    @Test
    public  void test2(){
        System.out.println("@Aftereach-executed once before all test methods in this class");
    }

}

