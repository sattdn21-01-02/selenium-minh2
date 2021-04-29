package com.logigear;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.Description;
import helper.*;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RegisterTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();


    @Description("TC01 - User can register a new account Railway with valid register information")
    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can register a new account Railway with valid register information");
        homePage.goToRegisterPage();
        String password = DataHelper.generateRandomPasswordString();
        Log.info("[STEP-1] - Register success with valid information");
        Account account = new Account(DataHelper.generateRandomEmailString(),
                password, password, DataHelper.generateRandomPidString());

        registerPage.register(account);

        Log.info("[STEP-2] - Assert the  register confirm message is displays");
        String actualMsg = Constant.REGISTER_CONFIRM_MSG;
        String expectedMsg = registerPage.getSuccessfulMessage();
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Description("TC04 - User can not register a new account Railway with invalid register information")
    @Test(dataProvider = "registerErrorObjects")
    public void TC04(Account account) {
        Log.startTestCase("TC04 - User can not register a new account Railway with invalid register information");
        homePage.goToRegisterPage();
        Log.info("[STEP-1] - Register with invalid information");
        account.setEmail(DataHelper.generateRandomErrorEmailString());
        registerPage.register(account);

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
        List<Account> accounts = Arrays.asList(objectMapper.treeToValue(jsonNode.get("register_error"), Account[].class));
        return accounts.toArray();
    }

}
