package main.JunitClass;
import org.junit.jupiter.api.*;
public class FirstJUnit {
    @BeforeAll
    public static void setUP(){
                System.out.println("@BeforeAll-executed once before all test mthods in this class");
            }
    @AfterAll
    public static void tearDown(){
        System.out.println("@AfterAll-executed once before all test mthods in this class");
    }
    @AfterEach
    public void done(){
        System.out.println("@AfterEach-executed once before all test mthods in this class");
    }
    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach-executed once before all test mthods in this class");
    }
    @Test
    public void test(){
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }
    @Test
    public void test1(){
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }
    @Test
    public  void test2(){
        System.out.println("@Aftereach-executed once before all test mthods in this class");
    }

}

