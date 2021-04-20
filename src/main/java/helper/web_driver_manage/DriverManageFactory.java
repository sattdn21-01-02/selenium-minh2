package helper.web_driver_manage;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManageFactory {
    public static DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new IEDriverManager();
                break;
        }
        return driverManager;
    }
}
