package TestFramework.base;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private static long DEFAULT_WAIT = 20;
    private static WebDriver driver;


    public static void setUp() {
        getDefaultDriver();
    }

    public static WebDriver getDefaultDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\TestFramework\\resources\\chromedriver.exe");

        if (driver != null) {
            return driver;
        }

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, capabilities);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_WAIT,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

     @After
    public void tearDown() {
        driver.manage();
    }

}
