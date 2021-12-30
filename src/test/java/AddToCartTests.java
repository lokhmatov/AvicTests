import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AddToCartTests extends BaseTests {
    private String EXPECTED_PRODUCT_TITLE = "Apple TV 4K 2021 64GB (MXH02)";

    @Test
    public void checkAddToCartWithCorrectParameters() {
        getHomePage().clickOnCatalogButton();
        getHomePage().clickOnApplestoreButton();
        getApplestorePage().clickOnAppletvButton();
        getApplestorePage().waitForPageLoadComplete(20);
        getAppletvPage().clickOnVersionButton();
        getAppletvPage().implicitWait(10);
        getAppletvPage().clickOnBuyAppletvbuttom();
        getAppletvPage().implicitWait(10);
        assertEquals(getAppletvPage().getVersionOfAppletvTitle(), EXPECTED_PRODUCT_TITLE);


    }
}
