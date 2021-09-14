package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SerialsPageWebDriver extends BasePageWebDriver {

    public SerialsPageWebDriver(WebDriver driver) {
        super(driver);
    }

    public void checkOpenSerialsPage() {
        isElementDisplayed(By.xpath("//h1[text()='Сериалы']"));
    }

    public void clickToFirstTailCardSerial() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void chooseSeasonsMoreOneSeason() {
        webDriver.findElement(By.xpath("//div[@class='_3i1jxy4zPnL4htxPozakKI']//span[contains(text(),'3 сезона') or contains(text(), '5 сезонов') or contains(text(), '7 сезонов')]")).click();
    }

    public void clickOnYearInput() {
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRadioButtons() {
        List<WebElement> radioButtons = webDriver.findElements(By.xpath("(//div[@class='_TKVCKE7PL8voHtm8HP2j'])[1]//span[@class='AoSy93bShFe6C6hlZfxUE']"));
        Assert.assertEquals(15, radioButtons.size());
    }

    public void chooseOneYearOnly() {
        click(By.xpath("//span[text()='2019 год']"));
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRequestResultOneYearOnly() {
        List<WebElement> CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
        for (int i=0; i<=5; i++)
        {
            CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
            CollectionOneCountry.get(i).click();
            WebElement button = webDriver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            webDriver.findElement(By.xpath("//dd[text()='2019']"));
            webDriver.navigate().back();
        }
    }

    public void choosePeriodOfYears() {
        click(By.xpath("//div[text()='Год с']"));
        click(By.xpath("(//span[text()='2010'])[1]"));

        click(By.xpath("//div[text()='по']"));
        click(By.xpath("(//span[text()='2020'])[2]"));
    }

    public void checkRequestResultPeriodOfYears() {
        List<WebElement> CollectionTwoCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
        for (int i=0; i<=5; i++)
        {
            CollectionTwoCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
            CollectionTwoCountry.get(i).click();
            WebElement button = webDriver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            webDriver.findElement(By.xpath("//dd[text()='2018' or text()='2019' or text()='2020' or text()='2021']"));
            webDriver.navigate().back();
        }
    }

    public void clickOnGenreInput() {
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkCheckboxes() {
        List<WebElement> checkboxes = webDriver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[1]//input[@type='checkbox']"));
        Assert.assertEquals(28, checkboxes.size());
    }

    public void chooseOneGenre() {
        click(By.xpath("//div[text()='Жанр']"));
        click(By.xpath("//span[text()='Документальный']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultOneGenre() {
        List<WebElement> CollectionOneGenre = webDriver.findElements(By.xpath("//div[@class='_2UHpP-xlu9DaTQUbJuPMEF' and contains(text(),'Документальный')]"));
        Assert.assertEquals(36, CollectionOneGenre.size());
    }

    public void chooseTwoGenre() {
        click(By.xpath("//div[text()='Документальный']"));
        click(By.xpath("//span[text()='Аниме']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultTwoGenre() {
        List<WebElement> CollectionTwoGenre = webDriver.findElements(By.xpath("//div[@class='_2UHpP-xlu9DaTQUbJuPMEF' and contains(text(),'Документальный')]|//div[@class='_2UHpP-xlu9DaTQUbJuPMEF' and contains(text(),'Аниме')]"));
        Assert.assertEquals(36, CollectionTwoGenre.size());
    }

    public void clickOnCountryInput() {
        click(By.xpath("//div[text()='Страна']"));
    }

    public void checkCheckboxesInCountry() {
        List<WebElement> checkboxes = webDriver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[2]//input[@type='checkbox']"));
        Assert.assertEquals(18, checkboxes.size());
    }

    public void chooseOneCountry() throws InterruptedException {
        click(By.xpath("//div[text()='Страна']"));
        click(By.xpath("//span[text()='США']"));
        click(By.xpath("//div[text()='Страна']"));
    }

    public void checkRequestResultOneCountry() {
        List<WebElement> CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
        for (int i=0; i<=8; i++)
        {
            CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
            CollectionOneCountry.get(i).click();
            WebElement button = webDriver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            webDriver.findElement(By.xpath("//div[contains(text(),'Россия')]"));
            webDriver.navigate().back();
        }
    }

    public void chooseTwoCountry() {
        click(By.xpath("//div[text()='Россия']"));
        click(By.xpath("//span[text()='США']"));
        click(By.xpath("//div[text()='Страна']"));
        webDriver.navigate().refresh();

    }

    public void checkRequestResultTwoCountry() {
        List<WebElement> CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
        for (int i=0; i<=8; i++)
        {
            CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[contains(@href,'/shows/')]"));
            CollectionOneCountry.get(i).click();
            WebElement button = webDriver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            webDriver.findElement(By.xpath("//div[contains(text(),'Россия') or contains(text(),'США')]"));
            webDriver.navigate().back();
        }

    }

    public void clickOnResetFiltersButton() {
        click(By.xpath("//button[text()='Сбросить']"));
    }

    public void checkResetAllFilters() {
        List<WebElement> Filters = webDriver.findElements(By.xpath("//div[@class='_1RRLrdyUeRf97LW7DW4bHw']//div[text()='Жанр' or text()='Страна' or text()='Сортировка' or text()='Год с' or text()='по' or text()='Рейтинг']"));
        Assert.assertEquals(6, Filters.size());
    }

    public void startVideoPleer() throws Exception {

    }

    public void checkElementsSerialsPage() {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//ol[@class='_1-ZY27a7Isb9dohjRr0mXq']"));
        isElementDisplayed(By.xpath("//h1[text()='Сериалы']"));
        isElementDisplayed(By.xpath("//div[@class='_10lCh4uWCss6HRDZrOjSEk']"));
        isElementDisplayed(By.xpath("//div[@class='_3SqVO95D45Gj6EpowjScAG']"));
        isElementDisplayed(By.xpath("(//div[@data-test='PackageListWrapper'])[1]"));
    }
    public void checkImageDifferCherdakAndBanners() throws IOException {
        // Сделать тестовый скриншот чердака:
        WebElement headerCherdakPp5 = webDriver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerCherdakPp5);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "serialsPageCherdakPp5" + ".png");
        ImageIO.write(screenshotHeaderCherdakPp5.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот чердака:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        WebElement headerCherdakPp5Standard = webDriver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerCherdakPp5Standard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/"+"serialsPageCherdakPp5Standard"+".png");
        ImageIO.write(screenshotHeaderCherdakPp5Standard.getImage(), "png", expectedFile1);

//        // Взять старый эталонный скриншот чердака:
//        Screenshot screenshotHeaderCherdakPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "serialsPageCherdakPp5Standard" + ".png")));

        // Сравнить скриншоты чердака (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotHeaderCherdakPp5Standard, screenshotHeaderCherdakPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffCherdak" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сделать тестовый скриншот баннерной зоны:
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        WebElement headerBannerPp5 = webDriver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .takeScreenshot(webDriver, headerBannerPp5);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "serialsPageBannerPp5" + ".png");
        ImageIO.write(screenshotHeaderBannerPp5.getImage(), "png", actualFile2);

        // Сделать новый эталонный скриншот баннерной зоны:
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        WebElement headerBannerPp5Standard = webDriver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerBannerPp5Standard);
        File expectedFile2 = new File("src/test/java/testScreenshots/expected/SerialsPage/"+"serialsPageBannerPp5Standard"+".png");
        ImageIO.write(screenshotHeaderBannerPp5Standard.getImage(), "png", expectedFile2);
        screenshotHeaderBannerPp5Standard.setIgnoredAreas(screenshotHeaderBannerPp5.getIgnoredAreas());

//        // Взять старый эталонный скриншот баннерной зоны:
//        Screenshot screenshotHeaderBannerPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "serialsPageBannerPp5Standard" + ".png")));
//        screenshotHeaderBannerPp5Standard.setIgnoredAreas(screenshotHeaderBannerPp5.getIgnoredAreas());

        // Сравнить скриншоты баннерной зоны (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotHeaderBannerPp5Standard, screenshotHeaderBannerPp5);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffBanner" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferBlocksCollection() throws IOException {
        // Сделать тестовый скриншот блока подборки с заголовком:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        JavascriptExecutor blockQuickFilters1 = (JavascriptExecutor) webDriver;
        blockQuickFilters1.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithTitlePp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор все блоки подборок, кроме первой
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "serialsPageCollectionWithTitlePp5" + ".png");
        ImageIO.write(screenshotCollectionWithTitlePp5.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот блока подборки с заголовком:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        JavascriptExecutor blockQuickFilters2 = (JavascriptExecutor) webDriver;
        blockQuickFilters2.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithTitlePp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/"+"serialsPageCollectionWithTitlePp5Standard"+".png");
        ImageIO.write(screenshotCollectionWithTitlePp5Standard.getImage(), "png", expectedFile1);
        screenshotCollectionWithTitlePp5Standard.setIgnoredAreas(screenshotCollectionWithTitlePp5.getIgnoredAreas());

//       // Взять старый эталонный скриншот блока подборки с заголовком:
//        Screenshot screenshotCollectionWithTitlePp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "serialsPageCollectionWithTitlePp5Standard" + ".png")));
//        screenshotCollectionWithTitlePp5Standard.setIgnoredAreas(screenshotCollectionWithTitlePp5.getIgnoredAreas());
//
        //Сравнение скриншотов блока подборки с заголовком (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectionWithTitlePp5Standard, screenshotCollectionWithTitlePp5);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffCollectionWithTitle" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сделать тестовый скриншот блока подборки без заголовка:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        JavascriptExecutor blockQuickFilters3 = (JavascriptExecutor) webDriver;
        blockQuickFilters3.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithoutTitlePp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор блоки подборки без заголовка, кроме первого найденного
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@data-test='CollectionBlock']")) // игнор постеры первого найденного блока подборки без заголовка
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']")) // игнор блоки подборки с заголовком
                .takeScreenshot(webDriver);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "serialsPageCollectionWithoutTitlePp5" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitlePp5.getImage(), "png", actualFile2);

        // Сделать новый эталонный скриншот блока подборки без заголовка:
        webDriver.get("https://web-prepro5.megafon.tv/shows");
        JavascriptExecutor blockQuickFilters4 = (JavascriptExecutor) webDriver;
        blockQuickFilters4.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithoutTitlePp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile2 = new File("src/test/java/testScreenshots/expected/SerialsPage/" + "serialsPageCollectionWithoutTitlePp5Standard" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitlePp5Standard.getImage(), "png", expectedFile2);
        screenshotCollectionWithoutTitlePp5Standard.setIgnoredAreas(screenshotCollectionWithoutTitlePp5.getIgnoredAreas());

//        // Взять старый эталонный скриншот блока подборки без заголовка:
//        Screenshot screenshotCollectionWithoutTitlePp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "serialsPageCollectionWithoutTitlePp5Standard" + ".png")));
//        screenshotCollectionWithoutTitlePp5Standard.setIgnoredAreas(screenshotCollectionWithoutTitlePp5.getIgnoredAreas());

        // Сравнение скриншотов блока подборки без заголовка (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotCollectionWithoutTitlePp5Standard, screenshotCollectionWithoutTitlePp5);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffCollectionWithoutTitle" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferFooter() throws IOException {
        // Сделать тестовый скриншот футера:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        WebElement footerPp5 = webDriver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooterPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver, footerPp5);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "serialsPageFooterPp5" + ".png");
        ImageIO.write(screenshotFooterPp5.getImage(), "png", actualFile1);

        //Сделать новый эталонный скриншот футера:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        WebElement footerPp5Standard = webDriver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooterPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver, footerPp5Standard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/"+"serialsPageFooterPp5Standard"+".png");
        ImageIO.write(screenshotFooterPp5Standard.getImage(), "png", expectedFile1);
        screenshotFooterPp5Standard.setIgnoredAreas(screenshotFooterPp5.getIgnoredAreas());

//        // Взять старый эталонный скриншот футера:
//        Screenshot screenshotFooterP54Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "serialsPageFooterPp5Standard" + ".png")));
//        screenshotFooterPp5Standard.setIgnoredAreas(screenshotFooterPp5.getIgnoredAreas());

        // Сравнить скриншоты футера (тестовый и эталонный):
        ImageDiff diff = new ImageDiffer().makeDiff(screenshotFooterPp5Standard, screenshotFooterPp5);
        System.out.println(diff.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffFooter" + ".png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff.getDiffSize() <= 100);
    }

    public void checkImageDifferSerialsPageScroll() throws IOException {
        // Сделать тестовый скриншот скролла страницы "Сериалы":
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        JavascriptExecutor blockQuickFilters5 = (JavascriptExecutor) webDriver;
        blockQuickFilters5.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
//        WebElement pageSerials = driver.findElement(By.xpath("//div[@class='appMountContainer']"));
        Screenshot screenshotSerialsPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор все подборки без заголовка, кроме первой найденной
                .addIgnoredElement(By.xpath("(//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор все подборки с заголовков, кроме первой найденной
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']")) // игнор футера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) // целиком название блока и счетчик
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@data-test='CollectionBlock']")) // игнор постеры первого найденного блока подборки без заголовка
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "scrollSerialsPagePp5" + ".png");
        ImageIO.write(screenshotSerialsPp5.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот скролла страницы "Сериалы":
        webDriver.get("https://web-prepro5.megafon.tv/shows");
        JavascriptExecutor blockQuickFilters6 = (JavascriptExecutor) webDriver;
        blockQuickFilters6.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
//        WebElement pageSerials2 = driver.findElement(By.xpath("//div[@class='appMountContainer']"));
        Screenshot screenshotSerialsPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/"+"scrollSerialsPagePp5Standard"+".png");
        ImageIO.write(screenshotSerialsPp5Standard.getImage(), "png", expectedFile1);
        screenshotSerialsPp5Standard.setIgnoredAreas(screenshotSerialsPp5.getIgnoredAreas());

//        // Взять старый эталонный скриншот скролла страницы "Сериалы":
//        Screenshot screenshotSerialsPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "scrollSerialsPagePp5Standard" + ".png")));
//        screenshotSerialsPp5Standard.setIgnoredAreas(screenshotSerialsPp5.getIgnoredAreas());

        // Сравнить скриншоты скролла страницы "Сериалы": (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotSerialsPp5Standard, screenshotSerialsPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffSerialsPageScroll" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 500);
        webDriver.navigate().refresh();
        JavascriptExecutor scrollUp = (JavascriptExecutor) webDriver;
        scrollUp.executeScript("scroll(0, -250);");
    }

    public void checkImageDifferBreadcrumbsAndBlocksFilters() throws IOException {
        // Сделать тестовый скриншот области хлебных крошек и блока фильтров страницы "Сериалы":
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        Screenshot screenshotBreadcrumbsAndBlocksFiltersPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_1f1-eBWSN1rERnEOvc6ScB _3ux7gCl0W5jAfa3bi4V4FU']")) // игнор область подробок
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "crumbsAndFiltersSerialsPagePp5" + ".png");
        ImageIO.write(screenshotBreadcrumbsAndBlocksFiltersPp5.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот области хлебных крошек и блока фильтров страницы "Сериалы":
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        Screenshot screenshotBreadcrumbsAndBlocksFiltersPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/"+"crumbsAndFiltersPagePp5Standard"+".png");
        ImageIO.write(screenshotBreadcrumbsAndBlocksFiltersPp5Standard.getImage(), "png", expectedFile1);
        screenshotBreadcrumbsAndBlocksFiltersPp5Standard.setIgnoredAreas(screenshotBreadcrumbsAndBlocksFiltersPp5.getIgnoredAreas());

//        // Взять старый эталонный скриншот области хлебных крошек и блока фильтров страницы "Сериалы":
//        Screenshot screenshotBreadcrumbsAndBlocksFiltersPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "crumbsAndFiltersSerialsPagePp5Standard" + ".png")));
//        screenshotBreadcrumbsAndBlocksFiltersPp5Standard.setIgnoredAreas(screenshotBreadcrumbsAndBlocksFiltersPp5.getIgnoredAreas());

        // Сравнить скриншоты области хлебных крошек и блока фильтров страницы "Сериалы" (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotBreadcrumbsAndBlocksFiltersPp5Standard, screenshotBreadcrumbsAndBlocksFiltersPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffCrumbsAndFiltersSerialsPage" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 500);
    }

    public void switchingFromBannerToCardSerial() {
        click(By.xpath("//div[@data-test='BannerCarousel']"));
    }

    public void clickToLinkAllOnCollectionBlock() {
        click(By.partialLinkText("Все"));
    }

    public void checkElementsBannersCarousel() throws InterruptedException {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='leftCarouselButton']"));

        List<WebElement> BannerForSerials = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForSerials.size());
        for (int i = 0; i < BannerForSerials.size(); i++) {
            BannerForSerials = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForSerials.get(i).click();
            isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[3]"));
            isElementDisplayed(By.xpath("(//div[@class='XYh-kiX21fyak70PYmHLU poster'])[3]"));
            System.out.println(webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText());
        }

        List<WebElement> BannerForSerials2 = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForSerials2.size());
        for (int i = 0; i < BannerForSerials2.size(); i++) {
            BannerForSerials2 = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForSerials2.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//a[@href='/shows']//span[text()='Сериалы']")).size());
            Thread.sleep(2000);
            webDriver.get("https://web-preprod2.megafon.tv/shows");
        }
    }

    public void autoScrollBanners() throws InterruptedException {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='leftCarouselButton']"));

        String banner1 = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(banner1);
        Thread.sleep(5000);
        String banner2 = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(banner2);
        Assert.assertNotEquals(banner1, banner2);
        Thread.sleep(5000);
        String banner3 = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(banner3);
        Assert.assertNotEquals(banner2, banner3);
        Thread.sleep(5000);
        String banner4 = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(banner4);
        Assert.assertNotEquals(banner3, banner4);
        Thread.sleep(5000);
        String banner5 = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(banner5);
        Assert.assertNotEquals(banner4, banner5);
    }

    public void scrollBannersToLeft() throws InterruptedException {
        List<WebElement> BannerForSerials = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForSerials.size());
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        Thread.sleep(2000);
        String bannerFirst = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerFirst);
        click(By.xpath("//button[@data-test='leftCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton'][last()]//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']"));
        Thread.sleep(2000);
        String bannerLast = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerLast);
        Assert.assertNotEquals(bannerFirst, bannerLast);
    }

    public void scrollBannersToRight() throws InterruptedException {
        List<WebElement> BannerForSerials = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForSerials.size());
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][last()]"));
        String bannerLast = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerLast);
        click(By.xpath("//button[@data-test='rightCarouselButton']"));
        //isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton'][1]//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']"));
        Thread.sleep(2000);
        String bannerFirst = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(bannerFirst);
        Assert.assertNotEquals(bannerLast, bannerFirst);
    }

    public void scrollСollectionToRightAndLeft() throws InterruptedException {
        // разовый скролл подборки вправо:
        String tail1Right = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")).getText();
        String tail2Right = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[2]")).getText();
        String tail3Right = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[3]")).getText();
        System.out.println(tail1Right);
        System.out.println(tail2Right);
        System.out.println(tail3Right);

        click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext']"));

        String tail4Right = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]")).getText();
        String tail5Right = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6Right = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]"));
        System.out.println(tail4Right);
        System.out.println(tail5Right);
        System.out.println(tail6Right);
        Thread.sleep(5000);
        Assert.assertNotEquals(tail1Right, tail4Right);
        Assert.assertNotEquals(tail2Right, tail5Right);
        Assert.assertNotEquals(tail3Right, tail6Right);

        // разовый скролл подборки влево:
        String tail4Left = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]")).getText();
        String tail5Left = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6Left = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev']"));
        String tail1Left = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")).getText();
        String tail2Left = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[2]")).getText();
        String tail3Left = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[3]")).getText();
        Thread.sleep(5000);
        Assert.assertNotEquals(tail1Left, tail4Left);
        Assert.assertNotEquals(tail2Left, tail5Left);
        Assert.assertNotEquals(tail3Left, tail6Left);

        // скоролл подборки вправо до упора:
        while (webDriver.findElements(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext' and @disabled]")).size() < 1) {
            for (int i = 0; i <= 10; i++) {
                click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext']"));
            }
        }
        // скоролл подборки вдлево до упора:
        while (webDriver.findElements(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev' and @disabled]")).size() < 1) {
            for (int i = 0; i <= 10; i++) {
                click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev']"));
            }
        }
    }

    public void checkImageDifferScrollQuickFilters() throws IOException, AWTException {
        // Сделать тестовый скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        click(By.xpath("//button[contains(@class,'_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1')]"));
        Robot bot1 = new Robot();
        bot1.mouseMove(0, 0);
        Screenshot screenshotScrollQuickFiltersPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_1f1-eBWSN1rERnEOvc6ScB _1u_yecGhipzBAdhHgvWkg9']")) // игнор область подробок
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "scrollQuickFiltersSerialsPagePp4" + ".png");
        ImageIO.write(screenshotScrollQuickFiltersPp4.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        click(By.xpath("//button[contains(@class,'_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1')]"));
        Robot bot2 = new Robot();
        bot2.mouseMove(0, 0);
        Screenshot screenshotScrollQuickFiltersPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/" + "scrollQuickFiltersSerialsPagePp4" + ".png");
        ImageIO.write(screenshotScrollQuickFiltersPp4Standard.getImage(), "png", expectedFile1);
        screenshotScrollQuickFiltersPp4Standard.setIgnoredAreas(screenshotScrollQuickFiltersPp4.getIgnoredAreas());

//        // Взять старый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
//        Screenshot screenshotScrollQuickFiltersPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "scrollQuickFiltersSerialsPagePp4Standard" + ".png")));
//        screenshotScrollQuickFiltersPp4Standard.setIgnoredAreas(screenshotScrollQuickFiltersPp4.getIgnoredAreas());

        // Сравнить скриншоты скролла быстрых фильтров страницы "Фильмы (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotScrollQuickFiltersPp4Standard, screenshotScrollQuickFiltersPp4);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffScrollQuickFiltersSerialsPagePp4" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 500);
    }

    public void chooseOneQuickFilter() {
        click(By.xpath("//button[text()='Приключения']"));
        isElementDisplayed(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Приключения']"));
    }

    public void checkCatalogViewFilmsPage() {
        Assert.assertEquals("вид страницы не каталог", 0, webDriver.findElements(By.xpath("//div[@data-test='PackageListWrapper']")).size());
    }

    public void checkRequestResultOneQuickFilter() {
        List<WebElement> CollectionQuickFilter = webDriver.findElements(By.xpath("//div[@class='_2UHpP-xlu9DaTQUbJuPMEF' and contains(text(),'Приключения')]"));
        Assert.assertEquals(36, CollectionQuickFilter.size());
    }

    public void chooseTwoQuickFilter() {
        click(By.xpath("//button[text()='Боевик']"));
        isElementDisplayed(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Боевик']"));
        isElementDisplayed(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Приключения']"));
    }

    public void checkRequestResultTwoQuickFilter() {
        List<WebElement> CollectionQuickFilter = webDriver.findElements(By.xpath("//div[@class='_2UHpP-xlu9DaTQUbJuPMEF' and contains(text(),'Приключения')]|//div[@class='_2UHpP-xlu9DaTQUbJuPMEF' and contains(text(),'Боевик')]"));
        Assert.assertEquals(36, CollectionQuickFilter.size());
    }

    public void checkUnplugQuickFilter() {
        click(By.xpath("//button[text()='Боевик']"));
        Assert.assertEquals("не отключен быстрый фильтр", 0, webDriver.findElements(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Боевик']")).size());
    }

    public void checkRequestResultOneCountryAndTwoGenre() throws InterruptedException {
        List<WebElement> CollectionOneCountry;
        for (int i = 0; i <= 5; i++) {
            CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_2pRJ20SCSLVGSVaxy5FNBi']//a[@class='_8m5mByCjTuND14zuGKagi']"));
            CollectionOneCountry.get(i).click();
            WebElement button = webDriver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            webDriver.findElement(By.xpath("//div[contains(text(),'Документальный') or contains(text(),'Аниме')]"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            webDriver.findElement(By.xpath("//div[contains(text(),'США')]"));
            webDriver.navigate().back();
            Thread.sleep(5000);
        }
    }

    public void checkCollectionsViewSerialsPage() {
        Assert.assertNotEquals("вид страницы не каталог", 0, webDriver.findElements(By.xpath("//div[@data-test='PackageListWrapper']")).size());
    }

    public void checkCatalogViewSerialsPage() {
        Assert.assertEquals("вид страницы не каталог", 0, webDriver.findElements(By.xpath("//div[@data-test='PackageListWrapper']")).size());
    }
    public void checkElementsBlockCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ'])[1]"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonPrev' and @disabled]"));
    }

    public void clickToSecondTailCardSerial() {
        click(By.xpath("(//a[@data-test='PackageLink'])[2]"));
    }
    public void checkImageDifferBlockCollectHistoryWatch() throws IOException {
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        WebElement blockCollectHistoryWatch = webDriver.findElement(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']"));
        Set<By> posterTailsCollection = new HashSet<>();
        posterTailsCollection.add(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='HZzNvtNX5fExVnjY_Popf']"));
        Set<By> nameTailsCollection = new HashSet<>();
        nameTailsCollection.add(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ']"));
        Set<By> counterTailsCollection = new HashSet<>();
        counterTailsCollection.add(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
        Screenshot screenshotCollectHistoryWatch = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .ignoredElements(posterTailsCollection)
                .ignoredElements(nameTailsCollection)
                .ignoredElements(counterTailsCollection)
                .takeScreenshot(webDriver, blockCollectHistoryWatch);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/SerialsPage/" + "collectHistoryWatch" + ".png");
        ImageIO.write(screenshotCollectHistoryWatch.getImage(), "png", actualFile1);

        // Сделать новый эталон скриншота:
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        WebElement blockCollectHistoryWatchStandard = webDriver.findElement(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']"));
        Screenshot screenshotCollectHistoryWatchStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .ignoredElements(posterTailsCollection)
                .ignoredElements(nameTailsCollection)
                .takeScreenshot(webDriver, blockCollectHistoryWatchStandard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/SerialsPage/" + "collectHistoryWatchStandard" + ".png");
        ImageIO.write(screenshotCollectHistoryWatchStandard.getImage(), "png", expectedFile1);
        screenshotCollectHistoryWatchStandard.setIgnoredAreas(screenshotCollectHistoryWatch.getIgnoredAreas());

//        // Взять старый эталон скриншота:
//        Screenshot screenshotCollectHistoryWatchStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/SerialsPage/" + "collectHistoryWatchStandard" + ".png")));
//        screenshotCollectHistoryWatchStandard.setIgnoredAreas(screenshotCollectHistoryWatch.getIgnoredAreas());

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectHistoryWatchStandard, screenshotCollectHistoryWatch);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/SerialsPage/" + "diffCollectHistoryWatch" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);
    }
    public void scrollToTailWatchAndEdit() {
        click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Смотреть и редактировать")));
        isElementDisplayed(By.partialLinkText("Смотреть и редактировать"));
        isElementDisplayed(By.xpath("//p[text()='всю историю просмотров']"));
    }

    public void checkTailWatchAndEdit() {
        isElementDisplayed(By.partialLinkText("Смотреть и редактировать"));
        isElementDisplayed(By.xpath("//p[text()='всю историю просмотров']"));
    }

    public void clickToAllOnBlockCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
        click(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void clickToTailWatchAndEdit() {
        click(By.partialLinkText("Смотреть и редактировать"));
    }

    public void clickToPosterFirstTailBlockCollectHistoryWatch() {
        click(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]"));
    }

    public void clickToTextFirstTailBlockCollectHistoryWatch() {
        click(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ'])[1]"));
    }

    public void checkContentOnlySerialsWithout18Plus() throws InterruptedException {
        List<WebElement> tailsBlockCollectHistoryWatch = webDriver.findElements(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//a[@data-test='PackageLink']"));
        for(int i=0;i<tailsBlockCollectHistoryWatch.size();i++){
            tailsBlockCollectHistoryWatch = webDriver.findElements(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//a[@data-test='PackageLink']"));
            tailsBlockCollectHistoryWatch.get(i).click();
            Assert.assertEquals("есть контент 18+",0, webDriver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']|//div[contains(text(),'Эротика')]")).size());
            Assert.assertEquals("есть контент не сериал",1, webDriver.findElements(By.xpath("//a[@href='/shows']//span[1]")).size());
            webDriver.get("https://web-preprod2.megafon.tv/shows");
            Thread.sleep(5000);
        }
    }

    public void checkToMoveTailToFirstPlace() {
        String nameSerial = webDriver.findElement(By.xpath("//h1[text()]")).getText();
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        System.out.println(nameSerial);
        System.out.println(webDriver.findElement(By.xpath("(//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//h3[@data-test='PackageDescriptionTitle'])[1]")).getText());
        Assert.assertEquals("элементы не совпадают", nameSerial, webDriver.findElement(By.xpath("(//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//h3[@data-test='PackageDescriptionTitle'])[1]")).getText());
    }

    public void checkToMoveTailToLastPlace() {
        String nameSerial = webDriver.findElement(By.xpath("//h1[text()]")).getText();
        webDriver.get("https://web-preprod2.megafon.tv/shows");
        System.out.println(nameSerial);
        System.out.println(webDriver.findElement(By.xpath("(//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//h3[@data-test='PackageDescriptionTitle'])[last()]")).getText());
        Assert.assertEquals("элементы не совпадают", nameSerial, webDriver.findElement(By.xpath("(//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//h3[@data-test='PackageDescriptionTitle'])[last()]")).getText());
    }

    public void clickToLastTailBlockCollectHistoryWatch() {
        click(By.xpath("(//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//a[@data-test='PackageLink'])[last()]"));
    }

    public void clickToFirstTailBlockCollectHistoryWatch() {
        click(By.xpath("(//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//a[@data-test='PackageLink'])[1]"));
    }

    public void checkAbsentBlockCollectHistoryWatch() {
        Assert.assertEquals("есть подборка 'Продолжить просмотр'", 0, webDriver.findElements(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']")).size());
    }

    public void clickOnFastFilterGenre() {
        click(By.xpath("//button[text()='Боевик']"));
    }
}
