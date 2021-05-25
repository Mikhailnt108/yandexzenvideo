package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.Coords;
import ru.yandex.qatools.ashot.coordinates.CoordsProvider;
import ru.yandex.qatools.ashot.coordinates.JqueryCoordsProvider;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.SimpleShootingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmsPage extends BasePage {
    String SITE_URL = "https://web-preprod4.megafon.tv/";

    public FilmsPage(WebDriver driver) {
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

    public void chooseTabPromo() {
        driver.navigate().refresh();
        click(By.xpath("//div[text()='По акции']"));
    }

    public void clickOnYearInput() {
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRadioButtons() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("(//div[@class='_TKVCKE7PL8voHtm8HP2j'])[1]//span[@class='AoSy93bShFe6C6hlZfxUE']"));
        Assert.assertEquals(15, radioButtons.size());
    }

    public void chooseOneYearOnly() {
        click(By.xpath("//span[text()='2019 год']"));
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRequestResultOneYearOnly() {
        List<WebElement> Only2019years = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'2019')]"));
        Assert.assertEquals(36, Only2019years.size());
    }

    public void choosePeriodOfYears() {
        click(By.xpath("//div[text()='2019 год']"));
        click(By.xpath("//span[text()='2018-2021']"));
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRequestResultPeriodOfYears() {
        List<WebElement> Period = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'2018') or contains(text(),'2019') or contains(text(),'2020') or contains(text(),'2021')]"));
        Assert.assertEquals(36, Period.size());
    }

    public void clickOnGenreInput() {
        click(By.xpath("//div[text()='Жанр']"));

    }

    public void checkCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[1]//input[@type='checkbox']"));
        Assert.assertEquals(28, checkboxes.size());
    }

    public void chooseOneGenre() {
        click(By.xpath("//span[text()='Документальный']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultOneGenre() {
        List<WebElement> CollectionOneGenre = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Документальный')]"));
        Assert.assertEquals(36, CollectionOneGenre.size());


    }

    public void chooseTwoGenre() {
        click(By.xpath("//div[text()='Документальный']"));
        click(By.xpath("//span[text()='Аниме']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultTwoGenre() {
        List<WebElement> CollectionTwoGenre = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Документальный') or contains(text(),'Аниме')]"));
        Assert.assertEquals(36, CollectionTwoGenre.size());
    }

    public void clickOnCountryInput() {
        click(By.xpath("//div[text()='Страна']"));
    }

    public void checkCheckboxesInCountry() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[2]//input[@type='checkbox']"));
        Assert.assertEquals(18, checkboxes.size());
        //for (WebElement checkbox : checkboxes) {
        //  checkbox.click();
        //}
    }

    public void chooseOneCountry() {
        click(By.xpath("//span[text()='Россия']"));
        click(By.xpath("//div[text()='Страна']"));
    }

    public void checkRequestResultOneCountry() {
        List<WebElement> CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionOneCountry = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionOneCountry.get(i).click();
            WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            driver.findElement(By.xpath("//div[contains(text(),'Россия')]"));
            driver.navigate().back();
        }
    }


    public void chooseTwoCountry() {
        click(By.xpath("//div[text()='Россия']"));
        click(By.xpath("//span[text()='Канада']"));
        click(By.xpath("//span[text()='Россия']"));
        click(By.xpath("//span[text()='Китай']"));
        click(By.xpath("//div[text()='Страна']"));
        driver.navigate().refresh();
    }

    public void checkRequestResultTwoCountry() {
        List<WebElement> CollectionTwoCountry = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionTwoCountry = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionTwoCountry.get(i).click();
            WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            driver.findElement(By.xpath("//div[contains(text(),'Китай') or contains(text(),'Канада')]"));
            driver.navigate().back();
        }
    }

    public void clickOnResetFiltersButton() {
        click(By.xpath("//button[text()='Сбросить']"));
    }

    public void checkResetAllFilters() {
        List<WebElement> Filters = driver.findElements(By.xpath("//div[@class='_1RRLrdyUeRf97LW7DW4bHw']//div[text()='Жанр' or text()='Страна' or text()='Год' or text()='Рейтинг']"));
        Assert.assertEquals(4, Filters.size());
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
        List<WebElement> CollectionPackages = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            CollectionPackages = driver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionPackages.get(i).click();
            Assert.assertEquals("Нет кнопки 'По акции на 48 часов за 0 ₽' на странице", "По акции на 48 часов за 0 ₽", driver.findElement(By.xpath("//span[text()='По акции на 48 часов за 0 ₽']")).getText());
            driver.navigate().back();
        }
    }

    public void clickToTailCardFilm() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void checkImageDifferCherdakAndBanners() throws IOException {
        // Сделать тестовый скриншот чердака:
        WebElement headerCherdakPp4 = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, headerCherdakPp4);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCherdakPp4" + ".png");
        ImageIO.write(screenshotHeaderCherdakPp4.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот чердака:
        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        WebElement headerCherdakPp4Standard = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, headerCherdakPp4Standard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCherdakPp4Standard" + ".png");
        ImageIO.write(screenshotHeaderCherdakPp4Standard.getImage(), "png", expectedFile1);

//        // Взять старый эталонный скриншот чердака:
//        Screenshot screenshotHeaderCherdakPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCherdakPp4Standard" + ".png")));

        // Сравнить скриншоты чердака (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotHeaderCherdakPp4Standard, screenshotHeaderCherdakPp4);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCherdak" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сделать тестовый скриншот баннерной зоны:
        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][2]"));
        WebElement headerBannerPp4 = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .takeScreenshot(driver, headerBannerPp4);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageBannerPp4" + ".png");
        ImageIO.write(screenshotHeaderBannerPp4.getImage(), "png", actualFile2);

        // Сделать новый эталонный скриншот баннерной зоны:
        driver.get("https://web-preprod4.megafon.tv/movies/vods");
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        WebElement headerBannerPp4Standard = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, headerBannerPp4Standard);
        File expectedFile2 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageBannerPp4Standard" + ".png");
        ImageIO.write(screenshotHeaderBannerPp4Standard.getImage(), "png", expectedFile2);
        screenshotHeaderBannerPp4Standard.setIgnoredAreas(screenshotHeaderBannerPp4.getIgnoredAreas());

//        // Взять старый эталонный скриншот баннерной зоны:
//        Screenshot screenshotHeaderBannerPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageBannerPp4Standard" + ".png")));
//        screenshotHeaderBannerPp4Standard.setIgnoredAreas(screenshotHeaderBannerPp4.getIgnoredAreas());

        // Сравнить скриншоты баннерной зоны (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotHeaderBannerPp4Standard, screenshotHeaderBannerPp4);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffBanner" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferBlocksCollection() throws IOException {
        // Сделать тестовый скриншот блока подборки с заголовком:
        driver.get("https://web-preprod4.megafon.tv/movies/vods");
        Screenshot screenshotCollectionWithTitlePp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор все блоки подборок, кроме первой
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCollectionWithTitlePp4" + ".png");
        ImageIO.write(screenshotCollectionWithTitlePp4.getImage(), "png", actualFile1);
//
        // Сделать новый эталонный скриншот блока подборки с заголовком:
        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        Screenshot screenshotCollectionWithTitlePp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithTitlePp4Standard" + ".png");
        ImageIO.write(screenshotCollectionWithTitlePp4Standard.getImage(), "png", expectedFile1);
        screenshotCollectionWithTitlePp4Standard.setIgnoredAreas(screenshotCollectionWithTitlePp4.getIgnoredAreas());
//
////        // Взять старый эталонный скриншот блока подборки с заголовком:
////       Screenshot screenshotCollectionWithTitlePp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithTitlePp4Standard" + ".png")));
////        screenshotCollectionWithTitlePp4Standard.setIgnoredAreas(screenshotCollectionWithTitlePp4.getIgnoredAreas());
//
        // Сравнение скриншотов блока подборки с заголовком (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectionWithTitlePp4Standard, screenshotCollectionWithTitlePp4);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCollectionWithTitle" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сделать тестовый скриншот блока подборки без заголовка:
        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        Screenshot screenshotCollectionWithoutTitlePp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_3vWFiYltc8dtOgsuRbqAyX']")) // игнорировать закрепленный блок фильтров
                .addIgnoredElement(By.xpath("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор блоки подборки без заголовка, кроме первого найденного
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@data-test='CollectionBlock']")) // игнор постеры первого найденного блока подборки без заголовка
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']")) // игнор блоки подборки с заголовком
                .takeScreenshot(driver);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageCollectionWithoutTitlePp4" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitlePp4.getImage(), "png", actualFile2);

        // Сделать новый эталонный скриншот блока подборки без заголовка:
        driver.get("https://web-preprod4.megafon.tv/movies/vods");
        Screenshot screenshotCollectionWithoutTitlePp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File expectedFile2 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithoutTitlePp4Standard" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitlePp4Standard.getImage(), "png", expectedFile2);
        screenshotCollectionWithoutTitlePp4Standard.setIgnoredAreas(screenshotCollectionWithoutTitlePp4.getIgnoredAreas());

//        //Взять старый эталонный скриншот блока подборки без заголовка:
//        Screenshot screenshotCollectionWithoutTitlePp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageCollectionWithoutTitlePp4Standard" + ".png")));
//        screenshotCollectionWithoutTitlePp4Standard.setIgnoredAreas(screenshotCollectionWithoutTitlePp4.getIgnoredAreas());

        //Сравнение скриншотов блока подборки без заголовка (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotCollectionWithoutTitlePp4Standard, screenshotCollectionWithoutTitlePp4);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCollectionWithoutTitle" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferFooter() throws IOException {
        // Сделать тестовый скриншот футера:
        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        WebElement footerPp4 = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooterPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver, footerPp4);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "filmsPageFooterPp4" + ".png");
        ImageIO.write(screenshotFooterPp4.getImage(), "png", actualFile1);

        //Сделать новый эталонный скриншот футера:
        driver.get("https://web-preprod4.megafon.tv/movies/vods");
        WebElement footerPp4Standard = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooterPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver, footerPp4Standard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageFooterPp4Standard" + ".png");
        ImageIO.write(screenshotFooterPp4Standard.getImage(), "png", expectedFile1);
        screenshotFooterPp4Standard.setIgnoredAreas(screenshotFooterPp4.getIgnoredAreas());

//        // Взять старый эталонный скриншот футера:
//        Screenshot screenshotFooterPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "filmsPageFooterPp4Standard" + ".png")));
//        screenshotFooterPp4Standard.setIgnoredAreas(screenshotFooterPp4.getIgnoredAreas());

        // Сравнить скриншоты футера (тестовый и эталонный):
        ImageDiff diff = new ImageDiffer().makeDiff(screenshotFooterPp4Standard, screenshotFooterPp4);
        System.out.println(diff.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffFooter" + ".png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff.getDiffSize() <= 100);
    }

    public void checkImageDifferFilmsPageScroll() throws IOException {
        // Сделать тестовый скриншот скролла страницы "Фильмы:
        driver.get("https://web-preprod4.megafon.tv/movies/vods");
        Screenshot screenshotFilmsPp4 = new AShot().coordsProvider(new WebDriverCoordsProvider())
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
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "scrollPageFilmsPp4" + ".png");
        ImageIO.write(screenshotFilmsPp4.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот скролла страницы "Фильмы:
        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        Screenshot screenshotFilmsPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "scrollFilmsPagePp4Standard" + ".png");
        ImageIO.write(screenshotFilmsPp4Standard.getImage(), "png", expectedFile1);
        screenshotFilmsPp4Standard.setIgnoredAreas(screenshotFilmsPp4.getIgnoredAreas());

//        // Взять старый эталонный скриншот скролла страницы "Фильмы:
//        Screenshot screenshotFilmsPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "scrollFilmsPagePp4Standard" + ".png")));
//        screenshotFilmsPp4Standard.setIgnoredAreas(screenshotFilmsPp4.getIgnoredAreas());

        // Сравнить скриншоты скролла страницы "Фильмы" (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotFilmsPp4Standard, screenshotFilmsPp4);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffFilmsPageScroll" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 500);
    }

    public void checkImageDifferBreadcrumbsAndBlocksFilters() throws IOException {
        // Сделать тестовый скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        driver.get("https://web-preprod4.megafon.tv/movies/vods");
        Screenshot screenshotBreadcrumbsAndBlocksFiltersPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//div[@class='_1f1-eBWSN1rERnEOvc6ScB _1u_yecGhipzBAdhHgvWkg9']")) // игнор область подробок
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/FilmsPage/" + "crumbsAndFiltersPageFilmsPp4" + ".png");
        ImageIO.write(screenshotBreadcrumbsAndBlocksFiltersPp4.getImage(), "png", actualFile1);

        // Сделать новый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
        driver.get("https://web-preprod5.megafon.tv/movies/vods");
        Screenshot screenshotBreadcrumbsAndBlocksFiltersPp4Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/FilmsPage/" + "crumbsAndFilters" + ".png");
        ImageIO.write(screenshotBreadcrumbsAndBlocksFiltersPp4Standard.getImage(), "png", expectedFile1);
        screenshotBreadcrumbsAndBlocksFiltersPp4Standard.setIgnoredAreas(screenshotBreadcrumbsAndBlocksFiltersPp4.getIgnoredAreas());

//        // Взять старый эталонный скриншот области хлебных крошек и блока фильтров страницы "Фильмы:
//        Screenshot screenshotBreadcrumbsAndBlocksFiltersPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/FilmsPage/" + "crumbsAndFiltersFilmsPagePp4Standard" + ".png")));
//        screenshotBreadcrumbsAndBlocksFiltersPp4Standard.setIgnoredAreas(screenshotBreadcrumbsAndBlocksFiltersPp4.getIgnoredAreas());

        // Сравнить скриншоты области хлебных крошек и блока фильтров страницы "Фильмы (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotBreadcrumbsAndBlocksFiltersPp4Standard, screenshotBreadcrumbsAndBlocksFiltersPp4);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/FilmsPage/" + "diffCrumbsAndFiltersFilmsPage" + ".png");
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

        List<WebElement> BannerForFilms = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForFilms.size());
        for (int i = 0; i < BannerForFilms.size(); i++) {
            BannerForFilms = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForFilms.get(i).click();
            isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[3]"));
            isElementDisplayed(By.xpath("(//div[@class='XYh-kiX21fyak70PYmHLU poster'])[3]"));
            System.out.println(driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText());
        }

        List<WebElement> BannerForFilms2 = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForFilms2.size());
        for (int i = 0; i < BannerForFilms2.size(); i++) {
            BannerForFilms2 = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForFilms2.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            Assert.assertEquals(1, driver.findElements(By.xpath("//a[@href='/movies/vods']//span[text()='Фильмы']")).size());
            Thread.sleep(2000);
            driver.navigate().back();
        }

    }

    public void autoScrollBanners() throws Exception {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='leftCarouselButton']"));

        String banner1 = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(banner1);
        Thread.sleep(5000);
        String banner2 = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(banner2);
        Assert.assertNotEquals(banner1, banner2);
        Thread.sleep(5000);
        String banner3 = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(banner3);
        Assert.assertNotEquals(banner2, banner3);
        Thread.sleep(5000);
        String banner4 = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(banner4);
        Assert.assertNotEquals(banner3, banner4);
        Thread.sleep(5000);
        String banner5 = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(banner5);
        Assert.assertNotEquals(banner4, banner5);
    }

    public void scrollBannersToLeft() throws Exception {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        Thread.sleep(2000);
        String bannerFirst = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerFirst);
        click(By.xpath("//button[@data-test='leftCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton'][last()]//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']"));
        Thread.sleep(2000);
        String bannerLast = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerLast);
        Assert.assertNotEquals(bannerFirst, bannerLast);
    }

    public void scrollBannersToRight() throws Exception {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][last()]"));
        String bannerLast = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerLast);
        click(By.xpath("//button[@data-test='rightCarouselButton']"));
        //isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton'][1]//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']"));
        Thread.sleep(2000);
        String bannerFirst = driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText();
        System.out.println(bannerFirst);
        Assert.assertNotEquals(bannerLast, bannerFirst);
    }

    public void scrollСollectionToRightAndLeft() throws Exception {

        // разовый скролл подборки вправо:
        String tail1Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")).getText();
        String tail2Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[2]")).getText();
        String tail3Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[3]")).getText();
        System.out.println(tail1Right);
        System.out.println(tail2Right);
        System.out.println(tail3Right);

        click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext']"));

        String tail4Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]")).getText();
        String tail5Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6Right = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
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
        String tail4Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]")).getText();
        String tail5Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev']"));
        String tail1Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")).getText();
        String tail2Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[2]")).getText();
        String tail3Left = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[3]")).getText();
        Thread.sleep(5000);
        Assert.assertNotEquals(tail1Left, tail4Left);
        Assert.assertNotEquals(tail2Left, tail5Left);
        Assert.assertNotEquals(tail3Left, tail6Left);

        // скоролл подборки вправо до упора:
        while (driver.findElements(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext' and @disabled]")).size() < 1) {
            for (int i = 0; i <= 10; i++) {
                click(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonNext']"));
            }
        }
        // скоролл подборки вдлево до упора:
        while (driver.findElements(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//button[@data-test='ArrowButtonPrev' and @disabled]")).size() < 1) {
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

}




