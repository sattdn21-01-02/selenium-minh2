package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Description("TC03 - User cannot log into Railway with invalid password ")
    @Test
    public void TC03() {
        LoggerHelper.startTestCase("TC03 - User cannot log into Railway with invalid password ");

        LoggerHelper.info("[STEP-1] - Click on login tab");
        homePage.goToLoginPage();

        LoggerHelper.info("[STEP-2] - Login unsuccessful with valid email and invalid password");
        Account account = new Account(Constant.USERNAME, DataHelper.getRandomErrorPassword());
        loginPage.login(account);

        LoggerHelper.info("[STEP-3] - Assert error message is displays");
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_LOGIN_INVALID_ACCOUNT;
        Assert.assertEquals(actualMsg, expectedMsg, actualMsg + " is not matched with " + expectedMsg);
    }
}
