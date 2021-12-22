package tests;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.DashboardPO;
import pageFactory.LoginPO;
import pageFactory.MyFilesPO;


public class MyFilesTest extends BaseTest{

    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private MyFilesPO myFilesPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        this.loginPage = new LoginPO(super.driver.getDriver());
        this.dashboardPage = new DashboardPO(super.driver.getDriver());
        this.myFilesPage = new MyFilesPO(super.driver.getDriver());
        this.loginPage.doLogin();

    }

    @Test(description = "First Test")
    public void createFolder() {
        this.dashboardPage.selectTab();
        this.myFilesPage.selectCreateFolder(2);
        Assert.assertTrue(myFilesPage.verifyAlertMessage().equals("Folder with this name already exists!"),"Error message is not displayed/correct");

    }

    @Test(description = "Second Test")
    public void createImage() {

        this.dashboardPage.selectTab();
        this.myFilesPage.uploadAnImage();
    }

    //@AfterMethod(alwaysRun = true)
    //public void cleanUp(){
        //this.myFilesPage.removeFolder();
    //}
}
