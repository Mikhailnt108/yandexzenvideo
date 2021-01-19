package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpInputCod extends BasePage {
    public PopUpInputCod(WebDriver driver) {
        super(driver);
    }

    public void checkOpenFrameInputCod() {
        isElementDisplayed(By.xpath("//div[text()='Введите код']"));
    }

    public void clickToComeIn(String buttonComeIn) {

        click(By.xpath("//button[text()='Войти']"));
    }
}


