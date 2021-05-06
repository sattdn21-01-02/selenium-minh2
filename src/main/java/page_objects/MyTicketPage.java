package page_objects;

import helper.BrowserHelper;
import helper.ElementHelper;
import helper.element_helper.Button;
import helper.element_helper.Label;
import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {

    //Elements
    private final Label lblMyTicket = new Label(By.cssSelector("#content h1"));
    Button btnCancel = new Button(By.cssSelector("[value=Cancel]"));
    String xPath = "//td[count(//th[text()='No.']) and text() = %d]//following-sibling::td//input";

    //Methods
    public String getMyTicketTitle() {
        return this.lblMyTicket.getText();
    }

    public void cancelSpecifiedTicket(int id) {
        String xPaths = String.format(xPath, id);
        Button btnCancel = new Button(By.xpath(xPaths));
        ElementHelper.scrollToView(btnCancel.findElement());
        this.btnCancel.click();
        BrowserHelper.acceptAlert();
    }
}
