import org.openqa.selenium.WebDriver;

public class ProductPage extends PageBase{
    public ProductPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }
}
