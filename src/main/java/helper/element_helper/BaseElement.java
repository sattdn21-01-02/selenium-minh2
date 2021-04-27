package helper.element_helper;

import helper.BrowserHelper;
import helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {

    private final By locator;

    private JavascriptExecutor js = (JavascriptExecutor) BrowserHelper.getDriver();

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return BrowserHelper.getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return BrowserHelper.getDriver().findElements(locator);
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        return findElement().getText();
    }

    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    public boolean isSelected() {
        return findElement().isDisplayed();
    }

    public void disableElement() {
        js.executeScript("arguments[0].setAttribute('style', 'display:none')", findElement());
    }

    public void waitForElementExist() {
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }
}