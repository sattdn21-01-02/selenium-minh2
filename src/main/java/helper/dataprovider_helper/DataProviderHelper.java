package helper.dataprovider_helper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class DataProviderHelper {

    @DataProvider(name = "login_success")
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

    @DataProvider(name = "login_error")
    public Object[] readJsonLoginError() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/login-data.json");

        Object object = jsonParser.parse(reader);
        JSONObject userLoginJsonObj = (JSONObject) object;
        JSONArray userLoginsArray = (JSONArray) userLoginJsonObj.get("logins_error");
        String arr[] = new String[userLoginsArray.size()];
        for (int i = 0; i < userLoginsArray.size(); i++) {
            JSONObject users = (JSONObject) userLoginsArray.get(i);
            String email = (String) users.get("email");
            String password = (String) users.get("password");

            arr[i] = email + "," + password;
        }
        return arr;
    }

    @DataProvider(name = "register_error")
    public Object[] readJsonRegisterError() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/register-data.json");

        Object object = jsonParser.parse(reader);
        JSONObject userLoginJsonObj = (JSONObject) object;
        JSONArray userLoginsArray = (JSONArray) userLoginJsonObj.get("register_error");
        String arr[] = new String[userLoginsArray.size()];
        for (int i = 0; i < userLoginsArray.size(); i++) {
            JSONObject users = (JSONObject) userLoginsArray.get(i);
            String email = (String) users.get("email");
            String password = (String) users.get("password");
            String confirmPassword = (String) users.get("confirm_password");
            String pid = (String) users.get("PID");
            arr[i] = email + "," + password + "," + confirmPassword + "," + pid;
        }
        return arr;
    }
}
