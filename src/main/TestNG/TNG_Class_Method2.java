package main.TestNG;

import org.testng.annotations.*;

public class TNG_Class_Method2 extends TNG_Suite{
    @BeforeClass//Similar to BeforeAll in JUnit
    public void setUP(){
        System.out.println("Class2 - @BeforeClass method ");
    }
    @AfterClass//Similar to AfterAll in JUnit
    public void tearDown(){
        System.out.println("Class2 - @AfterClass method ");
    }
    @BeforeMethod//Similar to BeforeEach in JUnit
    public void init(){
        System.out.println("Class2 - @BeforeMethod method ");
    }
    @AfterMethod//Similar to AfterEach in JUnit
    public void quit(){
        System.out.println("Class2 - @AfterMethod method ");
    }
    @Test
    public void test1 (){
        System.out.println("Class2 - @Test1 method");
    }
    @Test
    public void test2 (){
        System.out.println("@Class2 - Test2 method");
    }
    @Test
    public void test3 (){
        System.out.println("@Class2 - Test3 method");
    }
}
