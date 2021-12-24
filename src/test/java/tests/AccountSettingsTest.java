package tests;

import core.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.*;


public class AccountSettingsTest extends BaseTest {

    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private ActionsPO manageTeamPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        this.loginPage = new LoginPO(super.driver.getDriver());
        this.dashboardPage = new DashboardPO(super.driver.getDriver());
        this.manageTeamPage = new ActionsPO(super.driver.getDriver());

        loginPage.doLogin();
    }
    @Test(priority = 1,description = "First Test",dataProvider = "addedUsers", dataProviderClass = Data.class)
    public void createUsers(String userName, String userMail) throws InterruptedException {
        this.dashboardPage.selectManage();
        this.manageTeamPage.addUser();
        this.manageTeamPage.createNewMember(userName,userMail);
        this.manageTeamPage.saveTeamMember();
        Assert.assertTrue(manageTeamPage.verifyUserInGrid(userMail),"User is not displayed in the grid!");
    }

    @Test(priority = 2,description = "Second Test")
    public void removeUsers() {
        this.dashboardPage.selectManage();
        this.manageTeamPage.removeUsers();
        Assert.assertEquals(manageTeamPage.verifyAmoutOfUsers(),1);
    }
}
