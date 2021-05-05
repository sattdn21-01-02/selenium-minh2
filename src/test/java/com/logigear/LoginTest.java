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

        homePage.goToLoginPage();

        Account account = new Account(Constant.USERNAME, DataHelper.getRandomErrorPassword());
        loginPage.login(account);

        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_LOGIN_INVALID_ACCOUNT;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
