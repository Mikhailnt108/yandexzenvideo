package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpInputPhone extends BasePage {
    public PopUpInputPhone(WebDriver driver) {super(driver);

    }
    public void checkOpenFrameInputPhone() {
        isElementDisplayed(By.xpath("//div[text()='Введите номер телефона']"));
    }

    public void inputLogin(String login) {
        WebElement element = webDriver.findElement(By.xpath("//input[@value='+7 ']"));
        element.sendKeys(login);
    }

    public void clickToNext(String buttonNext) {

        click(By.xpath("//button[text()='Далее']"));

    }
}
