package pages;

import base.BasePageWebDriver;
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

public class CollectionPageWebDriver extends BasePageWebDriver {
    public CollectionPageWebDriver(WebDriver driver) {
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
        // проверка все тайлы коллекции - "Для детей":
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

    public void checkImageDifferPageBlockCollection() throws IOException {
        // Сделать тестовый скриншот:
        webDriver.get("https://web-preprod5.megafon.tv/collection/poprobui_besplatno?referrer_screen=main");
        Screenshot screenshotPageBlockCollection = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("//div[@class='_3aj_Jy1k9olQljjM96VrlO']"))
                .takeScreenshot(webDriver);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/CollectPage/" + "pageBlockCollection" + ".png");
        ImageIO.write(screenshotPageBlockCollection.getImage(), "png", actualFile1);

//        // Сделать новый этанолонный скриншот:
//        driver.get("https://web-preprod5.megafon.tv/collection/poprobui_besplatno?referrer_screen=main");
//        Screenshot screenshotPageBlockCollectionStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/CollectPage/" + "pageBlockCollectionStandard" + ".png");
//        ImageIO.write(screenshotPageBlockCollectionStandard.getImage(), "png", expectedFile1);
//        screenshotPageBlockCollectionStandard.setIgnoredAreas(screenshotPageBlockCollection.getIgnoredAreas());

        // Взять старый эталонный скриншот:
        Screenshot screenshotPageBlockCollectionStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/CollectPage/"+"PageBlockCollectionStandard"+".png")));
        screenshotPageBlockCollectionStandard.setIgnoredAreas(screenshotPageBlockCollection.getIgnoredAreas());

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotPageBlockCollection, screenshotPageBlockCollectionStandard);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/CollectPage/" + "diffPageBlockCollection" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);
    }

    public void clickToTailFilm() {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href, '/vods')])[1]"));
    }

    public void clickToTailContentOnPageCollect() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]|//a[@href='/shows']//span[1]|//a[@href='/tv']//span[1]"));
    }

    public void clickToTailSerial() {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href, '/shows/')])[1]"));
    }

    public void clickToTailTvProgram() {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href, '/tv/channels/')])[1]"));
    }

    public void clickToTailPackage() {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href, '/mixed_groups/')])[1]"));
    }

    public void selectCollectionForKids() throws InterruptedException {
        webDriver.get("https://web-preprod5.megafon.tv/kids");
        String nameForKidsBlockCollect = webDriver.findElement(By.xpath("(//h3[@data-test='PackageListWrapperName'])[5]")).getText();
        System.out.println(nameForKidsBlockCollect);
        webDriver.get("https://web-preprod5.megafon.tv/collection");
        List<WebElement> collectNames = webDriver.findElements(By.xpath("//h3[@class='_3vH5TQCwbJxGYqr32QUtld']"));
        List<WebElement> paginations = webDriver.findElements(By.xpath("//a[@class='_321YEvw8w6G20aKg-N8nNe']"));
        for (int a = 0; a < paginations.size(); a++) {
            for (int i = 0; i < collectNames.size(); i++) {
                collectNames = webDriver.findElements(By.xpath("//h3[@class='_3vH5TQCwbJxGYqr32QUtld']"));
                String nameString = collectNames.get(i).getText();
                System.out.println("название подборки на стр коллекций: " + nameString);
                if (nameString.equals(nameForKidsBlockCollect)) {
                    collectNames.get(i).click();
                    Assert.assertEquals(webDriver.findElement(By.tagName("h1")).getText(), nameForKidsBlockCollect);
//                    Assert.assertEquals("нет детского фона", 1, driver.findElements(By.xpath("//div[contains(@class,'_3c9FjHVIHIuT3fX6yTP3IO') and contains(@style,'background')]")).size());
                    return;
                }
                if (i == collectNames.size() - 1) {
                    break;
                }
            }
            click(By.xpath("//a[contains(@href,'/collection?page') and @rel='next']"));
            Thread.sleep(3000);
        }
    }
}
