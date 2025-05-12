import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.*;

public class MainPage extends PageBase {
    // Locators
    private final By loginLinkLocator = By.cssSelector("a[href='/register/']");
    private final By cookieAcceptButton = By.xpath("//div[@class='disclaimer-button']//a[contains(normalize-space(), 'Elfogadom!')]");

    public MainPage(WebDriver webdriver) {
        super(webdriver);
        this.driver.get("http://tarsasjatekok.com");

        clickElementFromLocator(cookieAcceptButton);
    }

    public LoginPage PushLoginLink() {
        clickElementFromLocator(loginLinkLocator);

        return new LoginPage(this.driver);
    }
}