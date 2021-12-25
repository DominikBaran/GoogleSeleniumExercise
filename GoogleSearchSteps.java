package steps;

import driver.DriverManagerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.GoogleMainPage;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultsPage;
import pages.OlxResultsPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoogleSearchSteps {
    WebDriver driver;

    @BeforeStory
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeScenario
    public void setupScenario() {
        driver = DriverManagerFactory.getManager().getDriver();
    }

    @AfterScenario
    public void tearDownScenario() {
        DriverManagerFactory.getManager().getDriver().quit();
    }

    @AfterStory
    public void tearDownStory() {
        DriverManagerFactory.getManager().getDriver().quit();
    }

    @Given("consumer navigates to google search page")
    public void navigateToGoogle() {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        GoogleSearchPage googleSearchPage = googleMainPage.navigateToThePageAndAcceptCookies(driver);
        googleSearchPage.waitForSearchInputField(driver);
    }

    @Given("consumer searches for '$searchCriteria' phase")
    public void searchFor(String searchCriteria) {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        GoogleSearchResultsPage googleSearchResultsPage = googleSearchPage.searchFor(driver, searchCriteria);
        googleSearchResultsPage.waitForSearchResultsElement(driver);
    }

    @When("any results exist on the result page")
    public void checkForResults() {
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();
        assertTrue("Cannot find any results on the Google results page.", googleSearchResultsPage.checkIfGoogleResultsExist(driver));
    }

    @Then("the olx results exist on the search google results page and OLX pages contain valid results counter")
    public void checkOlxResults() {
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();
        List<WebElement> olxResults = googleSearchResultsPage.getOlxResultsIfExist(driver);
        assertTrue("Cannot find any OLX results on the Google results page.", olxResults != null && olxResults.size() > 0);
        for (WebElement olxResult : olxResults) {
            OlxResultsPage olxResultsPage = new OlxResultsPage();
            assertTrue("Something is wrong with the numeric results on the OLX page.", olxResultsPage.checkOlxResultsPage(driver, olxResult));
        }
    }
}
