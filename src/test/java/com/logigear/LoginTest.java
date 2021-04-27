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

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.goToLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
    }

    @Description("TC01 - User can log into Railway with valid username and password")
    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Log.info("[STEP-2] - Assert welcome message is displays");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }

    @Description("TC04 - User can not log into Railway with blank username or password")
    @Test
    public void TC04() {
        Log.startTestCase("TC04 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login fail with invalid account");
        loginPage.login("", "");

        Log.info("[STEP-2] - Assert login error message email is displays");
        String actualMsgUsername = loginPage.getEmailErrorMessage();
        String expectedMsg2 = Constant.INVALID_MSG_LOGIN_USERNAME;
        Assert.assertEquals(actualMsgUsername, expectedMsg2);

        Log.info("[STEP-3] - Assert login error message password is displays");
        String actualMsgPassword = loginPage.getPasswordErrorMessage();
        String expectedMsgPassword = Constant.INVALID_MSG_LOGIN_PASSWORD;
        Assert.assertEquals(actualMsgPassword, expectedMsgPassword);
    }

    @Description("TC05 - User can log into Railway with valid username and password")
    @Test(dataProvider = "loginSuccess")
    public void TC05(String data) {
        Log.startTestCase("5 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login success with valid account");
        String users[] = data.split(",");
        loginPage.login(users[0], users[1]);

        Log.info("[STEP-2] - Assert welcome message is displays");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + users[0].toString();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }

    @Description("TC07 - User can log into Railway with valid username and password")
    @Test(dataProvider = "loginSuccessObjects")
    public void TC07(Login login) {
        Log.startTestCase("TC07 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login success with valid account");
        loginPage.login(login.getEmail(), login.getPassword());

        Log.info("[STEP-2] - Assert welcome message is displays");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.WELCOME + login.getEmail();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        Log.info("[STEP-3] - Logout");
        loginPage.logout();
    }

    @Description("TC08 - User can not log into Railway with valid username and password")
    @Test(dataProvider = "loginErrorObjects")
    public void TC08(Login login) {
        Log.startTestCase("TC08 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login fail with invalid account");
        loginPage.login(login.getEmail(), login.getPassword());

        Log.info("[STEP-2] - Assert login error message email is displays");
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Description("TC09 - User can not log into Railway with valid username and password")
    @Test
    public void TC09() {
        Log.startTestCase("TC09 - User can log into Railway with valid username and password");

        Log.info("[STEP-1] - Login fail with invalid account");
        Login login = new Login();
        login.setEmail(DataHelper.generateRandomEmailString());
        login.setPassword(DataHelper.generateRandomPasswordString());
        loginPage.login(login.getEmail(), login.getPassword());

        Log.info("[STEP-2] - Assert login error message email is displays");
        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.INVALID_MSG_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @DataProvider(name = "loginSuccess")
    public Object[] readJsonLoginSuccess() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/login-data.json");

        Object object = jsonParser.parse(reader);
        JSONObject userLoginJsonObj = (JSONObject) object;
        JSONArray userLoginsArray = (JSONArray) userLoginJsonObj.get("logins");
        String arr[] = new String[userLoginsArray.size()];
        for (int i = 0; i < userLoginsArray.size(); i++) {
            JSONObject users = (JSONObject) userLoginsArray.get(i);
            String email = (String) users.get("email");
            String password = (String) users.get("password");

            arr[i] = email + "," + password;
        }
        return arr;
    }

    @DataProvider(name = "loginSuccessObjects")
    public Object[] readJsonObjectMapperLogin() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader("src/test/resources/login-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<Login> logins = Arrays.asList(objectMapper.treeToValue(jsonNode.get("logins"), Login[].class));
        return logins.toArray();
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
