package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppleStorePage extends BasePage {

    @FindBy(xpath = "//div[@class='brand-box__title']/a[contains(@href,'apple-tv')]")
    WebElement appletvButton;

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAppletvButton() {
        appletvButton.click();
    }
}
