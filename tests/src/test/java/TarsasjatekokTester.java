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
    public void loginWithValidCredentials() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.PushLoginLink();

        Assert.assertTrue("LoginPage should contain login text", loginPage.getBodyText().toLowerCase().contains("belépés"));

        loginPage.Login(ConfigReader.get("username"), ConfigReader.get("password"));
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

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}