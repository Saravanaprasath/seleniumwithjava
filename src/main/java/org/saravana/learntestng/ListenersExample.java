package org.saravana.learntestng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersExample implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test case going to start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case is executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test is failed but within success percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test is failed with timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Before all test execution");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("After all test execution");
    }
}
