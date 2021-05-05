package com.logigear;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.DataHelper;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Description("TC05 - System shows message when user enters wrong password several times ")
    @Test(dataProvider = "loginInvalidAccount")
    public void TC05(Account account) {
        LoggerHelper.startTestCase("TC05 - System shows message when user enters wrong password several times ");

        homePage.goToLoginPage();

        account.setPassword(DataHelper.getRandomErrorPassword());
        loginPage.login(account);

        String actualMsg = loginPage.getGeneralErrorMessage();
        String expectedMsg = Constant.FAIL_MSG_LOGIN_MULTIPLE;
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @DataProvider(name = "loginInvalidAccount")
    public Object[] readJsonObjectMapperLoginError() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader(Constant.TEST_RESOURCES_PATH+"test-data/login-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<Account> accounts = Arrays.asList(objectMapper.treeToValue(jsonNode.get("account_invalid"), Account[].class));
        return accounts.toArray();
    }
}
