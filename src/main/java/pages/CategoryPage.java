package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CategoryPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CategoryPage.class); // TODO nie powinien dziedziczyc loggera po BasePage?

    private static final String XPATH_ADD_TO_BASKET = "//a[text() = 'Dodaj do koszyka'][contains(@aria-label, '";
    private static final String XPATH_ADDED_TO_CART = "//a[contains(@class, 'added_to_cart')]";


    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasket(WebDriver driver, String productName) {
        log.info("Adding : " + productName + " to the basket");
        WebElement element = driver.findElement(By.xpath(XPATH_ADD_TO_BASKET + productName + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ADDED_TO_CART)));

    }

    public void goToBasket(WebDriver driver) {
        log.info("Go to the basket");
        driver.findElement(By.xpath(XPATH_ADDED_TO_CART)).click();
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }


}
