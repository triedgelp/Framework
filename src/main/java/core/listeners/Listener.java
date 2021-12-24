package core.listeners;

import core.ExtentLogger;
import core.ExtentReport;
import org.testng.*;

import java.io.IOException;


public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onFinish(ISuite suite) {
        try{
            ExtentReport.finishReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.buildReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Triggered on test success
     *
     * @param result : {@link ITestResult}
     */

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    /**
     * Triggered on test success
     *
     * @param result : {@link ITestResult}
     */
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " has failed");
    }
    /**
     * Triggered on test success
     *
     * @param result : {@link ITestResult}
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " has been skipped");
    }
    /**
     * Triggered on test success
     *
     * @param result : {@link ITestResult}
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " has passed");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //TODO
    }

    @Override
    public void onStart(ITestContext context) {
        //TODO
    }

    @Override
    public void onFinish(ITestContext context) {
        //TODO
    }

}

