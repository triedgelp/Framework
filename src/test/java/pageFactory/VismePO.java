package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;


public class VismePO extends BasePOM {

    @FindBy( linkText = "Login")
    WebElement login;

    public VismePO(WebDriver driver) {
        super(driver);
    }

    public void selectLogIn(){
        login.click();
    }

    public void swithPages() {
        Set<String> browserTabs = driver.getWindowHandles();
        driver.switchTo().window(browserTabs.toArray()[0].toString());
        driver.switchTo().window(browserTabs.toArray()[1].toString());
    }
}

