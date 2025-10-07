package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static pages.GLOBAL_VALUES.XPATH_SHOP_PAGE_TITLE;

public class ShopPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ShopPage.class);

    private static final String XPATH_CATEGORY = "//li[contains(@class,'product-category')]/a[@aria-label = 'Przejdź do kategorii produktu ";


    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public CategoryPage chooseCategory(WebDriver driver, String categoryName) {
        log.info("Choosing Category: " + categoryName);
        driver.findElement(By.xpath(XPATH_CATEGORY + categoryName + "']")).click();
        wait.until(ExpectedConditions.textToBe(By.xpath(XPATH_SHOP_PAGE_TITLE), categoryName));

        return new CategoryPage(driver);
    }

}
