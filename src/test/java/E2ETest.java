import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MenuItemPage;
import pages.ShopPage;

public class E2ETest extends BaseTestCase {

    private static final String CATEGORY_NAME = "Wspinaczka";
    MenuItemPage menuItem;
    ShopPage shopPage;
    CategoryPage categoryPage;

    @Test(priority = 1)
    private void E2ETest() {
        menuItem = new MenuItemPage(driver);
        shopPage = menuItem.openShopPage(driver);
        categoryPage = shopPage.chooseCategory(driver, CATEGORY_NAME);
        categoryPage.addToBasket(driver, "Grań Kościelców");
        categoryPage.goToBasket(driver);
    }


}
