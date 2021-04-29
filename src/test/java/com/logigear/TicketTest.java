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
    private String msgExpectedArriveStation = "Arrive Station is not displayed as expected";
    private String msgExpectedDepartStation = "Depart Station is not displayed as expected";
    private String msgExpectedDateDepart = "Depart Date is not displayed as expected";
    private String msgExpectedSeatType = "Seat Type is not displayed as expected";
    private String msgExpectedTicketAmount = "Amount is not displayed as expected";
    private String msgExpectedDateBook = "Book Date is not displayed as expected";
    private String msgExpectedExpiredDate = "Expired Date is not displayed as expected";
    private String msgExpectedTotalPrice = "Total Price is not displayed as expected";

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
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_ARRIVE_STATION), bookTicket.getArriveAt(), msgExpectedArriveStation);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_DEPART_STATION), bookTicket.getDepartFrom(), msgExpectedDepartStation);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_SEAT_TYPE), bookTicket.getSeatType(), msgExpectedSeatType);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_DEPART_DATE), bookTicket.getDepartDate(), msgExpectedDateDepart);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_BOOK_DATE), bookTicket.getBookDate(), msgExpectedDateBook);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_EXPIRED_DATE), bookTicket.getExpiredDate(), msgExpectedExpiredDate);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_AMOUNT), bookTicket.getTicketAmount(), msgExpectedTicketAmount);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_TOTAL_PRICE), bookTicket.getTotalPrice(), msgExpectedTotalPrice);
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

        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_ARRIVE_STATION), book.getArriveAt(), msgExpectedArriveStation);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_DEPART_STATION), book.getDepartFrom(), msgExpectedDepartStation);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_SEAT_TYPE), book.getSeatType(), msgExpectedSeatType);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_DEPART_DATE), book.getDepartDate(), msgExpectedDateDepart);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_BOOK_DATE), book.getBookDate(), msgExpectedDateBook);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_EXPIRED_DATE), book.getExpiredDate(), msgExpectedExpiredDate);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_AMOUNT), book.getTicketAmount(), msgExpectedTicketAmount);
        Assert.assertEquals(bookTicketPage.getTextByHead(Constant.HEADER_TOTAL_PRICE), book.getTotalPrice(), msgExpectedTotalPrice);
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

