package com.logigear;

import helper.Constant;
import helper.dataprovider_helper.DataProviderHelper;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class RegisterTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeMethod
    public void beforeMethod() {
        Constant.DRIVER_MANAGER = DriverManageFactory.getDriverManager(DriverType.CHROME);
        Constant.WEB_DRIVER = Constant.DRIVER_MANAGER.getWebDriver();
        Constant.WEB_DRIVER.get(Constant.RAILWAY_URL);
        Constant.WEB_DRIVER.manage().window().maximize();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        homePage.goToRegisterPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEB_DRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can register a new account Railway with valid register information");
        registerPage.scrollPage();
        registerPage.register(Constant.REGISTER_EMAIL, Constant.REGISTER_PASSWORD, Constant.REGISTER_PID);
        String actualMsg = registerPage.getSuccessfulMessage();
        String expectedMsg = "Welcome " + Constant.REGISTER_EMAIL;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        registerPage.logout();
    }

    @Test(dataProvider = "register_error", dataProviderClass = DataProviderHelper.class)
    public void TC02(String data) {
        System.out.println("TC01 - User can not register a new account Railway with invalid register information");
        String users[] = data.split(",");
        registerPage.register(users[0].toString(),
                users[1].toString(),
                users[2].toString());
        String actualMsg = registerPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_REGISTER;
        Assert.assertEquals(actualMsg, expectedMsg);
    }


}
