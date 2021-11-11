package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionPage extends BasePageWebDriver {
    public CollectionPage(WebDriver driver) {
        super(driver);
    }

    public void checkOpenCollectionPageForKids() {
        isElementDisplayed(By.xpath("//a[@href='/collection']//span[1]"));
    }

    public void checkOpenCollectionRent2Page() {
        isElementDisplayed(By.xpath("//h1[contains(text(), 'аренд')]"));
    }

    public void clickToTailFilmRent2() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void checkCollectionOfMy() {
        // проверка все тайлы коллекции - "Для детей":
        isElementDisplayed(By.xpath("//h1[text()='Мое']|//h1[text()='Моё']"));
        List<WebElement> countAllTail = webDriver.findElements(By.xpath("//a[@data-test='PackageLink']"));
        List<WebElement> countForKids = webDriver.findElements(By.xpath("//span[contains(text(),'Для детей')]"));
        Assert.assertEquals(countAllTail.size(), countForKids.size());
        System.out.println(countAllTail.size());
        System.out.println(countForKids.size());
        List<WebElement> hrefOnlyVods = webDriver.findElements(By.xpath("//a[@data-test='PackageLink' and contains(@href, '/vods')]"));
        Assert.assertEquals(countAllTail.size(), hrefOnlyVods.size());
        System.out.println(hrefOnlyVods.size());
    }

    public void checkCollectionOfFavorites() throws InterruptedException {
        List<WebElement> CollectionOfFavorites = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i < CollectionOfFavorites.size(); i++) {
            CollectionOfFavorites = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionOfFavorites.get(i).click();
            isElementDisplayed(By.xpath("//button[@class='_3TTcTpw6F5NxpSgIqK8AbK wkkWkxgKsqx1R8o0ukJPB']"));
            isElementDisplayed(By.xpath("//div[contains(text(),'Для детей')]"));
            click(By.xpath("(//div[text()='Детям'])[1]"));
            click(By.linkText("Избранное"));
            Thread.sleep(2000);
        }
    }

    public void checkElementsPageBlockCollection() {
        isElementDisplayed(By.xpath("//h1[text()]"));
//        isElementDisplayed(By.xpath("//h1[text()]/following-sibling::div/span[text()]"));
        isElementDisplayed(By.xpath("//a[@data-test='PackageLink']"));
    }


    public void clickToTailFilm() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href, '/vods')])[1]"));
    }

    public void clickToTailContentOnPageCollect() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]|//a[@href='/shows']//span[1]|//a[@href='/tv']//span[1]"));
    }

    public void clickToTailSerial() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href, '/shows/')])[1]"));
    }

    public void clickToTailTvProgram() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href, '/tv/channels/')])[1]"));
    }

    public void clickToTailPackage() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href, '/mixed_groups/')])[1]"));
    }

    public void checkBackgroundPageForKids() {

    }
}
