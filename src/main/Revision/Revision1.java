package main.Revision;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Revision1 {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        baseUrl="http://demo.guru99.com/test/radio.html";
        chromeDriver.manage().window().maximize();
        //chromeDriver.navigate().to(baseUrl);
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
        //chromeDriver.findElement( By.xpath("//li[@class='project sizzlejs']")).click();
    }
    @AfterAll
    public static void quit(){
       // chromeDriver.quit();
        System.out.println("@AfterAll - initiated and browser closed");
    }
    @Test
    public void test1() throws InterruptedException {
        WebElement radio1= chromeDriver.findElement(By.xpath("//input[@value='Option 1']"));
        radio1.click();
        Thread.sleep(5000);
        WebElement radio2= chromeDriver.findElement(By.xpath("//input[@value='Option 2']"));
        radio2.click();
        Thread.sleep(5000);
        WebElement radio3= chromeDriver.findElement(By.xpath("//input[@value='Option 3']"));
        radio3.click();
        Thread.sleep(5000);
    }

    @Test
    public void test2() throws InterruptedException {
        WebElement checkBox1= chromeDriver.findElement(By.xpath("//input[@value='checkbox1']"));
        checkBox1.click();
        Thread.sleep(5000);
        WebElement checkBox2= chromeDriver.findElement(By.xpath("//input[@value='checkbox2']"));
        checkBox2.click();
        Thread.sleep(5000);
        WebElement checkBox3= chromeDriver.findElement(By.xpath("//input[@value='checkbox3']"));
        checkBox3.click();
        Thread.sleep(5000);
    }
    @Test
    public void test3() throws InterruptedException {
        chromeDriver.get("https://letskodeit.teachable.com/p/practice");

        WebElement dropDown= chromeDriver.findElement(By.id("carselect"));
        Thread.sleep(5000);
        Select carSelect2= new Select (dropDown);
                carSelect2.selectByVisibleText("Benz");
                Thread.sleep(5000);

    }
    @Test
    public void test4() throws InterruptedException {
        WebElement dropDown= chromeDriver.findElement(By.id("multiple-select-example"));
        Thread.sleep(5000);
        Select carSelect2= new Select (dropDown);
        List<WebElement> toBeSelected = carSelect2.getOptions();
        for(WebElement each: toBeSelected){
            carSelect2.selectByVisibleText(each.getText());
            Thread.sleep(5000);
        }


    }
}
