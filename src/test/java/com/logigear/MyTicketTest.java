package com.logigear;

import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import models.Account;
import models.Ticket;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class MyTicketTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final MyTicketPage manageTicketPage = new MyTicketPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "User can cancel a ticket")
    public void TC016() {
        LoggerHelper.startTestCase("TC16 - User can cancel a ticket");

        int id = 1;
        String dateDepart = DataHelper.getRandomValidDepartDate();
        String departFrom = "Phan Thiết";
        String arriveAt = "Đà Nẵng";
        String seatType = "Hard seat";
        String ticketAmount = "1";
        String dateBook = DataHelper.getToday();
        String expiredDate = DataHelper.get3PlusDay();
        String status = "New";
        String totalPrice = "240000";
        Ticket bookTicket = new Ticket(dateDepart,
                departFrom,
                arriveAt,
                seatType,
                ticketAmount,
                dateBook,
                expiredDate,
                status,
                totalPrice);

        homePage.goToLoginPage();
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        loginPage.login(account);
        homePage.goToBookTicketPage();
        bookTicketPage.bookTicket(bookTicket);
        homePage.goToMyTicketPage();
        manageTicketPage.cancelSpecifiedTicket(id);

        /*String actualMsg = manageTicketPage.getErrorMessage();
        String expectedMsg = Constant.CHANGE_PASSWORD_MSG;
        Assert.assertEquals(actualMsg,expectedMsg);*/
    }
}
