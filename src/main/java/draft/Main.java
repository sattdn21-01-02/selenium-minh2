package draft;

import helper.BrowserHelper;
import helper.Constant;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import java.util.List;

public class Main {
    private HomePage homePage;
    private LoginPage loginPage;


    @BeforeMethod
    public void beforeMethod() throws IOException{
        Constant.DRIVER_MANAGER = DriverManageFactory.getDriverManager(DriverType.CHROME);
        Constant.WEB_DRIVER = Constant.DRIVER_MANAGER.getWebDriver();
        Constant.WEB_DRIVER.get(Constant.RAILWAY_URL);
        Constant.WEB_DRIVER.manage().window().maximize();

        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.goToLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEB_DRIVER.quit();
    }


    @Test(dataProvider = "dp")
    public void TC01(String data) {
        String users[] = data.split(",");
        /*ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/test/resources/login-data.json");
        Login people = objectMapper.readValue(jsonFile, Login.class);
        System.out.println("TC01 - User can log into Railway with valid username and password")*/;
        BrowserHelper.scrollPage();
        loginPage.login(users[0],users[1]);
        //loginPage.login(people.getEmail(), people.getPassword());
        //loginPage.login(logins.get(0).getEmail(),logins.get(0).getPassword());
        BrowserHelper.scrollPage();
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        loginPage.logout();
    }

    @DataProvider(name="dp")
    public Object[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/login-data.json");

        Object object = jsonParser.parse(reader);
        JSONObject userLoginJsonObj=(JSONObject) object;
        JSONArray userLoginsArray=(JSONArray) userLoginJsonObj.get("logins");
        String arr[] = new String[userLoginsArray.size()];
        for(int i=0;i<userLoginsArray.size();i++) {
            JSONObject users=(JSONObject) userLoginsArray.get(i);
            String email = (String) users.get("email");
            String password = (String) users.get("password");

            arr[i]=email+","+password;
        }
        return arr;
    }
}
