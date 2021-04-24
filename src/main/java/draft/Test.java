package draft;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.Constant;
import helper.Utilities;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverType;
import model.General;
import model.Login;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Test {
   public static void main(String[] args) throws IOException {
        /*ObjectMapper objectMapper = new ObjectMapper();
        Login login = objectMapper.readValue(new File("D:\\seleniumproject\\selenium_minh\\src\\test\\resources\\login-data.json"),Login.class);
        System.out.println(login);*/

        String json = "{ \"email\":\"minh\", \"password\":\"minh123\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Login login = objectMapper.readValue(json, Login.class);
        System.out.println(login.toString());

        File jsonFile = new File("src/test/resources/login-data.json");
        Login people = objectMapper.readValue(jsonFile, Login.class);
        System.out.println(people.getEmail());
    }


}
