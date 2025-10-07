package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static pages.GLOBAL_VALUES.XPATH_ENTRY_TITLE;
import static pages.GLOBAL_VALUES.XPATH_SHOP_PAGE_TITLE;

public class MenuItemPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(MenuItemPage.class);

    private static final String XPATH_MENU_HOME = "//li[@id = 'menu-item-197']";
    private static final String XPATH_MENU_SHOP = "//li[@id = 'menu-item-198']";
    private static final String XPATH_MENU_ORDER = "//li[@id = 'menu-item-199']";
    private static final String XPATH_MENU_BASKET = "//li[@id = 'menu-item-200']";
    private static final String XPATH_MENU_MY_ACCOUNT = "//li[@id = 'menu-item-201']";
    private static final String XPATH_MENU_WISH_LIST = "//li[@id = 'menu-item-248']";

    public MenuItemPage(WebDriver driver) {
        super(driver);
    }

    private void chooseItem(WebDriver driver, String xpath) {
        log.info("Choosing Item: " + xpath);
        driver.findElement(By.xpath(xpath)).click();
        // TODO zrealizować czekadełko
        //wait.withTimeout(Duration.ofSeconds(10));
    }

    public void openHomePage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_HOME);
    }

    public ShopPage openShopPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_SHOP);
        return new ShopPage(driver);
    }

    public OrderPage openOrderPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_ORDER);
        return new OrderPage(driver);
    }

    public BasketPage openBasketPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_BASKET);
        return new BasketPage(driver);
    }

    public MyAccountPage openMyAccountPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_MY_ACCOUNT);
        return new MyAccountPage(driver);
    }

    public void openWishListPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_WISH_LIST);
        // TODO return
    }

    public String checkPageTitle() {
        List<WebElement> entryTitle = driver.findElements(By.xpath(XPATH_ENTRY_TITLE));
        return !entryTitle.isEmpty() ? entryTitle.get(0).getText() : "";
    }

    public boolean checkIfShopPageIsOpened() {
        List<WebElement> shopTitle = driver.findElements(By.xpath(XPATH_SHOP_PAGE_TITLE));
        return !shopTitle.isEmpty() ? shopTitle.get(0).getText().equals("Sklep") : false;
    }

}
