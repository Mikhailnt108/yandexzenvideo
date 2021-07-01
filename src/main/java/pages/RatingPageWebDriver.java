package pages;

import base.BasePageWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RatingPageWebDriver extends BasePageWebDriver {
    public RatingPageWebDriver(WebDriver driver)
    { super(driver); }

    public void checkOpenRatingPage() {
        isElementDisplayed(By.xpath("//div[text()='Поставьте оценку']"));
    }
}
