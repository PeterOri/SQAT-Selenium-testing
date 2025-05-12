import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.*;


public abstract class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Locators
    private final By bodyLocator = By.tagName("body");

    protected PageBase(WebDriver webdriver) {
        this.driver = webdriver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return this.driver.findElement(locator);
    }

    protected WebElement waitAndReturnElement(By locator, boolean clickable) {
        if (clickable) {
            this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        } else {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        return this.driver.findElement(locator);
    }

    protected WebElement clickElementFromLocator(By locator) {
        WebElement locatorElement = waitAndReturnElement(locator, true);
        locatorElement.click();

        return locatorElement;
    }

    protected WebElement sendKeysFromLocator(By locator, String key) {
        WebElement locatorElement = waitAndReturnElement(locator);
        locatorElement.sendKeys(key);

        return locatorElement;
    }

    public String getBodyText() {
        WebElement bodyElement = waitAndReturnElement(bodyLocator);
        return bodyElement.getText();
    }
}