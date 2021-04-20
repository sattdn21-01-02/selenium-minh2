package helper.web_driver_manage;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        //set your browser-specific option here
        this.driver = new FirefoxDriver(options);

    }
}
