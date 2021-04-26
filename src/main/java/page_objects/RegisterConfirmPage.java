package page_objects;

import helper.element_helper.Label;
import org.openqa.selenium.By;

public class RegisterConfirmPage extends GeneralPage {


    //Elements
    private final Label lblSuccessfulMessage = new Label(By.cssSelector("#content p"));

    //Methods
    public String getMessages() {
        return this.lblSuccessfulMessage.getText();
    }
}
