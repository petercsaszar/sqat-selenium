import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends PageBase{
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.hestore.hu/forgot.php");
    }

    private By emailBy = By.name("email");
    private By submitBtn = By.xpath("//input[@value='Jelszóhelyreállító küldése']");

    public ForgotPasswordPage sendForm(String email) {
        WebElement emailField = driver.findElement(emailBy);
        emailField.sendKeys(email);

        WebElement submitButton = driver.findElement(submitBtn);
        submitButton.click();

        return this;
    }
}
