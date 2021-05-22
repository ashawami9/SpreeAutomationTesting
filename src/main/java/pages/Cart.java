package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Cart extends Header {
    @FindBy(id = "checkout-link")
    private WebElement checkoutButton;

    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean isCheckoutButtonClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        return checkoutButton.isDisplayed();
    }
}
