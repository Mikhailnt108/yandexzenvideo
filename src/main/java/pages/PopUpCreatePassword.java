package pages;

import base.BasePageWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpCreatePassword extends BasePageWebDriver {
    public PopUpCreatePassword(WebDriver driver) {
        super(driver);
    }

    public void checkOpenFrameCreatePassword() {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
    }

    public void inputPassword(String password) {
        WebElement element = webDriver.findElement(By.xpath("//input[@type='password']"));
        element.sendKeys(password);
    }

    public void clickToComeIn(String buttonComeIn) {

        click(By.xpath("//button[text()='Войти']"));
    }
}
