import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://hestore.hu/");
    }

    private By searchBarBy = By.xpath("//div[@id='menuSearch']/form/input[@name='q']");

    public SearchResultPage search(String query) {
        this.waitAndReturnElement(searchBarBy).sendKeys(query + "\n");
        return new SearchResultPage(driver);
    }
}
