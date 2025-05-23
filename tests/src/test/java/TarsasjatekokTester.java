import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.*;


public class TarsasjatekokTester {
    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException, InterruptedException  {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
    }

    @Test
    public void staticPagesShouldHaveCorrectTitles() {
        String[] staticPages = ConfigReader.get("static_pages").split(",");

        // test all static pages from config file with expected title
        for (String url : staticPages) {
            String trimmedUrl = url.trim();
            driver.get(trimmedUrl);

            String title = driver.getTitle();
            String expectedTitle = ConfigReader.get("expected_title");
            Assert.assertTrue("Page " + trimmedUrl + " should contain '" + expectedTitle + "' in the title", title.contains(expectedTitle));
        }

        // test main page with main title
        String mainTitle = ConfigReader.get("main_title");
        MainPage mainPage = new MainPage(this.driver);
        String title = mainPage.getPageTitle();
        Assert.assertTrue("Main page should contain '" + mainTitle + "' in the title", title.contains(mainTitle));
    }

    /*@Test
    public void loginAndOutWithValidCredentials() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.PushLoginLink();

        Assert.assertTrue("LoginPage should contain login text", loginPage.getBodyText().toLowerCase().contains("belépés"));

        MainPageLoggedIn mainPageLoggedIn = loginPage.Login(ConfigReader.get("username"), ConfigReader.get("password"));

        // Test if profile is available after valid login process.
        String profileBarText = mainPageLoggedIn.openAndGetProfileText();
        Assert.assertTrue("Profile bar should contain user name", profileBarText.contains(ConfigReader.get("username")));
        Assert.assertTrue("Profile bar should contain logging out option", profileBarText.contains("Kilépés"));
        Assert.assertTrue("Profile bar should contain notifications", profileBarText.contains("Értesítések"));

        // Logout
        mainPage = mainPageLoggedIn.logout();
        Assert.assertTrue("Login icon should appear after logging out", mainPage.isLoginButtonVisible());
    }

    @Test
    public void loginWithInvalidUsername() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.PushLoginLink();

        String invalidUsername;
        do {
            invalidUsername = RandomSampleGenerator.getUsername();
        } while (invalidUsername.equals(ConfigReader.get("username")));

        loginPage.Login(invalidUsername, ConfigReader.get("password"));

        String loginPageBodyText = loginPage.getBodyText().toLowerCase();
        Assert.assertTrue("LoginPage should contain error message", loginPageBodyText.contains("hibás") && loginPageBodyText.contains("felhasználónév"));
    }

    @Test
    public void loginWithInvalidPassword() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.PushLoginLink();

        String invalidPassword;
        do {
            invalidPassword = RandomSampleGenerator.getPassword();
        } while (invalidPassword.equals(ConfigReader.get("password")));

        loginPage.Login(ConfigReader.get("username"), invalidPassword);

        String loginPageBodyText = loginPage.getBodyText().toLowerCase();
        Assert.assertTrue("LoginPage should contain error message", loginPageBodyText.contains("hibás") && loginPageBodyText.contains("jelszó"));
    }

    @Test
    public void addAndRemoveGameFromWishList() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.PushLoginLink();
        MainPageLoggedIn mainPageLoggedIn = loginPage.Login(ConfigReader.get("username"), ConfigReader.get("password"));

        BoardGamesPage boardGames = mainPageLoggedIn.openAllBoardGames();
        boardGames.searchGame(ConfigReader.get("board_game_to_search"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        boardGames.addFirstGameToWishList();
        boardGames.openAndGetProfileText();
        ProfilePage profilePage = boardGames.openProfile();

        profilePage.openWishList();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        String boardGame = ConfigReader.get("board_game_to_search");
        Assert.assertTrue(boardGame + " should be in the wishlist", profilePage.getBodyText().contains(boardGame));

        profilePage.clearWishList();
        Assert.assertFalse(boardGame + " should NOT be in the wishlist", profilePage.getBodyText().contains(boardGame));
    }*/

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}