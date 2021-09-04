package pages;

import base.BasePageWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

public class MyPageWebDriver extends BasePageWebDriver {
    String My_favorites = "https://web-preprod5.megafon.tv/my/favorites";
    String My_history = "https://web-preprod5.megafon.tv/my/history";
    String My_purchases = "https://web-preprod5.megafon.tv/my/purchases";
    String My_subscriptions = "https://web-preprod5.megafon.tv/my/subscriptions";


    public MyPageWebDriver(WebDriver driver) {
        super(driver);
    }

    public void checkAddingTvProgramToFavorites() {
        isElementDisplayed(By.xpath("//h3[text()='ТВ-каналы']"));
    }

    public void checkAddingFilmInPurchases() {
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        String nameFilm = webDriver.findElement(By.tagName("h1")).getText();
        System.out.println(nameFilm);
        webDriver.get(My_purchases);
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        Assert.assertEquals(nameFilm, webDriver.findElement(By.tagName("h1")).getText());
    }

    public void checkNoPurchase() {
        Assert.assertEquals(0, webDriver.findElements(By.xpath("//span[text()='Куплено']")).size());
    }

    public void checkAddingFilmToFavorites() {
        webDriver.get("https://web-preprod5.megafon.tv/movies/vods");
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        String nameFilm = webDriver.findElement(By.tagName("h1")).getText();
        System.out.println(nameFilm);
        webDriver.get(My_favorites);
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        Assert.assertEquals(nameFilm, webDriver.findElement(By.tagName("h1")).getText());
    }

    public void checkAddingSerialsInPurchases() throws InterruptedException {
        click(By.xpath("//a[@href='/my/purchases/series']"));
        List<WebElement> count1 = webDriver.findElements(By.xpath("//a[@data-test='PackageLink']"));
        int i1 = count1.size();
        webDriver.get("https://web-preprod5.megafon.tv/shows");
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        isElementDisplayed(By.xpath("//a[@href='/shows']//span[1]"));
        click(By.xpath("(//button[@type='button']//span)[4]"));
        isElementDisplayed(By.xpath("//h3[contains(text(),'Подписка')]"));
        click(By.xpath("//button[text()='Принять и подключить']"));
        isElementDisplayed(By.xpath("//h3[text()='Подключение выполнено успешно']"));
        click(By.xpath("//button[text()='Закрыть']"));
        isElementDisplayed(By.xpath("//span[text()='Смотреть']"));

        webDriver.get("https://web-preprod5.megafon.tv/my/purchases");
        click(By.xpath("//div[text()='Пакеты и сервисы']"));
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));

        String countSerialsInPackage = webDriver.findElement(By.className("ie5X02ZFMoZJ1Ued-w7x_")).getText();
        String count2 = countSerialsInPackage.substring(0,3);
        System.out.println(count2);
        int i2 = Integer.parseInt(count2);

        webDriver.get("https://web-preprod5.megafon.tv/my/purchases");
        click(By.xpath("//a[@href='/my/purchases/series']"));
        for (int a=0; a<=8; a++) {
            List<WebElement> count3 = webDriver.findElements(By.xpath("//a[@data-test='PackageLink']"));
            JavascriptExecutor jsDown = (JavascriptExecutor) webDriver;
            jsDown.executeScript("window.scrollTo(0, 50000);");
            Thread.sleep(10000);
            System.out.println(count3.size());
            Assert.assertNotEquals("количество элементов равно", count3.size(), webDriver.findElements(By.xpath("//a[@data-test='PackageLink']")).size());
            System.out.println(webDriver.findElements(By.xpath("//a[@data-test='PackageLink']")).size());
        }
        List<WebElement> countSerials = webDriver.findElements(By.xpath("//a[@data-test='PackageLink']"));
        int i3 = countSerials.size();
        Assert.assertEquals("не равно количество сериалов", i3, i1+i2 );
    }

    public void checkAddingSerialToFavorites() {
        String nameSerial = webDriver.findElement(By.tagName("h1")).getText();
        System.out.println(nameSerial);
        webDriver.get(My_favorites);
        // переход в карточку сериала:
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        // переход в карточку эпизода:
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        Assert.assertEquals(nameSerial, webDriver.findElement(By.tagName("h1")).getText());
    }

    public void goToCollectionFavoritesPage() {
        click(By.xpath("//a[@href='/my/favorites/films']"));
        isElementDisplayed(By.xpath("//a[@href='/my/favorites']"));
    }

    public void goToCollectionPurchasesPage() {
        click(By.xpath("//a[@href='/my/purchases/films']"));
        isElementDisplayed(By.linkText("Фильмы"));
    }

    public void checkSubscriptionsPackages() {
        List<WebElement> CollectionPackages = webDriver.findElements(By.xpath("//div[@class='_2_Ri6nlJFXGDuvpZHi8zlB']//a[@data-test='PackageLink']"));
        for (int i=0; i<CollectionPackages.size(); i++)
        {
            CollectionPackages = webDriver.findElements(By.xpath("//div[@class='_2_Ri6nlJFXGDuvpZHi8zlB']//a[@data-test='PackageLink']"));
            CollectionPackages.get(i).click();
            webDriver.findElement(By.xpath("//div[text()='Бесплатно']|//div[text()='Навсегда']|//div[text()='Доступно']|//div[text()='Входит']"));
            webDriver.navigate().back();
        }

    }

    public void clickToTailCardFilmFromFavorites() {
        click(By.xpath("//a[@data-test='PackageLink']"));
    }

    public void clickToTailCardFilmFromPurchases() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void clickToTailCardPackageFromSubscriptions() {
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
    }

    public void checkAddingFilmInHistory() {
        String nameFilm = webDriver.findElement(By.tagName("h1")).getText();
        System.out.println(nameFilm);
        webDriver.get(My_history);
        click(By.xpath("//a[@data-test='PackageLink']"));
        Assert.assertEquals(nameFilm, webDriver.findElement(By.tagName("h1")).getText());
    }
    public void goToMyPageFavorites() { webDriver.get(My_favorites);
        isElementDisplayed(By.xpath("//a[@href='/my']//span[1]"));
    }
    public void goToMyPagePurchases() {
        webDriver.get(My_purchases);
        isElementDisplayed(By.xpath("//span[text()='Оплаченное']"));
    }
    public void goToMyPageSubscriptions() {
        webDriver.get(My_subscriptions);
        isElementDisplayed(By.xpath("//div[text()='Пакеты и сервисы']"));
    }

    public void checkOpenPageMyHistory() {
        isElementDisplayed(By.xpath("//span[text()='История']"));
    }

    public void checkVisibleContent18Plus() {
        isElementDisplayed(By.xpath("//span[contains(text(),'Эротика')]"));
    }

    public void clickToButtonClearAllHistory() {
        click(By.xpath("//div[text()='Стереть всю историю']"));
       click(By.xpath("//button[text()='Стереть']"));
    }

    public void checkCountSerialsInPurchases() {
        List<WebElement> count = webDriver.findElements(By.xpath("//a[@data-test='PackageLink']"));
        int i = count.size();
        webDriver.get("https://web-preprod5.megafon.tv/shows");
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));

        String countSerials = Integer.toString(i);
        StringSelection stringSelection = new StringSelection(countSerials);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

    public void checkAddingFilmInPurchasesForNotif() {
        String nameFilm = webDriver.findElement(By.tagName("h1")).getText();
        System.out.println(nameFilm);
        webDriver.get(My_purchases);
        click(By.xpath("(//a[@data-test='PackageLink'])[1]"));
        Assert.assertEquals(nameFilm, webDriver.findElement(By.tagName("h1")).getText());
    }
}




