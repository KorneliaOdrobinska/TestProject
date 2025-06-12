package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasketPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasketPage.class); // TODO nie powinien dziedziczyc loggera po BasePage?

    private static final String XPATH_CHECKOUT_BUTTON = "//a[contains(@class,'checkout-button')]";


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage goToPayment(WebDriver driver){
        log.info("Going to Payment");
        // TODO !!! wycignac do metody
        WebElement element = driver.findElement(By.xpath(XPATH_CHECKOUT_BUTTON));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
        element.click();

        return new OrderPage(driver);
    }

}
