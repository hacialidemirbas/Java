package main.TestNG;

import main.AppCode.AppForTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TNGTestSoftAsserts {
    AppForTest atest= new AppForTest();

    @Test
    public void test1 (){
        int res;
        SoftAssert sa= new SoftAssert();
        res= atest.sumNbrs(2,2);
        sa.assertEquals(res, 4, "sum mismatch");
        System.out.println("@Test1 first assertion completed");
        sa.assertEquals(res, 5, "sum mismatch");
        System.out.println("@Test1 second assertion completed");
        sa.assertEquals(res, 6, "sum mismatch");
        System.out.println("@Test1 third assertion completed");
        sa.assertAll("After all assertions");
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
