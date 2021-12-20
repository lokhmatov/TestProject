package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
//    private static final String SEARCH_INPUT = "//input[@id='input_search']";
//    private static final String SEARCH_BUTTON = "//button[@class='button-reset search-btn']";
    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@class='button-reset search-btn']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }
}
