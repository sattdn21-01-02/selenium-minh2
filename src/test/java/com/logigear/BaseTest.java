package com.logigear;

import helper.BrowserHelper;
import helper.Constant;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
        BrowserHelper.maximize();
    }

    @AfterMethod
    public void afterMethod() {
        BrowserHelper.quitBrowser();
    }
}
