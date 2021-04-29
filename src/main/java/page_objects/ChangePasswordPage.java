package page_objects;

import helper.Constant;
import helper.ElementHelper;
import helper.element_helper.Button;
import helper.element_helper.Label;
import helper.element_helper.TextBox;
import models.Account;
import org.openqa.selenium.By;

public class ChangePasswordPage extends GeneralPage {

    //Locator
    private final TextBox currentPassword = new TextBox(By.cssSelector("[id=currentPassword]"));
    private final TextBox newPassword = new TextBox(By.cssSelector("[id=newPassword]"));
    private final TextBox confirmPassword = new TextBox(By.cssSelector("[id=confirmPassword]"));
    private final Label lblErrorMessage = new Label(By.cssSelector(".message.error"));
    private final Label lblInvalidCurrentPassword = new Label(By.cssSelector(".validation-error[for=currentPassword]"));
    private final Label lblInvalidNewPassword = new Label(By.cssSelector(".validation-error[for=newPassword]"));
    private final Label lblSuccessMessage = new Label(By.cssSelector(".message.success"));
    private final Button btnSubmit = new Button(By.cssSelector("[type=submit]"));

    public void changePassword(Account account, String newPassword) {
        this.currentPassword.enterText(account.getPassword());
        this.newPassword.enterText(newPassword);
        this.confirmPassword.enterText(newPassword);
        ElementHelper.scrollToView(btnSubmit.findElement());
        this.btnSubmit.click();
        account.setPassword(newPassword);
    }

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public String getInvalidCurrentPassword() {
        return this.lblInvalidCurrentPassword.getText();
    }

    public String getInvalidConfirmPassword() {
        return this.lblInvalidNewPassword.getText();
    }

    public String getSuccessMessage() {
        return this.lblSuccessMessage.getText();
    }
}
