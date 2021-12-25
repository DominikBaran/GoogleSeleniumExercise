package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitExtension {
    public static void waitFotPageToBeLoaded(WebDriver driver) {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(driver1 -> ((JavascriptExecutor) driver1) //
                .executeScript("return document.readyState") //
                .toString() //
                .equals("complete"));
    }

    public static void waitForElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
