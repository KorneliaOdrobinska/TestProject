package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class OrderPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(OrderPage.class); // TODO nie powinien dziedziczyc loggera po BasePage?

    private static final String ID_FIRST_NAME = "billing_first_name";
    private static final String ID_LAST_NAME = "billing_last_name";
    private static final String ID_ADDRESS = "billing_address_1";
    private static final String ID_POSTCODE = "billing_postcode";
    private static final String ID_CITY = "billing_city";
    private static final String ID_PHONE = "billing_phone";
    private static final String ID_EMAIL = "billing_email";

    private static final String XPATH_CARD_NUMBER = "//input[@name = 'cardnumber']";
    private static final String XPATH_CARD_EXPIRY = "//span[contains(@class, 'InputContainer')]/input[@name = 'exp-date']";
    private static final String XPATH_CARD_CVC = "//span[contains(@class, 'InputContainer')]/input[@name = 'cvc']";

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(WebDriver driver, String firstName) {
        log.info("Setting first name: " + firstName);
        driver.findElement(By.id(ID_FIRST_NAME)).sendKeys(firstName);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }

    public void setLastName(WebDriver driver, String lastName) {
        log.info("Setting last name: " + lastName);
        driver.findElement(By.id(ID_LAST_NAME)).sendKeys(lastName);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }

    public void setAddress(WebDriver driver, String address) {
        log.info("Setting address: " + address);
        driver.findElement(By.id(ID_ADDRESS)).sendKeys(address);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }

    public void setPostcode(WebDriver driver, String postcode) {
        log.info("Setting first name: " + postcode);
        driver.findElement(By.id(ID_POSTCODE)).sendKeys(postcode);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }

    public void setCity(WebDriver driver, String city) {
        log.info("Setting city: " + city);
        driver.findElement(By.id(ID_CITY)).sendKeys(city);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }

    public void setPhone(WebDriver driver, String phone) {
        log.info("Setting phone: " + phone);
        driver.findElement(By.id(ID_PHONE)).sendKeys(phone);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }

    public void setEmail(WebDriver driver, String email) {
        log.info("Setting email: " + email);
        driver.findElement(By.id(ID_EMAIL)).sendKeys(email);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));

    }

    public void setCardNumber(WebDriver driver, String cardNumber) {
        log.info("Setting card number: " + cardNumber);
        WebElement element = driver.findElement(By.xpath(XPATH_CARD_NUMBER));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
        element.sendKeys(cardNumber);
    }

    public void setExpiryDate(WebDriver driver, String expiryDate) {
        log.info("Setting expiry date: " + expiryDate);
        driver.findElement(By.xpath(XPATH_CARD_EXPIRY)).sendKeys(expiryDate);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }

    public void setCvcCode(WebDriver driver, String cvc) {
        log.info("Setting CVC code: " + cvc);
        driver.findElement(By.xpath(XPATH_CARD_CVC)).sendKeys(cvc);
        // TODO zrealizować czekadełko
        wait.withTimeout(Duration.ofSeconds(10));
    }
}
