package base;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePageWebDriver {
    public static WebDriver webDriver;
    public WebDriverWait wait;


    public BasePageWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver,40);
    }
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void click (By elementBy){
        waitVisibility(elementBy);
        webDriver.findElement(elementBy).click();
    }
    public boolean isElementDisplayed (By elementBy) {
        waitVisibility(elementBy);
        Assert.assertTrue("элемент не найден", webDriver.findElement(elementBy).isDisplayed());
        return false;
    }
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = webDriver.findElement(elementBy);
        element.sendKeys(Keys.CONTROL,"a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }
}
