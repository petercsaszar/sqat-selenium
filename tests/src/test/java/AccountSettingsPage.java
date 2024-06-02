import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSettingsPage extends PageBase{
    public AccountSettingsPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.hestore.hu/profile_settings.php");
    }

    private By oldPasswordBy = By.name("oldpw");
    private By newPasswordBy = By.name("newpw");
    private By newPasswordRepeatBy = By.name("newpw2");
    private By passwordBtnBy = By.xpath("//input[@value='Jelszó módosítása']");

    public AccountSettingsPage changePassword(String oldPassword, String newPassword) {
        WebElement oldPwElement = this.waitAndReturnElement(oldPasswordBy);
        oldPwElement.sendKeys(oldPassword);

        WebElement newPwElement = this.waitAndReturnElement(newPasswordBy);
        newPwElement.sendKeys(newPassword);

        WebElement newPwRepeatElement = this.waitAndReturnElement(newPasswordRepeatBy);
        newPwRepeatElement.sendKeys(newPassword);

        WebElement passwordBtnElement = this.waitAndReturnElement(passwordBtnBy);
        passwordBtnElement.click();

        return this;
    }
}
