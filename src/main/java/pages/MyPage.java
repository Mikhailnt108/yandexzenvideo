package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyPage extends BasePage {
    String My_favorites = "https://web-preprod1.megafon.tv/my/favorites";
    String My_history = "https://web-preprod1.megafon.tv/my/history";
    String My_purchases = "https://web-preprod1.megafon.tv/my/purchases";
    String My_subscriptions = "https://web-preprod1.megafon.tv/my/subscriptions";


    public MyPage(WebDriver driver) {
        super(driver);
    }

    public void checkAddingTvProgramToFavorites() {
        isElementDisplayed(By.xpath("//h3[text()='ТВ-каналы']"));
    }

    public void checkAddingFilmInPurchases() {
       // isElementDisplayed(By.xpath("//span[text()='Куплено']"));
        Assert.assertEquals(1, driver.findElements(By.xpath("//span[text()='Куплено']")).size());
    }

    public void checkNoPurchase() {
        Assert.assertEquals(0, driver.findElements(By.xpath("//span[text()='Куплено']")).size());
    }

    public void checkAddingFilmToFavorites() {
        Assert.assertEquals(1, driver.findElements(By.xpath("//h3[text()='Фильмы']")).size());
    }

    public void checkAddingSerialsInPurchases() {
        Assert.assertEquals(1, driver.findElements(By.xpath("//h3[text()='Сериалы']")).size());
    }

    public void checkAddingSerialToFavorites() {
        Assert.assertEquals(1, driver.findElements(By.xpath("//h3[text()='Сериалы']")).size());
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
        List<WebElement> CollectionPackages = driver.findElements(By.xpath("//div[@class='_2_Ri6nlJFXGDuvpZHi8zlB']//a[@data-test='PackageLink']"));
        for (int i=1; i<=CollectionPackages.size(); i++)
        {
            CollectionPackages = driver.findElements(By.xpath("//div[@class='_2_Ri6nlJFXGDuvpZHi8zlB']//a[@data-test='PackageLink']"));
            CollectionPackages.get(i-1).click();
            //WebElement button = driver.findElement(By.xpath("//button[text()='Прочитать описание']"));
            //wait.until(ExpectedConditions.visibilityOf(button));
            //button.click();
            driver.findElement(By.xpath("//button[text()='Отключить']|//div[text()='Навсегда']|//div[text()='Доступно']|//div[text()='Входит']"));
            driver.navigate().back();
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
        String nameFilm = driver.findElement(By.tagName("h1")).getText();
        System.out.println(nameFilm);
        driver.get(My_history);
        click(By.xpath("//a[@data-test='PackageLink']"));
        Assert.assertEquals(nameFilm, driver.findElement(By.tagName("h1")).getText());
    }
    public void goToMyPageFavorites() { driver.get(My_favorites);
        isElementDisplayed(By.xpath("//a[@href='/my']//span[1]"));
    }
    public void goToMyPagePurchases() {
        driver.get(My_purchases);
        isElementDisplayed(By.xpath("//span[text()='Оплаченное']"));
    }
    public void goToMyPageSubscriptions() {
        driver.get(My_subscriptions);
        isElementDisplayed(By.xpath("//span[text()='Пакеты']"));
    }
}




