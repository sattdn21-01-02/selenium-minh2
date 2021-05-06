package page_objects;

import helper.BrowserHelper;
import helper.Constant;
import helper.ElementHelper;
import helper.element_helper.Dropdown;
import helper.element_helper.Label;
import models.Ticket;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {

    //Locator
    private final Dropdown ddlDepartDate = new Dropdown(By.cssSelector("[name=Date]"));
    private final Dropdown ddlDepartFrom = new Dropdown(By.cssSelector("[name=DepartStation]"));
    private final Dropdown ddlArriveAt = new Dropdown(By.cssSelector("[name=ArriveStation]"));
    private final Dropdown ddlSeatType = new Dropdown(By.cssSelector("[name=SeatType]"));
    private final Dropdown ddlTicketAmount = new Dropdown(By.cssSelector("[name=TicketAmount]"));
    private final Dropdown btnBookTicket = new Dropdown(By.cssSelector("input[value='Book ticket']"));
    private final Label lblErrorMessage = new Label(By.cssSelector(".message.error"));
    private final Label lblAmountErrorMessage = new Label(By.cssSelector(".validation-error"));

    //Method
    public void bookTicket(Ticket ticket) {
        BrowserHelper.scrollPage();
        this.ddlDepartFrom.selectDropDownText(ticket.getDepartFrom());
        this.ddlDepartDate.selectDropDownText(ticket.getDepartDate());
        this.ddlSeatType.selectDropDownText(ticket.getSeatType());
        this.ddlTicketAmount.selectDropDownText(ticket.getTicketAmount());
        ElementHelper.waitForElementDisplay(ddlArriveAt.findElement(), Constant.LONG_TIME_WAIT).click();
        this.ddlArriveAt.selectDropDownText(ticket.getArriveAt());
        BrowserHelper.scrollPage();
        this.btnBookTicket.click();
    }

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public String getAmountTicketErrorMessage() {
        return this.lblAmountErrorMessage.getText();
    }
}
