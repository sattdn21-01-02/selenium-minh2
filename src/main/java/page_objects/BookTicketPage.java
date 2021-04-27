package page_objects;

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
        return Constant.WEB_DRIVER.findElement(selectDate);
    }

    public Select getSelectDepartFrom() {
        return new Select(Constant.WEB_DRIVER.findElement(cbbDepartFrom));
    }

    public WebElement getSelectArriveAt() {
        return Constant.WEB_DRIVER.findElement(selectArriveAt);
    }

    public List<WebElement> getAllSelectArriveAt() {
        return Constant.WEB_DRIVER.findElements(selectArriveAt);
    }

    public WebElement getSelectSeatType() {
        return Constant.WEB_DRIVER.findElement(selectSeatType);
    }

    public WebElement getSelectTicketAmount() {
        return Constant.WEB_DRIVER.findElement(selectTicketAmount);
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEB_DRIVER.findElement(btnSubmitBookTicket);
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
