package pageFactory;

import core.ExtentLogger;
import core.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyFilesPO extends BasePOM{


    //@FindBy(css ="div.icon-with-text-button.my-files-dir-section__button > span")
    @FindBy(xpath = "//*[@id=\"contentPanelContentMyFiles\"]/div[1]/div[1]/div/div[2]/div[1]/span")
    WebElement createFolder;
    @FindBy(css = "[class='my-files-static-folders__icon']")
    List<WebElement> imagesOption;
    @FindBy(className = "my-files-modal__input")
    WebElement folderName;
    @FindBy(css = "[class='visme-button visme-button--confirmation modal__button']")
    WebElement createBtn;
    @FindBy(css = "[class='my-files-directory__name']")
    WebElement folderExists;
    @FindBy(css = "[class='my-files-directory__menu']")
    WebElement actionsMenu;
    @FindBy(linkText = "Delete")
    WebElement deleteFolder;
    @FindBy(css = "[class='my-files-upload__attach-button']")
    WebElement uploadBtn;
    @FindBy(css = "div.modal__body > p")
    WebElement error;

    public MyFilesPO(WebDriver driver) {
        super(driver);
    }

    public void selectCreateFolder(int repeat){

        driver.switchTo().frame(0);
        for(int i=0; i<repeat;i++){
            click(createFolder);
            this.saveNewFolder();
        }
    }

    public void saveNewFolder(){
        onWaitSend(folderName,"Tesst1");
        click(createBtn);
    }
    public void uploadAnImage(){
        driver.switchTo().frame(0);
        ExtentLogger.pass("Switched to Iframe");
        click(uploadBtn);

        String location= System.getProperty("user.dir");
        //System.out.println(location + "\\src\\test\\java\\Assets\\Image1.PNG");
        uploadBtn.sendKeys(location+"/src/test/Assets/Image1.PNG");
    }

    public void removeFolder(){
        click(actionsMenu);
        click(deleteFolder);
    }

    public boolean verifyCreatedFolder(){
        driver.switchTo().frame(0);
        return this.folderExists.isDisplayed();
    }
    public String verifyAlertMessage(){
        implcitlyWait();
        gracefullyWait(error);
        ExtentLogger.pass("Al final lo obtubeee to Iframe");
        return error.getText();
    }
}
