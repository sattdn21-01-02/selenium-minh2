package com.logigear;

import helper.Constant;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();


    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        LoggerHelper.startTestCase("TC07 - User can create new account");

        homePage.goToRegisterPage();
        Account account = new Account();
        registerPage.register(account);

        String actualMsg = registerPage.getSuccessfulMessage();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message fails to display!");
    }

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        LoggerHelper.startTestCase("TC11 - User can't create account while password and PID fields are empty");

        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedPasswordErrorMsg = "Invalid password length";
        String expectedErrorPidMsg = "Invalid ID length";

        homePage.goToRegisterPage();
        Account account = new Account(Constant.USERNAME, "", "");
        registerPage.register(account);

        String actualErrorMsg = registerPage.getGeneralErrorMessage();
        String actualPasswordErrorMsg = registerPage.getPasswordErrorMessage();
        String actualPidErrorMsg = registerPage.getPidErrorMessage();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message fails to display! ");
        Assert.assertEquals(actualPasswordErrorMsg, expectedPasswordErrorMsg, "Error password message fails to display!");
        Assert.assertEquals(actualPidErrorMsg, expectedErrorPidMsg, "Error pid message fails to display!");
    }
}
