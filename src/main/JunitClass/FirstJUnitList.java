package main.JunitClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstJUnitList {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://learn.letskodeit.com/p/practice");
        System.out.println("@BeforeAll-initiated and navigated to web page");
            }
    @AfterAll
    public static void tearDown(){
        chromeDriver.quit();
        System.out.println("@AfterAll-executed and chromeDriver closed");
    }
    @Test
    public void radios() throws InterruptedException {
        List<WebElement> listEle= chromeDriver.findElements(By.xpath("//div[@id='radio-btn-example']//input"));
        for (WebElement ele: listEle             ) {
            ele.click();
            System.out.println("radio button isSelected: "+ ele.isSelected());
            Thread.sleep(5000);
        }
            }

        @Test
    public void checks() throws InterruptedException {
        List<WebElement> listEle= chromeDriver.findElements(By.xpath("//legend[text()='Checkbox Example']/following-sibling::label/input"));
        for (WebElement ele: listEle             ) {
            ele.click();
            System.out.println("check isSelected: "+ ele.isSelected());
            Thread.sleep(5000);
        }
            }
    @Test
    public void tableEx() {
        List<WebElement> listHead= chromeDriver.findElements(By.xpath("//table[@class='table-display']//th"));
        List<WebElement> listAuthor= chromeDriver.findElements(By.xpath("//table[@class='table-display']//td[1]"));
        List<WebElement> listCourse= chromeDriver.findElements(By.xpath("//table[@class='table-display']//td[2]"));
        List<WebElement> listPrice= chromeDriver.findElements(By.xpath("//table[@class='table-display']//td[3]"));
        List<WebElement> listLocation= chromeDriver.findElements(By.xpath("//table[@class='table-display']//td[4]"));
            for (WebElement ele: listHead             ) {
            System.out.println("Table Header is:   "+ele.getText());}

            for(WebElement aele:listAuthor){
                System.out.println("Author is: "+aele.getText());
            }
            for(WebElement aele:listCourse){
                System.out.println("Course is: "+aele.getText());
            }for(WebElement aele:listPrice){
                System.out.println("Price is: "+aele.getText());
            }
            int headSize=listHead.size();
        System.out.println("Header element size is : "+headSize);
        if (headSize>0){
            for (int i = 0; i < listHead.size(); i++) {
                System.out.println("Table header is : "+listHead.get(i).getText());
            }
        }
        else{
            System.out.println("Header element not found");}
        int locationSize=listLocation.size();
        System.out.println("Location element size is : "+locationSize);
        if (locationSize>0){
            for (int i = 0; i < listLocation.size(); i++) {
                System.out.println("Table location is : "+listLocation.get(i).getText());
            }
        }
        else{
            System.out.println("4th colomn element not found");
        }


            }
    }

