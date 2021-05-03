package com.logigear;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
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

    private final HomePage homePage = new HomePage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final LoginPage loginPage = new LoginPage();

    @Description("TC01 - User can book ticket into Railway with valid information")
    @Test()
    public void TC01() {
        LoggerHelper.startTestCase("TC01 - User can book ticket into Railway with valid information");
        homePage.goToBookTicketPage();
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

        LoggerHelper.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        LoggerHelper.info("[STEP-2] - Book Ticket");
        bookTicketPage.bookTicket(bookTicket);

        LoggerHelper.info("[STEP-3] - Assert information book ticket");
        Assert.assertEquals(bookTicketPage.getTableCellValue(Constant.HEADER_ARRIVE_STATION), bookTicket.getArriveAt(), "Arrive Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue(Constant.HEADER_DEPART_STATION), bookTicket.getDepartFrom(), "Depart Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue(Constant.HEADER_SEAT_TYPE), bookTicket.getSeatType(), "Seat Type is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue(Constant.HEADER_DEPART_DATE), bookTicket.getDepartDate(), "Depart Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue(Constant.HEADER_BOOK_DATE), bookTicket.getBookDate(), "Book Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue(Constant.HEADER_EXPIRED_DATE), bookTicket.getExpiredDate(), "Expired Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue(Constant.HEADER_AMOUNT), bookTicket.getTicketAmount(), "Amount is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue(Constant.HEADER_TOTAL_PRICE), bookTicket.getTotalPrice(), "Total Price is not displayed as expected");
    }

}

