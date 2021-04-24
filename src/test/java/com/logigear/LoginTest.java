package com.logigear;

import helper.Constant;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        Constant.DRIVER_MANAGER = DriverManageFactory.getDriverManager(DriverType.CHROME);
        Constant.WEB_DRIVER = Constant.DRIVER_MANAGER.getWebDriver();
        Constant.WEB_DRIVER.get(Constant.RAILWAY_URL);
        Constant.WEB_DRIVER.manage().window().maximize();
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.goToLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEB_DRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        loginPage.scrollPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.scrollPage();
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        loginPage.logout();
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can not log into Railway with invalid username and password");
        loginPage.scrollPage();

        loginPage.login(Constant.failUsernameLogin, Constant.failPasswordLogin);
        loginPage.scrollPage();
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User can not log into Railway with invalid username or password");

        loginPage.scrollPage();

        loginPage.login(Constant.failUsernameLogin, Constant.PASSWORD);
        loginPage.scrollPage();

        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);

    }

    @Test
    public void TC04() {
        System.out.println("TC03 - User can not log into Railway with blank username or password");

        loginPage.scrollPage();

        loginPage.login("", "");
        loginPage.scrollPage();
        String actualMsgUsername = loginPage.getEmailErrorMessage();
        String expectedMsg2 = Constant.INVALID_MSG_LOGIN_USERNAME;

        Assert.assertEquals(actualMsgUsername, expectedMsg2);
        String actualMsgPassword = loginPage.getPasswordErrorMessage();
        String expectedMsgPassword = Constant.INVALID_MSG_LOGIN_PASSWORD;
        Assert.assertEquals(actualMsgPassword, expectedMsgPassword);
    }
}
