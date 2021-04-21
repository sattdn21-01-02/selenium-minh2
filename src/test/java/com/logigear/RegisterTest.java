package com.logigear;

import helper.Constant;
import helper.Utilities;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverManager;
import helper.web_driver_manage.DriverType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class RegisterTest {
    JavascriptExecutor js;
    DriverManager driverManager;
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driverManager = DriverManageFactory.getDriverManager(DriverType.CHROME);
        Constant.WEBDRIVER = driverManager.getWebDriver();
        Constant.WEBDRIVER.get(Constant.RAILWAY_URL);
        Constant.WEBDRIVER.manage().window().maximize();
        js = (JavascriptExecutor) Constant.WEBDRIVER;
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can register a new account Railway with valid register information");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        js.executeScript("window.scrollBy(0,500)", "");
        registerPage.register(Constant.registerEmail, Constant.registerPassword, Constant.registerConfirmPassword, Constant.registerPid);
        String actualMsg = homePage.getMessageRegisterConfirmed();
        String expectedMsg = Constant.registerConfirmMsg;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        //loginPage.gotoLogoutPage();*/
    }

    @Test
    public void TC02() {
        System.out.println("TC01 - User can not register a new account Railway with invalid register information");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        js.executeScript("window.scrollBy(0,500)", "");
        registerPage.register(Constant.failEmailRegister,
                Constant.failPasswordRegister,
                Constant.failConfirmPasswordRegister,
                Constant.failPidRegister);
        String actualMsg = registerPage.getErrorMsgRegister();
        String expectedMsg = Constant.failMsgRegister;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void TC03() {
        System.out.println("TC03- User can not register a new account Railway with invalid register information email");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        js.executeScript("window.scrollBy(0,500)", "");
        registerPage.register(Constant.failEmailRegister,
                Constant.registerPassword,
                Constant.registerConfirmPassword,
                Constant.registerPid);
        String actualMsg = registerPage.getErrorMsgRegisterEmail();
        String expectedMsg = Constant.invalidMsgRegisterEmail;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
