package page_objects;

import helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        this.getSelectDate().sendKeys(date);
        this.getSelectDepartFrom().sendKeys(departFrom);
        this.getSelectArriveAt().sendKeys(arriveAt);
        this.getSelectSeatType().sendKeys(seatType);
        this.getSelectTicketAmount().sendKeys(ticketAmount);
        this.getBtnBookTicket().click();
    }
}
