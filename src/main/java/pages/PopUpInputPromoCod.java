package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpInputPromoCod extends BasePage {
    public PopUpInputPromoCod(WebDriver driver) {super(driver);

    }
    public void checkFrameInputPromoCod() {
        isElementDisplayed(By.xpath("//h3[text()='Введите промокод']"));
    }

}
