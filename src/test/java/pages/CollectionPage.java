package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionPage extends BasePage {
    public CollectionPage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenCollectionPage() {
        isElementDisplayed(By.xpath("//a[@href='/collection']//span[1]"));
    }

    public void checkOpenCollectionRent2Page() {
        isElementDisplayed(By.xpath("//h1[contains(text(), 'аренд')]"));
    }

    public void clickToTailFilmRent2() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void checkCollectionOfMy() {
        List<WebElement> CollectionOfMy = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 1; i <= CollectionOfMy.size(); i++) {
            CollectionOfMy = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionOfMy.get(i - 1).findElement(By.xpath("//span[contains(text(), 'Для детей')]"));

        }
    }

    public void checkCollectionOfFavorites() {
        List<WebElement> CollectionOfMy = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 1; i <= CollectionOfMy.size(); i++) {
            CollectionOfMy = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionOfMy.get(i - 1).findElement(By.xpath("//span[contains(text(), 'Для детей')]"));
        }
    }

    public void clickToTailFilm() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("//span[text()='Фильмы']"));
    }


}