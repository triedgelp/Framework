package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActionsPO extends BasePOM{

    @FindBy(linkText = "Add Member")
    WebElement addMember;
    @FindBy(css = "input[class='el-input__inner']")
    List<WebElement> inputs;
    @FindBy(css = "[class='el-button el-button--primary']")
    List<WebElement> saveMember;
    @FindBy(css = "[class='remove-invite']")
    List<WebElement> removeUsers;
    @FindBy(css = "[class='el-table_1_column_2   el-table__cell']")
    List<WebElement> listOfUsers;
    @FindBy(css = "[class='el-table_1_column_3   el-table__cell']")
    List<WebElement> listOfMails;
    @FindBy(css = "[class='el-button el-button--default el-button--small el-button--primary ']")
    WebElement confirmRemoval;



    public ActionsPO(WebDriver driver) {
        super(driver);
    }
    public void addUser(){
        click(addMember);
    }

    public void saveTeamMember() {
        click(saveMember.get(1));
    }

    public void createNewMember(String name, String mail){
        onWaitSend(inputs.get(0), name);
        onWaitSend(inputs.get(1), mail);
        click(saveMember.get(1));
        implcitlyWait();
    }

    public boolean verifyUserInGrid(String value){

        for (WebElement user : listOfUsers) {
            if (user.getText().contains(value)) {
                return true;
            }
        }
        return false;
    }

    public void removeUsers(){
        for(int i=1;i < removeUsers.size();i++ ){
            click(removeUsers.get(i));
            click(confirmRemoval);
            waitElementVisible(removeUsers.get(i));
        }
    }

    public int verifyAmoutOfUsers(){
        int value = listOfUsers.size();
        return value;
    }
}
