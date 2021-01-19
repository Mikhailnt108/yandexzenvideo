package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpCreatePassword extends BasePage {
    public PopUpCreatePassword(WebDriver driver) {
        super(driver);
    }

    public void checkOpenFrameCreatePassword() {
        isElementDisplayed(By.xpath("//div[text()='Придумайте пароль']"));
    }

    public void inputPassword(String password) {
        WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
        element.sendKeys(password);
    }

    public void clickToComeIn(String buttonComeIn) {

        click(By.xpath("//button[text()='Войти']"));
    }
}
