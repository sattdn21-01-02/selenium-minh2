package page_objects;

import helper.element_helper.Label;
import org.openqa.selenium.By;

public class ChangePasswordPage extends GeneralPage {

    //Elements
    private final Label lblChangePassword = new Label(By.cssSelector("[align='center']"));

    //Methods
    public String getChangePasswordTitle() {
        return this.lblChangePassword.getText();
    }
}
