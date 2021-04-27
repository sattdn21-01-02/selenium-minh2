package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.BrowserHelper;
import helper.Constant;
import helper.Log;
import helper.Utilities;
import helper.dataprovider_helper.DataProviderHelper;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;
import models.Register;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterConfirmPage;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        homePage.goToRegisterPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEB_DRIVER.quit();
    }

    @Description("TC01 - User can register a new account Railway with valid register information")
    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can register a new account Railway with valid register information");

        Log.info("[STEP-1] - Register success with valid information");
        Register register = new Register();
        register.setEmail(Utilities.generateRandomEmailString());
        String password = Utilities.generateRandomPasswordString();
        register.setPassword(password);
        register.setConfirmPassword(password);
        register.setPid(Utilities.generateRandomPidString());
        registerPage.register(register.getEmail(),
                register.getPassword(),
                register.getConfirmPassword(),
                register.getPid());

        Log.info("[STEP-2] - Assert the  register confirm message is displays");
        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();
        String actualMsg = registerConfirmPage.getMessages();
        String expectedMsg = registerPage.getSuccessfulMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Description("TC02 - User can not register a new account Railway with invalid register information")
    @Test(dataProvider = "registerError", dataProviderClass = DataProviderHelper.class)
    public void TC02(String data) {
        Log.startTestCase("TC02 - User can not register a new account Railway with invalid register information");

        Log.info("[STEP-1] - Register with invalid information");
        BrowserHelper.scrollPage();
        String users[] = data.split(",");
        registerPage.register(users[0].toString(),
                users[1].toString(),
                users[2].toString(),
                users[3].toString());

        Log.info("[STEP-2] - Assert the error message is displays");
        String actualMsg = registerPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_REGISTER;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Description("TC03 - User can register a new account Railway with valid register information")
    @Test(dataProvider = "registerSuccessObjects", dataProviderClass = DataProviderHelper.class)
    public void TC03(Register register) {
        Log.startTestCase("TC03 - User can register a new account Railway with valid register information");

        Log.info("[STEP-1] - Register success with valid information");
        register.setEmail(Utilities.generateRandomEmailString());
        BrowserHelper.scrollPage();
        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        Log.info("[STEP-2] - Assert the  register confirm message is displays");
        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();
        String actualMsg = registerConfirmPage.getMessages();
        String expectedMsg = registerPage.getSuccessfulMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Description("TC04 - User can not register a new account Railway with invalid register information")
    @Test(dataProvider = "registerErrorObjects", dataProviderClass = DataProviderHelper.class)
    public void TC04(Register register) {
        Log.startTestCase("TC04 - User can not register a new account Railway with invalid register information");

        Log.info("[STEP-1] - Register with invalid information");
        register.setEmail(Utilities.generateRandomErrorEmailString());
        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        Log.info("[STEP-2] - Assert the error message is displays");
        String actualMsg = registerPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_REGISTER;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
