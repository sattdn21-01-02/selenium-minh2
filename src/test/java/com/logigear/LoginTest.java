package com.logigear;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();


    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        LoggerHelper.startTestCase("TC01 - User can log into Railway with valid username and password");

        homePage.goToLoginPage();

        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        loginPage.login(account);

        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message fails to display!");
    }

    @Test(description = "TC02 - User can't login with blank Username textbox")
    public void TC02() {
        LoggerHelper.startTestCase("TC02 - User can't login with blank Username textbox");
        String blankEmail = "";
        homePage.goToLoginPage();

        Account account = new Account(blankEmail, Constant.PASSWORD);
        loginPage.login(account);

        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_BLANK_ACCOUNT_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message fails to display!");
    }

    @Test(description = "TC03 - User cannot log into Railway with invalid password ")
    public void TC03() {
        LoggerHelper.startTestCase("TC03 - User cannot log into Railway with invalid password ");

        homePage.goToLoginPage();

        Account account = new Account(Constant.USERNAME, DataHelper.getRandomErrorPassword());
        loginPage.login(account);

        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_ACCOUNT_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message fails to display!");
    }

    @Test(description = "TC05 - System shows message when user enters wrong password several times ")
    public void TC05() {
        LoggerHelper.startTestCase("TC05 - System shows message when user enters wrong password several times ");

        Account account = new Account(Constant.USERNAME, DataHelper.getRandomErrorPassword());
        int nTimes = 5;
        homePage.goToLoginPage();
        loginPage.loginNTimes(account, nTimes);

        String actualMsg = loginPage.getGeneralErrorMessage();
        Assert.assertEquals(actualMsg, Constant.MAXIMUM_LOGIN_ATTEMPTS_WARNING_MSG, "Error message fails to display!");
    }

}
