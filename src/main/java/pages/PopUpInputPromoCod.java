package pages;

import base.BasePageWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpInputPromoCod extends BasePageWebDriver {
    public PopUpInputPromoCod(WebDriver driver) {super(driver);

    }
    public void checkFrameInputPromoCod() {
        isElementDisplayed(By.xpath("//h3[text()='Введите промокод']"));
    }

}
