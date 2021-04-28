package page_objects;

import helper.BrowserHelper;
import helper.Constant;
import helper.ElementHelper;
import helper.element_helper.Dropdown;
import helper.element_helper.Label;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {

    //Locator
    private final Dropdown ddlDepartDate = new Dropdown(By.cssSelector("[name=Date]"));
    private final Dropdown ddlDepartFrom = new Dropdown(By.cssSelector("[name=DepartStation]"));
    private final Dropdown ddlArriveAt = new Dropdown(By.cssSelector("[name=ArriveStation]"));
    private final Dropdown ddlSeatType = new Dropdown(By.cssSelector("[name=SeatType]"));
    private final Dropdown ddlTicketAmount = new Dropdown(By.cssSelector("[name=TicketAmount]"));
    private final Dropdown btnSubmitBookTicket = new Dropdown(By.cssSelector("input[value='Book ticket']"));
    private final Label lblErrorMessage = new Label(By.cssSelector(".message"));
    private final Label lblErrorMessageAmount = new Label(By.cssSelector(".validation-error"));
    private final String dynamicTableCell = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";

    //Method
    public void bookTicket(Ticket ticket) {
        BrowserHelper.scrollPage();
        this.ddlDepartFrom.selectDropDownText(ticket.getDepartFrom());
        this.ddlDepartDate.selectDropDownText(ticket.getDepartDate());
        this.ddlSeatType.selectDropDownText(ticket.getSeatType());
        this.ddlTicketAmount.selectDropDownText(ticket.getTicketAmount());
        ElementHelper.waitForElement(ddlArriveAt.findElement(), Constant.LONG_TIME_WAIT).click();
        this.ddlArriveAt.selectDropDownText(ticket.getArriveAt());
        BrowserHelper.scrollPage();
        this.btnSubmitBookTicket.click();
    }

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public WebElement getTdTextByHeader(String header) {
        return BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicTableCell, header)));
    }

    public String getTextByHead(String header) {
        return getTdTextByHeader(header).getText();
    }
}
