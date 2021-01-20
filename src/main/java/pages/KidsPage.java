package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public void switchingFromBannerToCardFilm() throws Exception {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            //Thread.sleep(3000);
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/movies/vods/')]")).isDisplayed())
            {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Фильмы']"));
                Thread.sleep(3000);
                break;
            }
            else {
                BannerForKids.get(i).click();
            }
        }
    }

    public void switchingFromBannerToCardSerial() throws Exception {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            //isElementDisplayed(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/shows/')]"));
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/shows/')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Сериалы']"));
                Thread.sleep(3000);
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
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='ТВ']"));
                Thread.sleep(3000);
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
            Thread.sleep(3000);
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/programs/Channel')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='ТВ']"));
                Thread.sleep(3000);
                break;
            } else {
                BannerForKids.get(i).click();
            }
        }
    }

    public void switchingFromBannerToCardPackage() throws Exception {
        List<WebElement> BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        for (int i = 0; i < BannerForKids.size(); i++) {
            BannerForKids = driver.findElements(By.xpath("//div[@class='_2-F_qEwyH9P_zWeUdZcMcd _77CQGroIvaqgGukdVHQ7X']//button[@data-test='CarouselDotButton']"));
            BannerForKids.get(i).click();
            Thread.sleep(3000);
            if (driver.findElement(By.xpath("//div[@class='XYh-kiX21fyak70PYmHLU poster']//a[contains(@href,'/mixed_groups/')]")).isDisplayed()) {
                click(By.xpath("//div[@data-test='BannerCarousel']"));
                isElementDisplayed(By.xpath("//span[text()='Пакеты']"));
                Thread.sleep(3000);
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
}
