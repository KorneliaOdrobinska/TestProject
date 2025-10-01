import org.testng.annotations.Test;
import pages.*;

public class E2ETest extends BaseTestCase {

    private static final String CATEGORY_NAME = "Wspinaczka";
    MenuItemPage menuItem;
    ShopPage shopPage;
    CategoryPage categoryPage;
    BasketPage basketPage;
    OrderPage orderPage;

    @Test(priority = 1)
    private void E2ETest() {
        menuItem = new MenuItemPage(driver);
        shopPage = menuItem.openShopPage(driver);
        categoryPage = shopPage.chooseCategory(driver, CATEGORY_NAME);
        categoryPage.addToBasket(driver, "Grań Kościelców");
        basketPage = categoryPage.goToBasket(driver);
        orderPage = basketPage.goToPayment(driver);

        // TODO 0!!! sprobowac usunac driver z metod -- czy wszedzie trzeb podawac driver?
        orderPage.setFirstName(driver, "Kornelia");
        orderPage.setLastName(driver, "xxx");
        orderPage.setAddress(driver, "Alternatywy 4");
        orderPage.setPostcode(driver, "56-099");
        orderPage.setCity(driver, "Radom");
        orderPage.setPhone(driver, "666-666-666");
        orderPage.setEmail(driver, "xxx@wp.pl");

        orderPage.setCardNumber(driver, "4242424242424242");
        orderPage.setExpiryDate(driver, "12/12");
        orderPage.setCvcCode(driver, "666");


    }


}
