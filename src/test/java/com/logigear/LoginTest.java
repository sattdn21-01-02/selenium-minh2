package com.logigear;

import helper.Constant;
import helper.Utilities;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverManager;
import helper.web_driver_manage.DriverType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest {
    JavascriptExecutor js;
    DriverManager driverManager;
private HomePage homePage;
private LoginPage loginPage;
    @BeforeMethod
    public void beforeMethod() {
        driverManager = DriverManageFactory.getDriverManager(DriverType.CHROME);
        Constant.WEB_DRIVER = driverManager.getWebDriver();
        Constant.WEB_DRIVER.get(Constant.RAILWAY_URL);
        Constant.WEB_DRIVER.manage().window().maximize();
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.goToLoginPage();
        js = (JavascriptExecutor) Constant.WEB_DRIVER;
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEB_DRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        js.executeScript("window.scrollBy(0,250)", "");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        loginPage.logout();
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can not log into Railway with invalid username and password");
        js.executeScript("window.scrollBy(0,250)", "");

        loginPage.login(Constant.failUsernameLogin, Constant.failPasswordLogin);

        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;

        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User can not log into Railway with invalid username or password");

        js.executeScript("window.scrollBy(0,500)", "");

        loginPage.login(Constant.failUsernameLogin, Constant.PASSWORD);
        js.executeScript("window.scrollBy(0,500)", "");

        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);

    }

    @Test
    public void TC04() {
        System.out.println("TC03 - User can not log into Railway with blank username or password");

        js.executeScript("window.scrollBy(0,500)", "");

        loginPage.login("", "");
        js.executeScript("window.scrollBy(0,500)", "");
        String actualMsgUsername = loginPage.getErrorLoginUsername();
        String expectedMsg2 = Constant.INVALID_MSG_LOGIN_USERNAME;

        Assert.assertEquals(actualMsgUsername, expectedMsg2);
        String actualMsgPassword = loginPage.getErrorLoginPassword();
        String expectedMsgPassword = Constant.INVALID_MSG_LOGIN_PASSWORD;
        Assert.assertEquals(actualMsgPassword, expectedMsgPassword);
    }
}
