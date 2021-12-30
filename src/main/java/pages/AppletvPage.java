package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppletvPage extends BasePage{

    @FindBy(xpath = "//div[@class=' choose-config__right ']//a[contains(@href, 'apple-tv-4k-2021-64gb')]")
    WebElement versionOfAppletv;
    @FindBy(xpath = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Apple TV 4K 2021 64GB')]")
    WebElement buyAppletvButton;
    @FindBy(xpath = "//span[@class='name'][contains(text(), 'Apple TV')]")
    WebElement versionOfAppletvTitle;

    public AppletvPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnVersionButton() {
        versionOfAppletv.click();
    }

    public void clickOnBuyAppletvbuttom() {
        buyAppletvButton.click();
    }

    public String getVersionOfAppletvTitle() {
        return versionOfAppletvTitle.getText();
    }
}
