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
        menuItem = new MenuItemPage(driver); // TODO 1!!! gdzie tworzyc obiekt? jeden globalny czy w kazdej metodzie?
        myAccountPage = menuItem.openMyAccountPage(driver);

        Assert.assertEquals(menuItem.checkPageTitle(driver), MY_ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 1)
    private void logInTest() {
        myAccountPage.setEmail(driver, "kornelia.fabian92@gmail.com");
        myAccountPage.setPassword(driver, "Automaty1234!");
        myAccountPage.clickLogIn(driver);

        Assert.assertTrue(myAccountPage.checkIfUserIsLogged(driver, "kornelia.fabian92"));
    }
}
