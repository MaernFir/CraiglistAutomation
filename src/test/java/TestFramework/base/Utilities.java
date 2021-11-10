package TestFramework.base;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utilities {

    private static WebDriver driver = BasePage.getDefaultDriver();

    public static WebElement findWebElementByCss(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public static WebElement findWebElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static List findElementsBy(String value) {
        List links = driver.findElements(By.xpath("value"));
        return links;
    }

    private static WebElement elementVisible(WebElement element){
        return element.isDisplayed() ? element: null;
    }

    public static ExpectedCondition<WebElement>visibilityOfElement(final By locator){
        return new ExpectedCondition<WebElement>()
        {
            public WebElement apply(WebDriver driver){
                try
                {
                    return elementVisible(driver.findElement(locator));}
                    catch (Exception e){return null;}}};
        }

    public static void checkElementText(String title) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), title);
    }

    public static void findAndClickElement(String xpath) {
        WebElement menuOption = driver.findElement(By.xpath(xpath));
        menuOption.click();
    }

    public static void navigateToWebsite(String website) {
        driver.navigate().to(website);
    }

    private static WebDriverWait createWait(WebDriver driver) {
        return new WebDriverWait(driver,20,500);
    }

    public static<T> T waitUntil(ExpectedCondition<T> expectedCondition){
        WebDriverWait wait = createWait(driver);
        return wait.until(expectedCondition);
    }
}

