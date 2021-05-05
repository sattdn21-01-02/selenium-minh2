package page_objects;

import helper.element_helper.Link;
import org.openqa.selenium.By;

public class ContactPage extends GeneralPage {

    //Elements
    private final Link linkEmail = new Link(By.cssSelector("[href|='mailto:thanh.viet.le@logigear.com']"));

    //Methods
    public String getEmail() {
        return this.linkEmail.getText();
    }
}
