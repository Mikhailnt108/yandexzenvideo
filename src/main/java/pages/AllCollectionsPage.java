package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class AllCollectionsPage extends BasePage {
    public AllCollectionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickToTailCollection() {
        driver.navigate().refresh();
        click(By.xpath("//a[contains(@href,'collection/')]"));
    }

    public void checkElementsPageCollections() {
        isElementDisplayed(By.xpath("//h1[text()='Популярные подборки фильмов и сериалов']"));
        isElementDisplayed(By.xpath("//p[contains(text(),'Мы собрали коллекции лучших фильмов, мультфильмов и сериалов, чтобы смотреть МегаФон ТВ где и когда удобно с любых устройств.')]"));
        isElementDisplayed(By.xpath("//a[@class='_2W-IRVg8nfmL65JjHBY-ly']"));
        isElementDisplayed(By.className("_7d-AKYRwQQezRB7rjcWEA"));
    }

    public void checkImageDifferPageCollections() throws IOException {
        driver.get("https://web-preprod5.megafon.tv/collection");
        Screenshot screenshotPageCollectionPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//h3[@class='_3vH5TQCwbJxGYqr32QUtld']")) // название контента
                .addIgnoredElement(By.xpath("//img[@class='_3te-a1teTTW-lKUjvWVxkj']")) // постер тайла контента
                .addIgnoredElement(By.xpath("(//a[contains(@href,'/collection?page')])[last()]")) // номер последней страницы пагинации
                .addIgnoredElement(By.xpath("//a[@class='_2W-IRVg8nfmL65JjHBY-ly']")) // целиком тайл
                .takeScreenshot(driver);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/CollectPage/"+"collectionPagePp5"+".png");
        ImageIO.write(screenshotPageCollectionPp5.getImage(), "png", actualFile1);

        // Сделать новый этанолонный скриншот:
        driver.get("https://web-preprod5.megafon.tv/collection");
        Screenshot screenshotPageCollectionPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/CollectPage/"+"collectionPagePp5Standard"+".png");
        ImageIO.write(screenshotPageCollectionPp5Standard.getImage(), "png", expectedFile1);
        screenshotPageCollectionPp5Standard.setIgnoredAreas(screenshotPageCollectionPp5.getIgnoredAreas());

//        // Взять старый эталонный скриншот:
//        Screenshot screenshotPageCollectionPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/CollectPage/"+"collectionPagePp5Standard"+".png")));
//        screenshotPageCollectionPp5Standard.setIgnoredAreas(screenshotPageCollectionPp5.getIgnoredAreas());

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotPageCollectionPp5, screenshotPageCollectionPp5Standard);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/CollectPage/"+"diffCollectionPagePp5"+".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize()<=50);
    }
}
