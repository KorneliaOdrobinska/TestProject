package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccountPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(MyAccountPage.class); // TODO nie powinien dziedziczyc loggera po BasePage?

    private static final String XPATH_LOGIN_BUTTON = "//button[contains(@name,'login')]";
    private static final String XPATH_EMAIL = "//input[@name = 'username']";
    private static final String ID_PASSWORD = "password";
    private static final String XPATH_MY_ACCOUNT_CONTENT = "//div[@class = 'woocommerce-MyAccount-content']";
    private static final String XPATH_ALERT = "//ul[@class = 'woocommerce-error']";


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(WebDriver driver, String email) {
        log.info("Setting email: " + email);
        driver.findElement(By.xpath(XPATH_EMAIL)).sendKeys(email);
    }

    public void setPassword(WebDriver driver, String password) {
        log.info("Setting address: " + password);
        driver.findElement(By.id(ID_PASSWORD)).sendKeys(password);
    }

    public void clickLogIn(WebDriver driver) {
        log.info("Clicking LogIn button");
        driver.findElement(By.xpath(XPATH_LOGIN_BUTTON)).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_MY_ACCOUNT_CONTENT)),
                ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_ALERT))
        ));
    }

    public boolean checkIfUserIsLogged(WebDriver driver, String username) {
        // TODO 0!!! czy nie trzeba dodac łapania wyjątku gdyby elementu nie było?
        return driver.findElement(By.xpath(XPATH_MY_ACCOUNT_CONTENT)).getText().contains(username);
    }
}
