package main.JunitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.List;
import java.util.Set;

public class FirstJUnitHandle {
    static WebDriver fireFoxDriver;
    static String baseUrl;
    static JavascriptExecutor jse;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        fireFoxDriver= new FirefoxDriver();
        fireFoxDriver.manage().window().maximize();
        baseUrl="https://learn.letskodeit.com/p/practice";
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
        Thread.sleep(5000);
        List<WebElement> findCourse=fireFoxDriver.findElements(By.xpath("//input[@placeholder='Find a course']"));
        String parentHandle=fireFoxDriver.getWindowHandle();
        System.out.println("@Test1 - Current Window Handle before clicking: "+parentHandle);
        fireFoxDriver.findElement(By.id("openwindow")).click();
        Thread.sleep(5000);

        Set<String> handles= fireFoxDriver.getWindowHandles();
        System.out.println("Number of windows: "+handles.size());
        for( String handle : handles){
            if(handle.equals(parentHandle)){
                System.out.println("handle is parent Handle "+handle);
            }
            else{
                System.out.println("handle is child Handle "+handle);
                fireFoxDriver.switchTo().window(handle);

                if(findCourse.size()==1){
                    findCourse.get(0).sendKeys("my proper course");
                    System.out.println("Found the correct child window and entered given value in webelement inside it");
                    break;
                }
                else{
                    System.out.println("Not the child window we are looking for");

                }
            }

        }
    Thread.sleep(5000);
        fireFoxDriver.switchTo().window(parentHandle);
    fireFoxDriver.findElement(By.id("bmwradio")).click();}


}

