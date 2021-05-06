package com.logigear;

import helper.DataHelper;
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
}
