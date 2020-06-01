package main.JunitClass;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitSelRadioButton {
    boolean benzSelected;
    boolean bmwSelected;
    boolean hondaSelected;
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        baseUrl="https://letskodeit.teachable.com/p/practice";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test mthods in this class");
            }
   /* @AfterAll
    public static void tearDown(){
        chromeDriver.quit();
        System.out.println("@AfterAll-executed once before all test mthods in this class");
    }*/
   /* @AfterEach
    public void done(){
        chromeDriver.navigate().refresh();
        System.out.println("@AfterEach-executed once before all test mthods in this class");
    }
    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach-executed once before all test mthods in this class");
    }*/
    @Test
    public void test() throws InterruptedException{
       /* chromeDriver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        System.out.println("Clicked on sign in link");*/
        chromeDriver.findElement(By.xpath("//*[@id=\"benzradio\"]")).click();
        System.out.println("Click check box");
        Thread.sleep(5000);
        chromeDriver.findElement(By.xpath("//*[@id=\"bmwradio\"]")).click();
        System.out.println("Click check box");
        Thread.sleep(5000);
        chromeDriver.findElement(By.xpath("//*[@id=\"hondaradio\"]")).click();
        System.out.println("Click check box");
        Thread.sleep(5000);
        chromeDriver.findElement(By.xpath("//*[@id=\"bmwcheck\"]")).click();
        System.out.println("Click chek box");
        chromeDriver.findElement(By.xpath("//*[@id=\"benzcheck\"]")).click();
        System.out.println("Click chek box");
        chromeDriver.findElement(By.xpath("//*[@id=\"hondacheck\"]")).click();
        System.out.println("Click chek box");

        bmwSelected=chromeDriver.findElement(By.xpath("//*[@id=\"bmwcheck\"]")).isSelected();
        benzSelected=chromeDriver.findElement(By.xpath("//*[@id=\"benzcheck\"]")).isSelected();
        hondaSelected= chromeDriver.findElement(By.id("hondacheck")).isSelected();

        System.out.println("Radio bmwSelected: "+ bmwSelected);
        System.out.println("Radio benzSelected: "+ benzSelected);
        System.out.println("Radio hondaSelected: "+ hondaSelected);


    }
    @Test
    public void checkBoxyTest() throws InterruptedException{
        WebElement bmwCheck= chromeDriver.findElement(By.id("bmwcheck"));
        WebElement benzCheck= chromeDriver.findElement(By.id("benzcheck"));
        WebElement hondaCheck= chromeDriver.findElement(By.id("hondacheck"));
        bmwCheck.click();
        Thread.sleep(5000);
        benzCheck.click();
        Thread.sleep(5000);
        hondaCheck.click();
        Thread.sleep(5000);
    }
   /* @Test
    public void test1() throws InterruptedException{
        Thread.sleep(5000);
        WebElement email =chromeDriver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }*/
    @Test
    public  void test2(){
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }

}
