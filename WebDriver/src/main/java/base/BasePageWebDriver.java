package base;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Statement;


public class BasePageWebDriver {

    public WebDriver webDriver;
    public WebDriverWait wait;

    public BasePageWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver,40);
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void click (By elementBy) throws InterruptedException {
        waitVisibility(elementBy);
        webDriver.findElement(elementBy).click();
        Thread.sleep(3000);
    }
    public boolean isElementDisplayed (By elementBy) {
        waitVisibility(elementBy);
        Assertions.assertTrue(webDriver.findElement(elementBy).isDisplayed(), "элемент не найден");
        return false;
    }
    public void writeText(By elementBy, String text) {
        webDriver.findElement(elementBy).click();
        waitVisibility(elementBy);
        WebElement element = webDriver.findElement(elementBy);
        element.sendKeys(Keys.CONTROL,"a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }
}
