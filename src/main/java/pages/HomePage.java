package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@class='button-reset search-btn']")
    private WebElement searchButton;
    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement catalogButton;
    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'game-zone')]")
    private WebElement gamezoneButton;
    @FindBy(xpath = "//div[@class='brand-box__title']/a[contains(@href,'igrovie-pristavki')]")
    private WebElement consoles;
    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")
    WebElement applestoreButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickOnCatalogButton() {
        catalogButton.click();
    }

    public void clickOnGamezoneButton() {
        gamezoneButton.click();
    }

    public void clickOnConsoles() {
        consoles.click();
    }

    public void clickOnApplestoreButton() {
        applestoreButton.click();
    }
}
