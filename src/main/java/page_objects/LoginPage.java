package page_objects;


import helper.Constant;
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
    private final Label lblGeneralErrorMessage = new Label(By.xpath("//p[contains(@class, 'message')]"));
    private final Label lblEmailErrorMessage = new Label(By.xpath("//label[@for='username' and @class = 'validation-error']"));
    private final Label lblPasswordErrorMessage = new Label(By.xpath("//label[@for='password' and @class = 'validation-error']"));

    //Methods
    public void login(String email, String password) {
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        this.btnLogin.waitForElementExist();
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
