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
        return Constant.WEB_DRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEB_DRIVER.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEB_DRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPid() {
        return Constant.WEB_DRIVER.findElement(txtPid);
    }

    public WebElement getLblErrorMsgEmail() {
        return Constant.WEB_DRIVER.findElement(lblErrorMsgEmail);
    }

    public WebElement getLblErrorMsgPassword() {
        return Constant.WEB_DRIVER.findElement(lblErrorMsgPassword);
    }

    public WebElement getLblErrorMsgConfirmPassword() {
        return Constant.WEB_DRIVER.findElement(lblErrorMsgConfirmPassword);
    }

    public WebElement getLblErrorMsgPid() {
        return Constant.WEB_DRIVER.findElement(lblErrorMsgPid);
    }

    public WebElement getLblErrorMsgRegister() {
        return Constant.WEB_DRIVER.findElement(lblErrorRegister);
    }

    public WebElement getBtnRegister() {
        return Constant.WEB_DRIVER.findElement(btnRegister);
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
