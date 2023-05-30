package nordeaassignment.amazonpages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    WebDriver driver;
    By searchBoxLocator = By.id("twotabsearchtextbox");

 // Constructor that takes a WebDriver instance
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

 // Method to open the home page of the website -Amazon.com
    public void openHomePage(String url) {
        driver.get(url);
    }

 // Method to enter a search keyword in the search box
    public void enterSearchKeyword(String keyword) {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.RETURN);
    }
}