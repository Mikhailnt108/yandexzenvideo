package base;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalTime;


public class BasePageWebDriver extends TestBaseWebDriver {

    public WebDriver webDriver;

    public BasePageWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkOpenUrl(String url) {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains(url), "opened valid url");
    }

    public void checkMatchCount(By elementBy1, By elementBy2){
        Assertions.assertEquals(webDriver.findElements(elementBy1).size(), (webDriver.findElements(elementBy2).size()), "count of elements "+ elementBy2 +" does not match");
    }

    public void checkTimeProgressPlayer(LocalTime Before, LocalTime After){
        Assertions.assertTrue(Before.isBefore(After), "time 'After': " +After+" more time 'Before'"+Before);
    }

    public void isElementDisplayed (By elementBy) {
        Assertions.assertTrue(webDriver.findElements(elementBy).size()>=1, "Element " + elementBy + " found on page");
    }
    public  void isElementNotDisplayed(By elementBy){
        Assertions.assertEquals(0, webDriver.findElements(elementBy).size(), "element " + elementBy + " is displayed");
    }
    public void click (By elementBy) {
        Assertions.assertTrue(webDriver.findElements(elementBy).size()>=1, "Element " + elementBy + " found on page");
        webDriver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        WebElement element = webDriver.findElement(elementBy);
        element.click();
        element.sendKeys(Keys.CONTROL,"a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }
}
