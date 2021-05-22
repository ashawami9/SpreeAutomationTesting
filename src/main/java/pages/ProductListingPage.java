package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListingPage extends Header {
    @FindBy(linkText = "Ruby on Rails Ringer T-Shirt")
    private WebElement searchedProduct;

    public ProductListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickTheProduct() {
        wait.until(ExpectedConditions.visibilityOf(searchedProduct));
        searchedProduct.click();
    }
}
