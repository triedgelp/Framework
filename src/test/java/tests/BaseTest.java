package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import core.Driver;

import core.ExtentLogger;
import core.ExtentManager;
import core.ExtentReport;
import core.listeners.Listener;
import org.testng.ITestContext;
import org.testng.annotations.*;

import pageFactory.VismePO;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {
    Driver driver;
    private VismePO vismeHome;
    private static ExtentReports extent;
    public static ExtentTest test;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void beforeTest( String browser) {
        driver = new Driver(browser);
        vismeHome = new VismePO(driver.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {

        vismeHome.dispose();
    }


    /**
     * Get the home page.
     *
     * @return HomePage
     */
    public VismePO getVismePage() {
        return vismeHome;
    }
}
