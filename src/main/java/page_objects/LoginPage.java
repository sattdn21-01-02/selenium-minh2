package page_objects;


import helper.BrowserHelper;
import helper.Constant;
import helper.ElementHelper;
import helper.element_helper.Button;
import helper.element_helper.Label;
import helper.element_helper.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //Elements
    private final TextBox txtEmail = new TextBox(By.cssSelector("input#username"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("input#password"));
    private final Button btnLogin = new Button(By.cssSelector("input[title='Login']"));
    private final Label lblGeneralErrorMessage = new Label(By.cssSelector(".message.error.LoginForm"));
    private final Label lblEmailErrorMessage = new Label(By.cssSelector("[for=username].validation-error"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector("[for=password].validation-error"));

    //Methods
    public void login(String email, String password) {
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        ElementHelper.scrollToView(btnLogin.findElement());
        this.btnLogin.click();
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
