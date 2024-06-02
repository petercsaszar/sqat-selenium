import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {
    public WebDriver driver;
    public JsonNode config;

    @Before
    public void setup()  throws MalformedURLException, IOException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();

        ObjectMapper objectMapper = new ObjectMapper();
        config = objectMapper.readTree(new File("src/test/resources/config.json"));

    }

    @Test
    public void searchTest(){
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.getBodyText().contains("Újdonságok"));
        SearchResultPage resultPage = mainPage.search("ellenállás");
        Assert.assertTrue(resultPage.getBodyText().contains("19.6K-1%-0.6W"));
    }

    @Test
    public void invalidSearchTest(){
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.getBodyText().contains("Újdonságok"));
        SearchResultPage resultPage = mainPage.search("xxxxxxxxxxxxxxxxxxxxxxxx");
        Assert.assertTrue(resultPage.getBodyText().contains("Nincs a keresési feltételnek megfelelő megjeleníthető termék!"));
    }

    @Test
    public void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getBodyText().contains("Bejelentkezés"));
        loginPage = loginPage.invalidLogin();
        Assert.assertTrue(loginPage.getBodyText().contains("Bejelentkezés"));
        Assert.assertTrue(loginPage.getBodyText().contains("A megadott e-mail cím / jelszó érvénytelen!"));
    }

    @Test
    public void validLogin(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getBodyText().contains("Bejelentkezés"));
        MainPage mainPage = loginPage.login(config.get("email").asText(), config.get("password").asText());
        Assert.assertTrue(mainPage.getBodyText().contains(config.get("user").asText()));
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
