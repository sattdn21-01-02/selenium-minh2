package helper.element_helper;

import helper.BrowserHelper;
import helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void waitForElementExist() {
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElementInVisible() {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getDriver(), Constant.EXPLICIT_ELEMENT_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public int getElementCount() {
        return findElements().size();
    }
}
