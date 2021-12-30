import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class FilterTests extends BaseTests {
    private String EXPECTED_TITLE_FROM_FILTER = "PlayStation 5";

    @Test
    public void checkSelectionByParameters() {
        getHomePage().clickOnCatalogButton();
        getHomePage().clickOnGamezoneButton();
        getHomePage().clickOnConsoles();
        getConsolesPage().waitVisibilityOfElement(20, getConsolesPage().getFilterPlaystation());
        getConsolesPage().clickOnPlaystationFilter();
        getConsolesPage().waitVisibilityOfElement(20, getConsolesPage().getContainerOfProducts());
        assertTrue(getConsolesPage().getTextFromTitleName().contains(EXPECTED_TITLE_FROM_FILTER));
    }
}
