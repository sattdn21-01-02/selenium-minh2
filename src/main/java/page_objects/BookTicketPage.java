package page_objects;

import helper.BrowserHelper;
import helper.Constant;
import helper.element_helper.Dropdown;
import helper.element_helper.Label;
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
import java.util.concurrent.TimeUnit;

public class BookTicketPage extends GeneralPage {

    //Locator
    private final Dropdown ddlDepartDate = new Dropdown(By.xpath("//select[@name='Date']"));
    private final Dropdown ddlDepartFrom = new Dropdown(By.xpath("//select[@name='DepartStation']"));
    private final Dropdown ddlArriveAt = new Dropdown(By.xpath("//select[@name='ArriveStation']"));
    private final Dropdown ddlSeatType = new Dropdown(By.xpath("//select[@name='SeatType']"));
    private final Dropdown ddlTicketAmount = new Dropdown(By.xpath("//select[@name='TicketAmount']"));
    private final Dropdown ddlSubmitBookTicket = new Dropdown(By.xpath("//input[@value='Book ticket']"));
    private final Label lblErrorMessage = new Label(By.cssSelector(".message"));
    private final Label lblErrorMessageAmount = new Label(By.cssSelector(".validation-error"));

    //Method
    public void bookTicket(String date, String departFrom, String arriveAt,
                           String seatType, String ticketAmount) {
        BrowserHelper.scrollPage();
        this.ddlDepartDate.selectDropDownText(date);
        this.ddlDepartFrom.selectDropDownText(departFrom);
        BrowserHelper.waitForElement(BrowserHelper.getDriver(),ddlArriveAt.findElement(),20).click();
        this.ddlArriveAt.selectDropDownText(arriveAt);
        this.ddlSeatType.selectDropDownText(seatType);
        this.ddlTicketAmount.selectDropDownText(ticketAmount);
        BrowserHelper.scrollPage();
        this.ddlSubmitBookTicket.click();
    }

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }

}
