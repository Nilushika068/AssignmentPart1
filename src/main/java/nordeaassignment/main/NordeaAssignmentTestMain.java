package nordeaassignment.main;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import nordeaassignment.amazonpages.HomePage;
import nordeaassignment.amazonpages.ResultPage;

public class NordeaAssignmentTestMain {
	
	private static final String webdriverURL=  "Path-To-Webdriver\\chromedriver.exe";
	
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",webdriverURL);
        WebDriver driver = new ChromeDriver();

        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = new ResultPage(driver);

        homePage.openHomePage("https://www.amazon.com"); 
        homePage.enterSearchKeyword("Nikon");


        WebElement sortByDropdown = driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
        Select select = new Select(sortByDropdown);
        select.selectByValue("price-desc-rank");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(".//h2")));

       
        resultPage.clickSecondResult();
        String headerText = resultPage.getProductHeaderText();
      assert headerText.contains("Nikon D3X") : "Product topic/header does not contain 'Nikon D3X'";

        driver.quit();
    }

}
