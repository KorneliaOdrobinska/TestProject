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
        categoryPage.addToBasket("Grań Kościelców");
        basketPage = categoryPage.goToBasket(driver);
        orderPage = basketPage.goToPayment(driver);

        orderPage.setFirstName("Kornelia");
        orderPage.setLastName("xxx");
        orderPage.setAddress("Alternatywy 4");
        orderPage.setPostcode("56-099");
        orderPage.setCity("Radom");
        orderPage.setPhone("666-666-666");
        orderPage.setEmail("xxx@wp.pl");

        orderPage.setCardNumber("4242424242424242");
        orderPage.setExpiryDate("12/12");
        orderPage.setCvcCode("666");


    }


}
