package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
            click(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));}
    }

    public void clickToTailCardFilm() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/vods')][1]"));
    }

    public void clickToTailCardSerial() {
        click(By.xpath("(//a[contains(@href,'/shows/')]/following-sibling::a)[1]"));
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

        while (driver.findElements(By.xpath("(//button[@class='_2k8t0pWxsThhBF_-hDMEc- _12wttH1TVBR-AUv1aCErMK'])[1]")).size()>0) {
            click(By.xpath("(//button[@data-test='ArrowButtonPrev'])[1]"));
        }
    }
    public void createScreenShot() throws AWTException, IOException {
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
        Screenshot screenshot1 = new AShot().takeScreenshot(driver);
        File actualFile = new File("src/test/java/testScreenshots/actual/"+"nil"+".png");
        ImageIO.write(screenshot1.getImage(), "png", actualFile);
        Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/"+"NilAllPage"+".png");
        ImageIO.write(screenshot2.getImage(), "png", actualFile2);
    }
    public void imageDifferPageHeader() throws AWTException, IOException {
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
        Screenshot screenshotNilPp1 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/"+"nilPp1"+".png");
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
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/"+"nilProd"+".png");
        ImageIO.write(screenshotNilProd.getImage(), "png", expectedFile1);
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotNilProd, screenshotNilPp1);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/"+"diff"+".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize()<=15);
    }
    public void imageDifferPageAll() throws AWTException, IOException {
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
        Screenshot screenshotNilPp1 = new AShot()
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
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/"+"nilPp1"+".png");
        ImageIO.write(screenshotNilPp1.getImage(), "png", actualFile1);
        String prod = "https://megafon.tv/";
        driver.get(prod);
        click(By.xpath("(//div[@role='dialog']//button)[3]"));
        Screenshot screenshotNilProd = new AShot()
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
                .takeScreenshot(driver);
        File expectedFile1 = new File("src/test/java/testScreenshots/expected/"+"nilProd"+".png");
        ImageIO.write(screenshotNilProd.getImage(), "png", expectedFile1);
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotNilProd, screenshotNilPp1);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/"+"diff"+".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize()<=15);
    }

    public void imageDifferHeader() throws AWTException, IOException {
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
        WebElement headerCherdakPp1 = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakPp1 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, headerCherdakPp1);

        WebElement headerBannerPp1 = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerPp1 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, headerBannerPp1);

        WebElement headerMarketingPp1 = driver.findElement(By.xpath("//a[@class='_9shdVW_v5Itw7J9UcKl6h']"));
        Screenshot screenshotHeaderMarketingPp1 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, headerMarketingPp1);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/"+"nilCherdakPp1"+".png");
        ImageIO.write(screenshotHeaderCherdakPp1.getImage(), "png", actualFile1);

        File actualFile2 = new File("src/test/java/testScreenshots/actual/NiL/"+"nilBannerPp1"+".png");
        ImageIO.write(screenshotHeaderBannerPp1.getImage(), "png", actualFile2);

        File actualFile3 = new File("src/test/java/testScreenshots/actual/NiL/"+"nilMarketingPp1"+".png");
        ImageIO.write(screenshotHeaderMarketingPp1.getImage(), "png", actualFile3);

        String prod = "https://megafon.tv/";
        driver.get(prod);
        click(By.xpath("(//div[@role='dialog']//button)[3]"));

        WebElement headerCherdakProd = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakProd = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, headerCherdakProd);

        WebElement headerBannerProd = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerProd = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, headerBannerProd);

        WebElement headerMarketingProd = driver.findElement(By.xpath("//a[@class='_9shdVW_v5Itw7J9UcKl6h']"));
        Screenshot screenshotHeaderMarketingProd = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .addIgnoredElement(By.xpath("//div[@class='_3UmDZyX05ClTVRp6p2xAZj']"))
                .takeScreenshot(driver, headerMarketingProd);

        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilCherdakProd"+".png");
        ImageIO.write(screenshotHeaderCherdakProd.getImage(), "png", expectedFile1);

        File expectedFile2 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilBannerlProd"+".png");
        ImageIO.write(screenshotHeaderBannerProd.getImage(), "png", expectedFile2);

        File expectedFile3 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilMarketingProd"+".png");
        ImageIO.write(screenshotHeaderMarketingProd.getImage(), "png", expectedFile3);

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotHeaderCherdakProd, screenshotHeaderCherdakPp1);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/"+"diffCherdak"+".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize()<=15);

        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotHeaderBannerProd, screenshotHeaderBannerPp1);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/NiL/"+"diffBanner"+".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize()<=15);

        ImageDiff diff3 = new ImageDiffer().makeDiff(screenshotHeaderMarketingProd, screenshotHeaderMarketingPp1);
        System.out.println(diff3.getDiffSize());
        File diffFile3 = new File("src/test/java/testScreenshots/markedImages/NiL/"+"diffMarketing"+".png");
        ImageIO.write(diff3.getMarkedImage(), "png", diffFile3);
        Assert.assertTrue(diff3.getDiffSize()<=15);
    }

    public void imageDifferCollections() throws AWTException, IOException {
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
        WebElement collectionWithTitlePp1 = driver.findElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]"));
        Screenshot screenshotCollectionWithTitlePp1 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .takeScreenshot(driver, collectionWithTitlePp1);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/"+"nilCollectionWithTitlePp1"+".png");
        ImageIO.write(screenshotCollectionWithTitlePp1.getImage(), "png", actualFile1);

        WebElement collectionWithoutTitlePp1 = driver.findElement(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']"));
        Screenshot screenshotCollectionWithoutTitlePp1 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .takeScreenshot(driver, collectionWithoutTitlePp1);

        File actualFile2 = new File("src/test/java/testScreenshots/actual/NiL/"+"nilCollectionWithoutTitlePp1"+".png");
        ImageIO.write(screenshotCollectionWithoutTitlePp1.getImage(), "png", actualFile2);

        String prod = "https://megafon.tv/";
        driver.get(prod);
        //click(By.xpath("(//div[@role='dialog']//button)[3]"));
        WebElement collectionWithTitleProd = driver.findElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]"));
        Screenshot screenshotCollectionWithTitleProd = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .takeScreenshot(driver, collectionWithTitleProd);

        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilCollectionWithTitleProd"+".png");
        ImageIO.write(screenshotCollectionWithTitleProd.getImage(), "png", expectedFile1);

        WebElement collectionWithoutTitleProd = driver.findElement(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']"));
        Screenshot screenshotCollectionWithoutTitleProd = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='FFsZUeKiSMK9khw9tZrW1']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1qN4BpLDL0brhXNNAWWcVD']"))
                .addIgnoredElement(By.xpath("//div[@class='_1byOct53kb4KlmAs0JuRSX']"))
                .takeScreenshot(driver, collectionWithoutTitleProd);

        File expectedFile2 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilCollectionWithoutTitleProd"+".png");
        ImageIO.write(screenshotCollectionWithoutTitleProd.getImage(), "png", expectedFile2);

        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectionWithTitleProd, screenshotCollectionWithTitlePp1);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/NiL/"+"diffCollectionWithTitle"+".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize()<=15);

        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotCollectionWithoutTitleProd, screenshotCollectionWithoutTitlePp1);
        System.out.println(diff1.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/NiL/"+"diffCollectionWithoutTitle"+".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize()<=15);
    }


    public void imageDifferFooter() throws AWTException, IOException {
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
        WebElement footerPp1 = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooterPp1 = new AShot()
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
                .takeScreenshot(driver, footerPp1);

        File actualFile1 = new File("src/test/java/testScreenshots/actual/NiL/"+"nilFooterPp1"+".png");
        ImageIO.write(screenshotFooterPp1.getImage(), "png", actualFile1);

        String prod = "https://megafon.tv/";
        driver.get(prod);
        //click(By.xpath("(//div[@role='dialog']//button)[3]"));
        WebElement footerProd = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooterProd = new AShot()
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
                .takeScreenshot(driver, footerProd);

        File expectedFile1 = new File("src/test/java/testScreenshots/expected/NiL/"+"nilFooterProd"+".png");
        ImageIO.write(screenshotFooterProd.getImage(), "png", expectedFile1);

        ImageDiff diff = new ImageDiffer().makeDiff(screenshotFooterProd, screenshotFooterPp1);
        System.out.println(diff.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/NiL/"+"diffFooter"+".png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff.getDiffSize()<=15);
    }


}




