package helper;

import helper.web_driver_manage.DriverManager;
import org.openqa.selenium.WebDriver;

public class Constant {

    //Variables
    public static final String RAILWAY_URL = "http://www.railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "tnminh1997123@gmail.com";
    public static final String PASSWORD = "minhvip1997";
    public static final String TEST_RESOURCES_PATH = "/src/test/resources/";
    public static final int TIME_WAITS_DRIVER = 30;
    public static final int TIMES_WAIT_ELEMENTS = 120;
    public static final int LONG_TIME_WAIT = 30;

    //Message
    public static final String INVALID_MSG_LOGIN = "Invalid username or password. Please try again.";
    public static final String INVALID_MSG_LOGIN_USERNAME = "You must specify a username.";
    public static final String INVALID_MSG_LOGIN_PASSWORD = "You must specify a password.";
    public static final String INVALID_MSG_REGISTER_EMAIL = "Invalid email length";
    public static final String WELCOME = "Welcome ";
    public static final String REGISTER_CONFIRM_MSG = "You're here";
    public static final String FAIL_MSG_REGISTER = "There're errors in the form. Please correct the errors and try again.";
}
