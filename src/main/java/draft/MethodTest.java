package draft;

import helper.BrowserHelper;
import helper.ElementHelper;
import helper.element_helper.Button;
import org.openqa.selenium.By;

public class MethodTest {

    public void cancelSpecifiedTicket(String id) {
        String xPath = "//td[count(//th[text()='No.']) and text() = "+id+"]//following-sibling::td//input";
        Button btnCancel = new Button(By.xpath(xPath));
        ElementHelper.scrollToView(btnCancel.findElement());

        BrowserHelper.getDriver().switchTo().alert().accept();
    }
}
