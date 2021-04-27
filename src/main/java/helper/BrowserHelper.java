package helper;

import helper.web_driver_manage.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {

    private static WebDriver driver;

    public static void startBrowser(DriverType type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                Log.info("------------------------------- OPEN CHROME DRIVER -------------------------------");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                Log.info("------------------------------- OPEN FIREFOX DRIVER -------------------------------");
                driver = new FirefoxDriver();
                break;
            default:
                Log.error("[startBrowser] No browser passed throw exception");
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constant.TIME_WAITS_DRIVER, TimeUnit.SECONDS);
    }

    public static void scrollPage() {
        JavascriptExecutor jse = (JavascriptExecutor) BrowserHelper.getDriver();
        jse.executeScript("window.scrollBy(0,250)");
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void waitForElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
