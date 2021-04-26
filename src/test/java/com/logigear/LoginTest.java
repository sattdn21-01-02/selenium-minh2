package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.Faker_helper.LoginFakerAPI;
import helper.Log;
import helper.dataprovider_helper.DataProviderHelper;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;
import models.Login;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest {

    private HomePage homePage;
    private LoginPage loginPage;
    LoginFakerAPI jf = new LoginFakerAPI();

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

    @Description("TC01 - User can log into Railway with valid username and password")
    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.scrollPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.scrollPage();

        Log.info("[STEP-2] - Assert welcome message is displays");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }

    @Description("TC04 - User can not log into Railway with blank username or password")
    @Test
    public void TC04() {
        Log.startTestCase("TC04 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login fail with invalid account");
        loginPage.scrollPage();
        loginPage.login("", "");
        loginPage.scrollPage();

        Log.info("[STEP-2] - Assert login error message email is displays");
        String actualMsgUsername = loginPage.getEmailErrorMessage();
        String expectedMsg2 = Constant.INVALID_MSG_LOGIN_USERNAME;
        Assert.assertEquals(actualMsgUsername, expectedMsg2);

        Log.info("[STEP-3] - Assert login error message password is displays");
        String actualMsgPassword = loginPage.getPasswordErrorMessage();
        String expectedMsgPassword = Constant.INVALID_MSG_LOGIN_PASSWORD;
        Assert.assertEquals(actualMsgPassword, expectedMsgPassword);
    }

    @Description("TC05 - User can log into Railway with valid username and password")
    @Test(dataProvider = "login_success", dataProviderClass = DataProviderHelper.class)
    public void TC05(String data) {
        Log.startTestCase("5 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login success with valid account");
        String users[] = data.split(",");
        loginPage.scrollPage();
        loginPage.login(users[0], users[1]);
        loginPage.scrollPage();

        Log.info("[STEP-2] - Assert welcome message is displays");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + users[0].toString();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }

    @Description("TC06 - User can not log into Railway with invalid username or password")
    @Test(dataProvider = "login_error", dataProviderClass = DataProviderHelper.class)
    public void TC06(String data) {
        Log.startTestCase("TC06 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login fail with invalid account");
        String users[] = data.split(",");
        loginPage.scrollPage();
        loginPage.login(users[0], users[1]);
        loginPage.scrollPage();

        Log.info("[STEP-2] - Assert login error message email is displays");
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);

    }

    @Description("TC07 - User can log into Railway with valid username and password")
    @Test(dataProvider = "login_success_objects", dataProviderClass = DataProviderHelper.class)
    public void TC07(Login login) {
        Log.startTestCase("TC07 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.scrollPage();
        loginPage.login(login.getEmail(), login.getPassword());
        loginPage.scrollPage();

        Log.info("[STEP-2] - Assert welcome message is displays");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + login.getEmail();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }

    @Description("TC08 - User can not log into Railway with valid username and password")
    @Test(dataProvider = "login_error_objects", dataProviderClass = DataProviderHelper.class)
    public void TC08(Login login) {
        Log.startTestCase("TC08 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login fail with invalid account");
        loginPage.scrollPage();
        loginPage.login(login.getEmail(), login.getPassword());
        loginPage.scrollPage();

        Log.info("[STEP-2] - Assert login error message email is displays");
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Description("TC09 - User can not log into Railway with valid username and password")
    @Test
    public void TC09() {
        Log.startTestCase("TC09 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login fail with invalid account");
        loginPage.scrollPage();
        loginPage.login(jf.getEmail(), jf.getPassword());
        loginPage.scrollPage();

        Log.info("[STEP-2] - Assert login error message email is displays");
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
