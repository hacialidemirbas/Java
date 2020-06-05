package main.Exercises;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Take_ScreenShot {
    static String baseUrl;
    static WebDriver fireFoxDriver;
      @BeforeAll
public static void beforeAll(){
          System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
          baseUrl="https://www.samanyoluhaber.com";
          fireFoxDriver= new FirefoxDriver();
          fireFoxDriver.get(baseUrl);
          fireFoxDriver.manage().window().maximize();
          System.out.println("@BeforeAll - Web page started");
      }
      @Test
      public void test(){
          System.out.println("Trying to take screenshoot");
      }
      @AfterAll
    public static void afterAll() throws InterruptedException, IOException {
          System.out.println("@AfterAll - Test completed and browser closed");
          Thread.sleep(10000);
          File file=((TakesScreenshot) fireFoxDriver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(file, new File("C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\src\\snippets\\samanyolu.jpg"));
          fireFoxDriver.quit();
      }



}