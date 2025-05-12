import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.*;

public class LoginPage extends PageBase {
    // Locators
    private final By usernameTextBoxLocator = By.id("username");
    private final By passwordTextBoxLocator = By.id("password");
    private final By loginButtonLocator = By.xpath("//div[@class='row margin-bottom-70']//button[contains(normalize-space(), 'Belépés')]");

    public LoginPage(WebDriver webdriver) {
        super(webdriver);
    }

    public void Login(String username, String password) {
        sendKeysFromLocator(usernameTextBoxLocator, username);
        sendKeysFromLocator(passwordTextBoxLocator, password);
        clickElementFromLocator(loginButtonLocator);
    }
}