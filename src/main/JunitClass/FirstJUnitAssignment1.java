package main.JunitClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitAssignment1 {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://www.expedia.com/Hotels");
        System.out.println("@BeforeAll-executed once before all test methods in this class");
            }
    @AfterAll
    public static void tearDown(){
        System.out.println("@AfterAll-executed once before all test methods in this class");
    }
    @AfterEach
    public void done(){
        System.out.println("@AfterEach-executed once before all test methods in this class");
    }
    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach-executed once before all test methods in this class");
    }
    @Test
    public void test(){

        System.out.println("@Aftereach-executed once before all test methods in this class");
    }
    @Test
    public void test1(){
        chromeDriver.findElement(By.xpath("//form/div[7]/div[3]/div/ul/li/button")).click();
        System.out.println("@Aftereach-executed once before all test methods in this class");
        enabled("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[2]");
        enabled("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[4]/button/span[1]");
    }
    @Test
    public  void test2(){
        displayed("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[3]/span");
        displayed("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[2]/label[1]/span");
        System.out.println("@Aftereach-executed once before all test methods in this class");
    }
    private void enabled(String locater){
        WebElement button= chromeDriver.findElement(By.xpath(locater));
        boolean enab=button.isEnabled();
        if(enab){
            System.out.println("- is enabled");
        }
        else{
            System.out.println("- is  disabled");
        }
    }
    private void displayed(String locator){
        WebElement button= chromeDriver.findElement(By.xpath(locator));
        boolean enab=button.isDisplayed();
        if(enab){
            System.out.println("1 is displayed");
        }
        else{
            System.out.println("1 is  NOT displayed");
        }
    }

}

