package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuItemPage {

    // TODO uproscic xpatha
    private static final String XPATH_MENU_HOME = "//li[@id = 'menu-item-197']";
    private static final String XPATH_MENU_SHOP = "//li[@id = 'menu-item-198']";
    private static final String XPATH_MENU_ORDER = "//li[@id = 'menu-item-199']";
    private static final String XPATH_MENU_BASKET = "//li[@id = 'menu-item-200']";
    private static final String XPATH_MENU_MY_ACCOUNT = "//li[@id = 'menu-item-201']";
    private static final String XPATH_MENU_WISH_LIST = "//li[@id = 'menu-item-248']";
    private static final String XPATH_ENTRY_TITLE = "//h1[@class = 'entry-title']";
    private static final String XPATH_SHOP_PAGE_TITLE = "//h1[@class = 'woocommerce-products-header__title page-title']";

    private void chooseItem(WebDriver driver, String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void openHomePage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_HOME);
    }

    public void openShopPage(WebDriver driver) {

        chooseItem(driver, XPATH_MENU_SHOP);
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
