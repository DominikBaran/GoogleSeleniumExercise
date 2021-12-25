package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverManager {
    protected final Class<? extends WebDriver> driverClass;
    private WebDriver driver;

    public DriverManager(Class<? extends WebDriver> driverClass) {
        this.driverClass = driverClass;
    }

    public WebDriver createDriver() {
        WebDriverManager.getInstance(driverClass).setup();
        try {
            driver = driverClass.newInstance();
        } catch (final InstantiationException e) {
            throw new WebDriverManagerException(
                    String.format("Cannot initialize the driver for: %s", driverClass.getName()), e);
        } catch (final IllegalAccessException e) {
            throw new WebDriverManagerException(
                    String.format("Cannot access the driver for: %s", driverClass.getName()), e);
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = this.createDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public boolean isDriverStarted() {
        return driver != null;
    }
}
