package helper;

import helper.web_driver_manage.DriverManager;
import org.openqa.selenium.WebDriver;

public class Constant {
    //Variables
    public static WebDriver WEB_DRIVER;
    public static final String RAILWAY_URL = "http://www.railwayqa.somee.com/Account/Register.cshtml";
    public static final String USERNAME = "tnminh19971234@gmail.com";
    public static final String PASSWORD = "minhvip1997";
    public static final String failUsernameLogin = "assdasdad@gmail.com";
    public static final String failPasswordLogin = "dasdasda";
    public static final String REGISTER_EMAIL = "tnminh199732151@gmail.com";
    public static final String REGISTER_PASSWORD = "doubleminh1997";
    public static final String REGISTER_CONFIRM_PASSWORD = "doubleminh1997";
    public static final String REGISTER_PID = "12345678";
    public static DriverManager DRIVER_MANAGER;
    public static final String failEmailRegister = "QWEAS";
    public static final String failPasswordRegister = "QWEASDZX";
    public static final String failConfirmPasswordRegister = "QWEASDZX";
    public static final String failPidRegister = "1234567";
    //Message
    public static final String INVALID_MSG_LOGIN = "Invalid username or password. Please try again.";
    public static final String INVALID_MSG_LOGIN_USERNAME = "You must specify a username.";
    public static final String INVALID_MSG_LOGIN_PASSWORD = "You must specify a password.";
    public static final String INVALID_MSG_REGISTER_EMAIL = "Invalid email length";
    public static final String REGISTER_CONFIRM_MSG = "Registration Confirmed! You can now log in to the site.";
    public static final String FAIL_MSG_REGISTER = "There're errors in the form. Please correct the errors and try again.";
}
