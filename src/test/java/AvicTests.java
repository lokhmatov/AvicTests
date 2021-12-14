import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AvicTests {

    private WebDriver driver;

    @BeforeTest
    public void profileSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("iPhone 13");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).click();
        assertTrue(driver.getCurrentUrl().contains("query=iPhone"));
    }

    @Test(priority = 2)
    public void checkSelectionByParameters() {
        driver.findElement(By.xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(By.xpath("//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'game-zone')]")).click();
        driver.findElement(By.xpath("//div[@class='brand-box__title']/a[contains(@href,'igrovie-pristavki')]")).click();
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.className("form-filters")));
        driver.findElement(By.xpath("//div[@class='filter__items checkbox']//a[contains(@href, 'playstation-5')]")).click();
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.className("container-main")));
        WebElement element = driver.findElement(By.xpath("//div[@class='page-title page-title-category']"));
        assertTrue(element.getText().contains("PlayStation 5"));
    }

    @Test(priority = 3)
    public void checkAddToCartWithCorrectParameters() {
        driver.findElement(xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(xpath("//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")).click();
        driver.findElement(xpath("//div[@class='brand-box__title']/a[contains(@href,'apple-tv')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//div[@class=' choose-config__right ']//a[contains(@href, 'apple-tv-4k-2021-64gb')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Apple TV 4K 2021 64GB')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        String actualProductsInCart =
                driver.findElement(xpath("//span[@class='name'][contains(text(), 'Apple TV')]"))
                        .getText();
        assertEquals(actualProductsInCart, "Apple TV 4K 2021 64GB (MXH02)");
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
