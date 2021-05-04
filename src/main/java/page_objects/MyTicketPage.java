package page_objects;

import helper.element_helper.Label;
import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {

    //Elements
    private final Label lblMyTicket = new Label(By.cssSelector("[align='center']"));

    //Methods
    public String getMyTicketTitle() {
        return this.lblMyTicket.getText();
    }
}
