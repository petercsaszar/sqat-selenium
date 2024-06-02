import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.hestore.hu/login.php");
    }

    private final By emailLocator = By.name("email");
    private final By passwordLocator = By.name("passw");
    private final By loginBtnLocator = By.xpath("//input[@value='Bejelentkezés']");

    public MainPage login(String email, String password) {
        WebElement emailElement = this.waitAndReturnElement(emailLocator);
        emailElement.sendKeys(email);

        WebElement passwordElement = this.waitAndReturnElement(passwordLocator);
        passwordElement.sendKeys(password);

        WebElement loginButton = this.waitAndReturnElement(loginBtnLocator);
        loginButton.click();

        return new MainPage(driver);
    }

    public LoginPage invalidLogin() {

        WebElement emailElement = this.waitAndReturnElement(emailLocator);
        emailElement.sendKeys("invalid@email.com");

        WebElement passwordElement = this.waitAndReturnElement(passwordLocator);
        passwordElement.sendKeys("InvalidPassword");

        WebElement loginButton = this.waitAndReturnElement(loginBtnLocator);
        loginButton.click();

        return this;
    }

}
