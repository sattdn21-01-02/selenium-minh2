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

        homePage.goToLoginPage();

        Account account = new Account(Constant.BLANK_EMAIL, Constant.PASSWORD);
        loginPage.login(account);

        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_LOGIN_BLANK_INFORMATION;
        Assert.assertEquals(actualMsg, expectedMsg, actualMsg + "is not matched with" + expectedMsg);
    }
}
