package page_objects;

import helper.BrowserHelper;
import helper.ElementHelper;
import helper.element_helper.Link;
import org.openqa.selenium.By;

public class ContactPage extends GeneralPage {

    //Elements
    private final Link linkEmail = new Link(By.cssSelector(".contact a"));

    //Methods
    public String getEmailHref() {
        return this.linkEmail.findElement().getAttribute("href");
    }
}
