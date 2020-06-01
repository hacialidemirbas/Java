package main.JunitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstJUnitAttribute {
    static WebDriver chromeDriver;
    static String baseUrl;

    @BeforeAll
    public static void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://learn.letskodeit.com/p/practice");
        System.out.println("@BeforeAll-initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() {
        chromeDriver.quit();
        System.out.println("@AfterAll-executed and chromeDriver closed");
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement openTab = chromeDriver.findElement(By.xpath("//legend[text()='Switch Tab Example']//following-sibling::a"));
        System.out.println("@test1 - class name is : " + openTab.getAttribute("class"));
        System.out.println("@test1 - id value is : " + openTab.getAttribute("id"));
        System.out.println("@test1 - href value is : " + openTab.getAttribute("href"));
        System.out.println("@test1 - target value is : " + openTab.getAttribute("target"));
    }

    @Test
    public void test2() {
        WebElement tagExample = chromeDriver.findElement(By.xpath("//*[text()='Switch Tab Example']"));
        System.out.println("@test2 - tagExample tagName : " + tagExample.getTagName());

    }

    @Test
    public void test3() throws InterruptedException {
        List<WebElement> listEle = chromeDriver.findElements(By.xpath("//div[@id='radio-btn-example']//input"));
        for (WebElement ele : listEle) {
            ele.click();
            System.out.println("Radio button selected is " + ele.getAttribute("value"));
            System.out.println("radio button selected is " + ele.isSelected());
            Thread.sleep(5000);
        }
    }
}

