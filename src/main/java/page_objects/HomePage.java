package page_objects;

import helper.element_helper.Label;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {

    //Elements
    private final Label lblWelcomeMessage = new Label(By.cssSelector(".account"));

    //Methods
    public String getWelcomeMessage() {
        return this.lblWelcomeMessage.getText();
    }
}
