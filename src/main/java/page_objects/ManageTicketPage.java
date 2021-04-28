package page_objects;

import helper.element_helper.Button;
import helper.element_helper.Label;
import org.openqa.selenium.By;

public class ManageTicketPage extends GeneralPage {

    private final Label lblTitlePage = new Label(By.cssSelector("[align=center]"));
    private final Label lblNumberOrder = new Label(By.cssSelector(".OddRow td:nth-child(1)"));
    private final Label lblDepartStation = new Label(By.cssSelector(".OddRow td:nth-child(2)"));
    private final Label lblArriveStation = new Label(By.cssSelector(".OddRow td:nth-child(3)"));
    private final Label lblSeatType = new Label(By.cssSelector(".OddRow td:nth-child(4)"));
    private final Label lblDepartDate = new Label(By.cssSelector(".OddRow td:nth-child(5)"));
    private final Label lblBookDate = new Label(By.cssSelector(".OddRow td:nth-child(6)"));
    private final Label lblExpiredDate = new Label(By.cssSelector(".OddRow td:nth-child(7)"));
    private final Label lblStatus = new Label(By.cssSelector(".OddRow td:nth-child(8)"));
    private final Label lblTicketAmount = new Label(By.cssSelector(".OddRow td:nth-child(9)"));
    private final Label lblTotalPrice = new Label(By.cssSelector(".OddRow td:nth-child(9)"));
    private final Button btnCancel = new Button(By.cssSelector("[value='Cancel']"));

    public void cancelBookTicket(String numberOrder) {

        this.btnCancel.click();
    }
}
