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

    @Test(description = "TC02 - User can't login with blank Username textbox")
    public void TC02() {
        LoggerHelper.startTestCase("TC02 - User can't login with blank Username textbox");

        homePage.goToLoginPage();

        Account account = new Account(Constant.BLANK_EMAIL, Constant.PASSWORD);
        loginPage.login(account);

        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_LOGIN_BLANK_INFORMATION;
        Assert.assertEquals(actualMsg, expectedMsg);
  }

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        LoggerHelper.startTestCase("TC01 - User can log into Railway with valid username and password");

        homePage.goToLoginPage();

        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        loginPage.login(account);

        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
