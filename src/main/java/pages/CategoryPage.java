package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static pages.GLOBAL_VALUES.PAGE_TITLE_BASKET;
import static pages.GLOBAL_VALUES.XPATH_ENTRY_TITLE;

public class CategoryPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CategoryPage.class);

    private static final String XPATH_ADD_TO_BASKET = "//a[text() = 'Dodaj do koszyka'][contains(@aria-label, '";
    private static final String XPATH_ADDED_TO_CART = "//a[contains(@class, 'added_to_cart')]";


    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasket(String productName) {
        log.info("Adding : " + productName + " to the basket");
        WebElement element = driver.findElement(By.xpath(XPATH_ADD_TO_BASKET + productName + "')]"));
        scrollAndClick(element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ADDED_TO_CART)));

    }

    public BasketPage goToBasket(WebDriver driver) {
        log.info("Go to the basket");
        driver.findElement(By.xpath(XPATH_ADDED_TO_CART)).click();
        wait.until(ExpectedConditions.textToBe(By.xpath(XPATH_ENTRY_TITLE), PAGE_TITLE_BASKET));

        return new BasketPage(driver);
    }

}
