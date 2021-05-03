package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.ElementHelper;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class ChangePasswordTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private final String newPassword = "minhvip1997";
    private final RegisterPage registerPage = new RegisterPage();

    @Description("TC01 - User can change password successful")
    @Test
    public void TC01() {
        LoggerHelper.startTestCase("TC01 - User can change password successful");
        String email = DataHelper.getRandomValidEmail();
        String password = DataHelper.getRandomValidPassword();
        String pid = DataHelper.getRandomValidPid();
        Account account = new Account(email, password, password, pid);

        LoggerHelper.info("[STEP-1] - Register success a valid account");
        homePage.goToRegisterPage();
        registerPage.register(account);
        homePage.goToLoginPage();

        LoggerHelper.info("[STEP-2] - Login success with valid account");
        loginPage.login(account.getEmail(), account.getPassword());

        LoggerHelper.info("[STEP-3] - Change password");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(account, newPassword);

        String actualMsg = changePasswordPage.getSuccessMessage();
        String expectedMsg = Constant.CHANGE_PASSWORD_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, actualMsg + " is not matched with " + expectedMsg);

        LoggerHelper.info("[STEP-4] - Logout");
        loginPage.logout();

        LoggerHelper.info("[STEP-5] - Login with new password");
        homePage.goToLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());
    }

    @Description("TC02 - User can not change with invalid password ")
    @Test
    public void TC02() {
        LoggerHelper.startTestCase("TC02 - User can not change with invalid password");

        String email = DataHelper.getRandomValidEmail();
        String password = DataHelper.getRandomValidPassword();
        String pid = DataHelper.getRandomValidPid();
        Account account = new Account(email, password, password, pid);

        LoggerHelper.info("[STEP-1] - Register success a valid account");
        homePage.goToRegisterPage();
        registerPage.register(account);
        homePage.goToLoginPage();


        LoggerHelper.info("[STEP-1] - Login success with valid account");
        loginPage.login(account.getEmail(), account.getPassword());


        LoggerHelper.info("[STEP-2] - Change password");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(account, Constant.BLANK_PASSWORD);

        String actualMsg = changePasswordPage.getErrorMessage();
        String expectedMsg = Constant.CHANGE_PASSWORD_ERROR;
        Assert.assertEquals(actualMsg, expectedMsg, actualMsg + " is not matched with " + expectedMsg);
    }
}
