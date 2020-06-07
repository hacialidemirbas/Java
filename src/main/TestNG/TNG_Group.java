package main.TestNG;

import org.testng.annotations.*;

public class TNG_Group extends TNG_Suite {
    @BeforeClass (alwaysRun = true)
    public void beforeClass(){
        System.out.println("@BeforeClass - alwaysRun");
    }

    @Test(groups = {"iphone","faceID"})
    public void testIphoneX (){
        System.out.println("@testIphoneX method");
    }
    @Test(groups = {"iphone","faceID"})
    public void testIPhoneXR (){
        System.out.println("@testIPhoneXR method");
    }
    @Test(groups = {"iphone","faceID"})
    public void testIphoneXS (){
        System.out.println("@testIphoneXS method");
    }
    @Test(groups = {"Android","samsung"})
    public void testGalaxy8 (){
        System.out.println("@testGalaxy8 method");
    }
    @Test(groups = {"Android","samsung"})
    public void testGalaxy9 (){
        System.out.println("@testGalaxy9 method");
    }
    @Test(groups = {"Android","samsung"})
    public void testGalaxy10 (){
        System.out.println("@testGalaxy10 method");
    }
    @Test(groups = {"Android","note"})
    public void testNot9 (){
        System.out.println("@testNot9 method");
    }
    @Test(groups = {"Android","note"})
    public void testNote10 (){
        System.out.println("@testNote10 method");
    }
}
