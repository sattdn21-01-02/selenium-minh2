package page_objects;

import helper.Constant;
import helper.element_helper.Tab;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverManager;
import helper.web_driver_manage.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Elements
    private final Tab tabHome = new Tab(By.cssSelector("a[href='../']"));
    private final Tab tabFAQ = new Tab(By.cssSelector("a[href='/Page/FAQ.cshtml']"));
    private final Tab tabContact = new Tab(By.cssSelector("a[href='/Page/Contact.cshtml']"));
    private final Tab tabTimetable = new Tab(By.cssSelector("a[href='TrainTimeListPage.cshtml']"));
    private final Tab tabTicketPrice = new Tab(By.cssSelector("a[href='/Page/TrainPriceListPage.cshtml']"));
    private final Tab tabBookTicket = new Tab(By.cssSelector("a[href='/Page/BookTicketPage.cshtml']"));
    private final Tab tabMyTicket = new Tab(By.cssSelector("a[href='/Page/ManageTicket.cshtml']"));
    private final Tab tabChangePassword = new Tab(By.cssSelector("a[href='/Account/ChangePassword.cshtml']"));
    private final Tab tabRegister = new Tab(By.cssSelector("a[href='/Account/Register.cshtml']"));
    private final Tab tabLogin = new Tab(By.cssSelector("a[href='/Account/Login.cshtml']"));
    private final Tab tabLogout = new Tab(By.cssSelector("a[href='/Account/Logout']"));

    //Methods
    public void goToHomePage() {
        this.tabHome.click();
    }

    public void goToFAQPage() {
        this.tabFAQ.click();
    }

    public void goToContactPage() {
        this.tabContact.click();
    }

    public void goToTimetablePage() {
        this.tabTimetable.click();
    }

    public void goToTicketPricePage() {
        this.tabTicketPrice.click();
    }

    public void goToBookTicketPage() {
        this.tabBookTicket.click();
    }

    public void goToMyTicketPage() {
        this.tabMyTicket.click();
    }

    public void goToChangePasswordPage() {
        this.tabChangePassword.click();
    }

    public void goToRegisterPage() {
        this.tabRegister.click();
    }

    public void goToLoginPage() {
        this.tabLogin.click();
    }

    public void logout() {
        this.tabLogout.click();
    }

    public void scrollPage() {
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEB_DRIVER;
        jse.executeScript("window.scrollBy(0,250)");
    }
}
