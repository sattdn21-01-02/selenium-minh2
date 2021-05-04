package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Description("TC02 - User can't login with blank Username textbox")
    @Test
    public void TC02() {
        LoggerHelper.startTestCase("TC02 - User can't login with blank Username textbox");

        LoggerHelper.info("[STEP-1] - Click on login tab");
        homePage.goToLoginPage();

        LoggerHelper.info("[STEP-2] - Login unsuccessful with blank email and valid password");
        Account account = new Account(Constant.BLANK_EMAIL, Constant.PASSWORD);
        loginPage.login(account);

        LoggerHelper.info("[STEP-3] - Assert error message is displays");
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_LOGIN_BLANK_INFORMATION;
        Assert.assertEquals(actualMsg, expectedMsg, actualMsg + "is not matched with" + expectedMsg);
    }
}
