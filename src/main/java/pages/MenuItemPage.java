package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuItemPage {

    // TODO uproscic xpatha
    private static final String XPATH_MENU_MY_ACCOUNT = "//li[@class = 'my-account menu-item menu-item-type-post_type menu-item-object-page menu-item-201']";
    private static final String XPATH_ENTRY_TITLE = "//h1[@class = 'entry-title']";

    public void myAccount(WebDriver driver){
        driver.findElement(By.xpath(XPATH_MENU_MY_ACCOUNT)).click();
    }

    public String checkPageTitle(WebDriver driver){
        // TODO czy nie trzeba dodac łapania wyjątku gdyby elementu nie było?
        return driver.findElement(By.xpath(XPATH_ENTRY_TITLE)).getText();
    }

}
