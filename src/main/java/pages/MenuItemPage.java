package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuItemPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(MenuItemPage.class); // TODO nie powinien dziedziczyc loggera po BasePage?

    private static final String XPATH_MENU_HOME = "//li[@id = 'menu-item-197']";
    private static final String XPATH_MENU_SHOP = "//li[@id = 'menu-item-198']";
    private static final String XPATH_MENU_ORDER = "//li[@id = 'menu-item-199']";
    private static final String XPATH_MENU_BASKET = "//li[@id = 'menu-item-200']";
    private static final String XPATH_MENU_MY_ACCOUNT = "//li[@id = 'menu-item-201']";
    private static final String XPATH_MENU_WISH_LIST = "//li[@id = 'menu-item-248']";
    private static final String XPATH_ENTRY_TITLE = "//h1[@class = 'entry-title']";
    private static final String XPATH_SHOP_PAGE_TITLE = "//h1[@class = 'woocommerce-products-header__title page-title']";

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

    public void openOrderPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_ORDER);
    }

    public void openBasketPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_BASKET);
    }

    public void openMyAccountPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_MY_ACCOUNT);
    }

    public void openWishListPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_WISH_LIST);
    }

    public String checkPageTitle(WebDriver driver) {
        // TODO czy nie trzeba dodac łapania wyjątku gdyby elementu nie było?
        return driver.findElement(By.xpath(XPATH_ENTRY_TITLE)).getText();
    }

    public boolean checkIfShopPageIsOpened(WebDriver driver) {
        // TODO czy nie trzeba dodac łapania wyjątku gdyby elementu nie było?
        return driver.findElement(By.xpath(XPATH_SHOP_PAGE_TITLE)).getText().equals("Sklep");
    }

}
