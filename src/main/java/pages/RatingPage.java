package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RatingPage extends BasePage {
    public RatingPage (WebDriver driver)
    { super(driver); }

    public void checkOpenRatingPage() {
        isElementDisplayed(By.xpath("//div[text()='Поставьте оценку']"));
    }
}
