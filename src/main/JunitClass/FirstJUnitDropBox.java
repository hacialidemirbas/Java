package main.JunitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitDropBox {

    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUP() {
       baseUrl = "https://www.dropbox.com/basic";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() {
        //driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @BeforeEach
    public void init() {

        System.out.println("@BeforeEach - refreshed the page");
    }

    @AfterEach
    public void done() {
        //  driver.navigate().refresh();
        System.out.println("@AfterEach - refreshed the page");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.dropbox.com/login']")).click();
        System.out.println("@Test1 - click sign in");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div/input[@name='login_email']")).sendKeys("hacialidemirbas@ymail.com");
        System.out.println("E-mail entered");
        driver.findElement(By.xpath("//div/input[@name='login_password']")).sendKeys("Nilfilsa@3710");
        System.out.println("Password entered");
        driver.findElement(By.xpath("//div/button[@type='submit']")).click();

    }

   /* @Test
    public void test2() throws InterruptedException {

    }*/
}
