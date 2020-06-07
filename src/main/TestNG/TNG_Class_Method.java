package main.TestNG;

import org.testng.annotations.*;

public class TNG_Class_Method {
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
    @Test
    public void test1 (){
        System.out.println("@Test1 method");
    }
    @Test
    public void test2 (){
        System.out.println("@Test2 method");
    }
    @Test
    public void test3 (){
        System.out.println("@Test3 method");
    }
}
