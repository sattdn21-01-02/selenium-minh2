package helper;

import helper.element_helper.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper extends BaseElement {

    public ElementHelper(By locator) {
        super(locator);
    }

    public static WebElement waitForElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getDriver(), seconds);
        WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(element));
        return elements;
    }

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserHelper.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
