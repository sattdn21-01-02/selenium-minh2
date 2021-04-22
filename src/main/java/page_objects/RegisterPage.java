package page_objects;

import helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locator
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPid = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@type='submit']");
    private final By lblErrorMsgEmail = By.xpath("//label[@for='email' and @class='validation-error']");
    private final By lblErrorMsgPassword = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By lblErrorMsgConfirmPassword = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
    private final By lblErrorMsgPid = By.xpath("//label[@for='pid' and @class='validation-error']");
    private final By lblErrorRegister = By.xpath("//p[@class='message error']");

    //Element

    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPid() {
        return Constant.WEBDRIVER.findElement(txtPid);
    }

    public WebElement getLblErrorMsgEmail() {
        return Constant.WEBDRIVER.findElement(lblErrorMsgEmail);
    }

    public WebElement getLblErrorMsgPassword() {
        return Constant.WEBDRIVER.findElement(lblErrorMsgPassword);
    }

    public WebElement getLblErrorMsgConfirmPassword() {
        return Constant.WEBDRIVER.findElement(lblErrorMsgConfirmPassword);
    }

    public WebElement getLblErrorMsgPid() {
        return Constant.WEBDRIVER.findElement(lblErrorMsgPid);
    }

    public WebElement getLblErrorMsgRegister() {
        return Constant.WEBDRIVER.findElement(lblErrorRegister);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public void register(String email, String password, String confirmPassword, String Pid) {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPid().sendKeys(Pid);
        this.getBtnRegister().click();

    }

    public String getErrorMsgRegister() {
        return this.getLblErrorMsgRegister().getText();
    }

    public String getErrorMsgRegisterEmail() {
        return this.getLblErrorMsgEmail().getText();
    }

}
