package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FilmsPage extends BasePageWebDriver {
    private String frontend;
    private String backend;
    public FilmsPage(WebDriver webDriver, String frontend, String backend) {
        super(webDriver);
        this.frontend = frontend;
        this.backend = backend;
    }

    public void checkOpenFilmsPage() {
        isElementDisplayed(By.xpath("//h1[text()='Фильмы']"));
    }

    public void clickToTailCardFilmFromAvailable() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void clickToHeaderRent2Collection() throws InterruptedException {
        click(By.partialLinkText("аренд"));
    }

    public void clickOnFilterPayment() throws InterruptedException {
        click(By.xpath("//button[text()='Оплачено']"));
    }

    public void chooseTabPromo() throws InterruptedException {
        webDriver.navigate().refresh();
        click(By.xpath("//div[text()='По акции']"));
        Thread.sleep(4000);
    }

    public void clickOnYearInput() throws InterruptedException {
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRadioButtons() {
        List<WebElement> radioButtons = webDriver.findElements(By.xpath("(//div[@class='_TKVCKE7PL8voHtm8HP2j'])[1]//span[@class='AoSy93bShFe6C6hlZfxUE']"));
        Assert.assertEquals(15, radioButtons.size());
    }

    public void chooseOneYearOnly() throws InterruptedException {
        click(By.xpath("//span[text()='2019 год']"));
        click(By.xpath("//div[text()='Год']"));
    }

    public void checkRequestResultOneYearOnly() {
        List<WebElement> Only2019years = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'2019')]"));
        Assert.assertEquals(36, Only2019years.size());
    }

    public void choosePeriodOfYears() throws InterruptedException {
        click(By.xpath("//div[text()='Год с']"));
        click(By.xpath("(//span[text()='2010'])[1]"));

        click(By.xpath("//div[text()='по']"));
        click(By.xpath("(//span[text()='2020'])[2]"));
    }

    public void checkRequestResultPeriodOfYears() {
        List<WebElement> Period = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'2018') or contains(text(),'2019') or contains(text(),'2020') or contains(text(),'2021')]"));
        Assert.assertEquals(36, Period.size());
    }

    public void clickOnGenreInput() throws InterruptedException {
        click(By.xpath("//div[text()='Жанр']"));

    }

    public void checkCheckboxes() {
        List<WebElement> checkboxes = webDriver.findElements(By.xpath("(//div[@class='_2t8gxqv7DAHrHOVOT7SNQu'])[1]//input[@type='checkbox']"));
        Assert.assertEquals(28, checkboxes.size());
    }

    public void chooseOneGenre() throws InterruptedException {
        click(By.xpath("//div[text()='Жанр']"));
        click(By.xpath("//span[text()='Документальный']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultOneGenre() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> CollectionOneGenre = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Документальный')]"));
        Assert.assertEquals(36, CollectionOneGenre.size());
    }

    public void chooseTwoGenre() throws InterruptedException {
        click(By.xpath("//div[text()='Документальный']"));
        click(By.xpath("//span[text()='Аниме']"));
        click(By.xpath("//div[text()='Жанр']"));
    }

    public void checkRequestResultTwoGenre() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> CollectionTwoGenre = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Документальный')]|//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Аниме')]"));
        Assert.assertEquals(36, CollectionTwoGenre.size());
    }

    public void clickOnCountryInput() throws InterruptedException {
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


    public void chooseTwoCountry() throws InterruptedException {
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

    public void clickOnResetFiltersButton() throws InterruptedException {
        click(By.xpath("//button[text()='Сбросить']"));
    }

    public void checkResetAllFilters() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> Filters = webDriver.findElements(By.xpath("//div[@class='_1RRLrdyUeRf97LW7DW4bHw']//div[text()='Жанр' or text()='Страна' or text()='Сортировка' or text()='Год с' or text()='по' or text()='Рейтинг']"));
        Assert.assertEquals(6, Filters.size());
    }

    public void clickToTailCardFilm3FromAll() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink'])[3]"));
    }

    public void clickToTailCardFilm4FromAll() throws InterruptedException {
        click(By.xpath("(//a[@data-test='PackageLink'])[5]"));
    }

    public void checkFilmsPromo() throws InterruptedException {
        List<WebElement> CollectionPackages = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i < 5; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']")));
            CollectionPackages = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionPackages.get(i).click();
            Thread.sleep(3000);
            Assert.assertEquals("Нет кнопки 'По акции на 48 часов за 0 ₽' на странице", "По акции на 48 часов за 0 ₽", webDriver.findElement(By.xpath("//span[text()='По акции на 48 часов за 0 ₽']")).getText());
            webDriver.navigate().back();
        }
    }

    public void clickToSecondTailCardFilm() throws InterruptedException {
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-test='PackageLink'])[2]")));
        click(By.xpath("(//a[@data-test='PackageLink'])[2]"));
    }

    public void checkElementsFilmsPage() throws InterruptedException {
        Thread.sleep(3000);
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

        List<WebElement> BannerForFilms = webDriver.findElements(By.xpath("//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForFilms.size());
        for (int i = 0; i < BannerForFilms.size(); i++) {
            BannerForFilms = webDriver.findElements(By.xpath("//button[@data-test='CarouselDotButton']"));
            BannerForFilms.get(i).click();
            isElementDisplayed(By.xpath("(//div[@data-test='SlideTitle'])[3]"));
            isElementDisplayed(By.xpath("(//div[@class='XYh-kiX21fyak70PYmHLU poster'])[3]"));
            System.out.println(webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[3]")).getText());
        }

        List<WebElement> BannerForFilms2 = webDriver.findElements(By.xpath("//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForFilms2.size());
        for (int i = 0; i < BannerForFilms2.size(); i++) {
            Thread.sleep(4000);
            BannerForFilms2 = webDriver.findElements(By.xpath("//button[@data-test='CarouselDotButton']"));
            BannerForFilms2.get(i).click();
            Thread.sleep(2000);
            click(By.xpath("//div[@data-test='BannerCarousel']"));
            Assert.assertEquals(1, webDriver.findElements(By.xpath("//a[@href='/movies/vods']//span[text()='Фильмы']")).size());
            webDriver.get(frontend+"movies/vods");
        }

    }

    public void autoScrollBanners() throws Exception {
        isElementDisplayed(By.xpath("//div[@data-test='BannerCarousel']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton']"));
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
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        click(By.xpath("//button[@data-test='CarouselDotButton'][1]"));
        String bannerFirst = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerFirst);
        click(By.xpath("//button[@data-test='leftCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton'][last()]//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']"));
        String bannerLast = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerLast);
        Assert.assertNotEquals(bannerFirst, bannerLast);
    }

    public void scrollBannersToRight() throws Exception {
        List<WebElement> BannerForKids = webDriver.findElements(By.xpath("//button[@data-test='CarouselDotButton']"));
        System.out.println(BannerForKids.size());
        click(By.xpath("//button[@data-test='CarouselDotButton'][last()]"));
        String bannerLast = webDriver.findElement(By.xpath("(//div[@data-test='SlideTitle'])[2]")).getText();
        System.out.println(bannerLast);
        click(By.xpath("//button[@data-test='rightCarouselButton']"));
        isElementDisplayed(By.xpath("//button[@data-test='CarouselDotButton']//div[@class='CCg90x7JQ0YOQVkXtgFkE _3Du8w-9yVSUhDNJpc7k-t3']"));
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

    public void switchingFromBannerToCardFilm() throws InterruptedException {
        click(By.xpath("//div[@data-test='BannerCarousel']"));
    }

    public void clickToLinkAllOnCollectionBlock() throws InterruptedException {
        click(By.partialLinkText("Все"));
    }

    public void chooseOneQuickFilter() throws InterruptedException {
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

    public void chooseTwoQuickFilter() throws InterruptedException {
        click(By.xpath("//button[text()='Боевик']"));
        isElementDisplayed(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Боевик']"));
        isElementDisplayed(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Приключения']"));
    }

    public void checkRequestResultTwoQuickFilter() {
        List<WebElement> CollectionQuickFilter = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Приключения')]|//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//span[contains(text(),'Боевик')]"));
        Assert.assertEquals(36, CollectionQuickFilter.size());
    }

    public void checkUnplugQuickFilter() throws InterruptedException {
        click(By.xpath("//button[text()='Боевик']"));
        Assert.assertEquals("не отключен быстрый фильтр", 0, webDriver.findElements(By.xpath("//button[contains(@class,'_3gAIIPQjtWSKeQ00BZcMjA _1jUu-xJ3uLr0UCGOxn-nJ9 _3Svh8L_4naDJIO2C6fl7oz') and text()='Боевик']")).size());
    }

    public void checkRequestResultOneCountryAndTwoGenre() throws InterruptedException {
        List<WebElement> CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
        for (int i = 0; i <= 5; i++) {
            Thread.sleep(4000);
            CollectionOneCountry = webDriver.findElements(By.xpath("//div[@class='_3cuXOHr5t7k7pVgE5bsgEF']//a[@data-test='PackageLink']"));
            CollectionOneCountry.get(i).click();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//button[text()='Прочитать описание']"))));
            webDriver.findElement(By.xpath("//div[contains(text(),'Документальный') or contains(text(),'Аниме')]"));
            webDriver.findElement(By.xpath("//button[text()='Прочитать описание']")).click();
            webDriver.findElement(By.xpath("//div[contains(text(),'Россия')]"));
            webDriver.navigate().back();
        }
    }

    public void checkCollectionsViewFilmsPage() {
        Assert.assertNotEquals("вид страницы не каталог", 1, webDriver.findElements(By.xpath("//h3[@data-test='PackageListWrapperName']")).size());
    }

    public void clickToFirstTailCardFilm() throws InterruptedException {
        if (webDriver.findElements(By.xpath("//div[@aria-label='Notification']")).size() != 0) {
            click(By.xpath("//button[text()='Закрыть']"));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-test='PackageLink'])[1]")));
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }
}





