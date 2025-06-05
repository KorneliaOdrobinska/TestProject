import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MenuItemPage;

public class MenuItemsTest extends BaseTestCase {

    private static final String HOME_PAGE_TITLE = "Wybierz podróż dla siebie!";
    private static final String ORDER_PAGE_TITLE = "Zamówienie";
    private static final String BASKET_PAGE_TITLE = "Koszyk";
    private static final String MY_ACCOUNT_PAGE_TITLE = "Moje konto";
    private static final String WISH_LIST_PAGE_TITLE = "Lista życzeń";
    MenuItemPage menuItem;

    @BeforeTest
    private void createMenuItemPage() {
        menuItem = new MenuItemPage(driver);
        // TODO otwierac przed kazdym testem strone główną
    }


    // TODO można przerobić na jeden test z dataProviderem?
    @Test(priority = 0)
    private void openHomePageTest() {
        menuItem.openHomePage(driver);

        Assert.assertEquals(menuItem.checkPageTitle(driver), HOME_PAGE_TITLE);
    }

    @Test(priority = 1)
    private void openShopPageTest() {
        menuItem.openShopPage(driver);

        Assert.assertTrue(menuItem.checkIfShopPageIsOpened(driver));
    }

    @Test(priority = 2)
    private void openOrderPageTest() {
        menuItem.openOrderPage(driver);

        // TODO chyba nie działa bez zalogowania - nie dziala gdy koszyk jest pusty
        Assert.assertEquals(menuItem.checkPageTitle(driver), ORDER_PAGE_TITLE);
    }

    @Test(priority = 3)
    private void openBasketPageTest() {
        menuItem.openBasketPage(driver);

        Assert.assertEquals(menuItem.checkPageTitle(driver), BASKET_PAGE_TITLE);
    }

    @Test(priority = 4)
    private void openMyAccountPageTest() {
        menuItem.openMyAccountPage(driver);

        Assert.assertEquals(menuItem.checkPageTitle(driver), MY_ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 5)
    private void openWishListPageTest() {
        menuItem.openWishListPage(driver);

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        Assert.assertEquals(menuItem.checkPageTitle(driver), WISH_LIST_PAGE_TITLE);
    }
}
