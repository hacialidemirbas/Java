package main.JunitClass;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitSelAmazon {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        baseUrl="https://amazon.com";
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
    public void test() throws InterruptedException{
       /* chromeDriver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        System.out.println("Clicked on sign in link");*/
        chromeDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        System.out.println("Click login link");
        Thread.sleep(5000);
        chromeDriver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("hacialidemirbas@gmail.com");
        System.out.println("Type email");
        chromeDriver.findElement(By.xpath("//span[@id=\"continue\"]")).click();
        Thread.sleep(5000);
        chromeDriver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Nilfilsa@3710");
        System.out.println("Enter password");
        chromeDriver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
    }
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
