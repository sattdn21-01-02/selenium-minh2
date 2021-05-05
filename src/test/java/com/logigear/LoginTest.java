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
import page_objects.RegisterPage;

public class LoginTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();

    @Description("TC08 - User can't login with an account hasn't been activated")
    @Test
    public void TC08() {
        LoggerHelper.startTestCase("TC01 - User can't login with an account hasn't been activated");

        homePage.goToRegisterPage();
        Account account = new Account(DataHelper.getRandomValidEmail(), DataHelper.getRandomValidPassword(), DataHelper.getRandomValidPid());
        registerPage.setInfoAccount(account);

        homePage.goToLoginPage();
        loginPage.login(account);

        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
