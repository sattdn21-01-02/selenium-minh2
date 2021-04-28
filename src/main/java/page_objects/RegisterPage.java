package page_objects;

import helper.BrowserHelper;
import helper.element_helper.Button;
import helper.element_helper.Label;
import helper.element_helper.TextBox;
import models.Account;
import models.Register;
import org.openqa.selenium.By;

public class RegisterPage extends GeneralPage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.cssSelector("input#email"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("input#password"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("input#confirmPassword"));
    private final TextBox txtPID = new TextBox(By.cssSelector("input#pid"));
    private final Button btnRegister = new Button(By.cssSelector("input[title='Register']"));
    private final Label lblGeneralErrorMessage = new Label(By.xpath("//p[contains(@class, 'message')]"));
    private final Label lblEmailErrorMessage = new Label(By.cssSelector("[for=email].validation-error"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector("[for=password].validation-error"));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.cssSelector("[for=confirmPassword].validation-error"));
    private final Label lblPIDErrorMessage = new Label(By.cssSelector("[for=pid].validation-error"));
    private final Label lblSuccessfulMessage = new Label(By.cssSelector("#content p"));

    //Methods
    public void register(Register register) {
        this.txtEmail.enterText(register.getEmail());
        this.txtPassword.enterText(register.getPassword());
        this.txtConfirmPassword.enterText(register.getConfirmPassword());
        this.txtPID.enterText(register.getPid());
        this.btnRegister.waitForElementExist();
        BrowserHelper.scrollPage();
        this.btnRegister.click();
    }

    public String getGeneralErrorMessage() {
        return this.lblGeneralErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        return this.lblEmailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return this.lblPasswordErrorMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return this.lblConfirmPasswordErrorMessage.getText();
    }

    public String getPIDErrorMessage() {
        return this.lblPIDErrorMessage.getText();
    }

    public String getSuccessfulMessage() {
        return this.lblSuccessfulMessage.getText();
    }
}
