import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.*;

public class BoardGamesPage extends MainPageLoggedIn {
    // Locators
    private final By searchLocator = By.xpath("//div[@class='col-sm-8']//input[@class='form-control']");
    private final By hearthIconLocator = By.cssSelector("i.fa.fa-heart");

    public BoardGamesPage(WebDriver webdriver) {
        super(webdriver);
    }

    public void searchGame(String gameName) {
        sendKeysFromLocator(searchLocator, gameName);
    }

    public void addFirstGameToWishList() {
        scrollDown(20);
        clickNthElementFromLocator(hearthIconLocator, 1);
    }
}