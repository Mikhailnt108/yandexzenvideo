package base;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
    }
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void click (By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
    public boolean isElementDisplayed (By elementBy) {
        waitVisibility(elementBy);
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed());
        return false;
    }
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }
}
