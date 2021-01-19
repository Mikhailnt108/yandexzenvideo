package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SportPage extends BasePage {
    public SportPage(WebDriver driver) {
        super(driver);
    }

    public void clickToTailTvChannel() {
        click(By.xpath("(//div[@class='lJKP8B9lCUmBeUxpmi06D'])[1]"));
    }

    public void clickToTailTvProgram() {
        click(By.xpath("(//div[@class='X6AUS0SWkRBAkOSrXkHMg _2yqndJWOuX36UWc1F5T19w'])[1]"));
    }
}
