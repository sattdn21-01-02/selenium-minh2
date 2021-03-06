package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {

    private static WebDriver driver;

    public enum DriverType {CHROME, FIREFOX, EDGE}

    public static void startBrowser(DriverType type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                LoggerHelper.info("------------------------------- OPEN CHROME DRIVER -------------------------------");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                LoggerHelper.info("------------------------------- OPEN FIREFOX DRIVER -------------------------------");
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                LoggerHelper.info("------------------------------- OPEN EDGE DRIVER -------------------------------");
                driver = new EdgeDriver();
                break;
            default:
                LoggerHelper.error("[startBrowser] No browser passed throw exception");
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constant.TIME_WAITS_DRIVER, TimeUnit.SECONDS);
    }

    public static void scrollPage() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,250)");
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    public static void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public static void maximize() {
        getDriver().manage().window().maximize();
    }
}
