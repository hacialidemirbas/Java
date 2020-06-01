package main.JunitClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstJUnitSelectMulti {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://learn.letskodeit.com/p/practice");
        System.out.println("@BeforeAll-executed once before all test methods in this class");
            }
    @AfterAll
    public static void tearDown(){
        chromeDriver.quit();
        System.out.println("@AfterAll-executed and chromeDriver closed");
    }

    @Test
    public void multiaa_SelectEach() throws InterruptedException {
        WebElement multiEle= chromeDriver.findElement(By.name("multiple-select-example"));
        Select sel=new Select(multiEle);
        sel.selectByValue("apple");
        Thread.sleep(5000);
        sel.selectByVisibleText("Orange");
        Thread.sleep(5000);
        sel.selectByIndex(2);
        Thread.sleep(5000);
        List<WebElement> opts= sel.getOptions();

    }
    @Test
    public void multiab_DeSelectEach() throws InterruptedException {
        WebElement multiEle= chromeDriver.findElement(By.name("multiple-select-example"));
        Select sel=new Select(multiEle);
        sel.deselectByValue("apple");
        Thread.sleep(5000);
        sel.deselectByVisibleText("Orange");
        Thread.sleep(5000);
        sel.deselectByIndex(2);
        Thread.sleep(5000);
        List<WebElement> opts= sel.getOptions();
            }
    @Test
    public  void multiac_SelectAll() throws InterruptedException {
        WebElement multiEle= chromeDriver.findElement(By.name("multiple-select-example"));
        Select sel=new Select(multiEle);
        List<WebElement> opts= sel.getOptions();//returns a list of Webelements of all the option tags inside select
        for (WebElement element:opts){
            System.out.println("Option is : "+ element.getText());
            sel.selectByVisibleText(element.getText());
            Thread.sleep(5000);
        }
        List<WebElement> selOpts= sel.getAllSelectedOptions();
        for (WebElement element:selOpts){
            System.out.println("deselection Option is : "+ element.getText());
            sel.deselectByVisibleText(element.getText());
            Thread.sleep(5000);
        }}
    @Test
    public  void multiac_getSelected() throws InterruptedException {
        WebElement multiEle= chromeDriver.findElement(By.name("multiple-select-example"));
        Select sel=new Select(multiEle);
        List<WebElement> opts= sel.getOptions();//returns a list of Webelements of all the option tags inside select
        for (WebElement element:opts){
            System.out.println("Option is : "+ element.getText());
            sel.selectByVisibleText(element.getText());
            Thread.sleep(5000);
        }
        sel.deselectByIndex(1);
        List<WebElement>selOpts= sel.getAllSelectedOptions();
        for (WebElement element:selOpts){
            System.out.println("Selected Option is : "+ element.getText());
        }

        sel.deselectAll();
        Thread.sleep(5000);
        selOpts=sel.getAllSelectedOptions();
        System.out.println("Selected options count: "+selOpts.size());
        System.out.println("isMultiple: "+sel.isMultiple());
    }

}

