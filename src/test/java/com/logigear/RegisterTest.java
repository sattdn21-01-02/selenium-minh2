package com.logigear;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import helper.*;
import models.Register;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterConfirmPage;
import page_objects.RegisterPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RegisterTest extends BaseTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        homePage.goToRegisterPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        BrowserHelper.getDriver().quit();
    }

    @Description("TC01 - User can register a new account Railway with valid register information")
    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can register a new account Railway with valid register information");

        Log.info("[STEP-1] - Register success with valid information");
        Register register = new Register();
        register.setEmail(DataHelper.generateRandomEmailString());
        String password = DataHelper.generateRandomPasswordString();
        register.setPassword(password);
        register.setConfirmPassword(password);
        register.setPid(DataHelper.generateRandomPidString());
        registerPage.register(register.getEmail(),
                register.getPassword(),
                register.getConfirmPassword(),
                register.getPid());

        Log.info("[STEP-2] - Assert the  register confirm message is displays");
        RegisterConfirmPage registerConfirmPage = new RegisterConfirmPage();
        String actualMsg = registerConfirmPage.getMessages();
        String expectedMsg = registerPage.getSuccessfulMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Description("TC04 - User can not register a new account Railway with invalid register information")
    @Test(dataProvider = "registerErrorObjects")
    public void TC04(Register register) {
        Log.startTestCase("TC04 - User can not register a new account Railway with invalid register information");

        Log.info("[STEP-1] - Register with invalid information");
        register.setEmail(DataHelper.generateRandomErrorEmailString());
        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        Log.info("[STEP-2] - Assert the error message is displays");
        String actualMsg = registerPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_REGISTER;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @DataProvider(name = "registerErrorObjects")
    public Object[] readJsonObjectMapperRegisterError() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader("src/test/resources/register-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<Register> registers = Arrays.asList(objectMapper.treeToValue(jsonNode.get("register_error"), Register[].class));
        return registers.toArray();
    }

}
