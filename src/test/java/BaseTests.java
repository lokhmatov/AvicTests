import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.AppleStorePage;
import pages.AppletvPage;
import pages.ConsolesPage;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTests {

    private WebDriver driver;
    private static final String AVIC_URL = "https://avic.ua/";

    @BeforeTest
    public void profileSetup () {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public ConsolesPage getConsolesPage() {
        return new ConsolesPage(getDriver());
    }

    public AppleStorePage getApplestorePage() {
        return new AppleStorePage(getDriver());
    }

    public AppletvPage getAppletvPage() {
        return new AppletvPage(getDriver());
    }

}
