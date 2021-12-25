package pages;

import helper.WaitExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage {
    private static final String SEARCH_RESULTS_ELEMENT_ID_LOCATOR = "rcnt";
    private static final String SEARCH_RESULTS_LOCATOR = "div#search";
    private static final String SEARCH_RESULTS_LIST_LOCATOR = "div > div > div.g";
    private static final String SEARCH_RESULTS_LIST_LINKS_LOCATOR = "div#search > div > div  div.g > div > div > div > a";
    private static final String LINK_ELEMENT_ATTRIBUTE = "href";
    private static final String OLX_LINK_PREFIX = "www.olx";

    public void waitForSearchResultsElement(WebDriver driver) {
        WaitExtension.waitForElement(driver, By.id(SEARCH_RESULTS_ELEMENT_ID_LOCATOR));
    }

    public boolean checkIfGoogleResultsExist(WebDriver driver) {
        WebElement resultsSection = driver.findElement(By.cssSelector(SEARCH_RESULTS_LOCATOR));
        if (resultsSection != null) {
            List<WebElement> results = resultsSection.findElements(By.cssSelector(SEARCH_RESULTS_LIST_LOCATOR));
            return results != null && results.size() > 0;
        }
        return false;
    }

    public List<WebElement> getOlxResultsIfExist(WebDriver driver) {
        return getOlxLinksFromResults(driver);
    }

    private List<WebElement> getOlxLinksFromResults(WebDriver driver) {
        List<WebElement> resultsLinks = driver.findElements(By.cssSelector(SEARCH_RESULTS_LIST_LINKS_LOCATOR));
        List<WebElement> olxResultsLinks = new ArrayList();
        for (WebElement resultLink : resultsLinks) {
            String linkUrl = resultLink.getAttribute(LINK_ELEMENT_ATTRIBUTE);
            if (linkUrl.contains(OLX_LINK_PREFIX)) {
                olxResultsLinks.add(resultLink);
            }
        }
        return olxResultsLinks;
    }
}
