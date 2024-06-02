import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends PageBase {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickProductPage(String productName){
        By productLinkBy = By.xpath("//a[b='"+productName+"']");
        WebElement productLink = driver.findElement(productLinkBy);

        return new ProductPage(driver, productLink.getAttribute("href"));
    }
}
