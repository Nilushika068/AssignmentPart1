package nordeaassignment.amazonpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ResultPage {
    WebDriver driver;
    By resultTitleLocator = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    By productHeaderLocator = By.xpath(".//h2");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSecondResultTitle() {
        List<WebElement> searchResults = driver.findElements(resultTitleLocator);
        WebElement secondResult = searchResults.get(1);
        return secondResult.getText();
    }
    /**
     * Clicks on the second search result.
     */
    public void clickSecondResult() {
    	
        List<WebElement> searchResults = driver.findElements(resultTitleLocator);
  
        WebElement secondResult = searchResults.get(1);
        secondResult.click();
    }

    public String getProductHeaderText() {
        WebElement productHeader = driver.findElement(productHeaderLocator);
        return productHeader.getText();
    }
}
