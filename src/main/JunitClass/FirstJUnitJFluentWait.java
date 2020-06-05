package main.JunitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstJUnitJFluentWait {
    static WebDriver fireFoxDriver;
    static String baseUrl;
    static JavascriptExecutor jse;
    @BeforeAll
    public static void setUP(){
        baseUrl="https:\\www.bankofamerica.com";
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        fireFoxDriver= new FirefoxDriver();
        fireFoxDriver.manage().window().maximize();
        fireFoxDriver.get(baseUrl);
       // fireFoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
            }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        fireFoxDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }

@Test
    public void clicking() throws InterruptedException {
   // WebDriverWait wait = new WebDriverWait(fireFoxDriver,5);
    FluentWait<WebDriver> wait= new FluentWait<>(fireFoxDriver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

        //WebElement academy= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'khanacademy')]")));
    WebElement academy= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'khanacademy')]")));
    wait.until(ExpectedConditions.attributeContains(By.xpath("//a[contains(@href,'khanacademy')]"),"id","EFF3SX93"));
        academy.click();
        System.out.println("@Aftereach-executed once before all test methods in this class");
    }
   @Test
    public void sendingKey() throws InterruptedException {

    System.out.println("@Test1-executed test");
    }
   @Test
    public  void scrollBy() throws InterruptedException {

        System.out.println("@scrollBy-scroll down and up executed");
    }

}

