package page_objects;

import helper.BrowserHelper;
import helper.element_helper.Dropdown;
import helper.element_helper.Label;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {

    //Locator
    private final Dropdown ddlDepartDate = new Dropdown(By.xpath("//select[@name='Date']"));
    private final Dropdown ddlDepartFrom = new Dropdown(By.xpath("//select[@name='DepartStation']"));
    private final Dropdown ddlArriveAt = new Dropdown(By.xpath("//select[@name='ArriveStation']"));
    private final Dropdown ddlSeatType = new Dropdown(By.xpath("//select[@name='SeatType']"));
    private final Dropdown ddlTicketAmount = new Dropdown(By.xpath("//select[@name='TicketAmount']"));
    private final Dropdown btnSubmitBookTicket = new Dropdown(By.xpath("//input[@value='Book ticket']"));
    private final Label lblErrorMessage = new Label(By.cssSelector(".message"));
    private final Label lblErrorMessageAmount = new Label(By.cssSelector(".validation-error"));

    //Method
    public void bookTicket(String date, String departFrom, String arriveAt,
                           String seatType, String ticketAmount) {
        BrowserHelper.scrollPage();
        this.ddlDepartFrom.selectDropDownText(departFrom);
        this.ddlDepartDate.selectDropDownText(date);
        this.ddlSeatType.selectDropDownText(seatType);
        this.ddlTicketAmount.selectDropDownText(ticketAmount);
        BrowserHelper.waitForElement(BrowserHelper.getDriver(), ddlArriveAt.findElement(), 30).click();
        this.ddlArriveAt.selectDropDownText(arriveAt);
        BrowserHelper.scrollPage();
        this.btnSubmitBookTicket.click();
    }

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }
}
