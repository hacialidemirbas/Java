package main.TestNG;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import main.listeners.CustomITestListener1;
import main.listeners.CustomListener1;
import main.listeners.CustomSuiteListener1;
import main.utils.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners({CustomITestListener1.class, CustomListener1.class, CustomSuiteListener1.class})
public class TNG_Extent {
    WebDriver driver;
    String baseUrl;
    ExtentReports reports;
    ExtentTest test;

    @BeforeTest
    public void setup() {
        baseUrl = "https://jqueryui.com/";
        reports= new ExtentReports("C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\src\\main\\Reports\\ereport.html");
        test=reports.startTest("Reporter Demo");
        test.log(LogStatus.INFO,"Test started ...");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hacia\\IdeaProjects\\NA_AutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() throws IOException {
        //driver.quit();
        reports.endTest(test);
        reports.flush();
        RandomString rString= new RandomString();
        String fileNm= System.getProperty("user.dir")+"src\\snippets\\"+rString.genRandom(5)+".png";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
        String imgPath = test.addScreenCapture(fileNm);
        test.log(LogStatus.ERROR, "some error screenshot", imgPath);

    }

    @AfterTest
    public void navBack() {
        driver.navigate().back();
    }

    @Parameters({"linknm"})
    @Test
    public void eventsTest(String linknm) {
        test.log(LogStatus.INFO, "inside eventsTest");
        WebElement desiredLink = driver.findElement(By.linkText(linknm));
        desiredLink.click();
        String currUrl = driver.getCurrentUrl();
        if (linknm.equals("Events")){
            Assert.assertEquals(currUrl, "https://openjsf.org/");
        test.log(LogStatus.PASS, "eventsTest: PASS");}
        else{
            Assert.assertEquals(currUrl, "https://plugins.jquery.com/");
            test.log(LogStatus.PASS, "eventsTest: PASS");
        }
    }

    @Parameters({"linknm"})
    @Test
    public void insideValidations(String clickLink) {
        WebElement logo, headerText;
        if (clickLink.equals("Events")) {
            logo = driver.findElement(By.xpath("//img[@alt='OpenJS Foundation']/parent::a"));
        } else {
            logo = driver.findElement(By.linkText("jQuery Plugin Registry"));
        }
        logo.click();
        if (clickLink.equals("Events")) {
            headerText = driver.findElement(By.xpath("//div[contains(@class, 'instance-1')]//div[@class='nectar-gradient-text']/h3"));
            Assert.assertTrue(headerText.getText().equals("Welcome Electron!"));
        } else {
            headerText = driver.findElement(By.cssSelector("#banner-secondary>h1"));
            Assert.assertTrue(headerText.getText().equals("The jQuery Plugin Registry"));
        }
    }
}