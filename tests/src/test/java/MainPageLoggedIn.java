import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.*;

public class MainPageLoggedIn extends MainPage {
    // Locators
    private final By baseProfilePictureLocator = By.xpath("//img[contains(@src, 'avatar-transparent')]");
    private final By profileBarLocator = By.cssSelector(".user_bar.profile");
    private final By logoutLinkLocator = By.className("logout");
    private final By profileLinkLocator = By.className("name-location");

    public MainPageLoggedIn(WebDriver webdriver) {
        super(webdriver, true);
    }

    public String openAndGetProfileText() {
        clickElementFromLocator(baseProfilePictureLocator);
        return waitAndReturnElement(profileBarLocator).getText();
    }

    public MainPage logout() {
        clickElementFromLocator(logoutLinkLocator);

        return new MainPage(this.driver, true);
    }

    public ProfilePage openProfile() {
        clickElementFromLocator(profileLinkLocator);
        return new ProfilePage(this.driver);
    }
}