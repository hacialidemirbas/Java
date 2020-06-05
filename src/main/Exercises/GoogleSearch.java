package main.Exercises;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    static WebDriver chromeDriver;
    static String baseUrl;

    @BeforeAll
    public static void setUP(){
        baseUrl="https://www.google.com";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        //Thread.sleep(10000);
        chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }
    @Test
    public void googleSearch() throws InterruptedException {
        WebElement searchBar= chromeDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBar.sendKeys("sami yusuf demirbas");
        WebElement searchKey=chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
        searchKey.click();
        Thread.sleep(15000);
    }
}