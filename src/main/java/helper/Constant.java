package helper;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railwayqa.somee.com/Account/Register.cshtml";
    public static final String username = "tnminh19971234@gmail.com";
    public static final String password = "minhvip1997";
    public static final String failUsernameLogin = "assdasdad@gmail.com";
    public static final String failPasswordLogin = "dasdasda";
    public static final String registerEmail = "tnminh19973215@gmail.com";
    public static final String registerPassword = "doubleminh1997";
    public static final String registerConfirmPassword = "doubleminh1997";
    public static final String registerPid = "12345678";
    public static final String failEmailRegister = "QWEAS";
    public static final String failPasswordRegister = "QWEASDZX";
    public static final String failConfirmPasswordRegister = "QWEASDZX";
    public static final String failPidRegister = "1234567";
    //Message
    public static final String invalidMsgLogin = "Invalid username or password. Please try again.";
    public static final String invalidMsgLoginUsername = "You must specify a username.";
    public static final String invalidMsgLoginPassword = "You must specify a password.";
    public static final String invalidMsgRegisterEmail = "Invalid email length";
    public static final String registerConfirmMsg = "Registration Confirmed! You can now log in to the site.";
    public static final String failMsgRegister = "There're errors in the form. Please correct the errors and try again.";
}
