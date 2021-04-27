package helper.dataprovider_helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Login;
import models.Register;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;

public class DataProviderHelper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @DataProvider(name = "loginError")
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

    @DataProvider(name = "registerError")
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

    @DataProvider(name = "registerSuccessObjects")
    public Object[] readJsonObjectMapperRegister() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader reader = new FileReader("src/test/resources/register-data.json");
        JsonNode jsonNode = objectMapper.readTree(reader);
        List<Register> registers = Arrays.asList(objectMapper.treeToValue(jsonNode.get("register_success"), Register[].class));
        return registers.toArray();
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