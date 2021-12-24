package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActionsPO extends BasePOM{

    @FindBy(linkText = "Agregar miembro")//"Add Member"
    WebElement addMember;
    @FindBy(css = "input[class='el-input__inner']")
    List<WebElement> inputs;
    @FindBy(css = "[class='el-button el-button--primary']")
    WebElement saveMember;
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
        click(saveMember);
        implcitlyWait();
    }

    public void createNewMember(String name, String mail) throws InterruptedException {
        onWaitSend(inputs.get(0), name);
        onWaitSend(inputs.get(1), mail);
        saveTeamMember();
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
        implcitlyWait();
        moveToElement(removeUsers,1);
        for (WebElement index : removeUsers) {
            click(index);
            click(confirmRemoval);
            implcitlyWait();
        }
    }

    public int verifyAmoutOfUsers(){

        waitElementsNotVisible(removeUsers);
        int value = listOfUsers.size();
        return value;
    }
}
