package com.logigear;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.Log;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class TicketTest extends BaseTest {

    private HomePage homePage;
    private BookTicketPage bookTicketPage;
    private LoginPage loginPage;
    private SuccessPage successPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage();
        bookTicketPage = new BookTicketPage();
        loginPage = new LoginPage();
        homePage.goToBookTicketPage();
        successPage = new SuccessPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
    }

    @Description("TC01 - User can book ticket into Railway with valid information")
    @Test()
    public void TC01() {
        Log.startTestCase("TC01 - User can log into Railway with valid username and password");

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
        Assert.assertEquals(bookTicket.toString(), successPage.getInformationBookTicket());
        loginPage.logout();
    }

    @Description("TC02 - User can not book over 10 ticket into Railway with valid information")
    @Test(dataProvider = "bookError")
    public void TC02(Ticket book) {
        Log.startTestCase("TC02 - User can not book over 10 ticket into Railway with valid information");

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        book.setDepartDate(DataHelper.getDepartDateRandom());
        Log.info("[STEP-2] - Book Ticket");
        bookTicketPage.bookTicket(book);

        Log.info("[STEP-3] - Assert information book ticket");

        Assert.assertEquals(book.getArriveAt(), successPage.getValueArriveStation());
        Assert.assertEquals(book.getDepartDate(),successPage.getValueDepartDate());
        Assert.assertEquals(book.getDepartFrom(),successPage.getValueDepartStation());
        Assert.assertEquals(book.getSeatType(),successPage.getValueSeatType());
        Assert.assertEquals(book.getTicketAmount(),successPage.getValueAmount());
        Assert.assertEquals(book.getBookDate(),successPage.getBookDate());
        Assert.assertEquals(book.getExpiredDate(),successPage.getValueExpiredDate());
        Assert.assertEquals(book.getTotalPrice(),successPage.getTotalPrice());
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

