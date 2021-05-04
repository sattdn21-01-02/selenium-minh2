package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class LoginTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();

    @Description("TC06 - Additional pages display once user logged in")
    @Test
    public void TC06() {
        LoggerHelper.startTestCase("TC03 - Additional pages display once user logged in");

        homePage.goToLoginPage();
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        loginPage.login(account);

        homePage.goToMyTicketPage();
        String actualMsgMyTicketPage = myTicketPage.getMyTicketTitle();
        String expectedMsgMyTicketPage = Constant.MY_TICKET_TITLE;
        Assert.assertEquals(actualMsgMyTicketPage, expectedMsgMyTicketPage);

        homePage.goToChangePasswordPage();
        String actualMsgChangePasswordPage = changePasswordPage.getChangePasswordTitle();
        String expectedMsgChangePasswordPage = Constant.CHANGE_PASSWORD_TITLE;
        Assert.assertEquals(actualMsgChangePasswordPage, expectedMsgChangePasswordPage);

        homePage.logout();
    }
}
