import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MenuItemPage;
import pages.MyAccountPage;

public class LoginTest extends BaseTestCase {

    private static final String MY_ACCOUNT_PAGE_TITLE = "Moje konto";
    MenuItemPage menuItem;
    MyAccountPage myAccountPage;

    @Test(priority = 0)
    private void openMyAccountPageTest() {
        menuItem = new MenuItemPage(driver);
        myAccountPage = menuItem.openMyAccountPage(driver);

        Assert.assertEquals(menuItem.checkPageTitle(), MY_ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 1)
    private void logInTest() {
        myAccountPage.setEmail("kornelia.fabian92@gmail.com");
        myAccountPage.setPassword("Automaty1234!");
        myAccountPage.clickLogIn();

        Assert.assertTrue(myAccountPage.checkIfUserIsLogged("kornelia.fabian92"));
    }
}
