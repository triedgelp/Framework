package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePOM{

    @FindBy(css ="[class='login']")
    WebElement email;
    @FindBy(css ="[class='password']")
    WebElement pwd;
    @FindBy(css ="[type='submit']")
    WebElement access;
    @FindBy(css = "[class='el-button login el-button--default']")
    WebElement multiLoginModal;

    public LoginPO(WebDriver driver){
        super(driver);
    }

    public void doLogin(){
        onWaitSend(email,"beurozeullawo-9008@yopmail.com");
        onWaitSend(pwd,"@@automationTest1234");
        click(access);
        discarMultiLoginModal();
    }

    public void discarMultiLoginModal(){
        try {
            click(multiLoginModal);
        }catch(Exception e){

        }
    }
}
