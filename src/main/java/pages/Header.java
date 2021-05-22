package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage {
    @FindBy(id = "link-to-login")
    private WebElement loginButton;
    @FindBy(linkText = "Logout")
    private WebElement logoutButton;
    @FindBy(className = "alert")
    private WebElement loginMessage;
    @FindBy(id = "keywords")
    private WebElement searchInput;
    @FindBy(className = "search-results-title")
    private WebElement searchResultTitle;
    @FindBy(className = "btn-success")
    private WebElement searchButton;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public void searchItem(String searchText) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(searchText);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public String getLoginMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginMessage));
        return loginMessage.getText();
    }

    public String getSearchResultMessage() {
        wait.until(ExpectedConditions.visibilityOf(searchResultTitle));
        return searchResultTitle.getText();
    }
}
