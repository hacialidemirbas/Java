package main.JunitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FirstJUnitAlert {
    static WebDriver fireFoxDriver;
    static String baseUrl;

    @BeforeAll
    public static void setUP(){
        baseUrl="https://letskodeit.teachable.com/p/practice";
        System.setProperty("webdriver.gecko.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\geckodriver.exe");
        fireFoxDriver= new FirefoxDriver();
        fireFoxDriver.manage().window().maximize();
        fireFoxDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
            }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        //Thread.sleep(10000);
        fireFoxDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }

    @Test
    public void test1()throws InterruptedException{
        Alert alert;//create Alert class object
        Thread.sleep(5000);
        WebElement alertBtn =fireFoxDriver.findElement(By.id("alertbtn"));
        WebElement confirmBtn =fireFoxDriver.findElement(By.id("confirmbtn"));
        WebElement nameEle =fireFoxDriver.findElement(By.id("name"));
        nameEle.sendKeys("NABOOT");
        alertBtn.click();
        Thread.sleep(5000);
        alert=fireFoxDriver.switchTo().alert();// switches to a javascript alert that opens at browser level
        System.out.println("alert text is : "+alert.getText());// alert box text retrieved
        alert.accept();
        Thread.sleep(5000);
        nameEle.sendKeys("NABOOT");
        confirmBtn.click();
        Thread.sleep(5000);

        alert=fireFoxDriver.switchTo().alert();// switches to a javascript alert that opens at browser level
        System.out.println("alert text is : "+alert.getText());// alert box text retrieved for confirm popup
        alert.dismiss();
        Thread.sleep(5000);

    }


}

