package page_objects;

import helper.BrowserHelper;
import helper.ElementHelper;
import helper.element_helper.Button;
import helper.element_helper.Label;
import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {

    //Elements
    private final Label lblMyTicket = new Label(By.cssSelector("#content h1"));
    Button btnCancel = new Button(By.cssSelector(".MyTable input"));

    //Methods
    public String getMyTicketTitle() {
        return this.lblMyTicket.getText();
    }

    public void deleteTicket() {
        ElementHelper.scrollToView(btnCancel.findElement());
        this.btnCancel.click();
        BrowserHelper.acceptAlert();
        this.btnCancel.waitForElementInVisible();
    }

    public int getTotalTicket() {
        return this.btnCancel.getElementCount();
    }
}
