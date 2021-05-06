package com.logigear;

import helper.Constant;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        LoggerHelper.startTestCase("TC01 - User can't create account while password and PID fields are empty");

        String blankPassword = "";
        String blankPid = "";
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedErrorPasswordMsg = "Invalid password length";
        String expectedErrorPidMsg = "Invalid ID length";

        homePage.goToRegisterPage();
        Account account = new Account(Constant.USERNAME, blankPassword, blankPid);
        registerPage.register(account);

        String actualErrorMsg = registerPage.getGeneralErrorMessage();
        String actualErrorPasswordMsg = registerPage.getPasswordErrorMessage();
        String actualErrorPidMsg = registerPage.getPidErrorMessage();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message fails to display! ");
        Assert.assertEquals(actualErrorPasswordMsg, expectedErrorPasswordMsg, "Error password message fails to display!");
        Assert.assertEquals(actualErrorPidMsg, expectedErrorPidMsg, "Error pid message fails to display!");
    }

}
