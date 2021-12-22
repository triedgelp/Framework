package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePOM  {

    protected static WebDriver driver;
    private final WebDriverWait wait;


    public BasePOM(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 20);
        driver = pDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * Close the web driver.
     */
    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void waitElementVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));

    }

    public void click(WebElement element) {
        waitElementVisible(element);
        element.click();
    }

    public void onWaitSend(WebElement element, String value) {
        waitElementVisible(element);
        element.sendKeys(value);
    }

    public void gracefullyWait(WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
         wait.until(ExpectedConditions.presenceOfElementLocated((By) element)).click();
    }

    public void implcitlyWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
