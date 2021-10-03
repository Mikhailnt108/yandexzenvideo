package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SerialsPage extends BasePageWebDriver {

    public SerialsPage(WebDriver driver) {
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
            webDriver.get("https://web-preprod6.megafon.tv/shows");
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
            webDriver.get("https://web-preprod6.megafon.tv/shows");
            Thread.sleep(5000);
        }
    }

    public void checkToMoveTailToFirstPlace() {
        String nameSerial = webDriver.findElement(By.xpath("//h1[text()]")).getText();
        webDriver.get("https://web-preprod6.megafon.tv/shows");
        System.out.println(nameSerial);
        System.out.println(webDriver.findElement(By.xpath("(//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//h3[@data-test='PackageDescriptionTitle'])[1]")).getText());
        Assert.assertEquals("элементы не совпадают", nameSerial, webDriver.findElement(By.xpath("(//a[text()='Продолжить просмотр']/ancestor::div[@data-test='PackageListWrapper']//h3[@data-test='PackageDescriptionTitle'])[1]")).getText());
    }

    public void checkToMoveTailToLastPlace() {
        String nameSerial = webDriver.findElement(By.xpath("//h1[text()]")).getText();
        webDriver.get("https://web-preprod6.megafon.tv/shows");
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
