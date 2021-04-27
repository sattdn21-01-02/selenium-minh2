package page_objects;

import helper.BrowserHelper;
import helper.Constant;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookTicketPage extends GeneralPage {

    //Locator
    private final By selectDate = By.xpath("//select[@name='Date']");
    private final By cbbDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By selectArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By selectSeatType = By.xpath("//select[@name='SeatType']");
    private final By selectTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnSubmitBookTicket = By.xpath("//input[@value='Book ticket']");

    //Element
    public WebElement getSelectDate() {
        return BrowserHelper.getDriver().findElement(selectDate);
    }

    public Select getSelectDepartFrom() {
        return new Select(BrowserHelper.getDriver().findElement(cbbDepartFrom));
    }

    public WebElement getSelectArriveAt() {
        return BrowserHelper.getDriver().findElement(selectArriveAt);
    }

    public List<WebElement> getAllSelectArriveAt() {
        return BrowserHelper.getDriver().findElements(selectArriveAt);
    }

    public WebElement getSelectSeatType() {
        return BrowserHelper.getDriver().findElement(selectSeatType);
    }

    public WebElement getSelectTicketAmount() {
        return BrowserHelper.getDriver().findElement(selectTicketAmount);
    }

    public WebElement getBtnBookTicket() {
        return BrowserHelper.getDriver().findElement(btnSubmitBookTicket);
    }

    public void bookTicket(String date, String departFrom, String arriveAt,
                           String seatType, String ticketAmount) {
        BookTicketPage bookTicketPage = new BookTicketPage();
        Select selectDate = new Select(bookTicketPage.getSelectDate());
        selectDate.selectByVisibleText(date);
        //Select selectDepart = new Select(bookTicketPage.getSelectDepartFrom());
        //getSelectDepartFrom().select
        //selectDepart.selectByValue(departFrom);
        //selectArriveAt.select(arriveAt);
        Select selectSeatType = new Select(bookTicketPage.getSelectSeatType());
        selectSeatType.selectByValue(seatType);
        Select selectTicketAmount = new Select(bookTicketPage.getSelectTicketAmount());
        selectTicketAmount.selectByValue(ticketAmount);
    }

}
