package main.JunitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitExpediaDisabled {

    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUP() {
       baseUrl = "https://www.expedia.com/Hotels";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() {
        //driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @BeforeEach
    public void init() {

        System.out.println("@BeforeEach - refreshed the page");
    }

    @AfterEach
    public void done() {
        //  driver.navigate().refresh();
        System.out.println("@AfterEach - refreshed the page");
    }

    @Test
    public void enabledDate() throws InterruptedException {
        Thread.sleep(5000);
        performTest("//button[(@data-day='31' and @data-month='4') or (starts-with(@aria-label,'May 31'))]");
        Thread.sleep(5000);
    }
    @Test
    public void disabledDate() throws InterruptedException {
        Thread.sleep(5000);
        performTest("//button[starts-with(@aria-label,'May 21')]");
        Thread.sleep(5000);
    }
    private void performTest(String locat){
        WebElement dateField= driver.findElement(By.xpath(locat));
        boolean enabl= dateField.isEnabled();
        if(enabl){
            dateField.click();
            System.out.println("clicking on enabled date");
        }
        else{
            System.out.println("dateField disabled");
        }
    }
}
