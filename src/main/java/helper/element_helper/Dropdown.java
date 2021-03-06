package helper.element_helper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement {
    public Dropdown(By locator) {
        super(locator);
    }

    public void selectDropDownValue(String value) {
        Select select = new Select(findElement());
        select.selectByValue(value);
    }

    public void selectDropDownText(String text) {
        Select select = new Select(findElement());
        select.selectByVisibleText(text);
    }

    public String getSelectedValue() {
        Select select = new Select(findElement());
        return select.getFirstSelectedOption().getText();
    }
}
