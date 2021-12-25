package pages;

import helper.WaitExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private static final String SEARCH_INPUT_LOCATOR = "//input[@class='gLFyf gsfi']";
    private static final String SEARCH_BUTTON_LOCATOR = "input.gNO89b";

    public void waitForSearchInputField(WebDriver driver) {
        WaitExtension.waitForElement(driver, By.xpath(SEARCH_INPUT_LOCATOR));
    }

    public GoogleSearchResultsPage searchFor(WebDriver driver, String searchCriteria) {
        WebElement search = driver.findElement(By.xpath(SEARCH_INPUT_LOCATOR));
        search.clear();
        search.sendKeys(searchCriteria);
        search.click();
        WaitExtension.waitForElement(driver, By.cssSelector(SEARCH_BUTTON_LOCATOR));
        WebElement searchButton = driver.findElement(By.cssSelector(SEARCH_BUTTON_LOCATOR));
        searchButton.click();
        return new GoogleSearchResultsPage();
    }
}
