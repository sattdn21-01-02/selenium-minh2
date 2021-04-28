package com.logigear;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import helper.*;
import models.Login;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Description("TC01 - User can log into Railway with valid username and password")
    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can log into Railway with valid username and password");
        homePage.goToLoginPage();
        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Log.info("[STEP-2] - Assert welcome message is displays");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }

    @Description("TC08 - User can not log into Railway with valid username and password")
    @Test(dataProvider = "loginErrorObjects")
    public void TC02(Login login) {
        Log.startTestCase("TC08 - User can log into Railway with valid username and password");
        homePage.goToLoginPage();
        Log.info("[STEP-1] - Login fail with invalid account");
        loginPage.login(login.getEmail(), login.getPassword());

        Log.info("[STEP-2] - Assert login error message email is displays");
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @DataProvider(name = "loginErrorObjects")
    public Object[] readJsonObjectMapperLoginError() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader("src/test/resources/login-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<Login> logins = Arrays.asList(objectMapper.treeToValue(jsonNode.get("logins_error"), Login[].class));
        return logins.toArray();
    }
}
