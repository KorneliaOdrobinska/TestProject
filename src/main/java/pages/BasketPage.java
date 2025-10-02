package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasketPage.class);

    private static final String XPATH_CHECKOUT_BUTTON = "//a[contains(@class,'checkout-button')]";


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage goToPayment(WebDriver driver) {
        log.info("Going to Payment");
        WebElement element = driver.findElement(By.xpath(XPATH_CHECKOUT_BUTTON));
        scrollAndClick(element);

        return new OrderPage(driver);
    }

}
