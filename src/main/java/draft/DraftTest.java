package draft;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DraftTest {
    private HomePage homePage;
    private BookTicketPage bookTicketPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage();
        bookTicketPage = new BookTicketPage();
        loginPage = new LoginPage();
        homePage.goToBookTicketPage();

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
    }

    @Description("TC01 - User can book ticket into Railway with valid information")
    @org.testng.annotations.Test(dataProvider = "bookSuccess")
    public void TC01(Ticket book) {
        LoggerHelper.startTestCase("TC01 - User can log into Railway with valid username and password");

        LoggerHelper.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        book.setDepartDate(DataHelper.getRandomValidDepartDate());
        LoggerHelper.info("[STEP-2] - Book Ticket");
        bookTicketPage.bookTicket(book);

        LoggerHelper.info("[STEP-3] - Assert information book ticket");
        loginPage.logout();
    }
    @Description("TC02 - User can not book over 10 ticket into Railway with valid information")
    @org.testng.annotations.Test(dataProvider = "bookError")
    public void TC02(Ticket book) {
        LoggerHelper.startTestCase("TC02 - User can not book over 10 ticket into Railway with valid information");

        LoggerHelper.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        book.setDepartDate(DataHelper.getRandomValidDepartDate());
        LoggerHelper.info("[STEP-2] - Book Ticket");
        bookTicketPage.bookTicket(book);

        LoggerHelper.info("[STEP-3] - Assert information book ticket");

        loginPage.logout();
    }


    @DataProvider(name = "bookSuccess")
    public Object[] readJsonObjectBookSuccess() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader("src/test/resources/book-ticket-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<Ticket> bookTickets = Arrays.asList(objectMapper.treeToValue(jsonNode.get("book_success"), Ticket[].class));
        return bookTickets.toArray();
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
