package com.logigear;

import helper.BrowserHelper;
import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class BookTicketTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final TicketPricePage ticketPricePage = new TicketPricePage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final RegisterPage registerPage = new RegisterPage();


    @Test(description = "TC14 - User can't book more than 10 tickets")
    public void TC14() {
        LoggerHelper.startTestCase("TC14 - User can't book more than 10 tickets");

        homePage.goToLoginPage();
        String departDate = DataHelper.getRandomValidDepartDate();
        String departFrom = "Sài Gòn";
        String arriveAt = "Phan Thiết";
        String seatType = "Hard seat";
        String ticketAmount = "10";
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedTicketAmountErrorMsg = "You have booked 10 tickets. You can book no more.";
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        loginPage.login(account);
        homePage.goToBookTicketPage();
        bookTicketPage.bookTicket(ticket);
        homePage.goToBookTicketPage();
        bookTicketPage.bookTicket(ticket);

        String actualErrorMsg = bookTicketPage.getErrorMessage();
        String actualTicketAmountErrorMsg = bookTicketPage.getAmountTicketErrorMessage();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message fails to display! ");
        Assert.assertEquals(actualTicketAmountErrorMsg, expectedTicketAmountErrorMsg, "Ticket amount error fails to display!");
    }

    @Test(description = "TC15 - User can open Book ticket page by click on Book ticket link in Ticket price")
    public void TC15() {
        LoggerHelper.startTestCase("TC15 - User can open Book ticket page by click on Book ticket link in Ticket price");

        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Hard seat";
        Account account = new Account(DataHelper.getRandomValidEmail(), DataHelper.getRandomValidPassword(), DataHelper.getRandomValidPid());

        homePage.goToRegisterPage();
        registerPage.register(account);
        homePage.goToLoginPage();
        loginPage.login(account);
        homePage.goToTicketPricePage();
        ticketPricePage.clickOnCheckPrice(departFrom, arriveAt);
        ticketPricePage.clickOnBookTicket(seatType);

        String actualDepartFrom = bookTicketPage.getDepartFromValue();
        String actualArriveAt = bookTicketPage.getArriveAtValue();
        String actualSeatType = bookTicketPage.getSeatTypeValue();

        Assert.assertEquals(actualDepartFrom, departFrom, "Depart from displays incorrectly!");
        Assert.assertEquals(actualArriveAt, arriveAt, "Arrive at displays incorrectly!");
        Assert.assertEquals(actualSeatType, seatType, "Seat type displays incorrectly!");
    }
}
