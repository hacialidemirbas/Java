package main.TestNG;

import main.utils.RandomString;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TNG_Dependency {
    static WebDriver chromeDriver;
    static String baseUrl;
    static Actions action;
    @BeforeClass//Similar to BeforeAll in JUnit
    public void setUP(){

        baseUrl="https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        action= new Actions(chromeDriver);
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");System.out.println("@BeforeClass method ");
    }
    @AfterClass//Similar to AfterAll in JUnit
    public void tearDown() throws IOException {
        RandomString randomString= new RandomString();
        String flName=System.getProperty("user.dir")+"\\scr\\snippets\\"+randomString.genRandom(5)+".png";
        File scrFile=((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File(flName));
        //chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
        System.out.println("@AfterClass method ");
    }
        @Test
    public void test1 () throws InterruptedException {
        chromeDriver.navigate().to("https://jquery.com");
        Thread.sleep(5000);
        WebElement hoverSupport=chromeDriver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forums= chromeDriver.findElement(By.xpath("//a[text()='Forums']"));
        action.moveToElement(hoverSupport).perform();
        Thread.sleep(5000);
        action.moveToElement(forums).click().perform();
        Thread.sleep(5000);
        String currentUrl=chromeDriver.getCurrentUrl();
        Assertions.assertEquals("https://forum.jquery.com/",currentUrl,"url mismatch, Actual urls is: "+currentUrl);
        System.out.println("@Test1 - Current url is : "+currentUrl);

        System.out.println("@Test1 - test executed");
        System.out.println("@Test1 method");
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2 () throws InterruptedException {
       WebElement getStarted=chromeDriver.findElement(By.xpath("//a[@title='Getting Started']"));
       getStarted.click();
    }
    @Test(dependsOnMethods = {"test2"})
    public void test3 (){
        WebElement signUp=chromeDriver.findElement(By.xpath("//li[@id='ProblemsFilterMenuList']"));
        signUp.click();

        System.out.println("@Test3 method");
    }
    @Test(dependsOnMethods = {"test3"}, timeOut = 1000)
    public void test4 () throws InterruptedException {
        Thread.sleep(2000);
        WebElement signUp=chromeDriver.findElement(By.xpath("//li[@id='ProblemsFilterMenuList']"));
        signUp.click();

        System.out.println("@Test3 method");
    }
}
