package core.listeners;

import core.ExtentLogger;
import core.ExtentReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

import java.io.IOException;


public abstract class Listener implements ITestContext, ITestListener {


    /**
     * Triggered on finish
     *
     * @param instance : {@link ITestContext}
     */
    @Override
    public void onFinish(ITestContext instance) {
        try{
            ExtentReport.finishReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Triggered on start
     *
     * @param instance : {@link ITestContext}
     */
    @Override
    public void onStart(ITestContext instance) {
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
        ExtentLogger.fail(result.getMethod().getMethodName() + "has failed");
    }
    /**
     * Triggered on test success
     *
     * @param result : {@link ITestResult}
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + "has been skipped");
    }
    /**
     * Triggered on test success
     *
     * @param result : {@link ITestResult}
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + "has passed");
    }

}

