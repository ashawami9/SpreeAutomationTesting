package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    private WebDriver driver;

    @BeforeMethod
    public void initialSetup(){
        System.setProperty("webdriver.chrome.driver" , "/Users/ashawami/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com");
    }

    @AfterMethod
    public void endSetup(){
        driver.close();
    }

    @Test
    public void testSearchAndAssertIfItemAddedToCart(){
        String search_item = "Shirt";
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement search_bar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keywords")));
        search_bar.sendKeys(search_item);

        WebElement search_button = driver.findElement(By.className("btn-success"));
        search_button.click();

        WebElement search_result_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-results-title")));

        assertEquals(search_result_title.getText() , "Search results for " + "'" +  search_item + "'");

        WebElement select_shirt = driver.findElement(By.linkText("Ruby on Rails Ringer T-Shirt"));
        select_shirt.click();

        WebElement add_to_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
        add_to_cart.click();

        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-link")));

        assertEquals(checkout.isDisplayed() , true);
    }
}
