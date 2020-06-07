package main.TestNG;

import main.utils.RandomString;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TNG_Parameters {
    static WebDriver driver;
    static String baseUrl;
    static Actions action;
    @Parameters({"browser","platform"})
    @BeforeClass//Similar to BeforeAll in JUnit
    public void setUP(String browser, String platform){
        System.out.println("Browser name is "+ browser+"  Platform name is "+platform);
        baseUrl="https://jqueryui.com/";
        setBrowser(browser);
        action= new Actions(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");System.out.println("@BeforeClass method ");
    }
    private void setBrowser(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }
    }
    @AfterClass//Similar to AfterAll in JUnit
    public void tearDown() throws IOException {
        RandomString randomString= new RandomString();
        String flName=System.getProperty("user.dir")+"\\scr\\snippets\\"+randomString.genRandom(5)+".png";
        File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File(flName));
        driver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
        System.out.println("@AfterClass method ");
    }
        @Test
    public void test1 () throws InterruptedException {
        driver.navigate().to("https://jquery.com");
        Thread.sleep(5000);
        WebElement hoverSupport= driver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forums= driver.findElement(By.xpath("//a[text()='Forums']"));
        action.moveToElement(hoverSupport).perform();
        Thread.sleep(5000);
        action.moveToElement(forums).click().perform();
        Thread.sleep(5000);
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals("https://forum.jquery.com/",currentUrl,"url mismatch, Actual urls is: "+currentUrl);
        System.out.println("@Test1 - Current url is : "+currentUrl);

        System.out.println("@Test1 - test executed");
        System.out.println("@Test1 method");
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2 () throws InterruptedException {
       WebElement getStarted= driver.findElement(By.xpath("//a[@title='Getting Started']"));
       getStarted.click();
    }
    @Test(dependsOnMethods = {"test2"})
    public void test3 (){
        WebElement signUp= driver.findElement(By.xpath("//li[@id='ProblemsFilterMenuList']"));
        signUp.click();

        System.out.println("@Test3 method");
    }
    @Test(dependsOnMethods = {"test3"}, timeOut = 1000)
    public void test4 () throws InterruptedException {
        Thread.sleep(2000);
        WebElement signUp= driver.findElement(By.xpath("//li[@id='ProblemsFilterMenuList']"));
        signUp.click();

        System.out.println("@Test3 method");
    }
}
