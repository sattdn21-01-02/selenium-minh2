package helper.web_driver_manage;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        //set your broswer-specific options here
        this.driver = new InternetExplorerDriver(options);
    }
}
