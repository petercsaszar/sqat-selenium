/*

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class FirstSeleniumHomework {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    private final By bodyLocator = By.tagName("body");
    private final By emailLocator = By.id("email_login");
    private final By passwordLocator = By.id("password");
    private final By buttonLocator = By.className("radius");




    private WebElement waitVisibiiltyAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    @Test
    public void testValidLogin() {
        this.driver.get("https://vizvonal.hu/customer/login");

        WebElement resultElement = waitVisibiiltyAndFindElement(bodyLocator);
        System.out.println(resultElement.getText());
        Assert.assertTrue(resultElement.getText().contains("Belépés"));

        WebElement usernameElement = waitVisibiiltyAndFindElement(emailLocator);
        usernameElement.sendKeys("tomsmith");


        WebElement passwordElement = waitVisibiiltyAndFindElement(passwordLocator);
        passwordElement.sendKeys("SuperSecretPassword!");

        WebElement loginButton = waitVisibiiltyAndFindElement(buttonLocator);
        loginButton.click();

        resultElement = waitVisibiiltyAndFindElement(bodyLocator);
        System.out.println(resultElement.getText());
        Assert.assertTrue(resultElement.getText().contains("Secure Area"));

        WebElement logoutButton = waitVisibiiltyAndFindElement(buttonLocator);
        logoutButton.click();

    }

    @Test
    public void testInvalidLogin() {
        this.driver.get("http://the-internet.herokuapp.com/login");

        WebElement resultElement = waitVisibiiltyAndFindElement(bodyLocator);
        System.out.println(resultElement.getText());
        Assert.assertTrue(resultElement.getText().contains("Login Page"));

        WebElement usernameElement = waitVisibiiltyAndFindElement(usernameLocator);
        usernameElement.sendKeys("tomsmith");


        WebElement passwordElement = waitVisibiiltyAndFindElement(passwordLocator);
        passwordElement.sendKeys("SuperWrongPassword!");

        WebElement loginButton = waitVisibiiltyAndFindElement(buttonLocator);
        loginButton.click();

        resultElement = waitVisibiiltyAndFindElement(bodyLocator);
        System.out.println(resultElement.getText());
        Assert.assertTrue(resultElement.getText().contains("Your password is invalid!"));


    }


    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
*/