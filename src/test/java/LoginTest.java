import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MenuItemPage;

public class LoginTest extends BaseTestCase{

    private static final String MY_ACCOUNT_PAGE_TITLE = "Moje konto";
    MenuItemPage menuItem;
    @Test
    private void openMyAccountPage(){
        menuItem = new MenuItemPage(); // TODO gdzie tworzyc obiekt? jeden globalny czy w kazdej metodzie?
        menuItem.myAccount(driver);

        Assert.assertEquals(menuItem.checkPageTitle(driver), MY_ACCOUNT_PAGE_TITLE);
    }
}
