package com.logigear;

import helper.BrowserHelper;
import helper.Constant;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional String browser) {
        if (browser != null) {
            BrowserHelper.DriverType type = BrowserHelper.DriverType.valueOf(browser.toUpperCase());
            BrowserHelper.startBrowser(type);
        } else {
            BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        }
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
        BrowserHelper.maximize();
    }

    @AfterMethod
    public void afterMethod() {
        BrowserHelper.quitBrowser();
    }
}
