package main.JunitClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnit_Displaye_Enabled_Selected {
    static WebDriver chromeDriver;
    static String baseUrl;
    @BeforeAll
    public static void setUP(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://register.rediff.com/register/register.php?FormName=user_details");
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
        chromeDriver.findElement(By.xpath("//input[@onclick='chk_altemailID();fieldTrack(this);']")).click();
        System.out.println("@Aftereach-executed once before all test methods in this class");
    }
   /* @Test
    public  void test2(){
        verifyHidden("//input[@name='chk_altemail36240f16']");
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }*/
    private void verifyHidden(String locat) {
        WebElement childfield= chromeDriver.findElement(By.xpath(locat));
        boolean displ = childfield.isDisplayed();
        if(displ) {
            System.out.println("Element displayed");
        } else {
            System.out.println("Element Hidden");
        }
    }

}

