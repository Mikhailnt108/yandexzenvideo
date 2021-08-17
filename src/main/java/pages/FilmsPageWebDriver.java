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
import java.util.List;

public class FilmsPageWebDriver extends BasePageWebDriver {
    String SITE_URL = "https://web-preprod5.megafon.tv/";

    public FilmsPageWebDriver(WebDriver driver) {
        super(driver);
    }

    public void checkOpenFilmsPage() {
        isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
    }

    public void clickToTailCardFilmFromAvailable() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void clickToHeaderRent2Collection() {
        click(By.partialLinkText("аренд"));
    }

    public void clickOnFiltrPayment() {
        click(By.xpath("//button[text()='Оплачено']"));
    }

    public void chooseTabPromo() throws InterruptedException {
        webDriver.navigate().refresh();
        click(By.xpath("//div[text()='По акции']"));
        Thread.sleep(3000);
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
        List<WebElement> Only2019years = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'2019')]"));
        Assert.assertEquals(36, Only2019years.size());
    }

    public void choosePeriodOfYears() {
        click(By.xpath("//div[text()='Год с']"));
        click(By.xpath("(//span[text()='2010'])[1]"));

        click(By.xpath("//div[text()='по']"));
        click(By.xpath("(//span[text()='2020'])[2]"));
    }

    public void checkRequestResultPeriodOfYears() {
        List<WebElement> Period = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'2018') or contains(text(),'2019') or contains(text(),'2020') or contains(text(),'2021')]"));
        Assert.assertEquals(36, Period.size());
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
        List<WebElement> CollectionOneGenre = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Документальный')]"));
        Assert.assertEquals(36, CollectionOneGenre.size());
    }

    public void chooseTwoGenre() {
        click(By.xpath("//div[text()='Документальный']"));
        click(By.xpath("//span[text()='Аниме']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultTwoGenre() {
        List<WebElement> CollectionTwoGenre = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Документальный')]|//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Аниме')]"));
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
        click(By.xpath("//span[text()='Россия']"));
        click(By.xpath("//div[text()='Страна']"));
        Thread.sleep(3000);
    }

    public void checkRequestResultOneCountry() {
        List<WebElement> CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
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
        click(By.xpath("//span[text()='Канада']"));
        click(By.xpath("//span[text()='Россия']"));
        click(By.xpath("//span[text()='Китай']"));
        click(By.xpath("//div[text()='Страна']"));
        webDriver.navigate().refresh();
    }

    public void checkRequestResultTwoCountry() {
        List<WebElement> CollectionTwoCountry = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionTwoCountry = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionTwoCountry.get(i).click();
            WebElement button = webDriver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            webDriver.findElement(By.xpath("//div[contains(text(),'Китай') or contains(text(),'Канада')]"));
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

    public void clickToTailCardFilm2FromAll() {
        click(By.xpath("(//a[@data-test='PackageLink'])[2]"));
    }

    public void clickToTailCardFilm3FromAll() {
        click(By.xpath("(//a[@data-test='PackageLink'])[3]"));
    }

    public void clickToTailCardFilm4FromAll() {
        click(By.xpath("(//a[@data-test='PackageLink'])[5]"));
    }

    public void checkFilmsPromo() {
        List<WebElement> CollectionPackages = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i < 5; i++) {
            CollectionPackages = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionPackages.get(i).click();
            Assert.assertEquals("Нет кнопки 'По акции на 48 часов за 0 ₽' на странице", "По акции на 48 часов за 0 ₽", webDriver.findElement(By.xpath("//span[text()='По акции на 48 часов за 0 ₽']")).getText());
            webDriver.navigate().back();
        }
    }

    public void clickToTailCardFilm() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void checkImageDifferCherdakAndBannersGuest() throws IOException {
        // Сделать тестовый скриншот чердака:
        WebElement headerCherdakGuest = webDriver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakGuest = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerCherdakGuest);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCherdakGuest" + ".png");
        ImageIO.write(screenshotHeaderCherdakGuest.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот чердака:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        WebElement headerCherdakGuestStandard = webDriver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakGuestStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerCherdakGuestStandard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCherdakGuestStandard" + ".png");
        ImageIO.write(screenshotHeaderCherdakGuestStandard.getImage(), "png", expectedFile1);

//        // Взять старый эталонный скриншот чердака:
//        Screenshot screenshotHeaderCherdakGuestStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCherdakGuestStandard" + ".png")));

        // Сравнить скриншоты чердака (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotHeaderCherdakGuestStandard, screenshotHeaderCherdakGuest);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCherdakGuest" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сделать тестовый скриншот баннерной зоны:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][2]"));
        WebElement headerBanner = webDriver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBanner = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .takeScreenshot(webDriver, headerBanner);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageBanner" + ".png");
        ImageIO.write(screenshotHeaderBanner.getImage(), "png", actualFile2);

        // Сделать новый эталонный скриншот баннерной зоны:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        WebElement headerBannerStandard = webDriver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerBannerStandard);
        File expectedFile2 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageBannerStandard" + ".png");
        ImageIO.write(screenshotHeaderBannerStandard.getImage(), "png", expectedFile2);
        screenshotHeaderBannerStandard.setIgnoredAreas(screenshotHeaderBanner.getIgnoredAreas());

//        // Взять старый эталонный скриншот баннерной зоны:
//        Screenshot screenshotHeaderBannerStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageBannerStandard" + ".png")));
//        screenshotHeaderBannerStandard.setIgnoredAreas(screenshotHeaderBanner.getIgnoredAreas());

        // Сравнить скриншоты баннерной зоны (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotHeaderBannerStandard, screenshotHeaderBanner);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffBanner" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferBlocksCollectionGuest() throws IOException {
        // Сделать тестовый скриншот блока подборки с заголовком:
//        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFiltersGuest = (JavascriptExecutor) webDriver;
        blockQuickFiltersGuest.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithTitleGuest = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор все блоки подборок, кроме первой
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCollectionWithTitleGuest" + ".png");
        ImageIO.write(screenshotCollectionWithTitleGuest.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот блока подборки с заголовком:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters2 = (JavascriptExecutor) webDriver;
        blockQuickFilters2.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithTitleGuestStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithTitleGuestStandard" + ".png");
        ImageIO.write(screenshotCollectionWithTitleGuestStandard.getImage(), "png", expectedFile1);
        screenshotCollectionWithTitleGuestStandard.setIgnoredAreas(screenshotCollectionWithTitleGuest.getIgnoredAreas());

//        // Взять старый эталонный скриншот блока подборки с заголовком:
//        Screenshot screenshotCollectionWithTitleGuestStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithTitleGuestStandard" + ".png")));
//        screenshotCollectionWithTitleGuestStandard.setIgnoredAreas(screenshotCollectionWithTitleGuest.getIgnoredAreas());

        // Сравнение скриншотов блока подборки с заголовком (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectionWithTitleGuestStandard, screenshotCollectionWithTitleGuest);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCollectionWithTitleGuest" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сделать тестовый скриншот блока подборки без заголовка:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters3 = (JavascriptExecutor) webDriver;
        blockQuickFilters3.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithoutTitleGuest = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор блоки подборки без заголовка, кроме первого найденного
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@data-test='CollectionBlock']")) // игнор постеры первого найденного блока подборки без заголовка
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']")) // игнор блоки подборки с заголовком
                .takeScreenshot(webDriver);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCollectionWithoutTitleGuest" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitleGuest.getImage(), "png", actualFile2);

        // Сделать новый эталонный скриншот блока подборки без заголовка:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters4 = (JavascriptExecutor) webDriver;
        blockQuickFilters4.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithoutTitleGuestStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile2 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithoutTitleGuestStandard" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitleGuestStandard.getImage(), "png", expectedFile2);
        screenshotCollectionWithoutTitleGuestStandard.setIgnoredAreas(screenshotCollectionWithoutTitleGuest.getIgnoredAreas());

//        //Взять старый эталонный скриншот блока подборки без заголовка:
//        Screenshot screenshotCollectionWithoutTitleGuestStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithoutTitleGuestStandard" + ".png")));
//        screenshotCollectionWithoutTitleGuestStandard.setIgnoredAreas(screenshotCollectionWithoutTitleGuest.getIgnoredAreas());

        //Сравнение скриншотов блока подборки без заголовка (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotCollectionWithoutTitleGuestStandard, screenshotCollectionWithoutTitleGuest);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCollectionWithoutTitleGuest" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferFooter() throws IOException {
        // Сделать тестовый скриншот футера:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        WebElement footer = webDriver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooter = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver, footer);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageFooter" + ".png");
        ImageIO.write(screenshotFooter.getImage(), "png", actualFile1);

//        //Сделать новый эталонный скриншот футера:
//        driver.get("https://web-preprod5.megafon.tv/movies/vods");
//        WebElement footerStandard = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
//        Screenshot screenshotFooterStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver, footerStandard);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageFooterStandard" + ".png");
//        ImageIO.write(screenshotFooterStandard.getImage(), "png", expectedFile1);
//        screenshotFooterStandard.setIgnoredAreas(screenshotFooter.getIgnoredAreas());

        // Взять старый эталонный скриншот футера:
        Screenshot screenshotFooterStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageFooterStandard" + ".png")));
        screenshotFooterStandard.setIgnoredAreas(screenshotFooter.getIgnoredAreas());

        // Сравнить скриншоты футера (тестовый и эталонный):
        ImageDiff diff = new ImageDiffer().makeDiff(screenshotFooterStandard, screenshotFooter);
        System.out.println(diff.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffFooter" + ".png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff.getDiffSize() <= 100);
        JavascriptExecutor scrollUp = (JavascriptExecutor) webDriver;
        scrollUp.executeScript("scroll(0, -250);");
    }

    public void checkImageDifferFilmsPageScrollGuest() throws IOException {
        // Сделать тестовый скриншот скролла страницы "Фильмы:
//        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters5 = (JavascriptExecutor) webDriver;
        blockQuickFilters5.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotFilmsGuest = new AShot().coordsProvider(new WebDriverCoordsProvider())
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>2]")) // игнорировать блоки подборки, кроме первых 2х
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "scrollPageFilmsGuest" + ".png");
        ImageIO.write(screenshotFilmsGuest.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот скролла страницы "Фильмы:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters6 = (JavascriptExecutor) webDriver;
        blockQuickFilters6.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotFilmsGuestStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "scrollFilmsPageGuestStandard" + ".png");
        ImageIO.write(screenshotFilmsGuestStandard.getImage(), "png", expectedFile1);
        screenshotFilmsGuestStandard.setIgnoredAreas(screenshotFilmsGuest.getIgnoredAreas());

//        // Взять старый эталонный скриншот скролла страницы "Фильмы:
//        Screenshot screenshotFilmsGuestStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "scrollFilmsPageGuestStandard" + ".png")));
//        screenshotFilmsGuestStandard.setIgnoredAreas(screenshotFilmsGuest.getIgnoredAreas());

        // Сравнить скриншоты скролла страницы "Фильмы" (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotFilmsGuestStandard, screenshotFilmsGuest);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffFilmsPageScrollGuest" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 500);
        webDriver.navigate().refresh();
        JavascriptExecutor scrollUp = (JavascriptExecutor) webDriver;
        scrollUp.executeScript("scroll(0, -250);");
    }

    public void checkImageDifferBreadcrumbsAndBlocksFiltersGuest() throws IOException {
        // Сделать тестовый скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        Screenshot screenshotBreadcrumbsAndBlocksFiltersGuest = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_1f1-eBWSN1rERnEOvc6ScB _1u_yecGhipzBAdhHgvWkg9']")) // игнор область подробок
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "crumbsAndFiltersPageFilmsGuest" + ".png");
        ImageIO.write(screenshotBreadcrumbsAndBlocksFiltersGuest.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        Screenshot screenshotBreadcrumbsAndBlocksFiltersGuestStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "crumbsAndFiltersFilmsPageGuestStandard" + ".png");
        ImageIO.write(screenshotBreadcrumbsAndBlocksFiltersGuestStandard.getImage(), "png", expectedFile1);
        screenshotBreadcrumbsAndBlocksFiltersGuestStandard.setIgnoredAreas(screenshotBreadcrumbsAndBlocksFiltersGuest.getIgnoredAreas());

//        // Взять старый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
//        Screenshot screenshotBreadcrumbsAndBlocksFiltersGuestStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "crumbsAndFiltersFilmsPageGuestStandard" + ".png")));
//        screenshotBreadcrumbsAndBlocksFiltersGuestStandard.setIgnoredAreas(screenshotBreadcrumbsAndBlocksFiltersGuest.getIgnoredAreas());

        // Сравнить скриншоты области хлебных крошек и блока фильтров страницы "Фильмы" (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotBreadcrumbsAndBlocksFiltersGuestStandard, screenshotBreadcrumbsAndBlocksFiltersGuest);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCrumbsAndFiltersFilmsPageGuest" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 500);
    }

    public void checkElementsFilmsPage() {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//ol[@class='_1-ZY27a7Isb9dohjRr0mXq']"));
        isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
        isElementDisplayed(By.xpath("//div[@class='_10lCh4uWCss6HRDZrOjSEk']"));
        isElementDisplayed(By.xpath("//div[@class='_3SqVO95D45Gj6EpowjScAG']"));
        isElementDisplayed(By.xpath("(//div[@data-test='PackageListWrapper'])[1]"));
    }

    public void checkElementsBannersCarousel() throws InterruptedException {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='leftCarouselButton']"));

        List<WebElement> BannerForFilms = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForFilms.size());
        for (int i = 0; i < BannerForFilms.size(); i++) {
            BannerForFilms = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForFilms.get(i).click();
            isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[3]"));
            isElementDisplayed(By.xpath("(//div[@class='XYh-kiX21fyak70PYmHLU poster'])[3]"));
            System.out.println(webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText());
        }

        List<WebElement> BannerForFilms2 = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForFilms2.size());
        for (int i = 0; i < BannerForFilms2.size(); i++) {
            BannerForFilms2 = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForFilms2.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            Thread.sleep(2000);
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//a[@href='/movies/vods']//span[text()='Фильмы']")).size());
            Thread.sleep(2000);
            webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        }

    }

    public void autoScrollBanners() throws Exception {
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

    public void scrollBannersToLeft() throws Exception {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
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

    public void scrollBannersToRight() throws Exception {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
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

    public void scrollСollectionToRightAndLeft() throws Exception {

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
    public void switchingFromBannerToCardFilm() {
        click(By.xpath("//div[@data-test='BannerCarousel']"));
    }

    public void clickToLinkAllOnCollectionBlock() {
        click(By.partialLinkText("Все"));
    }

    public void checkImageDifferBlockQuickFilters() {

    }

    public void checkImageDifferScrollQuickFilters() throws IOException, AWTException {
        // Сделать тестовый скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        click(By.xpath("//button[contains(@class,'_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1')]"));
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
        Screenshot screenshotScrollQuickFilters = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_1f1-eBWSN1rERnEOvc6ScB _1u_yecGhipzBAdhHgvWkg9']")) // игнор область подробок
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "scrollQuickFiltersPageFilms" + ".png");
        ImageIO.write(screenshotScrollQuickFilters.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
//        driver.get("https://web-preprod5.megafon.tv/movies/vods");
//        click(By.xpath("//button[contains(@class,'_1P8UP167h6OHinoWcPAL23 _1mUdY0HH_3ift9AyWAmWx1')]"));
//        Robot bot2 = new Robot();
//        bot.mouseMove(0, 0);
//        Screenshot screenshotScrollQuickFiltersStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "scrollQuickFiltersPageFilmsStandard" + ".png");
//        ImageIO.write(screenshotScrollQuickFiltersStandard.getImage(), "png", expectedFile1);
//        screenshotScrollQuickFiltersStandard.setIgnoredAreas(screenshotScrollQuickFilters.getIgnoredAreas());

        // Взять старый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        Screenshot screenshotScrollQuickFiltersStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "scrollQuickFiltersPageFilmsStandard" + ".png")));
        screenshotScrollQuickFiltersStandard.setIgnoredAreas(screenshotScrollQuickFilters.getIgnoredAreas());

        // Сравнить скриншоты скролла быстрых фильтров страницы "Фильмы (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotScrollQuickFiltersStandard, screenshotScrollQuickFilters);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffScrollQuickFiltersPageFilms" + ".png");
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
        List<WebElement> CollectionQuickFilter = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Приключения')]"));
        Assert.assertEquals(36, CollectionQuickFilter.size());
    }

    public void chooseTwoQuickFilter() {
        click(By.xpath("//button[text()='Боевик']"));
        isElementDisplayed(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Боевик']"));
        isElementDisplayed(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Приключения']"));
    }

    public void checkRequestResultTwoQuickFilter() {
        List<WebElement> CollectionQuickFilter = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Приключения')]|//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Боевик')]"));
        Assert.assertEquals(36, CollectionQuickFilter.size());
    }

    public void checkUnplugQuickFilter() {
        click(By.xpath("//button[text()='Боевик']"));
        Assert.assertEquals("не отключен быстрый фильтр", 0, webDriver.findElements(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Боевик']")).size());
    }

    public void checkRequestResultOneCountryAndTwoGenre() {
        List<WebElement> CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionOneCountry.get(i).click();
            WebElement button = webDriver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            webDriver.findElement(By.xpath("//div[contains(text(),'Документальный') or contains(text(),'Аниме')]"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            webDriver.findElement(By.xpath("//div[contains(text(),'Россия')]"));
            webDriver.navigate().back();
        }
    }

    public void checkCollectionsViewFilmsPage() {
        Assert.assertNotEquals("вид страницы не каталог", 0, webDriver.findElements(By.xpath("//div[@data-test='PackageListWrapper']")).size());
    }

    public void checkImageDifferCherdakAndBannersUser() throws IOException {
        // Сделать тестовый скриншот чердака:
        WebElement headerCherdakUser = webDriver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakUser = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerCherdakUser);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCherdakUser" + ".png");
        ImageIO.write(screenshotHeaderCherdakUser.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот чердака:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        WebElement headerCherdakUserStandard = webDriver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakUserStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerCherdakUserStandard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCherdakUserStandard" + ".png");
        ImageIO.write(screenshotHeaderCherdakUserStandard.getImage(), "png", expectedFile1);

//        // Взять старый эталонный скриншот чердака:
//        Screenshot screenshotHeaderCherdakUserStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCherdakUserStandard" + ".png")));

        // Сравнить скриншоты чердака (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotHeaderCherdakUserStandard, screenshotHeaderCherdakUser);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCherdakUser" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сделать тестовый скриншот баннерной зоны:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][2]"));
        WebElement headerBanner = webDriver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBanner = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .takeScreenshot(webDriver, headerBanner);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageBanner" + ".png");
        ImageIO.write(screenshotHeaderBanner.getImage(), "png", actualFile2);

        // Сделать новый эталонный скриншот баннерной зоны:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        WebElement headerBannerStandard = webDriver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerBannerStandard);
        File expectedFile2 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageBannerStandard" + ".png");
        ImageIO.write(screenshotHeaderBannerStandard.getImage(), "png", expectedFile2);
        screenshotHeaderBannerStandard.setIgnoredAreas(screenshotHeaderBanner.getIgnoredAreas());

//        // Взять старый эталонный скриншот баннерной зоны:
//        Screenshot screenshotHeaderBannerStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageBannerStandard" + ".png")));
//        screenshotHeaderBannerStandard.setIgnoredAreas(screenshotHeaderBanner.getIgnoredAreas());

        // Сравнить скриншоты баннерной зоны (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotHeaderBannerStandard, screenshotHeaderBanner);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffBanner" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferBreadcrumbsAndBlocksFiltersUser() throws IOException {
        // Сделать тестовый скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
//        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        Screenshot screenshotBreadcrumbsAndBlocksFiltersUser = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_1f1-eBWSN1rERnEOvc6ScB _1u_yecGhipzBAdhHgvWkg9']")) // игнор область подробок
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "crumbsAndFiltersPageFilmsUser" + ".png");
        ImageIO.write(screenshotBreadcrumbsAndBlocksFiltersUser.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        Screenshot screenshotBreadcrumbsAndBlocksFiltersUserStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "crumbsAndFiltersFilmsPageUserStandard" + ".png");
        ImageIO.write(screenshotBreadcrumbsAndBlocksFiltersUserStandard.getImage(), "png", expectedFile1);
        screenshotBreadcrumbsAndBlocksFiltersUserStandard.setIgnoredAreas(screenshotBreadcrumbsAndBlocksFiltersUser.getIgnoredAreas());

//        // Взять старый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
//        Screenshot screenshotBreadcrumbsAndBlocksFiltersUserStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "crumbsAndFiltersFilmsPageUserStandard" + ".png")));
//        screenshotBreadcrumbsAndBlocksFiltersUserStandard.setIgnoredAreas(screenshotBreadcrumbsAndBlocksFiltersUser.getIgnoredAreas());

        // Сравнить скриншоты области хлебных крошек и блока фильтров страницы "Фильмы" (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotBreadcrumbsAndBlocksFiltersUserStandard, screenshotBreadcrumbsAndBlocksFiltersUser);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCrumbsAndFiltersFilmsPageUser" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 500);
    }

    public void checkImageDifferBlocksCollectionUser() throws IOException {
        // Сделать тестовый скриншот блока подборки с заголовком:
//        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFiltersGuest = (JavascriptExecutor) webDriver;
        blockQuickFiltersGuest.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithTitleUser = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор все блоки подборок, кроме первой
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCollectionWithTitleGuest" + ".png");
        ImageIO.write(screenshotCollectionWithTitleUser.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот блока подборки с заголовком:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters2 = (JavascriptExecutor) webDriver;
        blockQuickFilters2.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithTitleUserStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithTitleUserStandard" + ".png");
        ImageIO.write(screenshotCollectionWithTitleUserStandard.getImage(), "png", expectedFile1);
        screenshotCollectionWithTitleUserStandard.setIgnoredAreas(screenshotCollectionWithTitleUser.getIgnoredAreas());

//        // Взять старый эталонный скриншот блока подборки с заголовком:
//        Screenshot screenshotCollectionWithTitleUserStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithTitleUserStandard" + ".png")));
//        screenshotCollectionWithTitleUserStandard.setIgnoredAreas(screenshotCollectionWithTitleUser.getIgnoredAreas());

        // Сравнение скриншотов блока подборки с заголовком (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectionWithTitleUserStandard, screenshotCollectionWithTitleUser);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCollectionWithTitleUser" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сделать тестовый скриншот блока подборки без заголовка:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters3 = (JavascriptExecutor) webDriver;
        blockQuickFilters3.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithoutTitleUser = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор блоки подборки без заголовка, кроме первого найденного
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@data-test='CollectionBlock']")) // игнор постеры первого найденного блока подборки без заголовка
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']")) // игнор блоки подборки с заголовком
                .takeScreenshot(webDriver);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCollectionWithoutTitleUser" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitleUser.getImage(), "png", actualFile2);

        // Сделать новый эталонный скриншот блока подборки без заголовка:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters4 = (JavascriptExecutor) webDriver;
        blockQuickFilters4.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotCollectionWithoutTitleUserStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile2 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithoutTitleUserStandard" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitleUserStandard.getImage(), "png", expectedFile2);
        screenshotCollectionWithoutTitleUserStandard.setIgnoredAreas(screenshotCollectionWithoutTitleUser.getIgnoredAreas());

//        //Взять старый эталонный скриншот блока подборки без заголовка:
//        Screenshot screenshotCollectionWithoutTitleUserStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithoutTitleUserStandard" + ".png")));
//        screenshotCollectionWithoutTitleUserStandard.setIgnoredAreas(screenshotCollectionWithoutTitleUser.getIgnoredAreas());

        //Сравнение скриншотов блока подборки без заголовка (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotCollectionWithoutTitleUserStandard, screenshotCollectionWithoutTitleUser);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCollectionWithoutTitleUser" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferFilmsPageScrollUser() throws IOException {
        // Сделать тестовый скриншот скролла страницы "Фильмы:
//        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters5 = (JavascriptExecutor) webDriver;
        blockQuickFilters5.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotFilmsUser = new AShot().coordsProvider(new WebDriverCoordsProvider())
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>2]")) // игнорировать блоки подборки, кроме первых 2х
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "scrollPageFilmsUser" + ".png");
        ImageIO.write(screenshotFilmsUser.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот скролла страницы "Фильмы:
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        JavascriptExecutor blockQuickFilters6 = (JavascriptExecutor) webDriver;
        blockQuickFilters6.executeScript("return document.getElementsByClassName('_3GjHo6eid2U-Hge5EKolW5')[0].remove();");
        Screenshot screenshotFilmsUserStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "scrollFilmsPageUserStandard" + ".png");
        ImageIO.write(screenshotFilmsUserStandard.getImage(), "png", expectedFile1);
        screenshotFilmsUserStandard.setIgnoredAreas(screenshotFilmsUser.getIgnoredAreas());

//        // Взять старый эталонный скриншот скролла страницы "Фильмы:
//        Screenshot screenshotFilmsUserStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "scrollFilmsPageUserStandard" + ".png")));
//        screenshotFilmsUserStandard.setIgnoredAreas(screenshotFilmsGuest.getIgnoredAreas());

        // Сравнить скриншоты скролла страницы "Фильмы" (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotFilmsUserStandard, screenshotFilmsUser);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffFilmsPageScrollUser" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 500);
        webDriver.navigate().refresh();
        JavascriptExecutor scrollUp = (JavascriptExecutor) webDriver;
        scrollUp.executeScript("scroll(0, -250);");
    }
}





