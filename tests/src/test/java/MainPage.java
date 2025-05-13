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
    private final By loginButtonLocator = By.xpath("//div[contains(@class, 'user-badge')]//a[@class='user_icon']//i[contains(@class, 'fa-sign-in') and contains(@class, 'icon-custom')]");
    private final By gamesMenuLocator = By.cssSelector("a[href='/tarsasjatek']");
    private final By allBoardGamesLinkLocator = By.xpath("//ul[contains(@class, 'dropdown-menu')]//a[normalize-space(text())='Összes társasjáték']");
    private final By notificationTabNotButton = By.xpath("//div[@class='modal-footer']//button[normalize-space(text())='MOST NEM']");

    public MainPage(WebDriver webdriver) {
        super(webdriver);
        this.driver.get("http://tarsasjatekok.com");

        clickElementFromLocator(cookieAcceptButton);
    }
    protected MainPage(WebDriver webdriver, boolean skipCreation) {
        super(webdriver);
    }

    public LoginPage PushLoginLink() {
        clickElementFromLocator(loginLinkLocator);

        return new LoginPage(this.driver);
    }

    public boolean isLoginButtonVisible() {
        try {
            waitAndReturnElement(loginButtonLocator);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public BoardGamesPage openAllBoardGames() {
        try {
            // Waiting for notification pop-up to come
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        clickElementFromLocator(notificationTabNotButton);
        clickElementFromLocator(gamesMenuLocator);
        clickElementFromLocator(allBoardGamesLinkLocator);

        return new BoardGamesPage(this.driver);
    }
}