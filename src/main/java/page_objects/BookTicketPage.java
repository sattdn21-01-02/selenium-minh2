package page_objects;

import helper.element_helper.Dropdown;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {

    //Locator
    private final Dropdown ddlDepartFrom = new Dropdown(By.cssSelector("[name=DepartStation]"));
    private final Dropdown ddlArriveAt = new Dropdown(By.cssSelector("[name=ArriveStation]"));
    private final Dropdown ddlSeatType = new Dropdown(By.cssSelector("[name=SeatType]"));


    //Method
    public String getSeatTypeValue() {
        return this.ddlSeatType.getSelectedValue();
    }

    public String getDepartFromValue() {
        return this.ddlDepartFrom.getSelectedValue();
    }

    public String getArriveAtValue() {
        return this.ddlArriveAt.getSelectedValue();
    }

}
