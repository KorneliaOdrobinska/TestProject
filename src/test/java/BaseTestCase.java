import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTestCase {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    private static final Logger log = LoggerFactory.getLogger(BaseTestCase.class);

    @BeforeMethod
    static void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void chromeDefault(){
        driver = new ChromeDriver(chromeOptions());
        // browserSettings();
    }

    void browserSettings(){
        driver.manage().window().maximize();
    }

    ChromeOptions chromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

    @Test
    public void openMainPage(){
        driver.get("https://fakestore.testelka.pl");
        // TODO obsluzyc waita do ładowania strony
        //webDriverWait.until();
        log.info("Page title: " + driver.getTitle());
        System.out.println(driver.getTitle());
    }
}
