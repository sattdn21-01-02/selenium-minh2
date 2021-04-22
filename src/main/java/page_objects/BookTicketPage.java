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
    private final By selectDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By selectArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By selectSeatType = By.xpath("//select[@name='SeatType']");
    private final By selectTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnSubmitBookTicket = By.xpath("//input[@value='Book ticket']");

    //Element
    public WebElement getSelectDate() {
        return Constant.WEBDRIVER.findElement(selectDate);
    }

    public WebElement getSelectDepartFrom() {
        return Constant.WEBDRIVER.findElement(selectDepartFrom);
    }

    public WebElement getSelectArriveAt() {
        return Constant.WEBDRIVER.findElement(selectArriveAt);
    }

    public List<WebElement> getAllSelectArriveAt() {
        return Constant.WEBDRIVER.findElements(selectArriveAt);
    }

    public WebElement getSelectSeatType() {
        return Constant.WEBDRIVER.findElement(selectSeatType);
    }

    public WebElement getSelectTicketAmount() {
        return Constant.WEBDRIVER.findElement(selectTicketAmount);
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnSubmitBookTicket);
    }

    public void bookTicket(String date, String departFrom, String arriveAt,
                           String seatType, String ticketAmount) {
        BookTicketPage bookTicketPage = new BookTicketPage();
        Select selectDate = new Select(bookTicketPage.getSelectDate());
        selectDate.selectByVisibleText(date);
        // selectDate.selectByValue(date);
        Select selectDepart = new Select(bookTicketPage.getSelectDepartFrom());
        selectDepart.selectByValue(departFrom);
        List<WebElement> arrives = this.getAllSelectArriveAt();
        for (WebElement arrive : arrives) {
            if (!arrive.isSelected()) arrive.click();

        }
        Select selectSeatType = new Select(bookTicketPage.getSelectSeatType());
        selectSeatType.selectByValue(seatType);
        Select selectTicketAmount = new Select(bookTicketPage.getSelectTicketAmount());
        selectTicketAmount.selectByValue(ticketAmount);
    }


    public void chooseArrive(String depart) {
        String arrive = "";
        switch (depart) {
            case "1":
                arrive = "";
                break;
        }
    }


}
