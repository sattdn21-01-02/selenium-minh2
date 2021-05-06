package page_objects;

import helper.BrowserHelper;
import org.openqa.selenium.By;

public class TicketPricePage extends GeneralPage {

    //Elements
    private final String dynamicBtnCheckPriceXpath = "//li[text() = '%s to %s']//ancestor::tr//a";
    private final String dynamicBtnBookTicketXpath = "//td[text()='%s']//following-sibling::td/a";

    public void checkPrice(String departFrom, String arriveAt) {
        BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicBtnCheckPriceXpath, departFrom, arriveAt))).click();
    }

    public void bookTicket(String seatType) {
        BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicBtnBookTicketXpath, seatType))).click();
    }
}
