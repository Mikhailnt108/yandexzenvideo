package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
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

    public void checkElementsCollection() {
        isElementDisplayed(By.xpath("//h1[text()]"));
        isElementDisplayed(By.xpath("//h1[text()]/following-sibling::div/span[text()]"));
        isElementDisplayed(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void checkImageDifferPageCollection() throws IOException {
        driver.get("https://web-preprod4.megafon.tv/collection/poprobui_besplatno?referrer_screen=main");
        Screenshot screenshotBlockCollectionPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("//div[@class='_3aj_Jy1k9olQljjM96VrlO']"))
                .takeScreenshot(driver);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/CollectPage/"+"collectionPagePp4"+".png");
        ImageIO.write(screenshotBlockCollectionPp4.getImage(), "png", actualFile1);

        // Сделать новый этанолонный скриншот:
        driver.get("https://web-preprod5.megafon.tv/collection/poprobui_besplatno?referrer_screen=main");
        Screenshot screenshotBlockCollectionPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/CollectPage/"+"collectionPagePp4Standard"+".png");
        ImageIO.write(screenshotBlockCollectionPp4Standard.getImage(), "png", expectedFile1);
        screenshotBlockCollectionPp4Standard.setIgnoredAreas(screenshotBlockCollectionPp4.getIgnoredAreas());

//        //Использовать старый эталонный скриншот:
//        Screenshot screenshotBlockCollectionPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/CollectPage/"+"collectionPagePp5Standard"+".png")));
//        screenshotBlockCollectionPp4Standard.setIgnoredAreas(screenshotBlockCollectionPp4.getIgnoredAreas());

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotBlockCollectionPp4, screenshotBlockCollectionPp4Standard);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/CollectPage/"+"diffCollectionPagePp4"+".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize()<=50);
    }

    public void clickToTailContentOnPageCollect() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]|//a[@href='/shows']//span[1]"));
    }
}