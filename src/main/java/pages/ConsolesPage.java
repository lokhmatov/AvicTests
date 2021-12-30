package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsolesPage extends BasePage {

    @FindBy(xpath = "//div[@class='filter__items checkbox']//a[contains(@href, 'playstation-5')]")
    WebElement filterPlaystation;
    @FindBy(xpath = "//div[@class='page-title page-title-category']")
    WebElement title;
    @FindBy(xpath = "//div[@class='container-main']")
    WebElement containerOfProducts;


    public ConsolesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPlaystationFilter() {
        filterPlaystation.click();
    }

    public String getTextFromTitleName() {
        return title.getText();
    }

    public WebElement getFilterPlaystation () {
        return filterPlaystation;
    }

    public WebElement getContainerOfProducts() {
        return containerOfProducts;
    }


}
