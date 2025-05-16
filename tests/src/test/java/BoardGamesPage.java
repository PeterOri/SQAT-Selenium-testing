import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.*;

public class BoardGamesPage extends PageBase {
    // Locators
    private final By searchLocator = By.xpath("//div[@class='col-sm-8']//input[@class='form-control']");
    private final By hearthIconLocator = By.cssSelector("i.fa.fa-heart");

    public BoardGamesPage(WebDriver webdriver) {
        super(webdriver);
    }

    public void searchAndOpenGame(String gameName) {
        sendKeysFromLocator(searchLocator, gameName);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {}

        scrollDown(15);
        clickNthElementFromLocator(hearthIconLocator, 1);
    }
}