package main.JunitClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstJUnitSelectDrop {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        baseUrl="https://learn.letskodeit.com/p/practice";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-initiated and navigated web page");
            }
    @AfterAll
    public static void tearDown(){
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }

    @Test
    public void dropSelectEach() throws InterruptedException {
        System.out.println("@Test 1 - is executed");
        WebElement dropDownElement= chromeDriver.findElement(By.id("carselect"));
        Select sel=new Select(dropDownElement);
        sel.selectByValue("honda");
        Thread.sleep(5000);
        sel.selectByVisibleText("Benz");
        Thread.sleep(5000);
        sel.selectByIndex(0);
        Thread.sleep(5000);
    }
    @Test
    public  void dropSelectAll() throws InterruptedException {
        System.out.println("@Test 2 - is executed");
        WebElement dropDownElement= chromeDriver.findElement(By.id("carselect"));
        Select sel=new Select(dropDownElement);
        List<WebElement> options= sel.getOptions();
        for (WebElement element:options){
            System.out.println("Option is : "+ element.getText());
sel.selectByVisibleText(element.getText());
            Thread.sleep(5000);
        }

    }

}

