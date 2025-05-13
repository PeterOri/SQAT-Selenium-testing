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

    public BoardGamesPage(WebDriver webdriver) {
        super(webdriver);
    }
}