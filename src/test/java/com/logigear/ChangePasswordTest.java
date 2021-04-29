package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.Log;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class ChangePasswordTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private String newPassword = "minhvip1997";

    @Description("TC01 - User can change password successful")
    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can change password successful");
        homePage.goToLoginPage();

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);

        Log.info("[STEP-2] - Change password");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(account, newPassword);

        String actualMsg = changePasswordPage.getSuccessMessage();
        String expectedMsg = Constant.CHANGE_PASSWORD_MSG;
        Assert.assertEquals(actualMsg, expectedMsg);

        Log.info("[STEP-3] - Logout");
        loginPage.logout();

        Log.info("[STEP-4] - Login with new password");
        homePage.goToLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());
    }

    @Description("TC02 - User can not change with invalid password ")
    @Test
    public void TC02() {
        Log.startTestCase("TC02 - User can not change with invalid password");
        homePage.goToLoginPage();

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Account account = new Account(Constant.USERNAME, DataHelper.generateRandomPasswordString());

        Log.info("[STEP-2] - Change password");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(account, newPassword);

        String actualMsg = changePasswordPage.getErrorMessage();
        String expectedMsg = Constant.CHANGE_PASSWORD_ERROR;
        Assert.assertEquals(actualMsg, expectedMsg);

        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }
}
