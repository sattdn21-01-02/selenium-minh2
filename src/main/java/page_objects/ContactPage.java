package page_objects;

import helper.BrowserHelper;
import helper.ElementHelper;
import helper.element_helper.Link;
import org.openqa.selenium.By;

public class ContactPage extends GeneralPage {

    //Elements
    private final By linkEmail = new By.ByLinkText("thanh.viet.le@logigear.com");

    //Methods
    public String getEmail() {
        return BrowserHelper.getDriver().findElement(linkEmail).getAttribute("href");
    }
}
