import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.*;

public class ProfilePage extends PageBase {
    // Locators
    private final By listsLinkLocator = By.xpath("//a[contains(normalize-space(), 'Listák')]");
    private final By wishListLinkLocator = By.xpath("//a[contains(normalize-space(), 'Kívánságlistám')]");
    private final By removeHearthIconLocator = By.cssSelector(".fa.fa-heart-o");

    public ProfilePage(WebDriver webdriver) {
        super(webdriver);
    }

    public void openWishList() {
        clickElementFromLocator(listsLinkLocator);
        clickElementFromLocator(wishListLinkLocator);
    }

    public void clearWishList() {
        clickElementFromLocator(removeHearthIconLocator);
        openWishList();
    }
}