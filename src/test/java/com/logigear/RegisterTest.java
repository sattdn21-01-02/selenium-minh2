package com.logigear;

import helper.Constant;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class RegisterTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeMethod
    public void beforeMethod() {
        Constant.DRIVER_MANAGER = DriverManageFactory.getDriverManager(DriverType.CHROME);
        Constant.WEB_DRIVER = Constant.DRIVER_MANAGER.getWebDriver();
        Constant.WEB_DRIVER.get(Constant.RAILWAY_URL);
        Constant.WEB_DRIVER.manage().window().maximize();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        homePage.goToRegisterPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEB_DRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can register a new account Railway with valid register information");
        registerPage.scrollPage();
        registerPage.register(Constant.REGISTER_EMAIL, Constant.REGISTER_PASSWORD, Constant.REGISTER_PID);
        String actualMsg = registerPage.getSuccessfulMessage();
        String expectedMsg = "Welcome " + Constant.REGISTER_EMAIL;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        registerPage.logout();
    }

    @Test
    public void TC02() {
        System.out.println("TC01 - User can not register a new account Railway with invalid register information");
        registerPage.register(Constant.failEmailRegister,
                Constant.failPasswordRegister,
                Constant.failPidRegister);
        String actualMsg = registerPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_REGISTER;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void TC03() {
        System.out.println("TC03- User can not register a new account Railway with invalid register information email");
        registerPage.scrollPage();
        registerPage.register(Constant.failEmailRegister,
                Constant.REGISTER_PASSWORD,
                Constant.REGISTER_PID);
        String actualMsg = registerPage.getEmailErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_REGISTER_EMAIL;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
