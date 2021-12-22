package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPO extends BasePOM {

    @FindBy(linkText ="My Files")
    WebElement myFilesTab;
    @FindBy(id = "create-project-nav")
    WebElement createNewBtn;
    @FindBy(css = "[class='workspace-selector el-popover__reference']")
    WebElement accountDropdown;
    //@FindBy(css = "a[href='/v2/workspaces/members']")
    @FindBy(css = "a[href='/v2/workspaces/members']")
    List<WebElement> manageTeam;

    public DashboardPO(WebDriver driver) {
        super(driver);
    }

    public void createNew(){
        click(createNewBtn);
    }
    public void selectManage(){
        click(accountDropdown);
        click(manageTeam.get(1));
    }

    public void selectTab(){
        click(myFilesTab);
    }
}
