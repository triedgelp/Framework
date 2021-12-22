package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private WebDriver driver;


    public Driver(String browser) {
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        driver.get("https://dashboard.visme.co/v2/login");
        driver.manage().window().maximize();
        return this.driver;
    }

}
