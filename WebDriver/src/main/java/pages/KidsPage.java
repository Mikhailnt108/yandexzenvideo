package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KidsPage extends BasePageWebDriver {
    public KidsPage(WebDriver driver) {
        super(driver);
    }

    public void checkElementsBannersCarousel() throws Exception {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']")); // банерная зона
        isElementDisplayed(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']")); // точки пагинации
        isElementDisplayed(By.xpath("//button[@data-test='rightCarouselButton']")); // кнопка прокрутки баннера вправо
        isElementDisplayed(By.xpath("//button[@data-test='leftCarouselButton']")); // кнопка прокрутки баннера влево
        click(By.xpath("(//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton'])[1]"));

        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            Thread.sleep(2000);
            webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]"));
            System.out.println(webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText());
            webDriver.findElement(By.xpath("(//div[@class='XYh-kiX21fyak70PYmHLU poster'])[3]"));
            webDriver.findElement(By.xpath("(//div[@data-test='SlideDescription' and text()])[3]"));
        }

        List<WebElement> BannerForKids2 = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids2.size());
        for (int i = 0; i < BannerForKids2.size(); i++) {
            BannerForKids2 = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids2.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Для детей')]|//span[contains(text(),'Детский')]|//div[contains(text(),'Семейный')]")));
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//div[contains(text(),'Для детей')]|//span[contains(text(),'Детский')]|//div[contains(text(),'Семейный')]")).size());
            Thread.sleep(3000);
            webDriver.get("https://web-preprod3.megafon.tv/kids");
        }
    }

    public void clickToAllButton() throws InterruptedException {
        click(By.partialLinkText("Все"));
    }

    public void clickToFirstTailCardFilm() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href,'/movies/vods/')])[1]"));
    }

    public void clickToSecondTailCardFilm() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink' and contains(@href,'/movies/vods/')])[2]"));
    }

    public void clickToTailCardSerial() throws InterruptedException {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/shows')][1]"));
    }

    public void clickToTailCardTvProgram() throws InterruptedException {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/tv/channels/')][1]"));
    }

    public void clickToHeaderCollectionOfMy() throws InterruptedException {
        click(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Мое' or text()='Моё']"));
    }

    public void clickToHeaderCollectionOfFavorites() throws InterruptedException {
        click(By.linkText("Избранное"));
    }

    public void clickToHeaderCollectionForKids() throws InterruptedException {
        click(By.linkText("Детские фильмы"));
    }

    public void switchingFromBannerToCardFilm() throws InterruptedException {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            if (webDriver.findElements(By.xpath("//span[text()='Фильмы']")).size() > 0) {
                break;
            } else {
                webDriver.get("https://web-preprod3.megafon.tv/kids");
            }
        }
    }

    public void switchingFromBannerToCardSerial() throws InterruptedException {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            if (webDriver.findElements(By.xpath("//span[text()='Сериалы']")).size() > 0) {
                break;
            } else {
                webDriver.get("https://web-preprod3.megafon.tv/kids");
            }
        }
    }


    public void switchingFromBannerToCardTvChannel() throws Exception {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            if (webDriver.findElements(By.xpath("//span[text()='ТВ']")).size() > 0) {
                break;
            } else {
                webDriver.get("https://web-preprod3.megafon.tv/kids");
            }
        }
    }

    public void switchingFromBannerToCardTvProgram() throws Exception {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            if (webDriver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/programs/Channel')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='ТВ']"));
                break;
            } else {
                BannerForKids.get(i).click();
            }
        }
    }

    public void switchingFromBannerToCardPackage() throws InterruptedException {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = webDriver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            if (webDriver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/mixed_groups/')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Пакеты']"));
                break;
            } else {
                BannerForKids.get(i).click();
            }
        }
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

        while (webDriver.findElements(By.xpath("(//button[@class='_3DGjUma9lmXjaQqwfHiPuG _12wttH1TVBR-AUv1aCErMK _3mirESpL6CG--jdNvoNDsf'])[1]")).size() < 1) {
            click(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        }
    }

    public void scrollСollectionToLeft() throws InterruptedException {
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

    public void checkElementsBlockCollectionWithHeader() throws Exception {
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageListWrapperName']//a)[1]"));
        isElementDisplayed(By.partialLinkText("Все"));
        isElementDisplayed(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("(//div[@class='_3H6SpMZcck2BFXiKBB5gtC _3l_eEMTBvsXXhIcEIbq6Zh'])[1]"));
        isElementDisplayed(By.xpath("(//h3[@data-test='PackageDescriptionTitle'])[1]"));
        isElementDisplayed(By.xpath("(//span[@class='_1VOD2HVjO24JlwN9I3tRYd']//span)[1]"));
        isElementDisplayed(By.xpath("(//button[@data-test='ArrowButtonNext'])[1]"));
        isElementDisplayed(By.xpath("(//button[@data-test='ArrowButtonPrev' and @disabled])[1]"));

        List<WebElement> TailCollectForKids1 = webDriver.findElements(By.xpath("(//div[@data-test='PackageListWrapper'])[1]//a[@data-test='PackageLink']"));
        System.out.println(TailCollectForKids1.size());
        for (int a = 0; a < TailCollectForKids1.size(); a++) {
            Thread.sleep(2000);
            TailCollectForKids1 = webDriver.findElements(By.xpath("(//div[@data-test='PackageListWrapper'])[1]//a[@data-test='PackageLink']"));
            TailCollectForKids1.get(a).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Для детей')]")));
            System.out.println(webDriver.findElement(By.xpath("//h1[text()]")).getText());
            webDriver.get("https://web-preprod3.megafon.tv/kids");
        }
    }

    public void checkElementsBlockCollectionWithoutHeader() throws InterruptedException {
        isElementDisplayed(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']"));// блок подборки без заголовка
        isElementDisplayed(By.xpath("(//div[@class='_3tqh94XTCpOzUTwtkUwF7L']//div[@data-test='CollectionBlock'])[1]")); // тайл1 в подборке без заголовка
        isElementDisplayed(By.xpath("(//div[@class='_3tqh94XTCpOzUTwtkUwF7L']//div[@data-test='CollectionBlock'])[2]")); // тайл2 в подборке без заголовка
        isElementDisplayed(By.xpath("(//div[@class='_3tqh94XTCpOzUTwtkUwF7L']//h3[@data-test='CollectionName'])[1]")); // заголовок и возраст контента тайла1 в подборке без заголовка
        isElementDisplayed(By.xpath("(//div[@class='_3tqh94XTCpOzUTwtkUwF7L']//h3[@data-test='CollectionName'])[2]")); // заголовок и возраст контента тайла2 в подборке без заголовка
        isElementDisplayed(By.xpath("//button[@data-test='ArrowButtonNext']/ancestor::*//div[@class='_3tqh94XTCpOzUTwtkUwF7L']")); // кнопка листать вперед
        isElementDisplayed(By.xpath("//button[@data-test='ArrowButtonPrev' and @disabled]/ancestor::*//div[@class='_3tqh94XTCpOzUTwtkUwF7L']")); // кнопка листать назад

        List<WebElement> TailCollectForKids2 = webDriver.findElements(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']//div[@data-test='CollectionBlock']"));
        System.out.println(TailCollectForKids2.size());
        for (int a = 0; a < 2; a++) {
            TailCollectForKids2 = webDriver.findElements(By.xpath("//div[@class='_3tqh94XTCpOzUTwtkUwF7L']//div[@data-test='CollectionBlock']"));
            TailCollectForKids2.get(a).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test='PackageLink']")));
            List<WebElement> countAllTail = webDriver.findElements(By.xpath("//a[@data-test='PackageLink']"));
            countAllTail.size();
            List<WebElement> countForKids = webDriver.findElements(By.xpath("//span[contains(text(),'Для детей')]"));
            countForKids.size();
            Assert.assertEquals(countAllTail.size(), countForKids.size());
            System.out.println(countAllTail.size());
            System.out.println(countForKids.size());
            System.out.println(webDriver.findElement(By.xpath("//h1[text()]")).getText());
            click(By.xpath("(//div[text()='Детям'])[1]"));
            Thread.sleep(2000);
        }

    }

    public void clickToTailCardPackage() throws InterruptedException {
        click(By.xpath("//div[@data-test='PackageListWrapper']//a[contains(@href, '/mixed_groups/')][1]"));
    }

    public void clickToLinkAllOnCollectionBlock() throws InterruptedException {
        click(By.partialLinkText("Все"));
    }

    public void clickToLinkAllWithCollectionFilms() throws InterruptedException {
        click(By.xpath("(//a[contains(@href, '/vods')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void clickToLinkAllWithCollectionSerial() throws InterruptedException {
        click(By.xpath("(//a[contains(@href, '/shows/')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText'])[1]"));
    }

    public void clickToLinkAllWithCollectionTvProgram() throws InterruptedException {
        click(By.xpath("(//a[contains(@href, '/tv/channels/')]/ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText'])[1]"));
    }


    public void checkBackgroundCardContentForKids() {
        String Background = webDriver.findElement(By.xpath("//div[contains(@class,'_26VUc9ouKb9F8gVK9Zokon')]")).getCssValue("background-image");
        System.out.println(webDriver.findElement(By.xpath("//div[contains(@class,'_26VUc9ouKb9F8gVK9Zokon')]")).getCssValue("background-image"));
        System.out.println(Background.substring(0,3));
        Assert.assertEquals("нет детского фона", "url", Background.substring(0,3));
    }

    public void checkBackgroundPageCollectionForKids() {
        Assert.assertTrue("not found kids background", webDriver.findElements(By.xpath("//div[@class='_3c9FjHVIHIuT3fX6yTP3IO zK5BWWTConuPWpB-NgSkJ']")).size()==1);
        String Background = webDriver.findElement(By.xpath("//div[@class='_3c9FjHVIHIuT3fX6yTP3IO zK5BWWTConuPWpB-NgSkJ']")).getCssValue("background-image");
        System.out.println(webDriver.findElement(By.xpath("//div[@class='_3c9FjHVIHIuT3fX6yTP3IO zK5BWWTConuPWpB-NgSkJ']")).getCssValue("background-image"));
        System.out.println(Background.substring(0,3));
        Assert.assertEquals("нет детского фона", "url", Background.substring(0,3));
    }
}




