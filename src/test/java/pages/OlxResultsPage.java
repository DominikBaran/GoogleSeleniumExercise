package pages;

import helper.WaitExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OlxResultsPage {
    private static final String LINK_ELEMENT_ATTRIBUTE = "href";
    private static final String SEARCH_RESULTS_SUMMARY_ELEMENT_LOCATOR = "adsResultsIn";

    public boolean checkOlxResultsPage(WebDriver driver, WebElement olxResultLink) {
        String linkUrl = olxResultLink.getAttribute(LINK_ELEMENT_ATTRIBUTE);
        driver.navigate().to(linkUrl);
        WaitExtension.waitFotPageToBeLoaded(driver);
        WaitExtension.waitForElement(driver, By.id(SEARCH_RESULTS_SUMMARY_ELEMENT_LOCATOR));
        WebElement resultsCounterElement = driver.findElement(By.id(SEARCH_RESULTS_SUMMARY_ELEMENT_LOCATOR));
        String results = resultsCounterElement.getText();
        results = results.replaceAll("\\D+", "");
        return Long.parseLong(results) > 0;
    }
}
