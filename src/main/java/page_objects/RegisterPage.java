package page_objects;

import helper.BrowserHelper;
import helper.element_helper.Button;
import helper.element_helper.Label;
import helper.element_helper.TextBox;
import org.openqa.selenium.By;

public class RegisterPage extends GeneralPage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.cssSelector("input#email"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("input#password"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("input#confirmPassword"));
    private final TextBox txtPID = new TextBox(By.cssSelector("input#pid"));
    private final Button btnRegister = new Button(By.cssSelector("input[title='Register']"));
    private final Label lblGeneralErrorMessage = new Label(By.xpath("//p[contains(@class, 'message')]"));
    private final Label lblEmailErrorMessage = new Label(By.xpath("//label[@for='email' and @class = 'validation-error']"));
    private final Label lblPasswordErrorMessage = new Label(By.xpath("//label[@for='password' and @class = 'validation-error']"));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.xpath("//label[@for='confirmPassword' and @class = 'validation-error']"));
    private final Label lblPIDErrorMessage = new Label(By.xpath("//label[@for='pid' and @class = 'validation-error']"));
    private final Label lblSuccessfulMessage = new Label(By.xpath("//div[@id = 'content']//p"));

    //Methods
    public void register(String email, String password, String confirmPassword, String pid) {
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        this.txtConfirmPassword.enterText(confirmPassword);
        this.txtPID.enterText(pid);
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
