package page_objects;


import helper.Constant;
import helper.element_helper.Label;
import helper.web_driver_manage.DriverManageFactory;
import helper.web_driver_manage.DriverManager;
import helper.web_driver_manage.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends GeneralPage {
    //Elements
    private final Label lblWelcomeMessage = new Label(By.xpath("//div[@class = 'account']//strong"));

    //Methods
    public String getWelcomeMessage() {
        return this.lblWelcomeMessage.getText();
    }
}
