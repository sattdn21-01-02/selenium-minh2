package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.LoggerHelper;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.ManageTicketPage;

public class ManageTicketTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final ManageTicketPage manageTicketPage = new ManageTicketPage();

    @Description("TC02 - User can cancel 1 specified ticket successful")
    @Test
    public void TC01() {
        LoggerHelper.startTestCase("TC02 - User can cancel 1 specified ticket successful");
        homePage.goToLoginPage();
        int id = 1;
        LoggerHelper.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LoggerHelper.info("[STEP-2] - Cancel ticket");
        homePage.goToMyTicketPage();
        manageTicketPage.cancelSpecifiedTicket(id);

        /*String actualMsg = manageTicketPage.getErrorMessage();
        String expectedMsg = Constant.CHANGE_PASSWORD_MSG;
        Assert.assertEquals(actualMsg,expectedMsg);*/
    }

    @Description("TC01 - User can cancel all ticket successful")
    @Test
    public void TC02() {
        LoggerHelper.startTestCase("TC01 - User can cancel all ticket successful");
        homePage.goToLoginPage();

        LoggerHelper.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LoggerHelper.info("[STEP-2] - Cancel ticket");
        homePage.goToMyTicketPage();
        manageTicketPage.cancelAllTicket();

        /*String actualMsg = manageTicketPage.getErrorMessage();
        String expectedMsg = Constant.CHANGE_PASSWORD_MSG;
        Assert.assertEquals(actualMsg,expectedMsg);*/
    }


}
