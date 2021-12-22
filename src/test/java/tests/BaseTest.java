package tests;

import core.Driver;

import org.testng.annotations.*;

import pageFactory.VismePO;

public class BaseTest {
    Driver driver;
    private VismePO vismeHome;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void beforeTest(String browser) {
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
