package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class NilPage extends BasePage {
    private WebElement ToRight;

    public NilPage(WebDriver driver) {
        super(driver);
    }

    public void scrollСollectionToRight() throws Exception {
        String tail1 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]")).getText();
        String tail2 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[2]")).getText();
        String tail3 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[3]")).getText();
        System.out.println(tail1);
        System.out.println(tail2);
        System.out.println(tail3);

        click(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        String tail4 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]")).getText();
        String tail5 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        Assert.assertNotEquals(tail1, tail4);
        Assert.assertNotEquals(tail2, tail5);
        Assert.assertNotEquals(tail3, tail6);

        while (driver.findElements(By.xpath("(//button[@class='_3DGjUma9lmXjaQqwfHiPuG _12wttH1TVBR-AUv1aCErMK _3mirESpL6CG--jdNvoNDsf'])[1]")).size() < 1) {
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
        String tail8 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[8]")).getText();
        String tail9 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[9]")).getText();
        String tail10 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[10]")).getText();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//button[@data-test='ArrowButtonPrev'])[1]"))).click().build().perform();

        String tail5 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]")).getText();
        String tail6 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]")).getText();
        String tail7 = driver.findElement(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[7]")).getText();
        Assert.assertNotEquals(tail5, tail8);
        Assert.assertNotEquals(tail6, tail9);
        Assert.assertNotEquals(tail7, tail10);

        while (driver.findElements(By.xpath("(//button[@class='_2k8t0pWxsThhBF_-hDMEc- _12wttH1TVBR-AUv1aCErMK'])[1]")).size() > 0) {
            click(By.xpath("(//button[@data-test='ArrowButtonPrev'])[1]"));
        }
    }

    public void createScreenShot() throws AWTException, IOException {
        Screenshot screenshot1 = new AShot().takeScreenshot(driver);
        File actualFile = new File("src/test/java/testScreenshots/actual/NiL/" + "nil" + ".png");
        ImageIO.write(screenshot1.getImage(), "png", actualFile);
        Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
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
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilPp1" + ".png");
        ImageIO.write(screenshotNilPp1.getImage(), "png", actualFile1);
        String prod = "https://megafon.tv/";
        driver.get(prod);
        click(By.xpath("(//div[@role='dialog']//button)[3]"));
        Screenshot screenshotNilProd = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilProd" + ".png");
        ImageIO.write(screenshotNilProd.getImage(), "png", expectedFile1);
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotNilProd, screenshotNilPp1);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diff" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 15);
    }

    public void checkImageDifferNilPageAll() throws AWTException, IOException {
        driver.get("https://web-preprod4.megafon.tv/");
//        driver.navigate().refresh();
//        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        Set<By> posterTailsCollection = new HashSet<>();
        posterTailsCollection.add(By.xpath("//div[@class='HZzNvtNX5fExVnjY_Popf']"));
        Set<By> nameTailsCollection = new HashSet<>();
        nameTailsCollection.add(By.xpath("//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']"));
        Set<By> headerBlockCollection = new HashSet<>();
        headerBlockCollection.add(By.xpath("//h3[@data-test='PackageListWrapperName']//a"));

        Screenshot screenshotNilPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .ignoredElements(posterTailsCollection)
                .ignoredElements(nameTailsCollection)
                .ignoredElements(headerBlockCollection)
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "allPageNilPp5" + ".png");
        ImageIO.write(screenshotNilPp5.getImage(), "png", actualFile1);

//        //Сделать новый эталонный скриншот:
//        driver.get("https://web-preprod5.megafon.tv/");
//
//        Screenshot screenshotNilPp5Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .ignoredElements(posterTailsCollection)
//                .ignoredElements(nameTailsCollection)
//                .ignoredElements(headerBlockCollection)
//                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
//                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
//                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
//                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
//                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"allNilPagePp5Standard"+".png");
//        ImageIO.write(screenshotNilPp5Standard.getImage(), "png", expectedFile1);

        // Взять старый эталон скриншота:
        Screenshot screenshotNilPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "allNilPagePp5Standard" + ".png")));

        //Сравнение скриншотов:
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotNilPp5Standard, screenshotNilPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffNilPageAll" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 15);
    }

    public void checkImageDifferHeader() throws AWTException, IOException {
        WebElement headerCherdakPp5 = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, headerCherdakPp5);

        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        WebElement headerBannerPp5 = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, headerBannerPp5);

        //WebElement headerMarketingPp1 = driver.findElement(By.xpath("//a[@class='_9shdVW_v5Itw7J9UcKl6h']"));
        //Screenshot screenshotHeaderMarketingPp1 = new AShot()
        //.coordsProvider(new WebDriverCoordsProvider())
        // .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
        // .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
        // .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
        // .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
        // .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
        // .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
        // .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
        // .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
        // .takeScreenshot(driver, headerMarketingPp1);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilCherdakPp5" + ".png");
        ImageIO.write(screenshotHeaderCherdakPp5.getImage(), "png", actualFile1);

        File actualFile2 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilBannerPp5" + ".png");
        ImageIO.write(screenshotHeaderBannerPp5.getImage(), "png", actualFile2);

        //File actualFile3 = new File("src/test/java/testScreenshots/actual/NiL/"+"nilMarketingPp1"+".png");
        //ImageIO.write(screenshotHeaderMarketingPp1.getImage(), "png", actualFile3);

//          //Сделать новый эталонный скриншот:
//        driver.get("https://web-preprod5.megafon.tv/");
////
////        WebElement headerCherdakPp5Standard = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
////        Screenshot screenshotHeaderCherdakPp5Standard = new AShot()
////                .coordsProvider(new WebDriverCoordsProvider())
////                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
////                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
////                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
////                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
////                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
////                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
////                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
////                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
////                .takeScreenshot(driver, headerCherdakPp5Standard);
////
//        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
//        WebElement headerBannerPp5Standard = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
//        Screenshot screenshotHeaderBannerPp5Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
//                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
//                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
//                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
//                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
//                .takeScreenshot(driver, headerBannerPp5Standard);

        //WebElement headerMarketingProd = driver.findElement(By.xpath("//a[@class='_9shdVW_v5Itw7J9UcKl6h']"));
        //Screenshot screenshotHeaderMarketingProd = new AShot()
        //      .coordsProvider(new WebDriverCoordsProvider())
        //    .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
        //  .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
        //.addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
        //.addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
        //.addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
        //.addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
        //.addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
        //.addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
        //.takeScreenshot(driver, headerMarketingProd);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilCherdakPp5Standard"+".png");
//        ImageIO.write(screenshotHeaderCherdakPp5Standard.getImage(), "png", expectedFile1);
//        File expectedFile2 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilBannerPp5Standard"+".png");
//        ImageIO.write(screenshotHeaderBannerPp5Standard.getImage(), "png", expectedFile2);


        // Взять старый эталон скриншота:
        Screenshot screenshotHeaderCherdakPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilCherdakPp5Standard" + ".png")));
        // Взять старый эталон скриншота:
        Screenshot screenshotHeaderBannerPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilBannerPp5Standard" + ".png")));

        //File expectedFile3 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilMarketingProd"+".png");
        //ImageIO.write(screenshotHeaderMarketingProd.getImage(), "png", expectedFile3);

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotHeaderCherdakPp5Standard, screenshotHeaderCherdakPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCherdak" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);

        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotHeaderBannerPp5Standard, screenshotHeaderBannerPp5);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffBanner" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 100);

        //ImageDiff diff3 = new ImageDiffer().makeDiff(screenshotHeaderMarketingProd, screenshotHeaderMarketingPp1);
        //System.out.println(diff3.getDiffSize());
        //File diffFile3 = new File("src/test/java/testScreenshots/markedImages/NiL/"+"diffMarketing"+".png");
        //ImageIO.write(diff3.getMarkedImage(), "png", diffFile3);
        //Assert.assertTrue(diff3.getDiffSize()<=15);
    }

    public void checkImageDifferBlockCollection() throws AWTException, IOException {
        driver.get("https://web-preprod4.megafon.tv/");
        WebElement blockCollectionWithTitlePp5 = driver.findElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]"));
        Screenshot screenshotCollectionWithTitlePp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .takeScreenshot(driver, blockCollectionWithTitlePp5);


        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilCollectionWithTitlePp5" + ".png");
        ImageIO.write(screenshotCollectionWithTitlePp5.getImage(), "png", actualFile1);

        WebElement collectionWithoutTitlePp5 = driver.findElement(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']"));
        Screenshot screenshotCollectionWithoutTitlePp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .takeScreenshot(driver, collectionWithoutTitlePp5);

        File actualFile2 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilCollectionWithoutTitlePp5" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitlePp5.getImage(), "png", actualFile2);

        // Сделать новый эталон скриншота:
//        driver.get("https://web-preprod5.megafon.tv/");
//        WebElement blockCollectionWithTitlePp5Standard = driver.findElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]"));
//        Screenshot screenshotCollectionWithTitlePp5Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
//                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
//                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
//                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
//                .takeScreenshot(driver, blockCollectionWithTitlePp5Standard);
//
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilCollectionWithTitlePp5Standard"+".png");
//        ImageIO.write(screenshotCollectionWithTitlePp5Standard.getImage(), "png", expectedFile1);

        // Взять старый эталон скриншота:
        Screenshot screenshotCollectionWithTitlePp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectionWithTitleStandard" + ".png")));


        WebElement collectionWithoutTitlePp5Standard = driver.findElement(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']"));
        Screenshot screenshotCollectionWithoutTitlePp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .takeScreenshot(driver, collectionWithoutTitlePp5Standard);

        File expectedFile2 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectionWithoutTitlePp5Standard" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitlePp5Standard.getImage(), "png", expectedFile2);


        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectionWithTitlePp5Standard, screenshotCollectionWithTitlePp5);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCollectionWithTitle" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);

        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotCollectionWithoutTitlePp5Standard, screenshotCollectionWithoutTitlePp5);
        System.out.println(diff1.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCollectionWithoutTitle" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 100);
    }


    public void checkImageDifferFooter() throws AWTException, IOException {
        WebElement footerPp5 = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooterPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, footerPp5);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilFooterPp5" + ".png");
        ImageIO.write(screenshotFooterPp5.getImage(), "png", actualFile1);

        //Сделать новый эталонный скринншот:
//        driver.get("https://web-preprod5.megafon.tv/");
//        WebElement footerPp5Standard = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
//        Screenshot screenshotFooterPp5Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
//                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
//                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
//                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
//                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
//                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
//                .takeScreenshot(driver, footerPp5Standard);
//
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilFooterPp5Standard"+".png");
//        ImageIO.write(screenshotFooterPp5Standard.getImage(), "png", expectedFile1);

        // Взять старый эталон скриншота:
        Screenshot screenshotFooterPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilFooterPp5Standard" + ".png")));

        ImageDiff diff = new ImageDiffer().makeDiff(screenshotFooterPp5Standard, screenshotFooterPp5);
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

    public void checkScrollBannersToLeft() throws Exception {
        java.util.List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
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

    public void checkScrollBannersToRight() throws Exception {
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


    public void checkElementsCollection() {
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a)[1]"));
        isElementDisplayed(By.partialLinkText("Все"));
        isElementDisplayed(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]"));
        isElementDisplayed(By.xpath("(//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span)[1]"));
        isElementDisplayed(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        isElementDisplayed(By.xpath("(//button[@data-test='ArrowButtonPrev' and @disabled])[1]"));
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
        click(By.xpath("(//a[@data-test='PackageListWrapperMoreText']/following::a[contains(@href, '/vods')])[1]"));
    }

    public void clickToLinkAllWithCollectionSerial() {
        click(By.xpath("(//a[@data-test='PackageListWrapperMoreText']/following::a[contains(@href, '/shows/')])[1]"));
    }

    public void clickToLinkAllWithCollectionTvProgram() {
        click(By.xpath("(//a[@data-test='PackageListWrapperMoreText']/following::a[contains(@href, '/tv/channels/')])[1]"));
    }

    public void clickToLinkAllWithCollectionPackage() {
        click(By.xpath("(//a[@data-test='PackageListWrapperMoreText']/following::a[contains(@href, '/mixed_groups/')])[1]"));
    }

    public void checkElementsBanner() {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3pSmMGlz2N-PDRuE_jtIuS'])[2]"));
        isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[2]"));
        isElementDisplayed(By.xpath("(//div[@data-test='SlideDescription'])[2]"));
        isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='leftCarouselButton']"));
    }

    public void switchingFromBannerToCardFilm() {
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        List<WebElement> BannerForNil = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForNil.size());
        for (int i = 0; i < BannerForNil.size(); i++) {
            BannerForNil = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForNil.get(i).click();
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/movies/vods/')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Фильмы']"));
                break;
            } else {
                BannerForNil.get(i).click();
            }
        }
    }

    public void switchingFromBannerToCardSerial() {
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        List<WebElement> BannerForNil = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForNil.size());
        for (int i = 0; i < BannerForNil.size(); i++) {
            BannerForNil = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForNil.get(i).click();
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/shows/')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Сериалы']"));
                break;
            } else {
                BannerForNil.get(i).click();
            }
        }
    }

    public void checkElementsBlockCollectionSpecialForYou() {
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a)[1]"));
        isElementDisplayed(By.linkText("Подобрали специально для вас"));
        isElementDisplayed(By.partialLinkText("Все"));
        isElementDisplayed(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]"));
        isElementDisplayed(By.xpath("(//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span)[1]"));
        isElementDisplayed(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        isElementDisplayed(By.xpath("(//button[@data-test='ArrowButtonPrev' and @disabled])[1]"));
    }

    public void clickToTailContentCollectionSpecialForYou() {
        click(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']//following::div[@class='_1byOct53kb4KlmAs0JuRSX']"));
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]|//a[@href='/shows']//span[1]"));
    }

    public void clickToLinkAllWithCollectionSpecialForYou() {
        click(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void scrollСollectionToRightInBlockCollectionSpecialForYou() {
        while (driver.findElements(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext' and @disabled]")).size() < 1) {
//            click(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
            for (int i = 0; i <= 5; i++) {
                click(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
            }
        }
    }

    public void checkImageDifferBlockCollectionSpecialForYou() throws IOException {
        driver.get("https://web-preprod4.megafon.tv/");
        WebElement blockCollectSpecialForYouPp5 = driver.findElement(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']"));
        Set<By> posterTailsCollection = new HashSet<>();
        posterTailsCollection.add(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']//following::div[@class='_7LRTnrwDy15pRyA2wKc1m']"));
        Set<By> nameTailsCollection = new HashSet<>();
        nameTailsCollection.add(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ']"));
        Set<By> counterTailsCollection = new HashSet<>();
        counterTailsCollection.add(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
        Screenshot screenshotCollectSpecialForYouPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .ignoredElements(posterTailsCollection)
                .ignoredElements(nameTailsCollection)
                .ignoredElements(counterTailsCollection)
                .takeScreenshot(driver, blockCollectSpecialForYouPp5);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilCollectSpecialForYouPp5" + ".png");
        ImageIO.write(screenshotCollectSpecialForYouPp5.getImage(), "png", actualFile1);

        //Сделать новый эталон скриншота:
        driver.get("https://web-preprod4.megafon.tv/");
        WebElement blockCollectSpecialForYouPp5Standard = driver.findElement(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']"));
        Screenshot screenshotCollectSpecialForYouPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .ignoredElements(posterTailsCollection)
                .ignoredElements(nameTailsCollection)
                .takeScreenshot(driver, blockCollectSpecialForYouPp5Standard);

        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectSpecialForYouPp5Standard" + ".png");
        ImageIO.write(screenshotCollectSpecialForYouPp5Standard.getImage(), "png", expectedFile1);

//        // Взять старый эталон скриншота:
//        Screenshot screenshotCollectSpecialForYouPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectionWithTitleStandard" + ".png")));

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectSpecialForYouPp5Standard, screenshotCollectSpecialForYouPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCollectSpecialForYouPp5" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);

    }

    public void checkElementsBlockCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ'])[1]"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonPrev' and @disabled]"));
    }

    public void checkAndClickOnTailCardFilmInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_2I_pgomfMGx8HVFvHlZhKj'])[1]"));
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/vods')])[1]"));
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/vods')])[1]"));


    }

    public void checkAndClickOnTailCardSerialInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_2I_pgomfMGx8HVFvHlZhKj'])[1]"));
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/shows/')])[1]"));
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/shows/')])[1]"));

    }

    public void checkAndClickOnTailCardTvProgramInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ'])[1]"));
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/tv/channels/')])[1]"));
        String nameTVProgram = driver.findElement(By.xpath("(//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3)[1]")).getText();
        click(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::h3[@data-test='PackageDescriptionTitle'])[1]"));
        Assert.assertEquals(nameTVProgram,driver.findElement(By.className("_1v_D6wOANknQeJMBPo_rKK")).getText());
    }

    public void checkProgressBarInTailsCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::div[@class='_7LRTnrwDy15pRyA2wKc1m']/following-sibling::div[@class='_7FaeeXBmoJY-W9FbvAtmF']/div)[1]"));
    }

    public void scrollСollectionToRightInCollectHistoryWatch() {
        while (driver.findElements(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext' and @disabled]")).size() < 1) {
            click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        }
    }

    public void checkAndClickOnTailWatchAndEdit() {
        click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Смотреть и редактировать")));
        isElementDisplayed(By.partialLinkText("Смотреть и редактировать"));
        click(By.partialLinkText("Смотреть и редактировать"));
    }

    public void checkToMoveTileToFirstPlace() {
        String nameFilm = driver.findElement(By.xpath("//h1[text()]")).getText();
        driver.navigate().back();
        Assert.assertEquals("элементы не совпадают",nameFilm, driver.findElement(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::h3[@data-test='PackageDescriptionTitle'])[1]")).getText());

    }

    public void checkAbsentTvProgram18PlusInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/tv/channels/')])[1]"));
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/tv/channels/')])[1]"));
        Assert.assertEquals("отображается элемент", 0, driver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']|//div[contains(text(),'Эротика')]")).size());
    }

    public void checkAbsentFilm18PlusInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/vods')])[1]"));
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/vods')])[1]"));
        Assert.assertEquals("отображается элемент", 0, driver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']|//div[contains(text(),'Эротика')]")).size());
    }

    public void checkAbsentSerial18PlusInCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/shows/')])[1]"));
        click(By.xpath("(//a[text()='Продолжить просмотр']//following::a[contains(@href, '/shows/')])[1]"));
        Assert.assertEquals("отображается элемент", 0, driver.findElements(By.xpath("//h3[text()='Вам уже исполнилось 18 лет?']|//div[contains(text(),'Эротика')]")).size());
    }

    public void clickToAllOnBlockCollectHistoryWatch() {
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
        click(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void clickToTailWatchAndEdit() {
        click(By.partialLinkText("Смотреть и редактировать"));
    }

    public void checkAbsentBlockCollectHistoryWatch() {
        Assert.assertEquals("отображается элемент", 0, driver.findElements(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']")).size());
    }

    public void checkImageDifferBlockCollectHistoryWatch() throws IOException {
        driver.get("https://web-preprod4.megafon.tv/");
        WebElement blockCollectHistoryWatchPp5 = driver.findElement(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']"));
        Set<By> posterTailsCollection = new HashSet<>();
        posterTailsCollection.add(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='HZzNvtNX5fExVnjY_Popf']"));
        Set<By> nameTailsCollection = new HashSet<>();
        nameTailsCollection.add(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']//following::div[@class='_1IVk0Zab-UdqbOslYR6SnJ']"));
        Set<By> counterTailsCollection = new HashSet<>();
        counterTailsCollection.add(By.xpath("(//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']/following::a[@data-test='PackageListWrapperMoreText'])[1]"));
        Screenshot screenshotCollectHistoryWatchPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .ignoredElements(posterTailsCollection)
                .ignoredElements(nameTailsCollection)
                .ignoredElements(counterTailsCollection)
                .takeScreenshot(driver, blockCollectHistoryWatchPp5);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilCollectHistoryWatchPp5" + ".png");
        ImageIO.write(screenshotCollectHistoryWatchPp5.getImage(), "png", actualFile1);

        //Сделать новый эталон скриншота:
        driver.get("https://web-preprod4.megafon.tv/");
        WebElement blockCollectHistoryWatchPp5Standard = driver.findElement(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']"));
        Screenshot screenshotCollectHistoryWatchPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .ignoredElements(posterTailsCollection)
                .ignoredElements(nameTailsCollection)
                .takeScreenshot(driver, blockCollectHistoryWatchPp5Standard);

        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectHistoryWatchPp5Standard" + ".png");
        ImageIO.write(screenshotCollectHistoryWatchPp5Standard.getImage(), "png", expectedFile1);
        screenshotCollectHistoryWatchPp5Standard.setIgnoredAreas(screenshotCollectHistoryWatchPp5.getIgnoredAreas());

//        // Взять старый эталон скриншота:
//        Screenshot screenshotCollectHistoryWatchPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectHistoryWatchPp5Standard" + ".png")));
//        screenshotCollectHistoryWatchPp5Standard.setIgnoredAreas(screenshotCollectHistoryWatchPp5.getIgnoredAreas());

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectHistoryWatchPp5Standard, screenshotCollectHistoryWatchPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffCollectHistoryWatchPp5" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);
    }

    public void checkImageDifferTailWatchAndEditInCollectHistoryWatch() throws IOException, InterruptedException {
        driver.get("https://web-preprod4.megafon.tv/");
//        click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']")));
//        Thread.sleep(6000);
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']"));
        WebElement tailWatchAndEditPp5 = driver.findElement(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']"));
        Screenshot screenshotTailWatchAndEditPp5 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver, tailWatchAndEditPp5);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/" + "nilTailWatchAndEditPp5" + ".png");
        ImageIO.write(screenshotTailWatchAndEditPp5.getImage(), "png", actualFile1);

        //Сделать новый эталон скриншота:
        driver.get("https://web-preprod4.megafon.tv/");
//        click(By.xpath("//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']")));
//        Thread.sleep(3000);
        isElementDisplayed(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']"));
        WebElement tailWatchAndEditPp5Standard = driver.findElement(By.xpath("//a[text()='Продолжить просмотр']/following::a[@class='ArHiwAcYUlO8lYdGJYyYT']"));
        Screenshot screenshotTailWatchAndEditPp5Standard = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver, tailWatchAndEditPp5Standard);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/" + "nilTailWatchAndEditPp5Standard" + ".png");
        ImageIO.write(screenshotTailWatchAndEditPp5Standard.getImage(), "png", expectedFile1);

//        // Взять старый эталон скриншота:
//        Screenshot screenshotTailWatchAndEditPp5Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/NiL/" + "nilCollectHistoryWatchPp5Standard" + ".png")));

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotTailWatchAndEditPp5Standard, screenshotTailWatchAndEditPp5);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/" + "diffTailWatchAndEditPp5" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 100);
    }
}






