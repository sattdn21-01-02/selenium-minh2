package page_objects;

import helper.ElementHelper;
import helper.element_helper.Button;
import helper.element_helper.Label;
import helper.element_helper.TextBox;
import models.Account;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.cssSelector("input#username"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("input#password"));
    private final Button btnLogin = new Button(By.cssSelector("input[title='Login']"));
    private final Label lblGeneralErrorMessage = new Label(By.cssSelector(".message.error.LoginForm"));
    private final Label lblEmailErrorMessage = new Label(By.cssSelector("[for=username].validation-error"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector("[for=password].validation-error"));

    //Methods
    public void login(Account account) {
        this.txtEmail.enterText(account.getEmail());
        this.txtPassword.enterText(account.getPassword());
        ElementHelper.scrollToView(btnLogin.findElement());
        this.btnLogin.click();
    }

    public void loginNTimes(Account account, int n) {
        for (int i = 0; i < n; i++) {
            login(account);
        }
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
}
