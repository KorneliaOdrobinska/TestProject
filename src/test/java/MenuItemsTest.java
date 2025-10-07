import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MenuItemPage;

import static pages.GLOBAL_VALUES.PAGE_TITLE_BASKET;

public class MenuItemsTest extends BaseTestCase {

    private static final String HOME_PAGE_TITLE = "Wybierz podróż dla siebie!";
    private static final String ORDER_PAGE_TITLE = "Zamówienie";
    private static final String MY_ACCOUNT_PAGE_TITLE = "Moje konto";
    private static final String WISH_LIST_PAGE_TITLE = "Lista życzeń";
    MenuItemPage menuItem;

    @BeforeMethod
    private void createMenuItemPage() {
        menuItem = new MenuItemPage(driver);
        //menuItem.openHomePage(driver);
    }


    // TODO 1!!! można przerobić na jeden test z dataProviderem?
    @Test(priority = 0)
    private void openHomePageTest() {
        menuItem.openHomePage(driver);

        Assert.assertEquals(menuItem.checkPageTitle(), HOME_PAGE_TITLE);
    }

    @Test(priority = 1)
    private void openShopPageTest() {
        menuItem.openShopPage(driver);

        Assert.assertTrue(menuItem.checkIfShopPageIsOpened());
    }

    @Test(priority = 2)
    private void openOrderPageTest() {
        menuItem.openOrderPage(driver);

        // TODO chyba nie działa bez zalogowania - nie dziala gdy koszyk jest pusty
        Assert.assertEquals(menuItem.checkPageTitle(), ORDER_PAGE_TITLE);
    }

    @Test(priority = 3)
    private void openBasketPageTest() {
        menuItem.openBasketPage(driver);

        Assert.assertEquals(menuItem.checkPageTitle(), PAGE_TITLE_BASKET);
    }

    @Test(priority = 4)
    private void openMyAccountPageTest() {
        menuItem.openMyAccountPage(driver);

        Assert.assertEquals(menuItem.checkPageTitle(), MY_ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 5)
    private void openWishListPageTest() {
        menuItem.openWishListPage(driver);

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        Assert.assertEquals(menuItem.checkPageTitle(), WISH_LIST_PAGE_TITLE);
    }
}
