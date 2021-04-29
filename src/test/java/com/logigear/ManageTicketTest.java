package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.ManageTicketPage;

public class ManageTicketTest extends BaseTest{

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ManageTicketPage manageTicketPage = new ManageTicketPage();

    @Description("TC01 - User can cancel all ticket successful")
    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can cancel all ticket successful");
        homePage.goToLoginPage();

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Log.info("[STEP-2] - Change password");
        homePage.goToMyTicketPage();
        manageTicketPage.cancelAllTicket();

        String actualMsg = manageTicketPage.getErrorMessage();
        String expectedMsg = Constant.CHANGE_PASSWORD_MSG;
        Assert.assertEquals(actualMsg,expectedMsg);
        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }
}
