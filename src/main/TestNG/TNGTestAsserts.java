package main.TestNG;

import main.AppCode.AppForTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TNGTestAsserts {
    AppForTest atest= new AppForTest();

    @Test
    public void test1 (){
        int res= atest.sumNbrs(1,2);
        Assert.assertEquals(res, 4, "sum mismatch");
        System.out.println("@Test1 method");
    }
    @Test// write and practice addString
    public void test2 (){
        System.out.println("@Test2 method");
    }
    @Test// write and practice getArray
    public void test3 (){
        System.out.println("@Test3 method");
    }
}
