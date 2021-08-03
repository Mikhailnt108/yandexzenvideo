package pages;

import base.BasePageWebDriver;
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
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class NilPageWebDriver extends BasePageWebDriver {
    private WebElement ToRight;

    public NilPageWebDriver(WebDriver driver) {
        super(driver);
    }

    public void scrollСollectionToRight() throws Exception {
        String tail1 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")).getText();
        String tail2 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[2]")).getText();
        String tail3 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[3]")).getText();
        System.out.println(tail1);
        System.out.println(tail2);
        System.out.println(tail3);

        click(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        String tail4 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]")).getText();
        String tail5 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        Assert.assertNotEquals(tail1, tail4);
        Assert.assertNotEquals(tail2, tail5);
        Assert.assertNotEquals(tail3, tail6);

        while (webDriver.findElements(By.xpath("(//button[@class='_3DGjUma9lmXjaQqwfHiPuG _12wttH1TVBR-AUv1aCErMK _3mirESpL6CG--jdNvoNDsf'])[1]")).size() < 1) {
            click(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        }
    }

    public void clickToTailCardFilm() {
        click(By.xpath("(//div[@data-test='PackageListWrapper']//a[contains(@href, '/vods')])[1]"));
    }

    public void clickToTailCardSerial() {
        //click(By.xpath("(//a[contains(@href,'/shows/')]/following-sibling::a)[1]"));
        click(By.xpath("(//div[@data-test='PackageListWrapper']//a[contains(@href, '/shows/')])[1]"));
    }

    public void scrollСollectionToLeft() throws Exception {
        String tail8 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[8]")).getText();
        String tail9 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[9]")).getText();
        String tail10 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[10]")).getText();

        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("(//button[@data-test='ArrowButtonPrev'])[1]"))).click().build().perform();

        String tail5 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        String tail7 = webDriver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[7]")).getText();
        Assert.assertNotEquals(tail5, tail8);
        Assert.assertNotEquals(tail6, tail9);
        Assert.assertNotEquals(tail7, tail10);

        while (webDriver.findElements(By.xpath("(//button[@class='_2k8t0pWxsThhBF_-hDMEc- _12wttH1TVBR-AUv1aCErMK'])[1]")).size() > 0) {
            click(By.xpath("(//button[@data-test='ArrowButtonPrev'])[1]"));
        }
    }

    public void createScreenShot() throws AWTException, IOException {
        Screenshot screenshot1 = new AShot().takeScreenshot(webDriver);
        File actualFile = new File("src/test/java/testScreenshots/actual/NiL/" + "nil" + ".png");
        ImageIO.write(screenshot1.getImage(), "png", actualFile);
        Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(webDriver);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/NiL/" + "NilAllPage" + ".png");
        ImageIO.write(screenshot2.getImage(), "png", actualFile2);
    }

    public void imageDifferPageHeader() throws AWTException, IOException {
        Screenshot screenshotNilPp1 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilPp1" + ".png");
        ImageIO.write(screenshotNilPp1.getImage(), "png", actualFile1);
        String prod = "https://megafon.tv/";
        webDriver.get(prod);
        click(By.xpath("(//div[@role='dialog']//button)[3]"));
        Screenshot screenshotNilProd = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .takeScreenshot(webDriver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilProd" + ".png");
        ImageIO.write(screenshotNilProd.getImage(), "png", expectedFile1);
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotNilProd, screenshotNilPp1);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diff" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 15);
    }

    public void checkImageDifferNilPageScroll() throws AWTException, IOException {
        // Сделать тестовый скриншот скролла страницы НиЛ:
        webDriver.get("https://web-preprod5.megafon.tv/");
        Screenshot screenshotNil = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>2]")) // игнорировать блоки подборки, кроме первых 2х
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[2]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "scrollPageNil28AllCollect" + ".png");
        ImageIO.write(screenshotNil.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот скролла страницы НиЛ:
//        driver.get("https://web-preprod5.megafon.tv/");
//        Screenshot screenshotNilStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"scrollPageNilStandard28AllCollect"+".png");
//        ImageIO.write(screenshotNilStandard.getImage(), "png", expectedFile1);
//        screenshotNilStandard.setIgnoredAreas(screenshotNil.getIgnoredAreas());

        // Взять старый эталонный скриншот скролла страницы НиЛ:
        Screenshot screenshotNilStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "scrollPageNilStandard28AllCollect" + ".png")));
        screenshotNilStandard.setIgnoredAreas(screenshotNil.getIgnoredAreas());

        // Сравнить скриншоты скролла страницы НиЛ (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotNilStandard, screenshotNil);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffNilPageScroll" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 1200);
    }

    public void checkImageDifferCherdakAndBanners() throws AWTException, IOException {
        // Сделать тестовый скриншот чердака:
        webDriver.get("https://web-preprod5.megafon.tv/");
        WebElement headerCherdak = webDriver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdak = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(webDriver, headerCherdak);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "cherdak" + ".png");
        ImageIO.write(screenshotHeaderCherdak.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот чердака:
//        driver.get("https://web-preprod5.megafon.tv/");
//        WebElement headerCherdakStandard = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
//        Screenshot screenshotHeaderCherdakStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver, headerCherdakStandard);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"cherdakStandard"+".png");
//        ImageIO.write(screenshotHeaderCherdakStandard.getImage(), "png", expectedFile1);

        // Взять старый эталонный скриншот чердака:
        Screenshot screenshotHeaderCherdakStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "cherdakStandard" + ".png")));

        // Сравнить скриншоты чердака (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotHeaderCherdakStandard, screenshotHeaderCherdak);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCherdak" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);


        // Сделать тестовый скриншот баннерной зоны:
        webDriver.get("https://web-preprod5.megafon.tv/");
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][2]"));
        WebElement headerBanner = webDriver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBanner = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнорирование постера и элементов баннера
                .takeScreenshot(webDriver, headerBanner);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/NiL/" + "banner" + ".png");
        ImageIO.write(screenshotHeaderBanner.getImage(), "png", actualFile2);

//        // Сделать новый эталонный скриншот баннерной зоны:
//        driver.get("https://web-preprod5.megafon.tv/");
//        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
//        WebElement headerBannerStandard = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
//        Screenshot screenshotHeaderBannerStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver, headerBannerStandard);
//        File expectedFile2 = new File("src/test/java/testScreenshots/expected/NiL/"+"bannerStandard"+".png");
//        ImageIO.write(screenshotHeaderBannerStandard.getImage(), "png", expectedFile2);
//        screenshotHeaderBannerStandard.setIgnoredAreas(screenshotHeaderBanner.getIgnoredAreas());

        // Взять старый эталонный скриншот баннерной зоны:
        Screenshot screenshotHeaderBannerStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "bannerStandard" + ".png")));
        screenshotHeaderBannerStandard.setIgnoredAreas(screenshotHeaderBanner.getIgnoredAreas());

        // Сравнить скриншоты баннерной зоны (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotHeaderBannerStandard, screenshotHeaderBanner);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffBanner" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);

        // Сделать тестовый скриншот рекламного баннера:
//        WebElement headerMarketing = driver.findElement(By.xpath("//a[@class='_9shdVW_v5Itw7J9UcKl6h']"));
//        Screenshot screenshotHeaderMarketing = new AShot()
//        .coordsProvider(new WebDriverCoordsProvider())
//         .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
//         .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
//         .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
//         .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
//         .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
//         .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
//         .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
//         .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
//         .takeScreenshot(driver, headerMarketing);
//        File actualFile3 = new File("src/test/java/testScreenshots/actual/NiL/"+"marketing"+".png");
//        ImageIO.write(screenshotHeaderMarketing.getImage(), "png", actualFile3);
//
//        // Сделать новый эталонный скриншот рекламного баннера:
//        WebElement headerMarketingProd = driver.findElement(By.xpath("//a[@class='_9shdVW_v5Itw7J9UcKl6h']"));
//        Screenshot screenshotHeaderMarketingProd = new AShot()
//        .coordsProvider(new WebDriverCoordsProvider())
//        .takeScreenshot(driver, headerMarketingProd);
//        File expectedFile3 = new File("src/test/java/testScreenshots/expected/NiL/"+"marketingProd"+".png");
//        ImageIO.write(screenshotHeaderMarketingProd.getImage(), "png", expectedFile3);

//        // Сравнить скриншоты рекламного баннера (тестовый и эталонный):
//        ImageDiff diff3 = new ImageDiffer().makeDiff(screenshotHeaderMarketingProd, screenshotHeaderMarketing);
//        System.out.println(diff3.getDiffSize());
//        File diffFile3 = new File("src/test/java/testScreenshots/markedImages/NiL/"+"diffMarketing"+".png");
//        ImageIO.write(diff3.getMarkedImage(), "png", diffFile3);
//        Assert.assertTrue(diff3.getDiffSize()<=15);
    }

    public void checkImageDifferBlocksCollection() throws AWTException, IOException {
        // Сделать тестовый скриншот блока подборки с заголовком:
        webDriver.get("https://web-preprod5.megafon.tv/");
        Screenshot screenshotCollectionWithTitle = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнорировать блоки подборки, кроме первых 2х
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постера и элементов баннера
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) // целиком название блока и счетчик
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "collectionWithTitle28AllCollect" + ".png");
        ImageIO.write(screenshotCollectionWithTitle.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот блока подборки с заголовком:
//        driver.get("https://web-preprod5.megafon.tv/");
//        Screenshot screenshotCollectionWithTitleStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"collectionWithTitleStandard28AllCollect"+".png");
//        ImageIO.write(screenshotCollectionWithTitleStandard.getImage(), "png", expectedFile1);
//        screenshotCollectionWithTitleStandard.setIgnoredAreas(screenshotCollectionWithTitle.getIgnoredAreas());

        // Взять старый эталонный скриншот блока подборки с заголовком:
        Screenshot screenshotCollectionWithTitleStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "collectionWithTitleStandard28AllCollect" + ".png")));
        screenshotCollectionWithTitleStandard.setIgnoredAreas(screenshotCollectionWithTitle.getIgnoredAreas());

        // Сравнение скриншотов блока подборки с заголовком (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectionWithTitleStandard, screenshotCollectionWithTitle);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCollectionWithTitle" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 3000);

        // Сделать тестовый скриншот блока подборки без заголовка:
        webDriver.get("https://web-preprod5.megafon.tv/");
        Screenshot screenshotCollectionWithoutTitle = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[position()>1]")) // игнор блоки подборки без заголовка, кроме первого найденного
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@data-test='CollectionBlock']")) // игнор постеры первого найденного блока подборки без заголовка
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']")) // игнор блоки подборки с заголовком
                .takeScreenshot(webDriver);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/NiL/" + "collectionWithoutTitle28AllCollect" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitle.getImage(), "png", actualFile2);

//        // Сделать новый эталонный скриншот блока подборки без заголовка:
//        driver.get("https://web-preprod5.megafon.tv/");
//        Screenshot screenshotCollectionWithoutTitleStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver);
//        File expectedFile2 = new File("src/test/java/testScreenshots/expected/NiL/" + "collectionWithoutTitleStandard28AllCollect" + ".png");
//        ImageIO.write(screenshotCollectionWithoutTitleStandard.getImage(), "png", expectedFile2);
//        screenshotCollectionWithoutTitleStandard.setIgnoredAreas(screenshotCollectionWithoutTitle.getIgnoredAreas());

        // Взять старый эталонный скриншот блока подборки без заголовка:
        Screenshot screenshotCollectionWithoutTitleStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "collectionWithoutTitleStandard28AllCollect" + ".png")));
        screenshotCollectionWithoutTitleStandard.setIgnoredAreas(screenshotCollectionWithoutTitle.getIgnoredAreas());

        // Сравнение скриншотов блока подборки без заголовка (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotCollectionWithoutTitleStandard, screenshotCollectionWithoutTitle);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCollectionWithoutTitle" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 1200);
    }

    public void checkImageDifferFooter() throws AWTException, IOException {
        // Сделать тестовый скриншот футера:
        webDriver.get("https://web-preprod5.megafon.tv/");
        WebElement footer = webDriver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooter = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver, footer);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "footer" + ".png");
        ImageIO.write(screenshotFooter.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот футера:
//        driver.get("https://web-preprod5.megafon.tv/");
//        WebElement footerStandard = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
//        Screenshot screenshotFooterStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver, footerStandard);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"footerStandard"+".png");
//        ImageIO.write(screenshotFooterStandard.getImage(), "png", expectedFile1);
//        screenshotFooterStandard.setIgnoredAreas(screenshotFooter.getIgnoredAreas());

        // Взять старый эталонный скриншот футера:
        Screenshot screenshotFooterStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "footerStandard" + ".png")));
        screenshotFooterStandard.setIgnoredAreas(screenshotFooter.getIgnoredAreas());

        // Сравнить скриншоты футера (тестовый и эталонный):
        ImageDiff diff = new ImageDiffer().makeDiff(screenshotFooterStandard, screenshotFooter);
        System.out.println(diff.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffFooter" + ".png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff.getDiffSize() <= 100);
    }

    public void checkAutoScrollBanners() throws Exception {
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

    public void checkScrollBannersToLeft() throws Exception {
        java.util.List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
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

    public void checkScrollBannersToRight() throws Exception {
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

    public void checkElementsBlockCollectionWithHeader() {
        isElementDisplayed(By.xpath("(//div[@data-test='PackageListWrapper'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a)[1]"));
        isElementDisplayed(By.partialLinkText("Все"));
        isElementDisplayed(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]"));
        isElementDisplayed(By.xpath("(//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span)[1]"));
        isElementDisplayed(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        isElementDisplayed(By.xpath("(//button[@data-test='ArrowButtonPrev' and @disabled])[1]"));
    }
    public void checkElementsBlockCollectionWithoutHeader() {
        isElementDisplayed(By.xpath("(//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]"));
        isElementDisplayed(By.xpath("//div[@class='_32EmGwc0ERBa-YAD-9i89Q']//div[@data-test='CollectionBlock']"));
        isElementDisplayed(By.xpath("//div[@class='_32EmGwc0ERBa-YAD-9i89Q']//h3[@data-test='CollectionName']"));
        isElementDisplayed(By.xpath("//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//button[@data-test='ArrowButtonNext']"));
        isElementDisplayed(By.xpath("//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//button[@data-test='ArrowButtonPrev' and @disabled]"));
    }

    public void clickToTailCardTvProgram() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/tv/channels/')][1]"));
    }

    public void clickToTailCardPackage() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/mixed_groups/')][1]"));
    }

    public void clickToLinkAllOnCollectionBlock() {
        click(By.partialLinkText("Все"));
    }

    public void clickToLinkAllWithCollectionFilms() {
        click(By.xpath("(//a[contains(@href, '/vods')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void clickToLinkAllWithCollectionSerial() {
        click(By.xpath("(//a[contains(@href, '/shows/')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void clickToLinkAllWithCollectionTvProgram() {
        click(By.xpath("(//a[contains(@href, '/tv/channels/')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void clickToLinkAllWithCollectionPackage() {
        click(By.xpath("(//a[contains(@href, '/mixed_groups/')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void checkElementsBanner() throws InterruptedException {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3pSmMGlz2N-PDRuE_jtIuS'])[2]"));
        isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[2]"));
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        WebElement element = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]"));
//        js.executeScript("arguments[0].innerText='Меняем заголовок'",element);

        isElementDisplayed(By.xpath("(//div[@data-test='SlideDescription'])[2]"));
        isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='leftCarouselButton']"));
    }

    public void switchingFromBannerToCardFilm() throws InterruptedException {
        List<WebElement> BannerForNiL = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForNiL.size());
        for (int i = 0; i < BannerForNiL.size(); i++) {
            BannerForNiL = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForNiL.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            if (webDriver.findElements(By.xpath("//span[text()='Фильмы']")).size() > 0) {
                break;
            } else {
                webDriver.navigate().back();
            }
        }
    }

    public void switchingFromBannerToCardSerial() throws InterruptedException {
        List<WebElement> BannerForNiL = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForNiL.size());
        for (int i = 0; i < BannerForNiL.size(); i++) {
            BannerForNiL = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForNiL.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            if (webDriver.findElements(By.xpath("//span[text()='Сериалы']")).size() > 0) {
                break;
            } else {
                webDriver.navigate().back();
            }
        }
    }

    public void checkElementsBlockCollectionSpecialForYou() {
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']"));
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m']"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_2I_pgomfMGx8HVFvHlZhKj']"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText']"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonPrev' and @disabled])[1]"));
    }

    public void clickToTailContentCollectionSpecialForYou() {
        click(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1byOct53kb4KlmAs0JuRSX']"));
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]|//a[@href='/shows']//span[1]"));
    }

    public void clickToLinkAllWithCollectionSpecialForYou() {
        click(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText']"));
    }

    public void scrollСollectionToRightInBlockCollectionSpecialForYou() {
        while (webDriver.findElements(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext' and @disabled]")).size() < 1) {
//            click(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
            for (int i = 0; i <= 5; i++) {
                click(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
            }
        }
    }

    public void checkImageDifferBlockCollectionSpecialForYou() throws IOException {
        webDriver.get("https://web-preprod5.megafon.tv/");
//        WebElement blockCollectSpecialForYou = driver.findElement(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']"));
        Screenshot screenshotCollectSpecialForYou = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']")) // игнор постер и элементы баннера
                .addIgnoredElement(By.xpath("//h3//a[not(text()='Подобрали специально для вас')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .addIgnoredElement(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ']"))
                .addIgnoredElement(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']//following::div[@class='HZzNvtNX5fExVnjY_Popf']"))
                .addIgnoredElement(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']/following::a[@data-test='PackageListWrapperMoreText'])[1]"))
                .addIgnoredElement(By.xpath("//div[@class='_32EmGwc0ERBa-YAD-9i89Q']/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']")) // игнор все подборки без заголовка
                .takeScreenshot(webDriver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilCollectSpecialForYou28AllCollect" + ".png");
        ImageIO.write(screenshotCollectSpecialForYou.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот блока подборки "Подобрали специально для вас":
//        driver.get("https://web-preprod5.megafon.tv/");
////        WebElement blockCollectSpecialForYouStandard = driver.findElement(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']"));
//        Screenshot screenshotCollectSpecialForYouStandard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectSpecialForYouStandard28AllCollect" + ".png");
//        ImageIO.write(screenshotCollectSpecialForYouStandard.getImage(), "png", expectedFile1);
//        screenshotCollectSpecialForYouStandard.setIgnoredAreas(screenshotCollectSpecialForYou.getIgnoredAreas());

        // Взять старый эталон скриншота:
        Screenshot screenshotCollectSpecialForYouStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectSpecialForYouStandard28AllCollect" + ".png")));
        screenshotCollectSpecialForYouStandard.setIgnoredAreas(screenshotCollectSpecialForYou.getIgnoredAreas());

        // Сравнение скриншотов подборки "Подобрали специально для вас" (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectSpecialForYouStandard, screenshotCollectSpecialForYou);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCollectSpecialForYou" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);
    }

    public void checkElementsBlockCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']"));
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_2I_pgomfMGx8HVFvHlZhKj']"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[contains(@class,'_3RTKiE8VDgo764HGa4WvpJ _3uK4RWVSuUFLQ2ZmeFzsQi')]"));
//        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
//        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonPrev' and @disabled]"));
    }

    public void checkAndClickOnTailCardFilmInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/vods')]//div[@class='_7LRTnrwDy15pRyA2wKc1m']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/vods')]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/vods')]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/vods')]//div[@class='_2I_pgomfMGx8HVFvHlZhKj']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/vods')]"));
        click(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/vods')]"));
    }

    public void checkAndClickOnTailCardSerialInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/shows/')]//div[@class='_7LRTnrwDy15pRyA2wKc1m']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/shows/')]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/shows/')]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/shows/')]//div[@class='_2I_pgomfMGx8HVFvHlZhKj']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/shows/')]"));
        click(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/shows/')]"));

    }

    public void checkAndClickOnTailCardTvProgramInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/tv/channels/')]//div[@class='_7LRTnrwDy15pRyA2wKc1m']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/tv/channels/')]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/tv/channels/')]//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[contains(@href, '/tv/channels/')]"));
        String nameTVProgram = webDriver.findElement(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3")).getText();
        click(By.xpath("//a[text()='Продолжить просмотр']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3"));
        Assert.assertEquals(nameTVProgram, webDriver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
    }

    public void checkProgressBarInTailsCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::div[@class='_7LRTnrwDy15pRyA2wKc1m']/following-sibling::div[@class='_7FaeeXBmoJY-W9FbvAtmF']/div)[1]"));
    }

    public void scrollСollectionToRightInCollectHistoryWatch() {
        while (webDriver.findElements(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext' and @disabled]")).size() < 1) {
            click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        }
    }

    public void checkAndClickOnTailWatchAndEdit() {
//        click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Смотреть и редактировать")));
        isElementDisplayed(By.partialLinkText("Смотреть и редактировать"));
        click(By.partialLinkText("Смотреть и редактировать"));
    }

    public void checkToMoveTileToFirstPlace() {
        String nameFilm = webDriver.findElement(By.xpath("//h1[text()]")).getText();
        webDriver.get("https://web-preprod5.megafon.tv/");
        Assert.assertEquals("элементы не совпадают",nameFilm, webDriver.findElement(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::h3[@data-test='PackageDescriptionTitle'])[1]")).getText());
    }

    public void checkAbsentTvProgram18PlusInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/tv/channels/')])[1]"));
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/tv/channels/')])[1]"));
        Assert.assertEquals("отображается элемент", 0, webDriver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']|//div[contains(text(),'Эротика')]")).size());
    }

    public void checkAbsentFilm18PlusInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/vods')])[1]"));
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/vods')])[1]"));
        Assert.assertEquals("отображается элемент", 0, webDriver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']|//div[contains(text(),'Эротика')]")).size());
    }

    public void checkAbsentSerial18PlusInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/shows/')])[1]"));
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/shows/')])[1]"));
        Assert.assertEquals("отображается элемент", 0, webDriver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']|//div[contains(text(),'Эротика')]")).size());
    }

    public void clickToAllOnBlockCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
        click(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void clickToTailWatchAndEdit() {
        click(By.partialLinkText("Смотреть и редактировать"));
    }

    public void checkAbsentBlockCollectHistoryWatch() {
        Assert.assertEquals("отображается элемент", 0, webDriver.findElements(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']")).size());
    }

    public void checkImageDifferBlockCollectHistoryWatch() throws IOException {
        webDriver.get("https://web-preprod5.megafon.tv/");
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

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilCollectHistoryWatch" + ".png");
        ImageIO.write(screenshotCollectHistoryWatch.getImage(), "png", actualFile1);

        // Сделать новый эталон скриншота:
        webDriver.get("https://web-preprod5.megafon.tv/");
        WebElement blockCollectHistoryWatchStandard = webDriver.findElement(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']"));
        Screenshot screenshotCollectHistoryWatchStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .ignoredElements(posterTailsCollection)
                .ignoredElements(nameTailsCollection)
                .takeScreenshot(webDriver, blockCollectHistoryWatchStandard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectHistoryWatchStandard" + ".png");
        ImageIO.write(screenshotCollectHistoryWatchStandard.getImage(), "png", expectedFile1);
        screenshotCollectHistoryWatchStandard.setIgnoredAreas(screenshotCollectHistoryWatch.getIgnoredAreas());

//        // Взять старый эталон скриншота:
//        Screenshot screenshotCollectHistoryWatchStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectHistoryWatchStandard" + ".png")));
//        screenshotCollectHistoryWatchStandard.setIgnoredAreas(screenshotCollectHistoryWatch.getIgnoredAreas());

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectHistoryWatchStandard, screenshotCollectHistoryWatch);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCollectHistoryWatch" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);
    }

    public void checkImageDifferTailWatchAndEditInCollectHistoryWatch() throws IOException, InterruptedException {
        webDriver.get("https://web-preprod5.megafon.tv/");
//        click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']")));
//        Thread.sleep(6000);
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']"));
        WebElement tailWatchAndEdit = webDriver.findElement(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']"));
        Screenshot screenshotTailWatchAndEdit = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver, tailWatchAndEdit);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilTailWatchAndEdit" + ".png");
        ImageIO.write(screenshotTailWatchAndEdit.getImage(), "png", actualFile1);

        //Сделать новый эталон скриншота:
        webDriver.get("https://web-preprod5.megafon.tv/");
//        click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']")));
//        Thread.sleep(3000);
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']"));
        WebElement tailWatchAndEditStandard = webDriver.findElement(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']"));
        Screenshot screenshotTailWatchAndEditStandard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver, tailWatchAndEditStandard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilTailWatchAndEditStandard" + ".png");
        ImageIO.write(screenshotTailWatchAndEditStandard.getImage(), "png", expectedFile1);

//        // Взять старый эталон скриншота:
//        Screenshot screenshotTailWatchAndEditStandard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectHistoryWatchStandard" + ".png")));

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotTailWatchAndEditStandard, screenshotTailWatchAndEdit);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffTailWatchAndEdit" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);
    }

    public void checkLastTailInCollectionSpecialForYou() {
        isElementDisplayed(By.xpath("//div[text()='Повысить точность персональных рекомендаций']"));
    }

    public void clickToLastTailInCollectionSpecialForYou() {
        click(By.xpath("//div[text()='Повысить точность персональных рекомендаций']"));
    }
}
