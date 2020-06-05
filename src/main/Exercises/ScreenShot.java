package main.Exercises;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ScreenShot {
    static WebDriver chromeDriver;
    static String baseUrl;
    static String randomString;

    @BeforeAll
    public static void setUP(){
        baseUrl = "http://www.expedia.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @Test
    public void test() throws Exception {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        randomString = random.ints(leftLimit, rightLimit + 1)
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    @AfterAll
    public static void tearDown() throws IOException {
        String fileNm = System.getProperty("user.dir") + "/src/snippets/" + randomString + ".png";
        File srcFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
        chromeDriver.quit();
        System.out.println("Closed browser session");
    }
}