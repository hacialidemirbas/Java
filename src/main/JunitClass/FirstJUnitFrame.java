package main.JunitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class FirstJUnitFrame {
    static WebDriver fireFoxDriver;
    static String baseUrl;
    static JavascriptExecutor jse;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        fireFoxDriver= new FirefoxDriver();
        fireFoxDriver.manage().window().maximize();
        baseUrl="https://letskodeit.teachable.com/p/practice";
        jse=(JavascriptExecutor) fireFoxDriver;
        jse.executeScript("window.location=arguments[0]",baseUrl);

        System.out.println("@BeforeAll-executed once before all test methods in this class");
            }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        fireFoxDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }


    @Test
    public void test1()throws InterruptedException{
        Thread.sleep(10000);
WebElement iframe=fireFoxDriver.findElement(By.xpath("//*[contains(@src,'courses')]"));
        //fireFoxDriver.switchTo().frame("courses-iframe");
        fireFoxDriver.switchTo().frame(iframe);
        List<WebElement> findCourse=fireFoxDriver.findElements(By.xpath("//input[@placeholder='Find a course']"));
        if(findCourse.size()>0){
            findCourse.get(0).sendKeys("my proper course");
            System.out.println("Found the element on the page");
            Thread.sleep(5000);
                    }
        else {
            System.out.println("Did not find the element on the page");

        }}


}

