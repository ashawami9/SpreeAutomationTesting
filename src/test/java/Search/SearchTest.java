package Search;

import init.BaseTest;
import org.testng.annotations.*;
import pages.Cart;
import pages.ProductDetailPage;
import pages.ProductListingPage;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class  SearchTest extends BaseTest {
    public Properties prop;

    @BeforeMethod
    public void testSetup() throws IOException {
        initialSetup();
        prop = readDatabase();
    }

    @AfterMethod
    public void quitTest() {
        terminate();
    }

    @Test
    public void testValidSearchInput() {
        ProductListingPage products = new ProductListingPage(driver);
        products.searchItem(prop.getProperty("validItem"));
        assertEquals(products.getSearchResultMessage(), "Search results for '" + prop.getProperty("validItem") + "'");
    }

    @Test
    public void testInvalidSearchInput() {
        ProductListingPage products = new ProductListingPage(driver);
        products.searchItem(prop.getProperty("invalidItem"));
        assertEquals(products.getSearchResultMessage(), "No products found");
    }

    @Test
    public void testSearchAndCheckIfItemSuccessfullyAddedToCart() {
        ProductListingPage products = new ProductListingPage(driver);
        products.searchItem(prop.getProperty("validItem"));
        products.clickTheProduct();
        ProductDetailPage product = new ProductDetailPage(driver);
        product.addToCartButton();
        Cart cart = new Cart(driver);
        assertEquals(cart.isCheckoutButtonClickable(), true);
    }
}
