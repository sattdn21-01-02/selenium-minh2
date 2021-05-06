package page_objects;

import helper.BrowserHelper;
import org.openqa.selenium.By;

public class TicketPricePage extends GeneralPage {

    //Elements
    private final String dynamicTableCellCheckPrice = "//li[text() = '%s to %s']//ancestor::tr//a";
    private final String dynamicTableCellBookTicket = "//td[text()='%s']//following-sibling::td/a";

    public void checkPrice(String departFrom, String arriveAt) {
        BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicTableCellCheckPrice, departFrom, arriveAt))).click();
    }

    public void bookTicket(String seatType) {
        BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicTableCellBookTicket, seatType))).click();
    }
}
