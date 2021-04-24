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
import page_objects.RegisterPage;

public class RegisterTest {
    JavascriptExecutor js;
    DriverManager driverManager;
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driverManager = DriverManageFactory.getDriverManager(DriverType.CHROME);
        Constant.WEB_DRIVER = driverManager.getWebDriver();
        Constant.WEB_DRIVER.get(Constant.RAILWAY_URL);
        Constant.WEB_DRIVER.manage().window().maximize();
        js = (JavascriptExecutor) Constant.WEB_DRIVER;
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEB_DRIVER.quit();
    }

    @Test
    public void TC01() {
        /*System.out.println("TC01 - User can register a new account Railway with valid register information");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        js.executeScript("window.scrollBy(0,500)", "");
        registerPage.register(Constant.REGISTER_EMAIL, Constant.REGISTER_PASSWORD, Constant.REGISTER_CONFIRM_PASSWORD, Constant.REGISTER_PID);
        String actualMsg = homePage.getMessageRegisterConfirmed();
        String expectedMsg = Constant.REGISTER_CONFIRM_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        //loginPage.gotoLogoutPage();*/
    }

    @Test
    public void TC02() {
        /*System.out.println("TC01 - User can not register a new account Railway with invalid register information");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        js.executeScript("window.scrollBy(0,500)", "");
        registerPage.register(Constant.failEmailRegister,
                Constant.failPasswordRegister,
                Constant.failConfirmPasswordRegister,
                Constant.failPidRegister);
        String actualMsg = registerPage.getErrorMsgRegister();
        String expectedMsg = Constant.FAIL_MSG_REGISTER;
        Assert.assertEquals(actualMsg, expectedMsg);*/
    }

    @Test
    public void TC03() {
        /*System.out.println("TC03- User can not register a new account Railway with invalid register information email");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        js.executeScript("window.scrollBy(0,500)", "");
        registerPage.register(Constant.failEmailRegister,
                Constant.REGISTER_PASSWORD,
                Constant.REGISTER_CONFIRM_PASSWORD,
                Constant.REGISTER_PID);
        String actualMsg = registerPage.getErrorMsgRegisterEmail();
        String expectedMsg = Constant.INVALID_MSG_REGISTER_EMAIL;
        Assert.assertEquals(actualMsg, expectedMsg);*/
    }
}
