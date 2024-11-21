import org.testng.annotations.Test;
import pages.MenuItemPage;

public class LoginTest extends BaseTestCase{
    MenuItemPage menuItem;
    @Test
    private void openMyAccountPage(){
        menuItem = new MenuItemPage(); // TODO gdzie tworzyc obiekt? jeden globalny czy w kazdej metodzie?
        menuItem.myAccount(driver);

        // TODO dodac assercje czy strona sie otworzyla
    }
}
