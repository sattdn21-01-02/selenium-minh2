package com.logigear;

import helper.BrowserHelper;
import helper.Constant;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    public void beforeTest() {
        BrowserHelper.startBrowser(DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
        BrowserHelper.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterTest() {
        BrowserHelper.quitBrowser();
    }
}
