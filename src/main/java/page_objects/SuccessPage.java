package page_objects;

import helper.element_helper.Label;
import org.openqa.selenium.By;

public class SuccessPage extends GeneralPage{

    //Elements
    private final Label lblBookSuccess = new Label(By.cssSelector("#content h1"));
    private final Label lblDepartStation = new Label(By.cssSelector(".OddRow td:nth-child(1)"));
    private final Label lblArriveStation = new Label(By.cssSelector(".OddRow td:nth-child(2)"));
    private final Label lblSeatType = new Label(By.cssSelector(".OddRow td:nth-child(3)"));
    private final Label lblDepartDate = new Label(By.cssSelector(".OddRow td:nth-child(4)"));
    private final Label lblBookDate = new Label(By.cssSelector(".OddRow td:nth-child(5)"));
    private final Label lblExpiredDate = new Label(By.cssSelector(".OddRow td:nth-child(6)"));
    private final Label lblAmount = new Label(By.cssSelector(".OddRow td:nth-child(7)"));
    private final Label lblTotalPrice = new Label(By.cssSelector(".OddRow td:nth-child(8)"));

    //Method
    public String getValueDepartStation() {
        return this.lblDepartStation.getText();
    }

    public String getValueArriveStation() {
        return  this.lblArriveStation.getText();
    }

    public String getValueSeatType() {
        return this.lblSeatType.getText();
    }

    public String getValueDepartDate() {
        return this.lblDepartDate.getText();
    }

    public String getValueExpiredDate() {
        return this.lblExpiredDate.getText();
    }

    public String getBookDate() {
        return this.lblBookDate.getText();
    }

    public String getValueAmount() {
        return this.lblAmount.getText();
    }

    public String getTotalPrice() {
        return this.lblTotalPrice.getText();
    }

    public String getSuccessfulMessage() {
        return this.lblBookSuccess.getText();
    }

    public String getInformationBookTicket() {
        return this.getValueDepartDate()+
                " "+this.getValueDepartStation()+
                " "+this.getValueArriveStation()+
                " "+this.getValueSeatType()+
                " "+this.getValueAmount()+
                " "+this.getBookDate()+
                " "+this.getValueExpiredDate()+
                " "+this.getTotalPrice();
    }
}
