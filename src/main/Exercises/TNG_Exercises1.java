package main.TestNG.exercises;

import org.testng.annotations.*;

public class TNG_Exercises1 {
    @BeforeSuite
    public void bSuite(){
        System.out.println("@BeforeSuite method ");
    }
    @AfterSuite
    public void aSuite(){
        System.out.println("@AfterSuite method ");
    }
    @BeforeClass//Similar to BeforeAll in JUnit
    public void setUP(){
        System.out.println("@BeforeClass method ");
    }
    @AfterClass//Similar to AfterAll in JUnit
    public void tearDown(){
        System.out.println("@AfterClass method ");
    }
    @BeforeMethod//Similar to BeforeEach in JUnit
    public void init(){
        System.out.println("@BeforeMethod method ");
    }
    @AfterMethod//Similar to AfterEach in JUnit
    public void quit(){
        System.out.println("@AfterMethod method ");
    }
    @Test(groups = {"Mobile"})
    public void selenium (){
        System.out.println("@Selenium method");
    }
    @Test
    public void java (){
        System.out.println("@Java method");
    }
    @Test
    public void microsoft (){
        System.out.println("@Microsoft method");
    }
}
