package avic_tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchResultTests extends BaseTests{

    private static final String SEARCH_KEYWORD = "iPhone 13";
    private static final String EXPECTED_QUERY = "query=iPhone";
    private static final int EXPECTED_AMOUNT_OF_PRODUCTS = 12;

    @Test
    public void checkThatUrlContainsSearchWord() {
            getHomePage().searchByKeyword(SEARCH_KEYWORD);
            assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY));
    }

    @Test
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().implicitWait(20);
        assertEquals(getSearchResultPage().getSearchResultsCount(), EXPECTED_AMOUNT_OF_PRODUCTS);
    }

    @Test
    public void checkSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        for(WebElement webElement: getSearchResultPage().getSearchResultsList()) {
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD));
        }
    }
}
