package main.JunitClass;

import main.utils.RandomString;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class FirstJUnit_Actions {
    static WebDriver chromeDriver;
    static String baseUrl;
    static Actions action;

    @BeforeAll
    public static void setUP(){
        baseUrl="https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        action= new Actions(chromeDriver);
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterAll
    public static void tearDown() throws InterruptedException, IOException {
        RandomString randomString= new RandomString();
        String flName=System.getProperty("user.dir")+"\\scr\\snippets\\"+randomString.genRandom(5)+".png";
        File scrFile=((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File(flName));
        chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }
    @Test
    public void aHover_Click() throws InterruptedException {
        chromeDriver.navigate().to("https://jquery.com");
        Thread.sleep(5000);
        WebElement hoverSupport=chromeDriver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forums= chromeDriver.findElement(By.xpath("//a[text()='Forums']"));
        action.moveToElement(hoverSupport).perform();
        Thread.sleep(5000);
        action.moveToElement(forums).click().perform();
        Thread.sleep(5000);
        String currentUrl=chromeDriver.getCurrentUrl();
        Assertions.assertEquals("https://forum.jquery.com/",currentUrl,"url mismatch, Actual urls is: "+currentUrl);
        System.out.println("@Test1 - Current url is : "+currentUrl);

        System.out.println("@Test1 - test executed");


    }
    @Test
    public void bDoubleClick_ContextClick() throws InterruptedException {
        chromeDriver.navigate().to("https://jqueryui.com/button");
        Thread.sleep(5000);
        WebElement frame=chromeDriver.findElement(By.cssSelector(".demo-frame"));
        chromeDriver.switchTo().frame(frame);

        WebElement anchor=chromeDriver.findElement(By.xpath("//div[@class='widget']//a[text()='An anchor']"));
        //action.moveToElement(anchor).doubleClick().perform();
        action.doubleClick(anchor).perform();
        Thread.sleep(5000);
        action.contextClick(anchor).perform();

        Thread.sleep(5000);
        System.out.println("@Test2 - test executed");
        chromeDriver.switchTo().defaultContent();
    }
    @Test
    public void cDragDrop() throws InterruptedException {
        chromeDriver.navigate().to("https://jqueryui.com/droppable");
        Thread.sleep(5000);

        WebElement frame=chromeDriver.findElement(By.cssSelector(".demo-frame"));
        chromeDriver.switchTo().frame(frame);

        WebElement draggable=chromeDriver.findElement(By.id("draggable"));
        WebElement droppable=chromeDriver.findElement(By.id("droppable"));
        action.dragAndDrop(draggable,droppable).build().perform();

        Thread.sleep(5000);
        System.out.println("@Test3 - test executed");
        chromeDriver.switchTo().defaultContent();

       /* String actualTxt=droppable.findElement(By.tagName("p")).getText();
        Assertions.assertEquals("Dropped!",actualTxt);*/
    }
    @Test
    public void dSlider() throws InterruptedException {
        chromeDriver.navigate().to("https://www.kayak.com/cars/Tucson,AZ-c29704/2020-07-01/2020-07-02;map?sort=rank_a");
        Thread.sleep(10000);
        WebElement more=chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[5]/div"));
        more.click();
        Thread.sleep(10000);
        WebElement minPrice=chromeDriver.findElement(By.className("cars-results-filters-PriceFilterSection__Header__Min"));
        WebElement maxPrice=chromeDriver.findElement(By.className("cars-results-filters-PriceFilterSection__Header__Max"));

        System.out.println("Min Price before slide"+minPrice.getText());
        WebElement startingSlider= chromeDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[5]/div"));
        WebElement endSlider= chromeDriver.findElement(By.xpath("//*[@id=\"priceFilterSection_v\"]/div[2]/div[3]"));
        action.dragAndDropBy(startingSlider,100,0).perform();
        Thread.sleep(5000);
        action.dragAndDropBy(endSlider,-50,0).perform();

    }
    @Test
    public void fKeyPress() throws InterruptedException {
        chromeDriver.navigate().to("https://www.kayak.com/cars/Tucson,AZ-c29704/2020-06-02/2020-06-04;map?sort=rank_a");
        Thread.sleep(5000);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
        action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);

    }
}