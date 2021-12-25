package pages;

import helper.WaitExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {
    private final static String GOOGLE_PAGE_URL = "http://www.google.com";
    private final static String ACCEPT_COOKIES_BUTTON_ID_LOCATOR = "L2AGLb";


    public GoogleSearchPage navigateToThePageAndAcceptCookies(WebDriver driver) {
        driver.navigate().to(GOOGLE_PAGE_URL);
        WaitExtension.waitFotPageToBeLoaded(driver);
        WebElement acceptCookiesButton = driver.findElement(By.id(ACCEPT_COOKIES_BUTTON_ID_LOCATOR));
        acceptCookiesButton.click();
        return new GoogleSearchPage();
    }
}
