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

    @Description("TC01 - User can log into Railway with valid username and password")
    @Test
    public void TC01() {
        LoggerHelper.startTestCase("TC01 - User can log into Railway with valid username and password");

        LoggerHelper.info("[STEP-1] - Click on login tab");
        homePage.goToLoginPage();

        LoggerHelper.info("[STEP-2] - Login success with valid account");
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        loginPage.login(account);

        LoggerHelper.info("[STEP-3] - Assert welcome message is displays");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
