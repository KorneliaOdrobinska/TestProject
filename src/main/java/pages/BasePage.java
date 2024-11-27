package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait; // TODO dorobic oczekiwanie na element

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(45));
    }

    public BasePage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.wait = webDriverWait;
    }
}
