package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
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


    @Description("TC07 - User can create new account")
    @Test
    public void TC07() {
        LoggerHelper.startTestCase("TC07 - User can create new account");
        homePage.goToRegisterPage();

        String password = DataHelper.getRandomValidPassword();
        Account account = new Account(DataHelper.getRandomValidEmail(),
                password, DataHelper.getRandomValidPid());
        registerPage.register(account);

        String actualMsg = Constant.REGISTER_CONFIRM_MSG;
        String expectedMsg = registerPage.getSuccessfulMessage();
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
