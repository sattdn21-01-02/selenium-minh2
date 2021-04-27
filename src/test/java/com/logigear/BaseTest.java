package com.logigear;

import helper.BrowserHelper;
import helper.Constant;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeTest
    public void setUpTestMethod() {
        Constant.DRIVER_MANAGER = DriverManageFactory.getDriverManager(DriverType.CHROME);
        Constant.WEB_DRIVER = Constant.DRIVER_MANAGER.getWebDriver();
        Constant.WEB_DRIVER.get(Constant.RAILWAY_URL);
        Constant.WEB_DRIVER.manage().window().maximize();
    }

    @AfterTest
    public void closePage() {
        BrowserHelper.quitBrowser();
    }
}
