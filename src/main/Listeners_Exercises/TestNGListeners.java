package main.Listeners_Exercises;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("******************* Test started : "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("******************* Test is successful : "+result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("******************* Test failed : "+result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("******************* Test skipped : "+result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("******************* Test completed : "+context.getName());

    }
}
