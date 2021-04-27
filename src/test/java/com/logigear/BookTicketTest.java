package com.logigear;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import helper.BrowserHelper;
import helper.Constant;
import helper.DataHelper;
import helper.Log;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverManager;
import helper.web_driver_manage.DriverType;
import models.BookTicket;
import models.Login;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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


public class BookTicketTest extends BaseTest{

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
    @Test(dataProvider = "bookSuccess")
    public void TC01(BookTicket book) {
        Log.startTestCase("TC01 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        book.setDepartDate(DataHelper.getDepartDateRandom());
        Log.info("[STEP-2] - Book Ticket");
        bookTicketPage.bookTicket(book.getDepartDate(),
                book.getDepartFrom(),
                book.getArriveAt(),
                book.getSeatType(),
                book.getTicketAmount());

        Log.info("[STEP-3] - Assert information book ticket");
        Assert.assertEquals(book.toString(),successPage.getInformationBookTicket());
        loginPage.logout();
    }
    @Description("TC02 - User can not book over 10 ticket into Railway with valid information")
    @Test(dataProvider = "bookError")
    public void TC02(BookTicket book) {
        Log.startTestCase("TC02 - User can not book over 10 ticket into Railway with valid information");

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        book.setDepartDate(DataHelper.getDepartDateRandom());
        Log.info("[STEP-2] - Book Ticket");
        bookTicketPage.bookTicket(book.getDepartDate(),
                book.getDepartFrom(),
                book.getArriveAt(),
                book.getSeatType(),
                book.getTicketAmount());

        Log.info("[STEP-3] - Assert information book ticket");
        Assert.assertEquals(book.toString(),successPage.getInformationBookTicket());
        loginPage.logout();
    }


    @DataProvider(name = "bookSuccess")
    public Object[] readJsonObjectBookSuccess() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader("src/test/resources/book-ticket-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<BookTicket> bookTickets = Arrays.asList(objectMapper.treeToValue(jsonNode.get("book_success"), BookTicket[].class));
        return bookTickets.toArray();
    }

    @DataProvider(name = "bookError")
    public Object[] readJsonObjectBookError() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader("src/test/resources/book-ticket-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<BookTicket> bookTickets = Arrays.asList(objectMapper.treeToValue(jsonNode.get("book_error"), BookTicket[].class));
        return bookTickets.toArray();
    }
}

