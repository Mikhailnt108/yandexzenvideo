package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpInputPassword extends BasePage {
    public PopUpInputPassword(WebDriver driver){super(driver);}
    public void checkOpenFrameInputPassword() {
        isElementDisplayed(By.xpath("//div[text()='Введите пароль']"));
    }
    public void inputPassword(String password) {
        WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
        element.sendKeys(password);
    }

    public void clickToComeIn(String buttonComeIn) {
        click(By.xpath("//button[text()='Войти']"));
    }

    public void clickToButtonForgetPassword() {click(By.xpath("//button[text()='Я не помню пароль']"));
    }

}
