package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.List;

public class KidsPage extends BasePage {
    public KidsPage(WebDriver driver) {
        super(driver);
    }

    public void checkElementsBannersCarousel() throws Exception {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='leftCarouselButton']"));

        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[3]"));
            isElementDisplayed(By.xpath("(//div[@class='XYh-kiX21fyak70PYmHLU poster'])[3]"));
            isElementDisplayed(By.xpath("(//div[@data-test='SlideDescription' and contains(text(),'Для детей')])[3]"));
            //isElementDisplayed(By.xpath("(//div[@data-test='SlideDescription' and contains(text(),'Для детей')])[3]|(//div[@data-test='SlideDescription' and contains(text(),'20')])[3]|(//div[@class='kjFUbLahFxqq2AjHY8j2R'])[3]"));
            System.out.println(driver.findElement(By.xpath("(//div[@data-test='SlideDescription' and contains(text(),'Для детей')])[3]")).getText());
            //click(By.xpath("//div[@data-test='BannerCarousel']"));
            //Assert.assertEquals(1, driver.findElements(By.xpath("//div[contains(text(),'Для детей')]")).size());
            //Thread.sleep(2000);
            //driver.navigate().back();
        }

        List<WebElement> BannerForKids2 = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids2.size());
        for (int i = 0; i < BannerForKids2.size(); i++) {
            BannerForKids2 = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids2.get(i).click();
            Thread.sleep(2000);
            //isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[3]"));
            //isElementDisplayed(By.xpath("(//div[@class='XYh-kiX21fyak70PYmHLU poster'])[3]"));
            //System.out.println(driver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText());
            // isElementDisplayed(By.xpath("(//div[@data-test='SlideDescription' and contains(text(),'Для детей')])[3]"));
            //isElementDisplayed(By.xpath("(//div[@data-test='SlideDescription' and contains(text(),'Для детей')])[3]|(//div[@data-test='SlideDescription' and contains(text(),'20')])[3]|(//div[@class='kjFUbLahFxqq2AjHY8j2R'])[3]"));
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            Assert.assertEquals(1, driver.findElements(By.xpath("//div[contains(text(),'Для детей')]|//span[contains(text(),'Детский')]")).size());
            Thread.sleep(2000);
            driver.navigate().back();
        }

    }

    public void clickToAllButton() {
        click(By.partialLinkText("Все"));
    }

    public void clickToTailCardFilm() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/vods')][2]"));

    }

    public void checkOpenCardFilm() {
        isElementDisplayed(By.xpath("//a[@href='/movies/vods']//span[1]"));
    }

    public void clickToTailCardSerial() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/shows')][3]"));

    }

    public void checkOpenCardSerial() {
        isElementDisplayed(By.xpath("//a[@href='/shows']//span[1]"));
    }

    public void clickToTailCardTvProgram() {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/tv/channels/')][1]"));
    }

    public void clickToHeaderCollectionOfMy() {
        click(By.linkText("Мое"));
    }

    public void clickToHeaderCollectionOfFavorites() {
        click(By.linkText("Избранное"));
    }

    public void clickToHeaderCollectionForKids() {
        click(By.linkText("Детские фильмы"));
    }

    public void switchingFromBannerToCardFilm() {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/movies/vods/')]")).isDisplayed())
            {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Фильмы']"));
                break;
            }
            else {
                BannerForKids.get(i).click();
            }
        }
    }

    public void switchingFromBannerToCardSerial() {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/shows/')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Сериалы']"));
                break;
            } else {
                BannerForKids.get(i).click();
            }
        }

    }

    public void switchingFromBannerToCardTvChannel() throws Exception {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            Thread.sleep(3000);
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/tv/channels/')]")).isDisplayed()) {
                driver.findElement(By.xpath("//div[@data-test='BannerCarousel']")).click();
                isElementDisplayed(By.xpath("//span[text()='ТВ']"));
                break; }
                else {
                BannerForKids.get(i).click();
                }

        }
    }

    public void switchingFromBannerToCardTvProgram() throws Exception {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/programs/Channel')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='ТВ']"));
                break;
            } else {
                BannerForKids.get(i).click();
            }
        }
    }

    public void switchingFromBannerToCardPackage() {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/mixed_groups/')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Пакеты']"));
                break;
            } else {
                BannerForKids.get(i).click();
            }
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
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[4]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[5]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[6]"));
        System.out.println(tail4);
        System.out.println(tail5);
        System.out.println(tail6);
        Thread.sleep(5000);
        Assert.assertNotEquals(tail1, tail4);
        Assert.assertNotEquals(tail2, tail5);
        Assert.assertNotEquals(tail3, tail6);

        while (driver.findElements(By.xpath("(//button[@class='_3DGjUma9lmXjaQqwfHiPuG _12wttH1TVBR-AUv1aCErMK _3mirESpL6CG--jdNvoNDsf'])[1]")).size() < 1) {
            click(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        }
    }

    public void scrollСollectionToLeft() {
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

    public void checkImageDifferKidsPageScroll() throws AWTException, IOException {
        // Сделать тестовый скриншот скролла страницы НиЛ:
        driver.get("https://web-preprod4.megafon.tv/kids");
        JavascriptExecutor jsDownToElement = (JavascriptExecutor) driver;
        jsDownToElement.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//h3[@data-test='PackageListWrapperName'])[1]")));
//        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
//        Set<By> posterTailsCollection = new HashSet<>();
//        posterTailsCollection.add(By.xpath("//div[@class='HZzNvtNX5fExVnjY_Popf']"));
//        Set<By> nameTailsCollection = new HashSet<>();
//        nameTailsCollection.add(By.xpath("//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']"));
//        Set<By> headerBlockCollection = new HashSet<>();
//        headerBlockCollection.add(By.xpath("//h3[@data-test='PackageListWrapperName']//a"));
        Screenshot screenshotKidsPagePp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
//                .ignoredElements(posterTailsCollection)
//                .ignoredElements(nameTailsCollection)
//                .ignoredElements(headerBlockCollection)
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']"))//целиком название блока и счетчик
                .addIgnoredElement(By.xpath("//div[@data-test='CollectionBlock']")) // тайл подборки без заголовка
                .takeScreenshot(driver);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/KidsPage/" + "scrollPageKidsPp4" + ".png");
        ImageIO.write(screenshotKidsPagePp4.getImage(), "png", actualFile1);

//        // Сделать новый эталонный скриншот скролла страницы НиЛ:
//        driver.get("https://web-preprod4.megafon.tv/kids");
//        JavascriptExecutor jsDownToElement2 = (JavascriptExecutor) driver;
//        jsDownToElement2.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//h3[@data-test='PackageListWrapperName'])[1]")));
//        Screenshot screenshotKidsPagePp4Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/KidsPage/"+"scrollPageKidsPp4Standard"+".png");
//        ImageIO.write(screenshotKidsPagePp4Standard.getImage(), "png", expectedFile1);
//        screenshotKidsPagePp4Standard.setIgnoredAreas(screenshotKidsPagePp4.getIgnoredAreas());

        // Взять старый эталонный скриншот всей страницы НиЛ:
        Screenshot screenshotKidsPagePp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/KidsPage/" + "scrollKidsPagePp4Standard" + ".png")));
        screenshotKidsPagePp4Standard.setIgnoredAreas(screenshotKidsPagePp4.getIgnoredAreas());

        // Сравнить скриншоты скролла страницы НиЛ (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotKidsPagePp4Standard, screenshotKidsPagePp4);
        System.out.println(diff1.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/KidsPage/" + "diffKidsPageScroll" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff1.getDiffSize() <= 50);
    }

    public void checkImageDifferCherdakAndBanners() throws AWTException, IOException {
        // Сделать тестовый скриншот чердака:
        WebElement headerCherdakPp4 = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
        Screenshot screenshotHeaderCherdakPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, headerCherdakPp4);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/KidsPage/" + "kidsPageCherdakPp4" + ".png");
        ImageIO.write(screenshotHeaderCherdakPp4.getImage(), "png", actualFile1);

        // Сделать тестовый скриншот баннерной зоны:
        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
        WebElement headerBannerPp4 = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
        Screenshot screenshotHeaderBannerPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .takeScreenshot(driver, headerBannerPp4);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/KidsPage/" + "kidsPageBannerPp4" + ".png");
        ImageIO.write(screenshotHeaderBannerPp4.getImage(), "png", actualFile2);

//        // Сделать новый эталонный скриншот чердака:
//        driver.get("https://web-preprod4.megafon.tv/kids");
//        WebElement headerCherdakPp4Standard = driver.findElement(By.xpath("//div[@class='ch-cherdak']"));
//        Screenshot screenshotHeaderCherdakPp4Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver, headerCherdakPp4Standard);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/KidsPage/"+"kidsPageCherdakPp4Standard"+".png");
//        ImageIO.write(screenshotHeaderCherdakPp4Standard.getImage(), "png", expectedFile1);

        // Взять старый эталонный скриншот чердака:
        Screenshot screenshotHeaderCherdakPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/KidsPage/" + "kidsPageCherdakPp4Standard" + ".png")));

//        // Сделать новый эталонный скриншот баннерной зоны:
//        click(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'][1]"));
//        WebElement headerBannerPp4Standard = driver.findElement(By.xpath("//div[@data-test='BannerCarousel']"));
//        Screenshot screenshotHeaderBannerPp4Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .takeScreenshot(driver, headerBannerPp4Standard);
//        File expectedFile2 = new File("src/test/java/testScreenshots/expected/KidsPage/"+"kidsPageBannerPp4Standard"+".png");
//        ImageIO.write(screenshotHeaderBannerPp4Standard.getImage(), "png", expectedFile2);
//        screenshotHeaderBannerPp4Standard.setIgnoredAreas(screenshotHeaderBannerPp4.getIgnoredAreas());

        // Взять старый эталонный скриншот баннерной зоны:
        Screenshot screenshotHeaderBannerPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/KidsPage/" + "kidsPageBannerPp4Standard" + ".png")));
        screenshotHeaderBannerPp4Standard.setIgnoredAreas(screenshotHeaderBannerPp4.getIgnoredAreas());

        // Сравнить скриншоты чердака (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotHeaderCherdakPp4Standard, screenshotHeaderCherdakPp4);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/KidsPage/" + "diffCherdak" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        // Сравнить скриншоты баннерной зоны (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotHeaderBannerPp4Standard, screenshotHeaderBannerPp4);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/KidsPage/" + "diffBanner" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);
    }

    public void checkImageDifferBlocksCollection() throws AWTException, IOException {
        // Сделать тестовый скриншот блока подборки с заголовком:
        driver.get("https://web-preprod4.megafon.tv/kids");
        WebElement blockCollectionWithTitlePp4 = driver.findElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]"));
        Screenshot screenshotCollectionWithTitlePp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .addIgnoredElement(By.xpath("//div[@class='_7LRTnrwDy15pRyA2wKc1m']")) // картника постера тайла
                .takeScreenshot(driver, blockCollectionWithTitlePp4);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/KidsPage/" + "kidsPageCollectionWithTitlePp4" + ".png");
        ImageIO.write(screenshotCollectionWithTitlePp4.getImage(), "png", actualFile1);

        //Сделать тестовый скриншот блока подборки без заголовка:
        driver.get("https://web-preprod4.megafon.tv/kids");
        WebElement collectionWithoutTitlePp4 = driver.findElement(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']"));
        Screenshot screenshotCollectionWithoutTitlePp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .addIgnoredElement(By.xpath("//div[@class='_3GjqQPs5h2T_Dp5BPmv9ld _2TylJ5PYUAbQjq_Oho7_r8']"))
                .addIgnoredElement(By.xpath("//div[@class='_2yqndJWOuX36UWc1F5T19w']"))
                .addIgnoredElement(By.xpath("//div[@class='_1kVeVZ_VGnmjl8qGdsFyY9']"))
                .addIgnoredElement(By.xpath("//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']")) // название и мета контента
                .addIgnoredElement(By.xpath("//div[@class='HZzNvtNX5fExVnjY_Popf']")) // постер и возраст тайла в подборке
                .addIgnoredElement(By.xpath("//div[@class='_3dON2ZfMNClOIKEKKf0KE9']")) //целиком название блока и счетчик
                .addIgnoredElement(By.xpath("//div[@data-test='CollectionBlock']")) // тайл подборки без заголовка
                .takeScreenshot(driver, collectionWithoutTitlePp4);
        File actualFile2 = new File("src/test/java/testScreenshots/actual/KidsPage/" + "kidsPageCollectionWithoutTitlePp4" + ".png");
        ImageIO.write(screenshotCollectionWithoutTitlePp4.getImage(), "png", actualFile2);

//        //Сделать новый эталонный скриншот блока подборки с заголовком:
//        driver.get("https://web-preprod4.megafon.tv/kids");
//        WebElement blockCollectionWithTitlePp4Standard = driver.findElement(By.xpath("(//div[@class='_3UmDZyX05ClTVRp6p2xAZj'])[1]"));
//        Screenshot screenshotCollectionWithTitlePp4Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver, blockCollectionWithTitlePp4Standard);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/KidsPage/"+"kidsPageCollectionWithTitlePp4Standard"+".png");
//        ImageIO.write(screenshotCollectionWithTitlePp4Standard.getImage(), "png", expectedFile1);
//        screenshotCollectionWithTitlePp4Standard.setIgnoredAreas(screenshotCollectionWithTitlePp4.getIgnoredAreas());


        //Взять старый эталонный скриншот блока подборки с заголовком:
        Screenshot screenshotCollectionWithTitlePp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/KidsPage/" + "kidsPageCollectionWithTitlePp4Standard" + ".png")));
        screenshotCollectionWithTitlePp4Standard.setIgnoredAreas(screenshotCollectionWithTitlePp4.getIgnoredAreas());

//        //Сделать новый эталонный скриншот блока подборки без заголовка:
//        driver.get("https://web-preprod4.megafon.tv/kids");
//        WebElement collectionWithoutTitlePp4Standard = driver.findElement(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']"));
//        Screenshot screenshotCollectionWithoutTitlePp4Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver, collectionWithoutTitlePp4Standard);
//        File expectedFile2 = new File("src/test/java/testScreenshots/expected/KidsPage/" + "kidsPageCollectionWithoutTitlePp4Standard" + ".png");
//        ImageIO.write(screenshotCollectionWithoutTitlePp4Standard.getImage(), "png", expectedFile2);
//        screenshotCollectionWithoutTitlePp4Standard.setIgnoredAreas(screenshotCollectionWithoutTitlePp4.getIgnoredAreas());

        //Взять старый эталонный скриншот блока подборки без заголовка:
        Screenshot screenshotCollectionWithoutTitlePp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/KidsPage/" + "kidsPageCollectionWithoutTitlePp4Standard" + ".png")));
        screenshotCollectionWithoutTitlePp4Standard.setIgnoredAreas(screenshotCollectionWithoutTitlePp4.getIgnoredAreas());

        //Сравнение скриншотов блока подборки с заголовком (тестовый и эталонный):
        ImageDiff diff1 = new ImageDiffer().makeDiff(screenshotCollectionWithTitlePp4Standard, screenshotCollectionWithTitlePp4);
        System.out.println(diff1.getDiffSize());
        File diffFile1 = new File("src/test/java/testScreenshots/markedImages/KidsPage/" + "diffCollectionWithTitle" + ".png");
        ImageIO.write(diff1.getMarkedImage(), "png", diffFile1);
        Assert.assertTrue(diff1.getDiffSize() <= 50);

        //Сравнение скриншотов блока подборки без заголовка (тестовый и эталонный):
        ImageDiff diff2 = new ImageDiffer().makeDiff(screenshotCollectionWithoutTitlePp4Standard, screenshotCollectionWithoutTitlePp4);
        System.out.println(diff2.getDiffSize());
        File diffFile2 = new File("src/test/java/testScreenshots/markedImages/KidsPage/" + "diffCollectionWithoutTitle" + ".png");
        ImageIO.write(diff2.getMarkedImage(), "png", diffFile2);
        Assert.assertTrue(diff2.getDiffSize() <= 50);

    }

    public void checkImageDifferFooter() throws AWTException, IOException {
        // Сделать тестовый скриншот футера:
        WebElement footerPp4 = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
        Screenshot screenshotFooterPp4 = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver, footerPp4);
        File actualFile1 = new File("src/test/java/testScreenshots/actual/KidsPage/" + "kidsPageFooterPp4" + ".png");
        ImageIO.write(screenshotFooterPp4.getImage(), "png", actualFile1);

//        //Сделать новый эталонный скриншот футера:
//        driver.get("https://web-preprod4.megafon.tv/kids");
//        WebElement footerPp4Standard = driver.findElement(By.xpath("//footer[@class='uy6cMg76OlWzJbrz5UGzE']"));
//        Screenshot screenshotFooterPp4Standard = new AShot()
//                .coordsProvider(new WebDriverCoordsProvider())
//                .shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(driver, footerPp4Standard);
//        File expectedFile1 = new File("src/test/java/testScreenshots/expected/KidsPage/"+"kidsPageFooterPp4Standard"+".png");
//        ImageIO.write(screenshotFooterPp4Standard.getImage(), "png", expectedFile1);
//        screenshotFooterPp4Standard.setIgnoredAreas(screenshotFooterPp4.getIgnoredAreas());

        // Взять старый эталонный скриншот футера:
        Screenshot screenshotFooterPp4Standard = new Screenshot(ImageIO.read(new File("src/test/java/testScreenshots/expected/KidsPage/" + "kidsPageFooterPp4Standard" + ".png")));
        screenshotFooterPp4Standard.setIgnoredAreas(screenshotFooterPp4.getIgnoredAreas());

        // Сравнить скриншоты футера (тестовый и эталонный):
        ImageDiff diff = new ImageDiffer().makeDiff(screenshotFooterPp4Standard, screenshotFooterPp4);
        System.out.println(diff.getDiffSize());
        File diffFile = new File("src/test/java/testScreenshots/markedImages/KidsPage/" + "diffFooter" + ".png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        Assert.assertTrue(diff.getDiffSize() <= 100);
    }
}
