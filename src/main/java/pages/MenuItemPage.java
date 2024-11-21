package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuItemPage {

    // TODO uproscic xpatha
    private static final String XPATH_MENU_MY_ACCOUNT = "//li[@class = 'my-account menu-item menu-item-type-post_type menu-item-object-page menu-item-201']";

    public void myAccount(WebDriver driver){
        driver.findElement(By.xpath(XPATH_MENU_MY_ACCOUNT)).click();
    }

    // TODO sprawdzic czy otworzyla sie strona MyAccount

}
