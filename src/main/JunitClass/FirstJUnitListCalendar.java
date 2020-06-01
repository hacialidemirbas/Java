package main.JunitClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstJUnitListCalendar {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://expedia.com/hotels");
        System.out.println("@BeforeAll-executed once before all test methods in this class");
            }
    @AfterAll
    public static void tearDown(){
        chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }

    @BeforeEach
    public void init(){
        chromeDriver.findElement(By.xpath("//input[@id='hotel-checkin-hlp']")).click();
        System.out.println("@BeforeEach-executed once before all test methods in this class");
    }
    @Test
    public void test1(){
        List<WebElement> datesElements= chromeDriver.findElements(By.xpath("//div[@class='datepicker-cal-month']//button"));
        for (WebElement element:datesElements) {
            boolean enabl=element.isEnabled();
            String dateValue=element.getText();
            WebElement spanElement=element.findElement(By.tagName("span"));
            String monthValue=spanElement.getText();
            if(enabl){
                System.out.println(monthValue+"  "+dateValue+"  is enabled");
            }
            else{
                System.out.println(monthValue+"  "+dateValue+" is disabled");
            }

        }
        System.out.println("@Aftereach-executed once before all test methods in this class");
    }
    @Test
    public  void test2(){
        System.out.println("@Aftereach-executed once before all test methods in this class");
    }

}

