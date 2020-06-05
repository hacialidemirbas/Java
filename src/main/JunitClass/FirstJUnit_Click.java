package main.JunitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstJUnit_Click {
    static WebDriver fireFoxDriver;
    static String baseUrl;

    @BeforeAll
    public static void setUP(){
        baseUrl="https://letskodeit.teachable.com/p/practice";
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        fireFoxDriver= new FirefoxDriver();
        fireFoxDriver.manage().window().maximize();
        fireFoxDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        //Thread.sleep(10000);
        fireFoxDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }
    @BeforeEach
    public void init() {
        fireFoxDriver.navigate().refresh();
        System.out.println("@BeforeEach - refreshed the page");
    }
    @AfterEach
    public void done() {
        fireFoxDriver.navigate().refresh();
        System.out.println("@AfterEach - refreshed the page");
    }
    @Test
    public void test1() {
        fireFoxDriver.findElement(By.cssSelector("a.navbar-brand.header-logo")).click();
        System.out.println("@Test1 - clicking directly");
    }
    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement logo= fireFoxDriver.findElement(By.cssSelector("a.navbar-brand.header-logo"));
        logo.click();
        System.out.println("@Test2 - clicking on WebElement logo");
    }
}