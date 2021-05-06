package com.logigear;

import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class MyTicketTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can cancel a ticket")
    public void TC016() {
        LoggerHelper.startTestCase("TC16 - User can cancel a ticket");

        String dateDepart = DataHelper.getRandomValidDepartDate();
        String departFrom = "Phan Thiết";
        String arriveAt = "Đà Nẵng";
        String seatType = "Hard seat";
        String ticketAmount = "1";
        Account account = new Account(DataHelper.getRandomValidEmail(), DataHelper.getRandomValidPassword(), DataHelper.getRandomValidPid());
        homePage.goToRegisterPage();
        registerPage.register(account);
        Ticket bookTicket = new Ticket(dateDepart, departFrom, arriveAt, seatType, ticketAmount);

        homePage.goToLoginPage();
        loginPage.login(account);
        homePage.goToBookTicketPage();
        bookTicketPage.bookTicket(bookTicket);
        homePage.goToMyTicketPage();
        myTicketPage.deleteTicket();

        Assert.assertFalse(myTicketPage.isTicketDisplayed(), "Ticket is deleted unsuccessfully!");
    }
}
