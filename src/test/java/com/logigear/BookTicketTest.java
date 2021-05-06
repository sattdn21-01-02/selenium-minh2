package com.logigear;

import helper.BrowserHelper;
import helper.Constant;
import helper.LoggerHelper;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.TicketPricePage;

public class BookTicketTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final TicketPricePage ticketPricePage = new TicketPricePage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();


    @Test(description = "TC15 - User can open Book ticket page by click on Book ticket link in Ticket price")
    public void TC15() {
        LoggerHelper.startTestCase("TC15 - User can open Book ticket page by click on Book ticket link in Ticket price");

        homePage.goToLoginPage();
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Hard seat";

        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);

        loginPage.login(account);
        homePage.goToTicketPricePage();
        ticketPricePage.checkPrice(departFrom, arriveAt);
        ticketPricePage.bookTicket(seatType);

        BrowserHelper.scrollPage();

        String actualDepartFromMsg = bookTicketPage.getDepartFromValue();
        String actualArriveAtMsg = bookTicketPage.getArriveAtValue();
        String actualSeatTypeMsg = bookTicketPage.getSeatTypeValue();

        Assert.assertEquals(actualDepartFromMsg, departFrom, "Depart from error message fails to display!");
        Assert.assertEquals(actualArriveAtMsg, arriveAt, "Arrive at error message fails to display!");
        Assert.assertEquals(actualSeatTypeMsg, seatType, "Seat type error message fails to display!");
    }
}
