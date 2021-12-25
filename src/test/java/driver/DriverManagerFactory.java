package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManagerFactory {
    private static DriverManager driverManager;

    private DriverManagerFactory() {
    }

    public static DriverManager getManager() {
        if (driverManager != null) {
            return driverManager;
        }

        DriverType type = DriverType.CHROME;
        String value = System.getProperty("browser");
        if (value != null && !value.isEmpty()) {
            type = DriverType.getType(value);
        }

        switch (type) {
            case FIREFOX:
                driverManager = new DriverManager(FirefoxDriver.class);
                break;
            case EDGE:
                driverManager = new DriverManager(EdgeDriver.class);
                break;
            case IE:
                driverManager = new DriverManager(InternetExplorerDriver.class);
                break;
            case CHROME:
            default:
                driverManager = new DriverManager(ChromeDriver.class);
                break;
        }
        return driverManager;
    }
}
