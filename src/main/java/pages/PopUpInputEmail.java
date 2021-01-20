package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpInputEmail extends BasePage {
    public PopUpInputEmail(WebDriver driver) {
        super(driver);
    }


    public void inputEmail(String email) {
        isElementDisplayed(By.xpath("//div[text()='Введите E-mail']"));
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='E-mail']"));
        element.sendKeys(email);
        click(By.xpath("//button[text()='Далее']"));
    }
}
