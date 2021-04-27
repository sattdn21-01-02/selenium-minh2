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
    private final By cbbDate = By.xpath("//select[@name='Date']");
    private final By cbbDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By cbbArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By cbbSeatType = By.xpath("//select[@name='SeatType']");
    private final By cbbTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnSubmitBookTicket = By.xpath("//input[@value='Book ticket']");

    //Element
    public Select getSelectDate() {
        return new Select(BrowserHelper.getDriver().findElement(cbbDate));
    }

    public Select getSelectDepartFrom() {
        return new Select(BrowserHelper.getDriver().findElement(cbbDepartFrom));
    }

    public Select getSelectArriveAt() {
        return new Select(BrowserHelper.getDriver().findElement(cbbArriveAt));
    }

    public List<WebElement> getAllSelectArriveAt() {
        return BrowserHelper.getDriver().findElements(cbbArriveAt);
    }

    public Select getSelectSeatType() {
        return new Select(BrowserHelper.getDriver().findElement(cbbSeatType));
    }

    public Select getSelectTicketAmount() {
        return new Select(BrowserHelper.getDriver().findElement(cbbTicketAmount));
    }

    public WebElement getBtnBookTicket() {
        return BrowserHelper.getDriver().findElement(btnSubmitBookTicket);
    }

    public void bookTicket(String date, String departFrom, String arriveAt,
                           String seatType, String ticketAmount) {
        BookTicketPage bookTicketPage = new BookTicketPage();
        Select selectDate = bookTicketPage.getSelectDate();
        selectDate.selectByVisibleText(date);
        Select selectDepart = bookTicketPage.getSelectDepartFrom();
        selectDepart.selectByVisibleText(departFrom);
        Select selectArrive = bookTicketPage.getSelectArriveAt();
        selectArrive.selectByVisibleText(arriveAt);
        Select selectSeatType = bookTicketPage.getSelectSeatType();
        selectSeatType.selectByValue(seatType);
        Select selectTicketAmount = bookTicketPage.getSelectTicketAmount();
        selectTicketAmount.selectByValue(ticketAmount);
    }

}
