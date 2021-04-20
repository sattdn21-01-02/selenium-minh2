package page_objects;


import helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //Locator
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    // private final By lblLoginErrorMsgUsername = By.xpath("//label[@for='username' and @class = 'validation-error']");
    private final By lblLoginErrorMsgUsername = By.cssSelector(".validation-error, username");
    private final By lblLoginErrorMsgPassword = By.xpath("//label[@for='password' and @class = 'validation-error']");

    //Element
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public WebElement getLblLoginErrorMsgUsername() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsgUsername);
    }

    public WebElement getLblLoginErrorMsgPassword() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsgPassword);
    }

    public void login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

    }

    public String getErrorLoginMessage() {
        return this.getLblLoginErrorMsg().getText();
    }

    public String getErrorLoginUsername() {
        return this.getLblLoginErrorMsgUsername().getText();
    }

    public String getErrorLoginPassword() {
        return this.getLblLoginErrorMsgPassword().getText();
    }
}
