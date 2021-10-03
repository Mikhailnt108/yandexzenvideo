package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NilPage extends BasePageWebDriver {
    private WebElement ToRight;

    public NilPage(WebDriver driver) {
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
        isElementDisplayed(By.xpath("(//div[@class='_3pSmMGlz2N-PDRuE_jtIuS'])[3]"));
        isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[3]"));
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        WebElement element = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]"));
//        js.executeScript("arguments[0].innerText='Меняем заголовок'",element);

        isElementDisplayed(By.xpath("(//div[@data-test='SlideDescription'])[3]"));
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
                webDriver.get("https://web-preprod6.megafon.tv/");
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
                webDriver.get("https://web-preprod6.megafon.tv/");
            }
        }
    }

    public void checkElementsBlockCollectionSpecialForYou() {
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']"));
        isElementDisplayed(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Подобрали специально для вас']"));
        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m'])[1]"));
        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3)[1]"));
        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span)[1]"));

        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m'])[2]"));
        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3)[2]"));
        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span)[2]"));

        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_7LRTnrwDy15pRyA2wKc1m'])[3]"));
        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//h3)[3]"));
        isElementDisplayed(By.xpath("(//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//div[@class='_1IVk0Zab-UdqbOslYR6SnJ']//span)[3]"));

        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']//ancestor::div[@class='_3UmDZyX05ClTVRp6p2xAZj']//a[@data-test='PackageListWrapperMoreText']"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
        isElementDisplayed(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonPrev' and @disabled]"));
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
            for (int i = 0; i <= 10; i++) {
                click(By.xpath("//a[text()='Подобрали специально для вас']/ancestor::div[@data-test='PackageListWrapper']//button[@data-test='ArrowButtonNext']"));
            }
        }
    }

    public void checkElementsBlockCollectHistoryWatch() {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();"
                , webDriver.findElement(By.xpath("//h3[@data-test='PackageListWrapperName']//a[text()='Продолжить просмотр']")));
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
        webDriver.get("https://web-preprod6.megafon.tv/");
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

    public void checkLastTailInCollectionSpecialForYou() {
        isElementDisplayed(By.xpath("//div[text()='Повысить точность персональных рекомендаций']"));
    }

    public void clickToLastTailInCollectionSpecialForYou() {
        click(By.xpath("//div[text()='Повысить точность персональных рекомендаций']"));
    }
}
