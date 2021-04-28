package com.logigear;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.Log;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class TicketTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private LoginPage loginPage = new LoginPage();

    @Description("TC01 - User can book ticket into Railway with valid information")
    @Test()
    public void TC01() {
        Log.startTestCase("TC01 - User can log into Railway with valid username and password");
        homePage.goToBookTicketPage();
        String dateDepart = DataHelper.getDepartDateRandom();
        String departFrom = "Phan Thiết";
        String arriveAt = "Đà Nẵng";
        String seatType = "Hard seat";
        String ticketAmount = "1";
        String dateBook = DataHelper.getBookDate();
        String expiredDate = DataHelper.getExpiredDate();
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

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Log.info("[STEP-2] - Book Ticket");
        bookTicketPage.bookTicket(bookTicket);

        Log.info("[STEP-3] - Assert information book ticket");
        Assert.assertEquals(bookTicketPage.getTextByHead("Arrive Station"), bookTicket.getArriveAt(), "Arrive Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Depart Station"), bookTicket.getDepartFrom(), "Depart Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Seat Type"), bookTicket.getSeatType(), "Seat Type is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Depart Date"), bookTicket.getDepartDate(), "Depart Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Book Date"), bookTicket.getBookDate(), "Book Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Expired Date"), bookTicket.getExpiredDate(), "Expired Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Amount"), bookTicket.getTicketAmount(), "Amount is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Total Price"), bookTicket.getTotalPrice(), "Total Price is not displayed as expected");
        loginPage.logout();
    }

    @Description("TC02 - User can not book over 10 ticket into Railway with valid information")
    @Test(dataProvider = "bookError")
    public void TC02(Ticket book) {
        Log.startTestCase("TC02 - User can not book over 10 ticket into Railway with valid information");
        homePage.goToBookTicketPage();
        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        book.setDepartDate(DataHelper.getDepartDateRandom());
        Log.info("[STEP-2] - Book Ticket");
        bookTicketPage.bookTicket(book);

        Log.info("[STEP-3] - Assert information book ticket");

        Assert.assertEquals(bookTicketPage.getTextByHead("Arrive Station"), book.getArriveAt(), "Arrive Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Depart Station"), book.getDepartFrom(), "Depart Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Seat Type"), book.getSeatType(), "Seat Type is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Depart Date"), book.getDepartDate(), "Depart Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Book Date"), book.getBookDate(), "Book Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Expired Date"), book.getExpiredDate(), "Expired Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Amount"), book.getTicketAmount(), "Amount is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTextByHead("Total Price"), book.getTotalPrice(), "Total Price is not displayed as expected");
        loginPage.logout();
    }


    @DataProvider(name = "bookError")
    public Object[] readJsonObjectBookError() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader("src/test/resources/book-ticket-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<Ticket> bookTickets = Arrays.asList(objectMapper.treeToValue(jsonNode.get("book_error"), Ticket[].class));
        return bookTickets.toArray();
    }
}

