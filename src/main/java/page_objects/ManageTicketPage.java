package page_objects;

import helper.BrowserHelper;
import helper.ElementHelper;
import helper.element_helper.Button;
import helper.element_helper.Label;
import org.openqa.selenium.By;

public class ManageTicketPage extends GeneralPage {

    Label lblTitle = new Label(By.cssSelector("h1[align=center]"));
    Label lblErrorMessage = new Label(By.xpath("//li[contains(text(),'You')]"));
    Button btnCancel = new Button(By.cssSelector("[value=Cancel]"));

    public void cancelAllTicket() {
        int size = this.btnCancel.findElements().size();
        for (int i = 0; i < size; i++) {
            ElementHelper.scrollToView(btnCancel.findElement());
            this.btnCancel.click();
            BrowserHelper.getDriver().switchTo().alert().accept();
        }
    }

    public void cancelSpecifiedTicket(int id) {
        String xPath = "//td[count(//th[text()='No.']) and text() = "+id+"]//following-sibling::td//input";
        Button btnCancel = new Button(By.xpath(xPath));
        ElementHelper.scrollToView(btnCancel.findElement());
        this.btnCancel.click();
        BrowserHelper.getDriver().switchTo().alert().accept();
    }

    public String getTicketAmount() {
        return this.lblErrorMessage.getText();
    }
}
