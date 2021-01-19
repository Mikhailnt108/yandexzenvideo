package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllCollectionsPage extends BasePage {
    public AllCollectionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickToTailCollection() {
        driver.navigate().refresh();
        click(By.xpath("//a[contains(@href,'collection/')]"));
    }
}
