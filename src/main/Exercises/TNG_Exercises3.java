package main.TestNG.exercises;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.*;

public class TNG_Exercises3 {
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
    public void mswindows (){
        System.out.println("@MSWindows method");
    }
   @AfterEach
   public void aEach (){
       System.out.println("@AfterEach executed");
   }
   @BeforeEach
   public void bEach (){
       System.out.println("@BeforeEach executed");
   }
   @AfterAll
   public void aAll (){
       System.out.println("@AfterAll executed");
   }
   @BeforeAll
   public void bAll (){
       System.out.println("@BeforeAll executed");
   }
   @AfterGroups
   public void aGroups (){
       System.out.println("@AfterGroups executed");
   }
   @BeforeGroups
   public void bGroups (){
       System.out.println("@BeforeGroups executed");
   }
}
