package main.JunitClass;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FirstJUnit_Deneme {
    static WebDriver chromeDriver;
    static String baseUrl;
    WebElement mail;


    @BeforeTest
    public static void setUP(){
        baseUrl="https://www.gmail.com";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }
    @Test
    public void gMail() throws InterruptedException, IOException {
        Thread.sleep(5000);
       mail= chromeDriver.findElement(By.xpath("//div[text()='Ali Demirbas']"));
       mail.click();
        Thread.sleep(5000);
       mail=chromeDriver.findElement(By.xpath("//Span[text()='Next']"));
       mail.click();
        File scrFile = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
        //Write Screenshot to a file
        String currentDir = System.getProperty("user.dir");
        File getSreenShotMethodImageFile = new File (currentDir +
                "\\ScreenShots\\GetScreenShotMethod\\amazonscreenshot.png");
        FileUtils.copyFile(scrFile, getSreenShotMethodImageFile);


    }
}