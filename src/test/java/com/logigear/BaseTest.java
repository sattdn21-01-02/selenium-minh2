package com.logigear;

import helper.BrowserHelper;
import helper.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser) {

        BrowserHelper.DriverType type = BrowserHelper.DriverType.valueOf(browser.toUpperCase());
        BrowserHelper.startBrowser(type);

        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
        BrowserHelper.maximize();
    }

    @AfterMethod
    public void afterMethod() {
        BrowserHelper.quitBrowser();
    }
}
